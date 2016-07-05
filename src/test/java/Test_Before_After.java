import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Page;
import pages.PageObject;
import java.awt.*;
import java.net.MalformedURLException;


public class Test_Before_After {
    public  static final String SITE = "https://www.instagram.com";
    public  static String BITCH = "_sv.k_";
    protected PageObject photoPage;

    @Before
    public void setUp() throws MalformedURLException, AWTException {
        System.setProperty("webdriver.chrome.driver", "Z:/Downloads/chromedriver.exe");
        photoPage = new PageObject(new ChromeDriver());
        Page.getDriver().manage().window().maximize();

    }
    @After
    public void shoutDown() {
        if (Page.getDriver()!= null) {
            Page.getDriver().quit();
        }
    }
}
