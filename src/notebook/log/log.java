package notebook.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class log {
    public static final String LOG_PATH = "log.txt";

    public static void createLog() {
        try {
            File log = new File(LOG_PATH);
            if (log.createNewFile()) {
                System.out.println("LOG created");
            } else {
                System.out.println("LOG already exists");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void writeLog(String data) {
        Date currentDate = new Date();
        try {
            FileWriter writer = new FileWriter(LOG_PATH, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(currentDate + " : " + data +"\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

