package harvest.types;

import harvest.save.SaveJson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tongfei.progressbar.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.apache.commons.io.FileUtils;
import org.jsoup.select.Elements;

/**
 *
 * @author golivares
 */
public class NewsHarvester {

    public static String EXPORT_PATH = "";

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        EXPORT_PATH = "test2/";
        reforma();
    }

    public static void select(String source, String folder) throws InterruptedException {

        if (!folder.endsWith("/")) {
            folder = folder + "/";
            EXPORT_PATH = folder;
        }
        EXPORT_PATH = folder;

        String validate = "no";
        if (source.equals("reforma")) {
            validate = "si";
            reforma();
        }
        if (source.equals("eluniversal")) {
            validate = "si";
            eluniversal();
        }
        if (source.equals("all")) {
            validate = "si";
            reforma();
            eluniversal();
        }
        if (validate.equals("no")) {
            System.out.println("Invalid newspaper");
        }

    }

    //Reforma (México)    https://www.reforma.com
    //extract the information using the http protocol and export it to json format
    public static void reforma() throws InterruptedException {
        String url = "https://www.reforma.com/rss/nacional.xml";
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(2000000000).get();
            org.jsoup.select.Elements items = doc.getElementsByTag("item");
            ProgressBar reformaProgressBar = new ProgressBar("Reforma (México)", items.size());
            for (int i = 0; i < items.size(); i++) {
                Element noticia = items.get(i);
                Calendar fecha = new GregorianCalendar();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int hora = fecha.get(Calendar.HOUR_OF_DAY);
                int minuto = fecha.get(Calendar.MINUTE);
                int segundo = fecha.get(Calendar.SECOND);
                SaveJson docjson = new SaveJson();

                String id = "REF" + dia + (mes + 1) + año + hora + minuto + segundo;
                docjson.setId(id);

                docjson.setDate_harvested(dia + "-" + (mes + 1) + "-" + año + "T" + hora + ":" + minuto + ":" + segundo);

                String title = noticia.getElementsByTag("title").text();
                docjson.setTitle(title);

                String link = noticia.getElementsByTag("link").text();
                docjson.setSource(link);

                String creator = noticia.getElementsByTag("author").text();
                docjson.setCreator(creator);

                String pubDate = noticia.getElementsByTag("pubDate").text();
                docjson.setPublication_date(pubDate);

                String category = noticia.getElementsByTag("IdCategoria").text();
                docjson.setCategory(category);

                String description = noticia.getElementsByTag("description").text();
                docjson.setText(description);

                try {

                    link = "https://www.reforma.com/aplicacioneslibre/preacceso/articulo/default.aspx?urlredirect=" + link;
                    org.jsoup.nodes.Document dochtml = Jsoup.connect(link).userAgent("Mozilla/5.0").timeout(2000000000).get();
                    org.jsoup.select.Elements meta = dochtml.getElementsByTag("meta");
                    for (int j = 0; j < meta.size(); j++) {
                        Element name = meta.get(j);
                        String nam = name.attr("name");
                        if (nam.equals("Keywords")) {
                            String val = name.attr("content");
                            docjson.setKeywords(val);
                            break;
                        }
                    }
                } catch (Exception e) {
                }

                if (docjson.getText().length() > 0) {
                    FileUtils.writeStringToFile(new File(EXPORT_PATH + docjson.getId() + ".json"), docjson.toJSON("news").toString(), "UTF-8");
                    reformaProgressBar.setExtraMessage(docjson.getId() + " has been saved in folder");
                }
                reformaProgressBar.step();
                Thread.sleep(1000);
            }
        } catch (IOException ex) {
            Logger.getLogger(NewsHarvester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //El Universal (México)    https://www.eluniversal.com.mx
    //extract the information using the http protocol and export it to json format
    public static void eluniversal() throws InterruptedException {
        String url = "https://www.eluniversal.com.mx";
        ArrayList<String> news = new ArrayList<String>();
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(2000000000).get();
            Elements html = doc.getElementsByTag("a");
            for (int i = 0; i < html.size(); i++) {
                Element htmlhref = html.get(i);
                String href = htmlhref.attr("href").toString();
                if (href.contains("https://www.eluniversal.com.mx/mundo")) {
                    news.add(href);
                }
            }
            ProgressBar br = new ProgressBar("El Universal (México)", news.size());
            for (int x = 0; x < news.size(); x++) {
                String href = news.get(x);
                SaveJson docjson = new SaveJson();

                Calendar fecha = new GregorianCalendar();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int hora = fecha.get(Calendar.HOUR_OF_DAY);
                int minuto = fecha.get(Calendar.MINUTE);
                int segundo = fecha.get(Calendar.SECOND);
                docjson.setDate_harvested(dia + "-" + (mes + 1) + "-" + año + "T" + hora + ":" + minuto + ":" + segundo);

                String id = "UNI" + dia + (mes + 1) + año + hora + minuto + segundo;
                docjson.setId(id);

                try {

                    org.jsoup.nodes.Document doc1 = Jsoup.connect(href).userAgent("Mozilla/5.0").timeout(2000000000).get();
                    org.jsoup.select.Elements meta = doc1.getElementsByTag("meta");
                    for (int j = 0; j < meta.size(); j++) {
                        Element name = meta.get(j);
                        String nam = name.attr("name");
                        if (nam.equals("keywords")) {
                            String val = name.attr("content");
                            docjson.setKeywords(val);
                        }
                        if (nam.equals("title")) {
                            String val = name.attr("content");
                            docjson.setTitle(val);
                        }
                        if (nam.equals("author")) {
                            String val = name.attr("content");
                            docjson.setCreator(val);
                        }
                        if (nam.equals("language")) {
                            String val = name.attr("content");
                            docjson.setLanguage(val);
                        }
                        if (nam.equals("title")) {
                            String val = name.attr("content");
                            docjson.setTitle(val);
                        }

                    }
                    docjson.setSource(href);

                    String title = doc1.getElementsByClass("Encabezado-Articulo").text();
                    docjson.setTitle(title);

                    String content = doc1.getElementsByClass("field-name-body").text();
                    docjson.setText(content);

                    String datenews = doc1.getElementsByClass("ce12-DatosArticulo_ElementoFecha").text();
                    docjson.setPublication_date(datenews);

                } catch (Exception e) {
                }
                if (docjson.getText().length() > 0) {
                    FileUtils.writeStringToFile(new File(EXPORT_PATH + docjson.getId() + ".json"), docjson.toJSON("news").toString(), "UTF-8");
                    br.setExtraMessage(docjson.getId() + " has been saved in folder");
                }
                br.step();
                Thread.sleep(1000);
            }
        } catch (IOException ex) {
            Logger.getLogger(NewsHarvester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
