package assignment4;

public class MailNotifier implements Notifier {

    public static final String SUBJECT_PREFIX = "Notification about ";
    private final String receiverEmail;
    private final MailSender mailSender = new MailSender();

    public MailNotifier(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    @Override
    public boolean notify(String message, MessageType messageType) {

        boolean status = false;

        if (!message.isEmpty()) {
            String subject = SUBJECT_PREFIX + messageType.toString();
            String body = messageType.toString() + " - " + message;
            if ((mailSender.sendEmail(body, subject, receiverEmail))) {
                status = true;
            }
        }

        return status;


    }
}
