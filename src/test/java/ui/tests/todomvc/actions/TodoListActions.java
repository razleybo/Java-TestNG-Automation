package ui.tests.todomvc.actions;

import org.testng.Assert;
import ui.tests.todomvc.pages.TodoHomePage;
import ui.tests.todomvc.pages.TodoTodoListPage;
import utils.webdriverWrapper.DriverWrapper;

public class TodoListActions extends ActionsBase {

    public enum ToDoState{
        DONE {
            @Override
            public String toString(){
                return "completed";
            }
        }
        ,TODO{
            @Override
            public String toString(){
                return "";
            }
        }
    }

    private TodoHomePage todoHomePage;
    private TodoTodoListPage todoTodoListPage;

    public TodoListActions(DriverWrapper driver) {
        super(driver);
    }

    protected void initPages(DriverWrapper driver) {
        logger.trace("starting pages");
        todoHomePage = new TodoHomePage(driver);
        todoTodoListPage = new TodoTodoListPage(driver);
    }

    public void goToTodoListPage(){
        logger.debug("Navigate to the todo list page");
        todoHomePage.getPage();
        todoTodoListPage.waitForPageLoad();
    }
    public void addNewTodo(String todoName) {
        logger.debug("Adding todo task named : "+todoName);
        todoTodoListPage.setNewTodoName(todoName);
        todoTodoListPage.approveOnNewTodo();
    }

    public void verifyLastTodo(String todoName) {
        logger.debug("Verify todo task named : "+todoName +" is the last one on the list");
        String actualLastTodo = todoTodoListPage.getLastTodoText();

        Assert.assertNotNull(actualLastTodo,"No todo ware found in tha list ");
        Assert.assertEquals(actualLastTodo,todoName,"Last todo was not as expected");
    }

    public void toggleToDo(String todoName) {
        logger.debug("toggle todo named : "+todoName);
        todoTodoListPage.toggleTodo(todoName);
    }

    public void verifyToDoState(String todoName, ToDoState exactedState) {
        logger.debug("verify that todo  named : "+todoName+ "is at state "+exactedState );
       String actualStatus =  todoTodoListPage.getTodoStatus(todoName);
       Assert.assertEquals(actualStatus,exactedState.toString(),"Todo State was not as expected");
    }
}
