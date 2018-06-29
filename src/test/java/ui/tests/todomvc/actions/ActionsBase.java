package ui.tests.todomvc.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.webdriverWrapper.DriverWrapper;

public abstract class ActionsBase {
    protected Logger logger;

    public ActionsBase(DriverWrapper driver) {
        logger = LogManager.getLogger(this.getClass().getSimpleName());
        initPages (driver);

    }
    protected abstract  void initPages (DriverWrapper driver);
}
