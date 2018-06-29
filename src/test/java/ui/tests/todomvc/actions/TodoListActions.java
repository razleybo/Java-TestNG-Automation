package ui.tests.todomvc.actions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import ui.tests.todomvc.pages.TodoHomePage;
import ui.tests.todomvc.pages.TodoTodoListPage;
import utils.webdriverWrapper.DriverWrapper;

public class TodoListActions extends ActionsBase {

    public enum ToDoState{
        DONE,TODO;
        @Override
        public String toString(){
            return this.name();
        }
    }

    private TodoHomePage todomvcHomePage;
    private TodoTodoListPage todomvcTodoListPage;

    public TodoListActions(DriverWrapper driver) {
        super(driver);
    }

    protected void initPages(DriverWrapper driver) {
        logger.trace("starting pages");
        todomvcHomePage = new TodoHomePage(driver);
        todomvcTodoListPage = new TodoTodoListPage(driver);
    }

    public void goToTodoListPage(){
        logger.debug("Navigate to the todo list page");
        todomvcHomePage.getPage();
        todomvcTodoListPage.waitForPageLoade();
    }
    public void addNewTodo(String todoName) {
        logger.debug("Adding todo task named : "+todoName);
        todomvcTodoListPage.setNewTodoName(todoName);
        todomvcTodoListPage.approveOnNewTodo();
    }

    public void verifyLastTodo(String toDoName) {
        logger.debug("Verify todo task named : "+toDoName +" is the last one on the list");
        String actualLastTodo = todomvcTodoListPage.getLastTodoText();
        Assert.assertEquals(actualLastTodo,toDoName,"Last todo was not as expected");
    }

    public void toggleToDo(String toDoName) {
        logger.debug("toggle todo named : "+toDoName);
        todomvcTodoListPage.toggleTodo(toDoName);
    }

    public void verifyToDoState(String toDoName, ToDoState exactedState) {
        logger.debug("verify that todo  named : "+toDoName+ "is at state "+exactedState );
       String actualStatus =  todomvcTodoListPage.getTodoStatus(toDoName);
       String expected ="" ;
       if (exactedState.equals(ToDoState.DONE)){
           expected = "completed";
       }
       Assert.assertEquals(actualStatus,expected,"Todo State was not as expected");
    }
}
