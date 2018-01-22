package javacasestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //TODO with Igor: include arguments for number of threads (?) and amount
        Logger LOGGER = Logger.getLogger("Main Logger");
        int certificateUpdatsAmount = 10000000;
        //TODO: Ask Igor - why doesn't it work with a very large int number?
        List<String> list1 = new ArrayList<String>();

        FeedGenerator fg = new FeedGenerator();


        String result;

        for (int i = 0; i < certificateUpdatsAmount; i++) {
            try {
                result = fg.call();
                list1.add(result);
                LOGGER.info(i + ".: " + result + " added.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(i+1 + ".Element: " + list1.get(i));
        }

        }

    }

