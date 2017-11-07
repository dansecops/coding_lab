package assignment4;

public class NotifierFactory {

    public static Notifier createEmailNotifier(String recipientEmail) {
        return new MailNotifier(recipientEmail);
    }

    public static Notifier createLogNotifier(String filePath) {
        return new LogNotifier(filePath);
    }




}

