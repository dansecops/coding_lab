package assignment4;


import java.io.IOException;
import java.util.logging.*;

public class LogNotifier implements Notifier {

    private static final Logger LOGGER = Logger.getLogger(LogNotifier.class.getName());
    private static FileHandler fh;
    private static Formatter formatterTxt;


    public LogNotifier(String filepath) {
        try {
            fh = new FileHandler(filepath, true);
            LOGGER.addHandler(fh);
            formatterTxt = new SimpleFormatter();
            fh.setFormatter(formatterTxt);
        } catch (SecurityException | IOException e ) {
            e.printStackTrace();
        }

    }

    public boolean notify(String message, MessageType messageType) {
        if(message == null) {
            message = "";
        }
        boolean status;
        switch (messageType) {
            case INFO:
                LOGGER.log(Level.INFO, "INFO - " + message);
                status = true;
                break;
            case WARNING:
                LOGGER.log(Level.WARNING, "WARNING -" + message);
                status = true;
                break;
            case ERROR:
                LOGGER.log(Level.SEVERE, "ERROR - " + message);
                status = true;
                break;
            default:
                status = false;
        }

        return status;
    }

}
