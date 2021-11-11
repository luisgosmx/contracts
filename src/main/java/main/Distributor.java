package main;

import harvest.types.DefaulterHarvest;
import harvest.types.NewsHarvester;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author golivares
 */
public class Distributor {

    public static void newshaverst(String param, String outputfolder) {

        try {
            System.out.println("News will be extracted from " + param.toUpperCase() + " and gardaran in " + outputfolder.toUpperCase());
            System.out.println("");
            NewsHarvester.select(param, outputfolder);
        } catch (InterruptedException ex) {
            Logger.getLogger(Distributor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void defaulterwithos(String namecompany, String namesource, String folder, String os) {
        os = os.toLowerCase();
        if (os.length() > 0) {
            if (os.equals("windows") || os.equals("mac")) {

                if (os.equals("mac")) {
                    os = "1";
                } else {
                    os = "0";
                }
                System.out.println("will be consulted " + namecompany.toUpperCase() + " in " + namesource.toUpperCase() + " and saved in " + folder.toUpperCase() + "os selected" + os.toUpperCase());
                System.out.println("");
                try {
                    DefaulterHarvest.selectos(namecompany, namesource, folder, os);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Distributor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Distributor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("os invalid '-os Windows or Mac'");
                System.out.println("");
            }
        } else {
            System.out.println("insert os '-os Windows or Mac'");
        }
    }

}
