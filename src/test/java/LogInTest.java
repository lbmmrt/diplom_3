import com.codeborne.selenide.Condition;
import com.pageObj.LoginPageObj;
import com.pageObj.MainPageObj;
import com.pageObj.PasswordRecoveryPageObj;
import com.pageObj.RegistrationPageObj;
import com.UserOperations;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import io.qameta.allure.junit4.DisplayName;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogInTest {
    private final UserOperations userOperations = new UserOperations();
    private Map<String, String> userData;

    @Before
    public void generateData() {
        userData = userOperations.register();
    }

    @After
    public void clearData() {
        userOperations.delete();
    }

    @DisplayName("Логин на главной странице")
    @Test
    public void logInFromMainPage() {
        MainPageObj mainPageObj = open(MainPageObj.getFullPath(), MainPageObj.class);
        mainPageObj.clickButtonLogInAccount();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.getButtonSignIn().shouldBe(Condition.visible);
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        mainPageObj.getLabelConstructorBurger().shouldBe(Condition.visible);
    }

    @DisplayName("Логин через кнопку личного кабинета")
    @Test
    public void loginThroughButtonPersonalArea() {
        MainPageObj mainPageObj = open(MainPageObj.getFullPath(), MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.getButtonSignIn().shouldBe(Condition.visible);
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        mainPageObj.getLabelConstructorBurger().shouldBe(Condition.visible);
    }

    @DisplayName("Логин через кнопку под формой регистрации")
    @Test
    public void loginThroughRegistrationForm() {
        RegistrationPageObj registrationPageObj = open(MainPageObj.getFullPath(RegistrationPageObj.PATH_PAGE_REGISTER), RegistrationPageObj.class);
        registrationPageObj.clickButtonSignIn();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.getButtonSignIn().shouldBe(Condition.visible);
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.getLabelConstructorBurger().shouldBe(Condition.visible);
    }


    @DisplayName("Логин через форму восставновления пароля")
    @Test
    public void loginThroughPasswordRecoveryForm() {
        PasswordRecoveryPageObj passwordRecoveryPageObj = open(MainPageObj.getFullPath(PasswordRecoveryPageObj.PATH_PASSWORD_RECOVERY), PasswordRecoveryPageObj.class);
        passwordRecoveryPageObj.clickButtonSignIn();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.getButtonSignIn().shouldBe(Condition.visible);
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonConstructor();
        mainPageObj.getLabelConstructorBurger().shouldBe(Condition.visible);
    }
}
