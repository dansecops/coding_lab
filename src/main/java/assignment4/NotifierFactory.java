package assignment4;

import java.util.Map;

public class NotifierFactory {

    enum NotifierType {EMAIL, FILE}

    /**
     * @param type
     * @param
     * @return
     */
    public static Notifier createNotifier(int type, String filePath) {
        System.out.println(filePath);
        switch (type) {
            case 1: {
                return new LogNotifier(filePath);
            }
            case 2:
                return new MailNotifier();
            default:
                throw new RuntimeException("Notifier does not exist!");
        }


    }


    //private String[] settings = new String[3];

    /*
    use getNotifier method to get object of type Notifier
     */


}


