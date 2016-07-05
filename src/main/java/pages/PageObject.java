package pages;
import com.devcolibri.database.Connection_Class;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import units.Sleep;

import java.awt.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


import static units.ImageDownload.*;
import static units.RegCheck.regchecking;



public class PageObject extends  Page {
    private  static int SCROLL = 250;
    private Robot r = new Robot();
    @FindBy(xpath = "//a[@class='_oidfu']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//span[@class='_bkw5z']")
    private WebElement quantity;

    @FindBy(xpath = "//div[@class='_jjzlb']//img")
    private List<WebElement> photocicle;

    public PageObject(WebDriver webDriver) throws AWTException {
        super(webDriver);
    }
    public PageObject clickButton(){
        buttonContinue.click();
        return  this;
    }
     public  PageObject savetoComputer() {
         int rw =  Integer.parseInt(quantity.getText().replaceAll(",", ""));
         while (rw > photocicle.size()) {
             ((JavascriptExecutor) getDriver()).executeScript(String.format("scrollBy(0, %d)", SCROLL += 250));
             r.mouseWheel(-1);
             Sleep.sleep();
         }
         photocicle.stream()
                 .map((webElement -> regchecking(webElement.getAttribute("src"))))
                 .collect(Collectors.toSet())
                 .forEach(s -> {
                     try {
                         saver(s,FILE_WAY);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 });
         return this;

     }

    public  PageObject savetoDB(){
        int rw =  Integer.parseInt(quantity.getText().replaceAll(",", ""));
        while (rw > photocicle.size()) {
            ((JavascriptExecutor) getDriver()).executeScript(String.format("scrollBy(0, %d)", SCROLL += 250));
            r.mouseWheel(-1);
            Sleep.sleep();
        }
        photocicle.stream()
                .map((webElement -> regchecking(webElement.getAttribute("src"))))
                .collect(Collectors.toSet())
                .forEach(s -> {
                    try {
                        Connection_Class.getInstance().connectMethod(s);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        return this;

    }
}
