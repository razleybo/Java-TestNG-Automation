package ui.tests.todomvc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import utils.webdriverWrapper.DriverWrapper;

public class BasePage {

    DriverWrapper driver ;

    public BasePage(RemoteWebDriver driver){
        this.driver = new DriverWrapper(driver);
    }
}
