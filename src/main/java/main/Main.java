package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * Main class of the jar.
 *
 * @author golivares
 */
public class Main {

    static final Logger logger = Logger.getLogger(Main.class.getName());
    static boolean logs = false;
    public static long inittime = 0;

    public static void main(String[] args) throws XmlPullParserException {
        long inicio = System.currentTimeMillis();
        PrintStream systemerr = System.err;
        Main.init(args);
        if (args.length != 0) {
            String res = parsear(args);
            if (!res.isEmpty()) {
                System.out.println(res);
            }
        }

        System.setErr(systemerr);
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        logger.info("Execution time: " + tiempo + " seconds");

    }

    public static void init(String[] args) throws XmlPullParserException {
        logs = Arrays.asList(args).contains("-logs");
        logger.info("Harvest Start");

        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            String welcome = model.getArtifactId() + " " + model.getVersion() + "\n-----------------------------------------------------\n";
            logger.log(Level.INFO, "Name and Version: {0}", welcome);
        } catch (IOException e) {
        }

    }

    public static String parsear(String[] args) {
        ///Response
        StringBuilder res = new StringBuilder();
        CommandLineParser parser = null;
        CommandLine cmd = null;
        try {

            Options options = new Options();

            //info comandos
            options.addOption("help", false, "COMMAND to show help (Help)");

            //parametros
            options.addOption("namesource", true, "name of source");
            options.addOption("output", true, "chooses the possible output for the operation");
            options.addOption("name", true, "name or company");
            options.addOption("os", true, "sistem operative (Windows or Mac)");
            options.addOption("date", true, "search start date. Format (dd/mm/yyyy)");

            //tipos
            options.addOption("newsharvest", false, "Extract news from the diferent newspapers");
            options.addOption("defaulterharvest", false, "Extract defaulter from the diferent sources");

            parser = new BasicParser();
            cmd = parser.parse(options, args);

            if (cmd.hasOption("help") || args.length == 0) {
                new HelpFormatter().printHelp(Main.class.getCanonicalName(), options);
            }

            if (cmd.hasOption("newsharvest")) {
                String namesource = cmd.getOptionValue("namesource");
                String folder = cmd.getOptionValue("output");
                Distributor.newshaverst(namesource, folder);
            }

            if (cmd.hasOption("defaulterharvest")) {

                String namesource = cmd.getOptionValue("namesource");
                String os = cmd.getOptionValue("os");

                if (namesource.equals("sancionesmx")) {
                    String name = cmd.getOptionValue("name");
                    String folder = cmd.getOptionValue("output");
                    Distributor.defaulterwithos(name, namesource, folder, os);
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return res.toString();
    }

}
