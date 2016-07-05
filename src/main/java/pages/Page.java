package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    private static ThreadLocal <WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver(){
       return driver.get();
    }
    public Page(WebDriver webDriver) {
        driver.set(webDriver);
        PageFactory.initElements(driver.get(), this);

    }
}
