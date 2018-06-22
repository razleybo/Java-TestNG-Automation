package ui.tests.todomvc.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TodomvcHomePage extends BasePage {

    private final By title = new By.ByXPath("//h1[text()='todos']");
    private final String url = "http://todomvc.com/examples/react/#/";

    public TodomvcHomePage(RemoteWebDriver driver) {
        super(driver);
    }
    public void getPage(){
        driver.getPage(url);
        driver.waitForElement(title);
    }

}
