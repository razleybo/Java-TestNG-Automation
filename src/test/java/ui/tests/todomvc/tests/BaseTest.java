package ui.tests.todomvc.tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class BaseTest {

   protected RemoteWebDriver driver ;

    @BeforeClass
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        // need to get hub from configuration
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
    }
}
