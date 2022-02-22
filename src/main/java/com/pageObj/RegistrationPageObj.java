package com.pageObj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPageObj {
    static public final String PATH_PAGE_REGISTER = "/register";

    //поле для имени
    @FindBy(how = How.XPATH,using = "(.//input[@class='text input__textfield text_type_main-default'])[1]")
    private SelenideElement fieldForName;

    //поле для email
    @FindBy(how = How.XPATH,using = "(.//input[@class='text input__textfield text_type_main-default'])[2]")
    private SelenideElement fieldForEmail;

    //поле для password
    @FindBy(how = How.XPATH,using = "(.//input[@class='text input__textfield text_type_main-default'])[3]")
    private SelenideElement fieldForPassword;

    //кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement buttonForRegistration;

    //уведомление о неверном пароле
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement badPasswordNotification;

    //кнопка "Войти"
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement buttonSignIn;


    public SelenideElement getFieldForName() {
        return fieldForName;
    }

    public SelenideElement getFieldForEmail() {
        return fieldForEmail;
    }

    public SelenideElement getFieldForPassword() {
        return fieldForPassword;
    }

    public SelenideElement getButtonForRegistration() {
        return buttonForRegistration;
    }

    public SelenideElement getButtonSignIn() {
        return buttonSignIn;
    }

    public SelenideElement getBadPasswordNotification() {
        return badPasswordNotification;
    }

    @Step("Регистрация пользователя")
    public void registerUser(String nameUser, String emailUser, String passwordUser) {
        getFieldForName().setValue(nameUser);
        getFieldForEmail().setValue(emailUser);
        getFieldForPassword().setValue(passwordUser);
        getButtonForRegistration().click();
    }

    @Step("Ввод пароля")
    public void setValueInFieldPassword(String passwordUser) {
        getFieldForPassword().setValue(passwordUser);
        getFieldForEmail().click(); //чтобы сместить фокус с пароля
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickButtonSignIn() {
        getButtonSignIn().click();
    }
}
