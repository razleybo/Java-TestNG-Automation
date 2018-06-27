package ui.tests.todomvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import utils.webdriverWrapper.DriverWrapper;

import java.util.List;

public class TodoTodoListPage extends BasePage {

    // ideally we would have ask for id from the developer
    // since this is not passble in this case, we use a complex xpath
    @FindBy(xpath ="//input[@class='new-todo']" )
    private WebElement newTodoInput;


    private By.ByXPath todoNames = new By.ByXPath("//ul[@class ='todo-list']//li//label");

    public TodoTodoListPage(DriverWrapper driver) {
        super(driver);
        this.driver.initPage(this);
    }
    public void setNewTodoName(String name){
        driver.clearText(newTodoInput);
        driver.setText(newTodoInput,name);
    }
    public void approveOnNewTodo(){
        driver.hitEnter(newTodoInput);
    }

    public String getLastTodoText() {
        List<WebElement> allTdodNames = driver.getAllElements(todoNames);
        return allTdodNames.get(allTdodNames.size()-1).getText();
    }

    public void toggleTodo(String toDoName) {
        // ideally we would have ask for id from the developer
        // since this is not passble in this case, we use a complex xpath
        By toDoToToggle = new By.ByXPath("//label[text()='"+toDoName+"']/../input");
        driver.waitForElement(toDoToToggle).click();
    }
    public String getTodoStatus(String toDoName) {
        // ideally we would have ask for id from the developer
        // since this is not passble in this case, we use a complex xpath
        By toDoTargetStatus = new By.ByXPath("//*[text()='"+toDoName+"']/../..");
        //same here , we want the developer to add an attribute or id for this
        return driver.getAttributeValue(toDoTargetStatus,"class");
    }

    public void waitForPageLoade() {
        driver.waitForElement(newTodoInput);
    }
}
