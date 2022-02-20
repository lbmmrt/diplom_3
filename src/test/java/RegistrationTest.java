import com.PageObj.LoginPageObj;
import com.PageObj.MainPageObj;
import com.PageObj.RegistrationPageObj;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {

    @Test
    public void registration() {
        RegistrationPageObj registrationPageObj = open(MainPageObj.getFullPath(RegistrationPageObj.PATH_PAGE_REGISTER), RegistrationPageObj.class);
        registrationPageObj.registerUser(RandomStringUtils.randomAlphabetic(11),
                RandomStringUtils.randomAlphabetic(11)+"@mail.ru",
                RandomStringUtils.randomAlphabetic(11));

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.buttonSignInIsVisible();
    }

    @Test
    public void checkNotificationBadPassword() {
        RegistrationPageObj registrationPageObj = open(MainPageObj.getFullPath(RegistrationPageObj.PATH_PAGE_REGISTER), RegistrationPageObj.class);
        registrationPageObj.setValueInFieldPasswordAndCheckNotificationBadPassword("342");
    }
}
