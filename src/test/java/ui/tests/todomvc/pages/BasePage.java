package ui.tests.todomvc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.webdriverWrapper.DriverWrapper;

import java.net.MalformedURLException;

public class BasePage {

    DriverWrapper driver ;

    public BasePage(RemoteWebDriver driver){
        this.driver = new DriverWrapper(driver);
    }

    // I whould like this to be a class
    // but due to time issues
    private  void configurations(){

    }
}
