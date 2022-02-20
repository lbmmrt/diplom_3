package com.PageObj;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAreaPageObj {
    static public final String PATH_ACCOUNT_PROFILE = "/account/profile";

    //раздел "Профиль"
    @FindBy(how = How.XPATH,using = ".//a[text()='Профиль']")
    private SelenideElement labelProfile;

    //кнопка "Выход"
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement buttonLogout;

    public SelenideElement getLabelProfile() {
        return labelProfile;
    }

    public SelenideElement getButtonLogout() {
        return buttonLogout;
    }

    public void labelProfileIsVisible() {
        getLabelProfile().shouldBe(Condition.visible);
    }

    public void clickButtonLogout() {
        getButtonLogout().click();
    }
}
