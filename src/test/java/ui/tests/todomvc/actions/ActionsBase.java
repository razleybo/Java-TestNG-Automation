package ui.tests.todomvc.actions;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class ActionsBase {

    public ActionsBase(RemoteWebDriver driver) {
        initPages (driver);
    }
    protected abstract  void initPages (RemoteWebDriver driver);
}
