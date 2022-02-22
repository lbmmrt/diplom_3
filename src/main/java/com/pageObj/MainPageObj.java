package com.pageObj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageObj {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String BASE_URL_WITH_PATH = BASE_URL + "%s";

    public static String getFullPath(String path) {
        return String.format(BASE_URL_WITH_PATH, path);
    }

    public static String getFullPath() {
        return BASE_URL;
    }

    //кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement buttonLogInAccount;

    //заголовок "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement labelConstructorBurger;

    //кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalArea;

    //лого "Stellar Burgers"
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoStellarBurgers;

    //кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement buttonConstructor;

    //переключатель "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement toggleSouse;

    //переключатель "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement toggleBun;

    //переключатель "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement toggleIngredients;

    //карточка "Булки"
    @FindBy(how = How.XPATH, using = "(.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[1]")
    private SelenideElement catalogBun;

    //карточка "Соусы"
    @FindBy(how = How.XPATH, using = "(.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[2]")
    private SelenideElement catalogSouse;

    //карточка "Начинки"
    @FindBy(how = How.XPATH, using = "(.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[3]")
    private SelenideElement catalogIngredients;

    public SelenideElement getButtonLogInAccount() {
        return buttonLogInAccount;
    }

    public SelenideElement getLabelConstructorBurger() {
        return labelConstructorBurger;
    }

    public SelenideElement getButtonPersonalArea() {
        return buttonPersonalArea;
    }

    public SelenideElement getButtonConstructor() {
        return buttonConstructor;
    }

    public SelenideElement getLogoStellarBurgers() {
        return logoStellarBurgers;
    }

    public SelenideElement getToggleSouse() {
        return toggleSouse;
    }

    public SelenideElement getToggleBun() {
        return toggleBun;
    }

    public SelenideElement getToggleIngredients() {
        return toggleIngredients;
    }

    public SelenideElement getCatalogBun() {
        return catalogBun;
    }

    public SelenideElement getCatalogSouse() {
        return catalogSouse;
    }

    public SelenideElement getCatalogIngredients() {
        return catalogIngredients;
    }

    @Step("Клик по кнопке входа в аккаун")
    public void clickButtonLogInAccount() {
        getButtonLogInAccount().click();
    }

    @Step("Клик по кнопке входа в личный кабинет")
    public void clickButtonPersonalArea() {
        getButtonPersonalArea().click();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickButtonConstructor() {
        getButtonConstructor().click();
    }

    @Step("Клик по лого 'Stellar Burgers'")
    public void clickLogoStellarBurgers() {
        getLogoStellarBurgers().click();
    }

    @Step("Клик по переключателю на 'Соусы'")
    public void clickToggleSouse() {
        getToggleSouse().click();
    }

    @Step("Клик по переключателю на 'Булочки'")
    public void clickToggleBun() {
        getToggleBun().click();
    }

    @Step("клик по переключателю на 'Ингредиенты'")
    public void clickToggleIngredients() {
        getToggleIngredients().click();
    }
}
