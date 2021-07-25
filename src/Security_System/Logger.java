package Security_System;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

public class Logger {
    FileWriter logFile;


    public void createFile(int idNumber) throws IOException {
        String nameFile = "LoggerVisitor" + idNumber + ".txt";
        logFile = new FileWriter(nameFile, true);

    }

    /*Records the accessed websites for each visitor */
    public void add(int idNumber, String webSite) throws IOException {
        this.createFile(idNumber);
        String log = "El visitante con el id " + idNumber + " accedio al sitio " + webSite + "\n";
        logFile.write(log);
        logFile.close();
    }

}
