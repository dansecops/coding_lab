package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;


public interface Notifier {

    public enum MessageType {
        INFO, ERROR, WARNING
    }

    /**
     * @param message individual message that is sent to notifier
     * @param type    defines the message type of the notifier
     * @return returns true or false
     */
    public boolean notify(int type, String message);

    /*
     */
    public String addTransmissionDate();


}
