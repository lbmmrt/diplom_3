import com.PageObj.LoginPageObj;
import com.PageObj.MainPageObj;
import com.PageObj.PasswordRecoveryPageObj;
import com.PageObj.RegistrationPageObj;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void logInFromMainPage() {
        MainPageObj mainPageObj = open(MainPageObj.getFullPath(), MainPageObj.class);
        mainPageObj.clickButtonLogInAccount();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.buttonSignInIsVisible();
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        mainPageObj.labelConstructorBurgerIsVisible();
    }

    @Test
    public void loginThroughButtonPersonalArea() {
        MainPageObj mainPageObj = open(MainPageObj.getFullPath(), MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.buttonSignInIsVisible();
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        mainPageObj.labelConstructorBurgerIsVisible();
    }

    @Test
    public void loginThroughRegistrationForm() {
        RegistrationPageObj registrationPageObj = open(MainPageObj.getFullPath(RegistrationPageObj.PATH_PAGE_REGISTER), RegistrationPageObj.class);
        registrationPageObj.clickButtonSignIn();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.buttonSignInIsVisible();
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.labelConstructorBurgerIsVisible();
    }

    @Test
    public void loginThroughPasswordRecoveryForm() {
        PasswordRecoveryPageObj passwordRecoveryPageObj = open(MainPageObj.getFullPath(PasswordRecoveryPageObj.PATH_PASSWORD_RECOVERY), PasswordRecoveryPageObj.class);
        passwordRecoveryPageObj.clickButtonSignIn();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.buttonSignInIsVisible();
        loginPageObj.signInAccount(userData.get("email"), userData.get("password"));

        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonConstructorAndVisibleLabelConstructorBurger();
    }
}
