import com.codeborne.selenide.Condition;
import com.pageObj.LoginPageObj;
import com.pageObj.MainPageObj;
import com.pageObj.RegistrationPageObj;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {

    @DisplayName("Успешная регистрация")
    @Test
    public void registration() {
        RegistrationPageObj registrationPageObj = open(MainPageObj.getFullPath(RegistrationPageObj.PATH_PAGE_REGISTER), RegistrationPageObj.class);
        registrationPageObj.registerUser(RandomStringUtils.randomAlphabetic(11),
                RandomStringUtils.randomAlphabetic(11) + "@mail.ru",
                RandomStringUtils.randomAlphabetic(11));

        LoginPageObj loginPageObj = page(LoginPageObj.class);
        loginPageObj.getButtonSignIn().shouldBe(Condition.visible);
    }


    @DisplayName("Проверка ошибки для некорректного пароля")
    @Test
    public void checkNotificationBadPassword() {
        RegistrationPageObj registrationPageObj = open(MainPageObj.getFullPath(RegistrationPageObj.PATH_PAGE_REGISTER), RegistrationPageObj.class);
        registrationPageObj.setValueInFieldPassword("342");
        registrationPageObj.getBadPasswordNotification().shouldBe(Condition.visible);
    }
}
