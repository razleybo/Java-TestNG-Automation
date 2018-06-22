package ui.tests.todomvc.tests.todolist;

import org.testng.annotations.Test;
import ui.tests.todomvc.actions.TodoListActions;
import ui.tests.todomvc.tests.BaseTest;

public class MarkTodoAsDone extends BaseTest {

    String toDoName = "My Awesome ToBeDone";
    @Test
    public void addNewTask(){
        todoListActions.goToTodoListPage();
        todoListActions.addNewTodo(toDoName);
        todoListActions.verifyLastTodo(toDoName);
        todoListActions.verifyToDoState(toDoName,TodoListActions.ToDoState.TODO);
    }
    @Test(dependsOnMethods = "addNewTask")
    public void markTodoAsDone(){
        todoListActions.toggleToDo(toDoName);
        todoListActions.verifyToDoState(toDoName,TodoListActions.ToDoState.DONE);
    }
    @Test(dependsOnMethods = "markTodoAsDone")
    public void unMarkTodoAsDone(){
        todoListActions.toggleToDo(toDoName);
        todoListActions.verifyToDoState(toDoName,TodoListActions.ToDoState.TODO);
    }
}
