package assignment4;

import java.io.File;
import java.util.Date;

public class MailNotifier implements Notifier {


    public MailNotifier() {

    }


    @Override
    public boolean notify(int type, String message) {
        return false;
    }

    @Override
    public String addTransmissionDate() {
        return null;
    }



    public void sendEmail(String message) {
        System.out.println("Email sending successful!");

    }
}
