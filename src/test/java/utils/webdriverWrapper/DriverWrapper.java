package utils.webdriverWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverWrapper{

    private RemoteWebDriver driver ;
    private String hubUrl="http://localhost:4444/wd/hub";

    public DriverWrapper(RemoteWebDriver driver){
        this.driver=driver;
    }
    public WebElement waitForElement(By elemetToWaitFor){
        boolean found= false;
        int retries = 6;
        WebElement res = null;
        while (retries>0&&!found) {

            try {
                res = driver.findElement(elemetToWaitFor);
            }
            catch (Exception e){
                retries--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            found = true;
        }
        return res;
    }
    public void getPage(String url){
        driver.get(url);
    }
    public void clearText(By elemetToClear ) {
        waitForElement(elemetToClear).clear();
    }
    public void setText(By elemetToSetText,String textToSet) {
        waitForElement(elemetToSetText).sendKeys(textToSet);
    }
}
