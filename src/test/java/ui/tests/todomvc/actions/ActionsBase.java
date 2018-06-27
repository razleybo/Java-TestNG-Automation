package ui.tests.todomvc.actions;

import org.openqa.selenium.remote.RemoteWebDriver;
import utils.webdriverWrapper.DriverWrapper;

public abstract class ActionsBase {

    public ActionsBase(DriverWrapper driver) {
        initPages (driver);
    }
    protected abstract  void initPages (DriverWrapper driver);
}
