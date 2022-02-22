package com.pageObj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObj {
    static public final String PATH_PAGE_LOGIN = "/login";

    //поле для email
    @FindBy(how = How.XPATH, using = "(.//input[@class='text input__textfield text_type_main-default'])[1]")
    private SelenideElement fieldForEmail;

    //поле для password
    @FindBy(how = How.XPATH, using = "(.//input[@class='text input__textfield text_type_main-default'])[2]")
    private SelenideElement fieldForPassword;

    //кнока "Вход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement buttonSignIn;


    public SelenideElement getFieldForEmail() {
        return fieldForEmail;
    }

    public SelenideElement getFieldForPassword() {
        return fieldForPassword;
    }

    public SelenideElement getButtonSignIn() {
        return buttonSignIn;
    }

    @Step("Вход в аккаунт")
    public void signInAccount(String userEmail, String userPassword) {
        getFieldForEmail().setValue(userEmail);
        getFieldForPassword().setValue(userPassword);
        getButtonSignIn().click();
    }
}
