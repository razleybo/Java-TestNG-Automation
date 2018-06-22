package ui.tests.todomvc.actions;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.tests.todomvc.pages.TodomvcHomePage;
import ui.tests.todomvc.pages.TodomvcTodoListPage;

public class TodoListActions extends ActionsBase {

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
    }
    public void addNewTodo(String todoName) {
        todomvcTodoListPage.setNewTodoName(todoName);
        todomvcTodoListPage.hitEnterOnNewTodo();
    }
}
