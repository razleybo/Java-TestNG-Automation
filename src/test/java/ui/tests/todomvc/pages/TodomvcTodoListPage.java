package ui.tests.todomvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TodomvcTodoListPage extends BasePage {

    private final By newTodoInput = new By.ByXPath("//input[@class='new-todo']");

    public TodomvcTodoListPage(RemoteWebDriver driver) {
        super(driver);
    }
    public void setNewTodoName(String name){
        driver.clearText(newTodoInput);
        driver.setText(newTodoInput,name);
    }
}
