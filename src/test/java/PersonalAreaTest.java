import com.PageObj.LoginPageObj;
import com.PageObj.MainPageObj;
import com.PageObj.PersonalAreaPageObj;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void goToPersonalAccountThroughButton() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();

        PersonalAreaPageObj personalAreaPageObj = page(PersonalAreaPageObj.class);
        personalAreaPageObj.labelProfileIsVisible();
    }

    @Test
    public void FromPersonalAccountThroughButtonConstructor() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();
        mainPageObj.clickButtonConstructorAndVisibleLabelConstructorBurger();
    }

    @Test
    public void FromPersonalAccountThroughLogoStellarBurgers() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();
        mainPageObj.clickLogoStellarBurgersAndVisibleLabelConstructorBurger();
    }

    @Test
    public void logoutThoughButtonInPersonalArea() {
        MainPageObj mainPageObj = page(MainPageObj.class);
        mainPageObj.clickButtonPersonalArea();

        PersonalAreaPageObj personalAreaPageObj = page(PersonalAreaPageObj.class);
        personalAreaPageObj.clickButtonLogout();

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.buttonSignInIsVisible();
    }
}
