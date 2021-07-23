package Security_System;
import java.io.FileWriter;
import java.io.IOException;


public class Logger {
    FileWriter logFile;


    public void createFile(int idNumber) throws IOException {
        String nameFile = "LoggerVisitor" + idNumber + ".txt";
        logFile = new FileWriter(nameFile, true);

    }

    public void add(int idNumber, String webSite) throws IOException {
        this.createFile(idNumber);
        String log = "El visitante con el id " + idNumber + " accedio al sitio " + webSite + "\n";
        logFile.write(log);
        logFile.close();
    }

}
