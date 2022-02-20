import com.PageObj.LoginPageObj;
import com.PageObj.MainPageObj;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorBurgerTest {
    private final UserOperations userOperations = new UserOperations();

    @Before
    public void generateData() {
        Map<String, String> userData = userOperations.register();

        LoginPageObj loginPageObj = open(MainPageObj.getFullPath(LoginPageObj.PATH_PAGE_LOGIN), LoginPageObj.class);
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));
    }

    @After
    public void clearData() {
        userOperations.delete();
    }

    @Test
    public void checkMoveToSouse() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickToggleSouse();
        mainPageObj.visibleCatalogSouse();
    }

    @Test
    public void checkMoveToBun() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickToggleSouse();
        mainPageObj.clickToggleBun();
        mainPageObj.visibleCatalogBun();
    }

    @Test
    public void checkMoveToIngredients() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickToggleIngredients();
        mainPageObj.visibleCatalogIngredients();
    }
}
