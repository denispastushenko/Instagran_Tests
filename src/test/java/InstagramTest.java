import com.devcolibri.detabase.Connection_Class;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.rmi.Remote;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;
import java.sql.*;

public class InstagramTest {
    private  static String SITE = "https://www.instagram.com/";
    private  static String BITCH = "_sv.k_";
    private  static int scroll = 250;
    private RemoteWebDriver webDriver;
    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "Z:/Downloads/chromedriver.exe");
        URL testrem = new URL("http://localhost:4445/wd/hub");
        webDriver = new RemoteWebDriver(testrem, DesiredCapabilities.firefox());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void testTest() throws InterruptedException, IOException, AWTException {
        RegCheck check = new RegCheck();
        ImageDownload down = new ImageDownload();
        Robot r = new Robot();
        webDriver.get(SITE.concat(BITCH));
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1000)", "");
        webDriver.findElement(By.xpath("//a[@class = '_oidfu']")).click();
        WebElement webElement = webDriver.findElement(By.xpath("//span[@class='_bkw5z']"));
        String elem = webElement.getText();
        System.out.println(elem);
        int rw = Integer.parseInt(elem.replaceAll(",", ""));
        while (rw > webDriver.findElements(By.xpath("//div[@class='_jjzlb']//img")).size()) {
            jse.executeScript(String.format("window.scrollBy(0,%d)", scroll += 250));
            r.mouseWheel(-1);
            Thread.sleep(500);
        }
        List<WebElement> webEl = webDriver.findElements(By.xpath("//div[@class='_jjzlb']/img"));
        Set<String> linkSet = new HashSet<>();
        for (WebElement el : webEl) {
            linkSet.add(check.regchecking(el.getAttribute("src")));
        }
        for (String s : linkSet) {
            down.saver(s, ImageDownload.FILE_WAY);
        }
        linkSet.stream().forEach(out::println);
        System.out.println(linkSet.size());
    }
    @Test
    public void JDBS_Test() throws InterruptedException, IOException, AWTException, SQLException, ClassNotFoundException {
        RegCheck check = new RegCheck();
        Connection_Class con = new Connection_Class();
        Robot r = new Robot();
        webDriver.get(SITE.concat(BITCH));
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1000)", "");
        webDriver.findElement(By.xpath("//a[@class = '_oidfu']")).click();
        WebElement webElement = webDriver.findElement(By.xpath("//span[@class='_bkw5z']"));
        String elem = webElement.getText();
        System.out.println(elem);
        int rw = Integer.parseInt(elem.replaceAll(",", ""));
        while (rw > webDriver.findElements(By.xpath("//div[@class='_jjzlb']//img")).size()) {
            jse.executeScript(String.format("window.scrollBy(0,%d)", scroll += 250));
            r.mouseWheel(-1);
            Thread.sleep(1000);
        }
        List<WebElement> webEl = webDriver.findElements(By.xpath("//div[@class='_jjzlb']/img"));
        Set<String> linkSet = new HashSet<>();
        for (WebElement el : webEl) {
            linkSet.add(check.regchecking(el.getAttribute("src")));
        }
       /* for (String s : linkSet) {
            con.connectMethod(s);
            System.out.println(s);
        }*/
        linkSet.stream().forEach(out::println);
        System.out.println(linkSet.size());
        linkSet.stream().forEach(url -> {
            try {
                Connection_Class.getInstance().connectMethod(url);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @After
    public void shoutDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}