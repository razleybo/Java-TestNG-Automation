package ui.tests.todomvc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import utils.webdriverWrapper.DriverWrapper;

public class BasePage {

    protected DriverWrapper driver ;

    public BasePage(DriverWrapper driver){
        this.driver = driver;
    }
}
