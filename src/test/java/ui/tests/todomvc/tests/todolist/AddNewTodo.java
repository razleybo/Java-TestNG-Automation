package ui.tests.todomvc.tests.todolist;

import org.testng.annotations.Test;
import ui.tests.todomvc.tests.BaseTest;

public class AddNewTodo extends BaseTest {
   String toDoName = "My Awesome ToDo";
    @Test
    public void addNewTask(){
        todoListActions.goToTodoListPage();
        todoListActions.addNewTodo(toDoName);
        todoListActions.verifyLastTodo(toDoName);
    }
    @Test(dependsOnMethods = "addNewTask")
    public void addMultipleTasks(){
        final int MAX_TASKS = 10 ;
        for (int todoIteration =0 ;todoIteration<MAX_TASKS ; todoIteration++) {
            todoListActions.addNewTodo(toDoName+todoIteration);
            todoListActions.verifyLastTodo(toDoName+todoIteration);
        }
    }
}
