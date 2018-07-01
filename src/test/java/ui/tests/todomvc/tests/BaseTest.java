package ui.tests.todomvc.tests;

import configurations.ExecutionConfigurations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.tests.todomvc.actions.TodoListActions;
import utils.webdriverHelpers.WebdriverConfigurations;
import utils.webdriverWrapper.DriverWrapper;

import java.net.MalformedURLException;
import java.net.URL;

/***
 * This is the base class for all tests
 * it init the Webdriver and the all actions
 * also close Webdriver in the end
 */
public class BaseTest {

    private DriverWrapper driver ;
    private ExecutionConfigurations conf ;

    protected TodoListActions todoListActions;
    protected Logger logger;

    public BaseTest()
    {
        logger = LogManager.getLogger(this.getClass().getSimpleName());
        conf =  ExecutionConfigurations.getConfigurations();
    }
    @BeforeClass
    public void setUp(){
        logger.info("Starting Test");
        this.driver = driverSetup(conf.getBrowser(),conf.getExecution());
        actionsSetup();
    }
    @AfterClass
    public void tearDone(){
        logger.info("Test is done");
        driverCleanup();
    }

    private void driverCleanup() {
        driver.close();
    }

    private void actionsSetup() {
        todoListActions = new TodoListActions(driver);
    }

    /***
     * this method configures the webdriver wrapper according to wanted browser and execution
     * @param browser required browser Chrome or Firefox
     * @param execution required execution Local or remote (typo will return local )
     * @return DriverWrapper to run with
     */
    private DriverWrapper driverSetup(String browser , String execution ){
        DriverWrapper res = null ;
        if (execution
                .equalsIgnoreCase(
                        WebdriverConfigurations.Execution.Remote.name())){
            res = remoteDriverSetup(browser);
        }
        else {
            res =  localDriverSetup(browser);
        }
        return res;
    }
    private DriverWrapper localDriverSetup(String browser)
    {
        logger.info("setting up a local browser : "+browser);
        WebDriver localDriver = null ;

        if (browser.equalsIgnoreCase(WebdriverConfigurations.Browser.Firefox.name())){
            WebDriverManager.firefoxdriver().setup();
            localDriver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            localDriver = new ChromeDriver(WebdriverConfigurations.getChromeOptions());
        }

        return new DriverWrapper(localDriver);
    }

    private DriverWrapper remoteDriverSetup(String browser){
        logger.info("setting up a remote  browser : "+browser);

        RemoteWebDriver remoteWebDriver = null;
        DesiredCapabilities dc = WebdriverConfigurations.generateCapabilities(browser);
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(conf.getHubUrl()), dc);
        } catch (MalformedURLException e) {
            Assert.fail("Failed to setup WebDriver",e);
        }
        return new DriverWrapper(remoteWebDriver);
    }

}
