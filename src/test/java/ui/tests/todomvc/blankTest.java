package ui.tests.todomvc;

import org.testng.annotations.Test;
import ui.tests.todomvc.pages.TodomvcHomePage;
import ui.tests.todomvc.pages.TodomvcTodoListPage;
import ui.tests.todomvc.tests.BaseTest;


public class blankTest extends BaseTest {

    @Test
    public void seleinumTest01()  {

        TodomvcHomePage homePage = new TodomvcHomePage(driver);
        TodomvcTodoListPage listPage = new TodomvcTodoListPage(driver);
        homePage.getPage();
        listPage.setNewTodoName("My new Task");
    }

}
