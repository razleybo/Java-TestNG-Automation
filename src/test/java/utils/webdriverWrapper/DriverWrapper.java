package utils.webdriverWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.tests.todomvc.pages.BasePage;
import java.io.Closeable;
import java.util.List;

public class DriverWrapper implements Closeable {

    private WebDriver driver ;
    private final int TIMEOUT_SEC = 10;

    public DriverWrapper(WebDriver driver){
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
    public void clearText(WebElement elementToClear) {
        waitForElement(elementToClear).clear();
    }
    public void setText(WebElement elementToSetText,String textToSet) {
        waitForElement(elementToSetText).sendKeys(textToSet);
    }
    public void hitEnter(WebElement elementToHit) {
        waitForElement(elementToHit).sendKeys(Keys.ENTER);
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

