package harvest.types;

import harvest.save.SaveJson;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import me.tongfei.progressbar.ProgressBar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author golivares
 */
public class DefaulterHarvest {

    /**
     * @param args the command line arguments
     */
    public static String EXPORT_PATH = "";
    public static String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.1 Safari/605.1.15";

    public static void main(String[] args) throws IOException, InterruptedException {
        //sancionesmx("Banco Compartamos, S.A.");
        EXPORT_PATH = "jsontest/";
        //sanctions("Mexico");
        //smv("Jamaica All Natural Limited", "1");
        sancionesmx("banamex", "1");

    }



    public static void selectos(String namecompany, String nameresourse, String folder, String os) throws InterruptedException, IOException {

        if (!folder.endsWith("/")) {
            folder = folder + "/";
            EXPORT_PATH = folder;
        }
        EXPORT_PATH = folder;
        String validate = "no";
        
        if (nameresourse.equals("sancionesmx")) {
            validate = "si";
            sancionesmx(namecompany, os);
        }

        if (validate.equals("no")) {
            System.out.println("Invalid source");
        }
    }

    //Mexico https://sanciones.cnbv.gob.mx
    //extract the information using the http protocol and export it to json format
    public static void sancionesmx(String namecompany, String os) throws IOException, InterruptedException {

     

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().minimize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofHours(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(1));
        
        
        
        driver.get("https://sanciones.cnbv.gob.mx");
        WebElement name = driver.findElement(By.id("Denominacion"));
        name.clear();
        name.sendKeys(namecompany);

        
        ProgressBar ProgressBar = new ProgressBar("Mexico ", 100);
        ProgressBar.stepTo(25); 
        
        
        WebElement date = driver.findElement(By.id("FechaPublicacionInicio"));
        date.clear();
        date.sendKeys("Enero 2010");

        driver.findElement(By.id("btnBuscar")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        WebElement waittable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchResults")));

        int rowss = 0;

        while (rowss == 0) {
            Thread.sleep(1000);
            String page2 = driver.getPageSource();
            Document doc = Jsoup.parse(page2);
            Element table = doc.getElementById("SearchResults");
            Elements rows = table.select("tr");
            rowss = rows.size();
        }

        WebElement laspage = driver.findElement(By.className("k-pager-last"));
        String page = laspage.getAttribute("data-page");

        int numfin = Integer.parseInt(page);

        int numactual = 1;

        for (int x = numactual; x < numfin; x++) {

            String pageactual = driver.findElement(By.className("k-state-selected")).getText();
            numactual = Integer.parseInt(pageactual);

            String page2 = driver.getPageSource();
            Document doc = Jsoup.parse(page2);
            Element table = doc.getElementById("SearchResults");
            Elements rows = table.select("tr");

            System.out.println(rows.size());

            for (int i = 1; i < rows.size(); i++) {
                SaveJson docjson = new SaveJson();
                Calendar fecha = new GregorianCalendar();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int hora = fecha.get(Calendar.HOUR_OF_DAY);
                int minuto = fecha.get(Calendar.MINUTE);
                int segundo = fecha.get(Calendar.SECOND);
                String id = "SMX" + dia + (mes + 1) + año + hora + minuto + segundo;
                docjson.setId(id);
                Element row = rows.get(i);

                docjson.setCompany(namecompany);

                String names = row.getElementsByTag("td").get(1).text();
                if (names.length() > 0) {
                    docjson.setName(names);
                }

                String subsector = row.getElementsByTag("td").get(2).text();
                if (subsector.length() > 0) {
                    docjson.setSubsector(subsector);
                }

                String tipodesansion = row.getElementsByTag("td").get(3).text();
                if (tipodesansion.length() > 0) {
                    docjson.setType(tipodesansion);
                }

                String penalty_fee = row.getElementsByTag("td").get(4).text();
                if (penalty_fee.length() > 0) {
                    docjson.setPenalty_fee(penalty_fee);
                }

                String sanction = row.getElementsByTag("td").get(6).text();
                if (sanction.length() > 0) {
                    docjson.setSanction(sanction);
                }

                String datesanction = row.getElementsByTag("td").get(7).text();
                if (datesanction.length() > 0) {
                    docjson.setDatesanction(datesanction);
                }

                docjson.setCreator("Gustavo Olivares");

                FileUtils.writeStringToFile(new File(EXPORT_PATH + id + ".json"), docjson.toJSON("defaulter").toString(), "UTF-8");
                
                ProgressBar.setExtraMessage(id + " has been saved in folder");
                Thread.sleep(1000);
            }

            driver.findElement(By.className("k-i-arrow-e")).click();
            ProgressBar.step();
        }
        ProgressBar.stepTo(100);
    }
}
