package ui.tests.todomvc.tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import ui.tests.todomvc.actions.TodoListActions;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

   private RemoteWebDriver driver ;

   protected TodoListActions todoListActions;

    @BeforeClass
    public void setUp(){
        driverSetup();
        actionsSetup();
    }
    private void actionsSetup() {
        todoListActions = new TodoListActions(driver);
    }
    private void driverSetup(){
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        // need to get hub from configuration
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
        } catch (MalformedURLException e) {
            Assert.fail("Failed to setup Webdriver",e);
        }
    }
}
