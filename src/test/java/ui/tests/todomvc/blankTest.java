package ui.tests.todomvc;

import org.testng.annotations.Test;
import ui.tests.todomvc.tests.BaseTest;


public class blankTest extends BaseTest {

    @Test
    public void seleinumTest01()  {

        todoListActions.goToTodoListPage();
        todoListActions.addNewTodo("todoName");
    }

}
