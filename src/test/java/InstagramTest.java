import org.junit.Test;
import pages.Page;

public class InstagramTest extends  Test_Before_After {
    @Test
    public void userSearchTest() throws InterruptedException {
        Page.getDriver().get(SITE + "/" + BITCH);
       photoPage.clickButton();
        photoPage.savetoComputer();
    }
    @Test
    public void photosToDB() throws InterruptedException {
        Page.getDriver().get(SITE + "/" + BITCH);
        photoPage.clickButton();
        photoPage.savetoDB();
    }


   /* @Test
    public void testTest() throws InterruptedException, IOException, AWTException {

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1000)", "");



        System.out.println(elem);

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

        webDriver.get(SITE.concat(BITCH));
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1000)", "");
        webDriver.findElement(By.xpath("//a[@class = '_oidfu']")).click();
        WebElement webElement = webDriver.findElement(By.xpath("//span[@class='_bkw5z']"));
        String elem = webElement.getText();
        System.out.println(elem);
        int rw = Integer.parseInt(elem.replaceAll(",", ""));
        while (rw > webDriver.findElements(By.xpath("//div[@class='_jjzlb']//img")).size()) {
            jse.executeScript(String.format("window.scrollBy(0,%d)", SCROLL += 250));
            r.mouseWheel(-1);
            Thread.sleep(1000);
        }
        List<WebElement> webEl = webDriver.findElements(By.xpath("//div[@class='_jjzlb']/img"));
        Set<String> linkSet = new HashSet<>();
        for (WebElement el : webEl) {
            linkSet.add(check.regchecking(el.getAttribute("src")));
        }
        linkSet.stream().forEach(out::println);
        System.out.println(linkSet.size());
        linkSet.stream().forEach(url -> {
            try {
                Connection_Class.getInstance().connectMethod(url);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }*/

}