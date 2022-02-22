import com.codeborne.selenide.Condition;
import com.pageObj.LoginPageObj;
import com.pageObj.MainPageObj;
import com.UserOperations;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;

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

    @DisplayName("Переключение на раздел с соусами")
    @Test
    public void checkMoveToSouse() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickToggleSouse();
        mainPageObj.getCatalogSouse().shouldBe(Condition.visible);
    }

    @DisplayName("Переключение на раздел с булочками")
    @Test
    public void checkMoveToBun() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickToggleSouse();
        mainPageObj.clickToggleBun();
        mainPageObj.getCatalogBun().shouldBe(Condition.visible);
    }

    @DisplayName("Переключение на раздел с ингредиентами")
    @Test
    public void checkMoveToIngredients() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickToggleIngredients();
        mainPageObj.getCatalogIngredients().shouldBe(Condition.visible);
    }
}
