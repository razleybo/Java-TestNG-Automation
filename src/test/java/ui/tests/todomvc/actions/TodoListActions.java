package ui.tests.todomvc.actions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import ui.tests.todomvc.pages.TodomvcHomePage;
import ui.tests.todomvc.pages.TodomvcTodoListPage;

public class TodoListActions extends ActionsBase {

    public enum ToDoState{
        DONE,TODO
    }

    private TodomvcHomePage todomvcHomePage;
    private TodomvcTodoListPage todomvcTodoListPage;

    public TodoListActions(RemoteWebDriver driver) {
        super(driver);
    }

    protected void initPages(RemoteWebDriver driver) {
        todomvcHomePage = new TodomvcHomePage(driver);
        todomvcTodoListPage = new TodomvcTodoListPage(driver);
    }

    public void goToTodoListPage(){
        todomvcHomePage.getPage();
        todomvcTodoListPage.waitForPageLoade();
    }
    public void addNewTodo(String todoName) {
        todomvcTodoListPage.setNewTodoName(todoName);
        todomvcTodoListPage.hitEnterOnNewTodo();
    }

    public void verifyLastTodo(String toDoName) {
        String actualLastTodo = todomvcTodoListPage.getLastTodoText();
        Assert.assertEquals(actualLastTodo,toDoName,"Last todo was not as expected");
    }

    public void toggleToDo(String toDoName) {
        todomvcTodoListPage.toggleTodo(toDoName);
    }

    public void verifyToDoState(String toDoName, ToDoState exactedState) {
       String actualStatus =  todomvcTodoListPage.getTodoStatus(toDoName);
       String expected ="" ;
       if (exactedState.equals(ToDoState.DONE)){
           expected = "completed";
       }
       Assert.assertEquals(actualStatus,expected,"Todo State was not as expected");
    }
}
