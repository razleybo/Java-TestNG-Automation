package ui.tests.todomvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class TodomvcTodoListPage extends BasePage {

    private final By newTodoInput = new By.ByXPath("//input[@class='new-todo']");
    private final By todoNames = new By.ByXPath("//ul[@class ='todo-list']//li//label");
    public TodomvcTodoListPage(RemoteWebDriver driver) {
        super(driver);
    }
    public void setNewTodoName(String name){
        driver.clearText(newTodoInput);
        driver.setText(newTodoInput,name);
    }
    public void hitEnterOnNewTodo(){
        driver.hitEnter(newTodoInput);
    }

    public String getLastTodoText() {
        List<WebElement> allTdodNames = driver.getAllElements(todoNames);
        return allTdodNames.get(allTdodNames.size()-1).getText();
    }
}
