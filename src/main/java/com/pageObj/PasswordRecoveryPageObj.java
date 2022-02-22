package com.pageObj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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


    @Step("Клик по кнопке 'Войти'")
    public void clickButtonSignIn() {
        getButtonSignIn().click();
    }
}
