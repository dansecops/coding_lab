package codingsession4;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.jvnet.mock_javamail.Mailbox;
import javax.mail.MessagingException;



import java.io.File;
import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NotifierTest {


    private final File logFile = new File("logFile.txt");
    private MailSender mailSender;


    @Before
    public void setUp() throws Exception {
        //TODO: integrate with javamail mock
        mailSender = new MailSender();
        //clear Mock JavaMail box
        Mailbox.clearAll();
    }

    @After
    public void tearDown() throws Exception {
        FileUtils.deleteQuietly(logFile);
    }



    @Test
    public void testLogNotifier() throws Exception {
        Notifier logNotifier = NotifierFactory.createLogNotifier("logFile.txt");
        logNotifier.notify("Test log message", Notifier.MessageType.INFO);
        String fileContent = FileUtils.readFileToString(logFile, defaultCharset());
        assertTrue(fileContent.contains("INFO: INFO - Test log message"));
    }

    @Test
    public void testMailNotifier() throws Exception {

        Notifier mailNotifier = NotifierFactory.createEmailNotifier("skjallargrimmur@gmail.com");

        assertTrue(mailNotifier instanceof MailNotifier);
        assertTrue(mailNotifier.notify("Works", Notifier.MessageType.WARNING));
        assertFalse(mailNotifier.notify("", Notifier.MessageType.WARNING));

    }

    @Test
    public void testSendMailAsMock() throws MessagingException, IOException, EmailException {
        /*
        TODO mock up test: http://blog.nutpan.com/2012/03/mock-testing-for-java-mail.html
         */

    }

}