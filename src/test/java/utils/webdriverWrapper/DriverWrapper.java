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

/***
 * This class meant to encapsulate the Webdriver  and allow extra functionally
 */
public class DriverWrapper implements Closeable {

    private WebDriver driver ;
    private final static int TIMEOUT_SEC = 10;

    public DriverWrapper(WebDriver driver){
        this.driver=driver;
    }

    /***
     * Wait until element is viable on DOM , wait for {@value TIMEOUT_SEC} seconds .
     *  in case of time out , an element not found exception will be thrown
     * @param elementToWaitFor WebElement to wait for
     * @return the web element after found
     */
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

    /***
     *  return the value of a requested attribute on a webElement
     *  waits for the element first.
     *
     * @param elementToQuarry the element to serch the attribute's valu on
     * @param attToGet the attribute name
     *
     * @return return the value of a requested attribute on a webElement empty string if not found
     */
    public String getAttributeValue(By elementToQuarry, String attToGet) {
        return waitForElement(elementToQuarry).getAttribute(attToGet);
    }

    /***
     * init elements on page using selenium page factory
     * @param pageToInit the page to init
     */
    public void initPage (BasePage pageToInit){
        PageFactory.initElements(driver,pageToInit);
    }

    public void close()  {
        driver.close();
    }
}

