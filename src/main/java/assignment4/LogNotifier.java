package assignment4;

import java.io.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.*;

public class LogNotifier implements Notifier {


    private static final Logger LOGGER = Logger.getLogger(LogNotifier.class.getName());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
    private static FileHandler fh;
    private static Formatter formatterTxt;

    public LogNotifier(String filepath) {
        try {
            fh = new FileHandler(filepath);
            LOGGER.addHandler(fh);
            formatterTxt = new SimpleFormatter();
            fh.setFormatter(formatterTxt);
        } catch (SecurityException | IOException e ) {
            e.printStackTrace();
        }


        //removes the console handler
        //LOGGER.setUseParentHandlers(false);

    }

    public boolean notify(int type, String message) {
        boolean status;
        switch (type) {
            case 1:
                LOGGER.log(Level.INFO, "INFO " + message);
                status = true;
                break;
            case 2:
                LOGGER.log(Level.WARNING, "WARNING: " + message);
                status = true;
                break;
            case 3:
                LOGGER.log(Level.SEVERE, "ERROR: " + message);
                status = true;
                break;
            default:
                status = false;
        }

        return status;
    }

    @Override
    public String addTransmissionDate() {
        //  todo
        return null;
    }
}
