package ru.iteco.fmhandroid.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.iteco.fmhandroid.elements.LoginElements;
import ru.iteco.fmhandroid.elements.MainElements;
import ru.iteco.fmhandroid.setup.CreateDriver;
import ru.iteco.fmhandroid.setup.Login;
import ru.iteco.fmhandroid.setup.TestListener;

import java.net.MalformedURLException;

/**
 * Класс для тестирования Авторизации
 */
@ExtendWith(TestListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTests extends CreateDriver {
    LoginElements loginElements;
    MainElements mainElements;

    String validLogin = "login2";
    String validPassword = "password2";
    String invalidLogin = "логин";
    String invalidPassword = "пароль";

    @BeforeEach
    @Step("1. Запуск приложения")
    public void createDriver() throws MalformedURLException {

        CreateDriver createDriver = new CreateDriver();
        createDriver.createDriver();

        loginElements = new LoginElements(driver);
        mainElements = new MainElements(driver);
    }

    @Test
    @DisplayName("1. Application loading indicator is displayed")
    @Step("2. Отображается индикатор загрузки приложения")
    @Description("Индикатор загрузки присутствует")
    public void loaderDisplayed1() {

        loginElements.loader.isDisplayed();
    }

    @Test
    @DisplayName("2. Application loading img is displayed")
    @Step("2. Во время загрузки приложения отображается картинка")
    @Description("Картинка отображается")
    public void loadingImgDisplayed2() {

        loginElements.loadingImg.isDisplayed();
    }

    @Test
    @DisplayName("3. Loading Citation is displayed")
    @Step("2. Во время загрузки приложения отображается цитата")
    @Description("Цитата отображается")
    public void loadingCitationDisplayed3() {

        loginElements.loadingCitation.isDisplayed();
    }

    @Test
    @DisplayName("4. Filling authorization fields in Latin letters")
    @Step("2. Во время загрузки приложения отображается цитата")
    @Description("Цитата отображается")
    public void fillLatinLetters4() {

        loginElements.loginField.isDisplayed();
        loginElements.loginField.sendKeys(validLogin);

        loginElements.passwordField.isDisplayed();
        loginElements.passwordField.sendKeys(validPassword);

        Assertions.assertEquals(validLogin, loginElements.loginField.getText());
        Assertions.assertEquals(validPassword, loginElements.passwordField.getText());
    }

    @Test
    @DisplayName("5. Filling authorization fields in Cyrillic letters")
    @Step("2. Заполнение полей авторизации кириллическими буквами")
    @Description("Поле не заполнено")
    public void fillCyrillicLetters5() {

        loginElements.loginField.isDisplayed();
        loginElements.loginField.sendKeys(invalidLogin);

        loginElements.passwordField.isDisplayed();
        loginElements.passwordField.sendKeys(invalidPassword);

        loginElements.loginButton.click();

        Assertions.assertEquals("", loginElements.loginField.getText());
        Assertions.assertEquals("", loginElements.passwordField.getText());
    }

    @Test
    @DisplayName("6. Entry to App with valid data")
    @Step("2. Вход в систему с валидными данными")
    @Description("Авторизация прошла, открылась главная страница")
    public void entryToAppWithValidData6() {
        Login login = new Login();
        login.loginToApp();

        mainElements.mainHeaderClaims.isDisplayed();
    }

    @Test
    @DisplayName("9. Exit application")
    @Step("2. Выход из приложения")
    @Description("Открылась страница авторизации")
    public void exitApplication9() {
        Login login = new Login();
        login.loginToApp();

        loginElements.authorizationButton.isDisplayed();
        loginElements.authorizationButton.click();

        loginElements.logOutButton.isDisplayed();
        loginElements.logOutButton.click();

        loginElements.loginField.isDisplayed();
    }
}
