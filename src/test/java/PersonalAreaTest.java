import com.codeborne.selenide.Condition;
import com.pageObj.LoginPageObj;
import com.pageObj.MainPageObj;
import com.pageObj.PersonalAreaPageObj;
import com.UserOperations;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import io.qameta.allure.junit4.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class PersonalAreaTest {

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

    @DisplayName("Переход к личному кабинету через кнопку 'Личный кабинет'")
    @Test
    public void goToPersonalAccountThroughButton() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();

        PersonalAreaPageObj personalAreaPageObj = page(PersonalAreaPageObj.class);
        personalAreaPageObj.getLabelProfile().shouldBe(Condition.visible);
    }

    @DisplayName("Переход из личного кабинета в конструктор через кнопку 'Конструктор'")
    @Test
    public void FromPersonalAccountThroughButtonConstructor() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();
        mainPageObj.clickButtonConstructor();
        mainPageObj.getLabelConstructorBurger().shouldBe(Condition.visible);
    }

    @DisplayName("Переход из личного кабинета в конструктор через лого 'Stellar Burgers'")
    @Test
    public void FromPersonalAccountThroughLogoStellarBurgers() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();
        mainPageObj.clickLogoStellarBurgers();
        mainPageObj.getLabelConstructorBurger().shouldBe(Condition.visible);
    }

    @DisplayName("Выход из аккаунта по кнопке 'Выйти' в личном кабинете")
    @Test
    public void logoutThoughButtonInPersonalArea() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();

        PersonalAreaPageObj personalAreaPageObj = page(PersonalAreaPageObj.class);
        personalAreaPageObj.clickButtonLogout();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.getButtonSignIn().shouldBe(Condition.visible);
    }
}
