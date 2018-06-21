package ui.tests.todomvc;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.tests.todomvc.pages.TodomvcHomePage;
import ui.tests.todomvc.pages.TodomvcTodoListPage;

import java.net.MalformedURLException;
import java.net.URL;


public class blankTest {

    RemoteWebDriver driver ;
    @BeforeClass
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
    }


    @Test
    public void seleinumTest01()  {

        TodomvcHomePage homePage = new TodomvcHomePage(driver);
        TodomvcTodoListPage listPage = new TodomvcTodoListPage(driver);
        homePage.getPage();
        listPage.setNewTodoName("My new Task");

    }

}
