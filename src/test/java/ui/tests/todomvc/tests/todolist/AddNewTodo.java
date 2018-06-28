package ui.tests.todomvc.tests.todolist;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import ui.tests.todomvc.tests.BaseTest;


public class AddNewTodo extends BaseTest {
    final int MAX_TASKS = 10 ;
    private String toDoName = "My Awesome ToDo";
    @Description("This test create a new Todo task and verify it location on the list")
    @Test
    @Step("Create first task")
    public void addNewTask(){
        todoListActions.goToTodoListPage();
        todoListActions.addNewTodo(toDoName);
        todoListActions.verifyLastTodo(toDoName);
    }
    @Test(dependsOnMethods = "addNewTask")
    @Step("Verify new tasks are added below")
    public void addMultipleTasks(){
        for (int todoIteration =0 ;todoIteration<MAX_TASKS ; todoIteration++) {
            todoListActions.addNewTodo(toDoName+todoIteration);
            todoListActions.verifyLastTodo(toDoName+todoIteration);
        }
    }
}
