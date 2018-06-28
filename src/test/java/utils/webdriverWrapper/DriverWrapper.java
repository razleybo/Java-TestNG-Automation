package utils.webdriverWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.tests.todomvc.pages.BasePage;
import java.io.Closeable;
import java.util.List;

public class DriverWrapper implements Closeable {

    private RemoteWebDriver driver ;
    private final int WAIT_UNIT = 300;
    private final int TIMEOUT_SEC = 10;

    public DriverWrapper(RemoteWebDriver driver){
        this.driver=driver;
    }

    public WebElement  waitForElement (WebElement elementToWaitFor){

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_SEC);
        return  wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }
    public WebElement  waitForElement (By elementToWaitFor){
        WebElement webElement =  driver.findElement(elementToWaitFor);
        return waitForElement(webElement);
    }
    public void getPage(String url){
        driver.get(url);
    }
    public void clearText(WebElement elemetToClear) {
        elemetToClear.clear();
    }
    public void setText(WebElement elemetToSetText,String textToSet) {
        elemetToSetText.sendKeys(textToSet);
    }
    public void hitEnter(WebElement elemetToHit) {
        elemetToHit.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getAllElements(By todoNames) {
        return driver.findElements(todoNames);
    }

    public String getAttributeValue(By elementToQuarry, String attToGet) {
        return driver.findElement(elementToQuarry).getAttribute(attToGet);
    }
    public void initPage (BasePage pageToInit){
        PageFactory.initElements(driver,pageToInit);
    }

    public void close()  {
        driver.close();
    }
}

