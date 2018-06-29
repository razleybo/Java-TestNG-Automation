package ui.tests.todomvc.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.webdriverWrapper.DriverWrapper;

public class BasePage {

    protected DriverWrapper driver ;
    protected Logger logger;

    public BasePage(DriverWrapper driver){
        this.driver = driver;
        logger = LogManager.getLogger(this.getClass().getSimpleName());
    }
}
