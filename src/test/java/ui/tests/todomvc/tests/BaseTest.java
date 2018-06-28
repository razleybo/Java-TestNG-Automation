package ui.tests.todomvc.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import ui.tests.todomvc.actions.TodoListActions;
import utils.webdriverHelpers.WebdriverConfigurations;
import utils.webdriverWrapper.DriverWrapper;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private DriverWrapper driver ;
    private String hubUrl;
    private String browser;
    private String execution;
    protected TodoListActions todoListActions;
    private static  Logger logger;

    public BaseTest()
    {
        logger = LogManager.getLogger(this.getClass().getSimpleName());
    }
    @BeforeTest
    public void propertiesSetup(){
        hubUrl = System.getProperty("selenium.hub.url");
        browser = System.getProperty("selenium.browser","Chrome");
        execution = System.getProperty("selenium.execution","Local");
    }
    @BeforeClass
    public void setUp(){
        driverSetup(this.browser);
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
    private void driverSetup(String browser){
        if (execution.equalsIgnoreCase("remote")){
            remoteDriverSetup(browser);
        }
        else {
            localDriverSetup(browser);
        }
    }
    private void localDriverSetup(String browser)
    {
        WebDriver localDriver = null ;

        if (browser.equalsIgnoreCase(WebdriverConfigurations.Browser.Firefox.name())){
            WebDriverManager.firefoxdriver().setup();
            localDriver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            localDriver = new ChromeDriver(WebdriverConfigurations.getChromeOptions());
        }

        this.driver = new DriverWrapper(localDriver);
    }

    private void remoteDriverSetup(String browser){

        RemoteWebDriver remoteWebDriver = null;
        DesiredCapabilities dc = WebdriverConfigurations.generateCapabilities(browser);

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(hubUrl), dc);
        } catch (MalformedURLException e) {
            Assert.fail("Failed to setup WebDriver",e);
        }
        this.driver = new DriverWrapper(remoteWebDriver);
    }

}
