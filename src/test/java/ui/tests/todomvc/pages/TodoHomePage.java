package ui.tests.todomvc.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.webdriverWrapper.DriverWrapper;

public class TodoHomePage extends BasePage {

    @FindBy(xpath = "//h1[text()='todos']")
    private WebElement pageTitle;

    private final String url = "http://todomvc.com/examples/react/#/";

    public TodoHomePage(DriverWrapper driver) {
        super(driver);
        this.driver.initPage(this);
    }
    public void getPage(){
        driver.getPage(url);
        driver.waitForElement(pageTitle);
    }

}
