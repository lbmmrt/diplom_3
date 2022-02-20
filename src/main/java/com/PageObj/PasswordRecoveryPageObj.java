package com.PageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPageObj {
    static public final String PATH_PASSWORD_RECOVERY = "/forgot-password";

    //поле для email
    @FindBy(how = How.XPATH,using = "(.//input[@class='text input__textfield text_type_main-default'])[1]")
    private SelenideElement fieldForEmail;

    //кнопка войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement buttonSignIn;

    public SelenideElement getFieldForEmail() {
        return fieldForEmail;
    }

    public SelenideElement getButtonSignIn() {
        return buttonSignIn;
    }

    public void clickButtonSignIn() {
        getButtonSignIn().click();
    }
}
