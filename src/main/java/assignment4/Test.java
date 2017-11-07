package assignment4;

public class Test {
    public static void main(String[] args) {
        Notifier emailNotifier = NotifierFactory.createEmailNotifier("skjallargrimmur@gmail.com");
        emailNotifier.notify("World Hello", Notifier.MessageType.INFO);
    }
}
