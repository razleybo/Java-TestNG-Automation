package ui.tests.todomvc.tests.todolist;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.tests.todomvc.tests.BaseTest;


public class AddNewTodo extends BaseTest {
    final int MAX_TASKS = 10 ;
    private String todoName = "My Awesome ToDo";

    @Description("This test create a new Todo task and verify it location on the list")

    @Test(description = "Create first task")
    public void addNewTask(){
        todoListActions.goToTodoListPage();
        todoListActions.addNewTodo(todoName);
        todoListActions.verifyLastTodo(todoName);
    }
    @Test(description = "Adding lots of tasks and verify new tasks are added below", dependsOnMethods = "addNewTask")
    public void addMultipleTasks(){
        for (int todoIteration =0 ;todoIteration<MAX_TASKS ; todoIteration++) {
            todoListActions.addNewTodo(todoName+todoIteration);
            todoListActions.verifyLastTodo(todoName+todoIteration);
        }
    }
}
