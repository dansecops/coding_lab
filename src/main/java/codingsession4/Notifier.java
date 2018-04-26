package codingsession4;


public interface Notifier {

    enum MessageType {
        INFO, ERROR, WARNING
    }


    public boolean notify(String message, MessageType type);

}


