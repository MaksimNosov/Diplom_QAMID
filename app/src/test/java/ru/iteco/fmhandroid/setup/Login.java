package ru.iteco.fmhandroid.setup;

import org.junit.jupiter.api.AfterEach;
import ru.iteco.fmhandroid.elements.LoginElements;

import java.util.concurrent.TimeUnit;

/**
 * Класс для успешной авторизации в приложение
 */
public class Login extends CreateDriver {

    String validLogin = "login2";
    String validPassword = "password2";
    LoginElements loginElements;

    public void loginToApp() {
        loginElements = new LoginElements(driver);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        loginElements.loginField.isDisplayed();
        loginElements.loginField.sendKeys(validLogin);

        loginElements.passwordField.isDisplayed();
        loginElements.passwordField.sendKeys(validPassword);

        loginElements.loginButton.isDisplayed();
        loginElements.loginButton.click();
    }

    @AfterEach
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

