package assignment4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class FactoryPatternDemo {

    public static void main(String[] args) {

        Notifier myNotifier;

        myNotifier = NotifierFactory.createNotifier(1,"logFile.txt");

        System.out.println(myNotifier.notify(1,"Test"));







    }


}
