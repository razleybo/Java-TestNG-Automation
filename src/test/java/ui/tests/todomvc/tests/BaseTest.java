package ui.tests.todomvc.tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.tests.todomvc.actions.TodoListActions;
import utils.webdriverWrapper.DriverWrapper;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

   private DriverWrapper driver ;
   private String hubUrl;
   private String browser;
   protected TodoListActions todoListActions;

    @BeforeClass
    public void setUp(){
        propertiesSetup();
        driverSetup();
        actionsSetup();
    }
    @AfterClass
    public void tearDone(){
        driverCleanup();
    }

    private void driverCleanup() {
        driver.close();
    }

    private void actionsSetup() {
        todoListActions = new TodoListActions(driver);
    }

    private void driverSetup(){

        RemoteWebDriver remoteWebDriver = null;
        DesiredCapabilities dc = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("firefox")){
            FirefoxProfile ffProfile  =  new FirefoxProfile();
            dc.setCapability(FirefoxDriver.PROFILE,ffProfile);
        }
        else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            dc.setCapability(ChromeOptions.CAPABILITY, options);
        }

        // need to get hub from configuration
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(hubUrl), dc);
        } catch (MalformedURLException e) {
            Assert.fail("Failed to setup WebDriver",e);
        }

        this.driver = new DriverWrapper(remoteWebDriver);
    }

    private void propertiesSetup(){
        hubUrl = System.getProperty("selenium.hub.url");
        browser = System.getProperty("selenium.browser","Chrome");
    }

}
