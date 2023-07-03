package ru.iteco.fmhandroid.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import ru.iteco.fmhandroid.elements.AboutElements;
import ru.iteco.fmhandroid.elements.ClaimsElements;
import ru.iteco.fmhandroid.elements.MainElements;
import ru.iteco.fmhandroid.elements.NewsElements;
import ru.iteco.fmhandroid.setup.CreateDriver;
import ru.iteco.fmhandroid.setup.Login;

import java.net.MalformedURLException;

/**
 * Класс для тестирования вкладки Main
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTests extends CreateDriver {
    MainElements mainElements;
    ClaimsElements claimsElements;
    NewsElements newsElements;
    AboutElements aboutElements;

    @BeforeEach
    @Step("1. Запуск приложения и успешная авторизация")
    public void createDriverAndLoginToApp() throws MalformedURLException {

        CreateDriver createDriver = new CreateDriver();
        createDriver.createDriver();

        Login login = new Login();
        login.loginToApp();

        mainElements = new MainElements(driver);
        claimsElements = new ClaimsElements(driver);
        newsElements = new NewsElements(driver);
        aboutElements = new AboutElements(driver);
    }

    @Test
    @DisplayName("10. Open menu with pages list (hamburger button)")
    @Step("2. Открытие меню со списком страниц (кнопка гамбургер слева сверху)")
    @Description("Отображается Main, Claims, News, About")
    public void openMenuWithPagesList10() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();

        mainElements.claimsButton.isDisplayed();
        mainElements.newsButton.isDisplayed();
        mainElements.mainButton.isDisplayed();
        mainElements.aboutButton.isDisplayed();
    }

    @Test
    @DisplayName("11. Go from main page to claims page through menu")
    @Step("2. Переход с главной страницы на страницу с претензиями через меню")
    @Description("Открылась страница с претензиями")
    public void goFromMainToClaims11() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.claimsButton.click();

        claimsElements.claimsHeader.isDisplayed();
        Assertions.assertEquals("Claims", claimsElements.claimsHeader.getText());
    }

    @Test
    @DisplayName("12. Go from main page to news page through menu")
    @Step("2. Переход с главной страницы на страницу с новостями через меню")
    @Description("Открылась страница с новостями")
    public void goFromMainToNews12() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.newsButton.isDisplayed();
        mainElements.newsButton.click();

        newsElements.newsHeader.isDisplayed();
        Assertions.assertEquals("News", newsElements.newsHeader.getText());
    }

    @Test
    @DisplayName("13. Go from main page to about page through menu")
    @Step("2. Переход с главной страницы на страницу О приложении через меню")
    @Description("Открылась страница О приложении")
    public void goFromMainToAbout13() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.aboutButton.isDisplayed();
        mainElements.aboutButton.click();

        Assertions.assertEquals("Version:", aboutElements.version.getText());
    }

    @Test
    @DisplayName("14. Go from any page to main page through menu")
    @Step("2. Переход с любой страницы на главную через меню")
    @Description("Открылась страница с новостями")
    public void goFromAnyPageToMain14() {

        mainElements.menuButton.isDisplayed();
        mainElements.menuButton.click();
        mainElements.newsButton.click();
        newsElements.newsHeader.isDisplayed();
        mainElements.menuButton.click();
        mainElements.mainButton.click();

        mainElements.mainHeaderNews.isDisplayed();
        Assertions.assertEquals("News", mainElements.mainHeaderNews.getText());

        mainElements.mainHeaderClaims.isDisplayed();
        Assertions.assertEquals("Claims", mainElements.mainHeaderClaims.getText());
    }

    @Test
    @DisplayName("15. Go from main page to Love is ll page")
    @Step("2. Переход к странице Love is ll с главной страницы")
    @Description("Отображаются цитаты")
    public void goFromMainPageToLoveIsAll15() {

        mainElements.butterflyButton.isDisplayed();
        mainElements.butterflyButton.click();

        mainElements.loveIsAllHeader.isDisplayed();
        Assertions.assertEquals("Love is all", mainElements.loveIsAllHeader.getText());
        mainElements.loveIsAllCitation.isDisplayed();
    }

    @Test
    @DisplayName("16. Go to news page from main through All News in the news block")
    @Step("2. Переход на страницу с новостями с главного экрана через All News в блоке новостей")
    @Description("Открылась страница News")
    public void goFromMainPageToNewsPage16() {

        newsElements.allNewsButton.click();
        newsElements.newsHeader.isDisplayed();

        Assertions.assertEquals("News", newsElements.newsHeader.getText());
    }

    @Test
    @DisplayName("17. Go to claims page from main through All Claims in news block")
    @Step("2. Переход на страницу с претензиями с главного экрана через All Claims в блоке новостей")
    @Description("Открылась страница Claims")
    public void goFromMainPageToAllClaimsPage17() {

        claimsElements.allClaimsButton.click();
        claimsElements.claimsHeader.isDisplayed();

        Assertions.assertEquals("Claims", claimsElements.claimsHeader.getText());
    }

    @Test
    @DisplayName("18. Go to page for creating a new claim through main page")
    @Step("2. Переход на страницу создания новой претензии через главный экран")
    @Description("Открылась страница с созданием претензии")
    public void goFromMainPageToNewClaimsPage18() {

        mainElements.addNewClaimButton.isDisplayed();
        mainElements.addNewClaimButton.click();

        claimsElements.creatingHeader.isDisplayed();
    }

    @Test
    @DisplayName("27. Expand citation by Butterfly button")
    @Step("2. Разворачивание полного содержания цитаты через кнопку стрелку")
    @Description("Развернулось полное содержание цитаты")
    public void expandCitationByButterflyButton27() {

        mainElements.butterflyButton.isDisplayed();
        mainElements.butterflyButton.click();

        mainElements.expandCitation.isDisplayed();
        mainElements.expandCitation.click();

        mainElements.citationsDescription.isDisplayed();
    }
}
