package ru.iteco.fmhandroid.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.iteco.fmhandroid.elements.AboutElements;
import ru.iteco.fmhandroid.elements.MainElements;
import ru.iteco.fmhandroid.setup.CreateDriver;
import ru.iteco.fmhandroid.setup.Login;
import ru.iteco.fmhandroid.setup.TestListener;

import java.net.MalformedURLException;

/**
 * Класс для тестирования вкладки About
 */
@ExtendWith(TestListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AboutTests extends CreateDriver {
    AboutElements aboutElements;
    MainElements mainElements;

    @BeforeEach
    @Step("1. Запуск приложения и успешная авторизация")
    public void createDriverAndLoginToApp() throws MalformedURLException {
        CreateDriver createDriver = new CreateDriver();
        createDriver.createDriver();

        Login login = new Login();
        login.loginToApp();

        aboutElements = new AboutElements(driver);
        mainElements = new MainElements(driver);
    }

    @Test
    @DisplayName("22. Present app version on about page")
    @Step("2. Наличие на странице 'О приложении' информации о текущей версии приложения")
    @Description("Версия приложения отображается")
    public void presentAppVersion22() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.aboutButton.isDisplayed();
        mainElements.aboutButton.click();

        aboutElements.version.isDisplayed();
        aboutElements.versionValue.isDisplayed();
    }

    @Test
    @DisplayName("23. Link privacy policy works on about page")
    @Step("2. На странице 'О приложении' ссылка на политику конфиденциальности работает")
    @Description("Открылась страница с информацией о конфиденциальности")
    public void linkPrivacyPolicyWorks23() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.aboutButton.isDisplayed();
        mainElements.aboutButton.click();

        aboutElements.linkPrivacyPolicy.isDisplayed();
        aboutElements.linkPrivacyPolicy.click();
        aboutElements.chromeWelcome.isDisplayed();
    }

    @Test
    @DisplayName("24. Link terms of use works on about page")
    @Step("2. На странице 'О приложении' ссылка на условия использования работает")
    @Description("Открылась страница с информацией о условиях использования")
    public void linkTermsOfUseWorks24() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.aboutButton.isDisplayed();
        mainElements.aboutButton.click();

        aboutElements.linkTermsOfUse.isDisplayed();
        aboutElements.linkTermsOfUse.click();
        aboutElements.chromeWelcome.isDisplayed();
    }

    @Test
    @DisplayName("25. Manufacturer information displayed on about page")
    @Step("2. Наличие на странице 'О приложении' информации о производителе приложения")
    @Description("Информация о производителе отображается")
    public void manufacturerInformationDisplayed25() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.aboutButton.isDisplayed();
        mainElements.aboutButton.click();

        aboutElements.manufacturerInformation.isDisplayed();
    }

    @Test
    @DisplayName("26. Return from about page to main page")
    @Step("2. Возврат со страницы 'О приложении' на основную страницу через стрелочку")
    @Description("Открылась страница Main")
    public void returnFromAboutToMain26() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.aboutButton.isDisplayed();
        mainElements.aboutButton.click();

        aboutElements.backButton.isDisplayed();
        aboutElements.backButton.click();

        mainElements.mainHeaderNews.isDisplayed();
        mainElements.mainHeaderClaims.isDisplayed();
    }
}
