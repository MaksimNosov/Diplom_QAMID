package ru.iteco.fmhandroid.tests;

import io.appium.java_client.TouchAction;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoSuchElementException;
import ru.iteco.fmhandroid.elements.NewsElements;
import ru.iteco.fmhandroid.setup.CreateDriver;
import ru.iteco.fmhandroid.setup.Login;
import ru.iteco.fmhandroid.setup.TestListener;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.offset.PointOption.point;

/**
 * Класс для тестирования Новостей
 */
@ExtendWith(TestListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NewsTests extends CreateDriver {
    NewsElements newsElements;

    @BeforeEach
    @Step("1. Запуск приложения и успешная авторизация")
    public void createDriverAndLoginToApp() throws MalformedURLException {

        CreateDriver createDriver = new CreateDriver();
        createDriver.createDriver();

        Login login = new Login();
        login.loginToApp();

        newsElements = new NewsElements(driver);
    }

    @Test
    @DisplayName("19. News block turn/expand")
    @Step("2. При нажатии на главном экране на поле новостей сворачивается/разворачивается блок с новостями")
    @Description("19. Блок развернулся с списком новостей")
    public void newsBlockTurnAndExpand19() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.turnExpandNewsButton.isDisplayed();
        newsElements.turnExpandNewsButton.click();
        try {
            newsElements.allNewsButton.isDisplayed();
        } catch (NoSuchElementException e) {
            newsElements.turnExpandNewsButton.click();
        }
        newsElements.allNewsButton.isDisplayed();
    }

    @Test
    @DisplayName("40. The title of the news page should be 'News'")
    @Step("2. Название страницы с новостями должно быть News")
    @Description("40. Название страницы с новостями должно быть News")
    public void nameNewsPage40() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        Assertions.assertEquals("News", newsElements.newsHeader.getText());
    }

    @Test
    @DisplayName("41. On news page, clicking 'three dots and stripes' button open news filter")
    @Step("2. На странице новостей при нажатии кнопки 'три точки и полоски' открывается фильтр новостей")
    @Description("Открылась страница с фильтром новостей")
    public void openFilterInNewsPage41() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterHeader.isDisplayed();
        Assertions.assertEquals("Filter news", newsElements.filterHeader.getText());
    }

    @Test
    @DisplayName("42. Open Control panel in News page")
    @Step("2. На странице новостей при нажатии кнопки блокнот и карандаш открывается панель управления")
    @Description("Открылась страница Control panel")
    public void openControlPanelInNewsPage42() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.controlPanelHeader.isDisplayed();
        Assertions.assertEquals("Control panel", newsElements.controlPanelHeader.getText());
    }

    @Test
    @DisplayName("43. Expand and turn news")
    @Step("2. На странице новостей при нажатии на стрелку свернуть/развернуть новость отображается описание новости")
    @Description(" Новость разворачивается, видно описание новости")
    public void expandAndTurnNews43() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.expendNews.isDisplayed();
        newsElements.expendNews.click();

        newsElements.descriptionsNews.isDisplayed();
    }

    @Test
    @DisplayName("44. Name creating news page")
    @Step("2. Название страницы создания новостей должно быть Creating News")
    @Description("Открылась страница создания новостей Creating News")
    public void nameCreatingNewsPage40() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.plusButton.isDisplayed();
        newsElements.plusButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Creating", newsElements.creatingNewsHeader1.getText());

        newsElements.creatingNewsHeader2.isDisplayed();
        Assertions.assertEquals("News", newsElements.creatingNewsHeader2.getText());
    }

    @Test
    @DisplayName("45. Create news with valid data")
    @Step("2. Создание новости с валидными данными")
    @Description("Новость сохранена, открылась страница Control panel со списком новостей, отображается созданная новость")
    public void createNewsWithValidData45() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.plusButton.isDisplayed();
        newsElements.plusButton.click();

        newsElements.categoryButton.isDisplayed();
        newsElements.categoryButton.click();

        (new TouchAction(driver)).tap(point(865, 285));

        newsElements.titleField.isDisplayed();
        newsElements.titleField.sendKeys("Test Title");

        newsElements.publicationDate.isDisplayed();
        newsElements.publicationDate.click();

        newsElements.publicationDate.isDisplayed();
        newsElements.publicationDate.click();

        newsElements.okButtonPublicationDate.isDisplayed();
        newsElements.okButtonPublicationDate.click();

        newsElements.publicationTime.isDisplayed();
        newsElements.publicationTime.click();

        newsElements.okButtonPublicationTime.isDisplayed();
        newsElements.okButtonPublicationTime.click();

        newsElements.description.isDisplayed();
        newsElements.description.sendKeys("Test Description");

        newsElements.saveButton.isDisplayed();
        newsElements.saveButton.click();

        newsElements.controlPanelHeader.isDisplayed();

        newsElements.expendNews.isDisplayed();
        newsElements.expendNews.click();

        newsElements.titleNews.isDisplayed();
        Assertions.assertEquals("Test Title", newsElements.titleNews.getText());

        newsElements.descriptionsNews.isDisplayed();
        Assertions.assertEquals("Test Description", newsElements.descriptionsNews.getText());
    }

    @Test
    @DisplayName("46. Cancel news creation")
    @Step("2. Создание новости с валидными данными")
    @Description("Новость сохранена, открылась страница Control panel со списком новостей, отображается созданная новость")
    public void cancelNewsCreation46() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.plusButton.isDisplayed();
        newsElements.plusButton.click();

        newsElements.categoryButton.isDisplayed();
        newsElements.categoryButton.click();

        (new TouchAction(driver)).tap(point(865, 285));

        newsElements.titleField.isDisplayed();
        newsElements.titleField.sendKeys("Test Title");

        newsElements.publicationDate.isDisplayed();
        newsElements.publicationDate.click();

        newsElements.publicationDate.isDisplayed();
        newsElements.publicationDate.click();

        newsElements.okButtonPublicationDate.isDisplayed();
        newsElements.okButtonPublicationDate.click();

        newsElements.publicationTime.isDisplayed();
        newsElements.publicationTime.click();

        newsElements.okButtonPublicationTime.isDisplayed();
        newsElements.okButtonPublicationTime.click();

        newsElements.description.isDisplayed();
        newsElements.description.sendKeys("Test Description");

        newsElements.cancelButton.isDisplayed();
        newsElements.cancelButton.click();

        newsElements.okButtonPublicationDate.isDisplayed();
        newsElements.okButtonPublicationDate.click();

        newsElements.controlPanelHeader.isDisplayed();
    }

    @Test
    @DisplayName("47. If fields news creation empty, error appears when trying save")
    @Step("2. При пустых полях в окне создания новости появляется ошибка при попытке сохранения")
    @Description("Все поля обозначаются красным восклецательным знаком, снизу подсвечивается ошибка 'Fill empty fields'")
    public void ErrorWhenSaveWithEmptyFields47() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.plusButton.isDisplayed();
        newsElements.plusButton.click();

        newsElements.saveButton.isDisplayed();
        newsElements.saveButton.click();

        newsElements.saveButton.isDisplayed();
    }

    @Test
    @DisplayName("48. Error when creating news with invalid category ")
    @Step("2. При создании новости с невалидным значением категории подсвечивается ошибка")
    @Description("Новость сохранена, открылась страница Control panel со списком новостей, отображается созданная новость")
    public void errorWhenCreatingNewsWithInvalidCategory48() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.plusButton.isDisplayed();
        newsElements.plusButton.click();

        newsElements.categoryButton.isDisplayed();
        newsElements.categoryButton.click();

        newsElements.category.isDisplayed();
        newsElements.category.sendKeys("Something");

        newsElements.titleField.isDisplayed();
        newsElements.titleField.sendKeys("Test Title");

        newsElements.publicationDate.isDisplayed();
        newsElements.publicationDate.click();

        newsElements.okButtonPublicationDate.isDisplayed();
        newsElements.okButtonPublicationDate.click();

        newsElements.publicationTime.isDisplayed();
        newsElements.publicationTime.click();

        newsElements.okButtonPublicationTime.isDisplayed();
        newsElements.okButtonPublicationTime.click();

        newsElements.description.isDisplayed();
        newsElements.description.sendKeys("Test Description");

        newsElements.saveButton.isDisplayed();
        newsElements.saveButton.click();

        newsElements.saveButton.isDisplayed();
    }

    @Test
    @DisplayName("63. Title news editing screen should be 'Editing News'")
    @Step("2. Названия экрана с редактированием новостей должно быть Editing News")
    @Description("Открылось окно редактирования новости")
    public void titleNewsEditingShouldBeEditingNews55() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Editing", newsElements.creatingNewsHeader1.getText());

        newsElements.creatingNewsHeader2.isDisplayed();
        Assertions.assertEquals("News", newsElements.creatingNewsHeader2.getText());
    }

    @Test
    @DisplayName("64. News for editing has data entered earlier")
    @Step("2. При открытии окна редактирования новости, отображаются данные введенные ранее")
    @Description("Все ранее внесенные данные отображаются")
    public void newsForEditingHasDataEnteredEarlier64() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Editing", newsElements.creatingNewsHeader1.getText());

        Assertions.assertNotEquals("", newsElements.category.getText());
        Assertions.assertNotEquals("", newsElements.titleField.getText());
        Assertions.assertNotEquals("", newsElements.publicationDate.getText());
        Assertions.assertNotEquals("", newsElements.publicationTime.getText());
        Assertions.assertNotEquals("", newsElements.description.getText());
    }

    @Test
    @DisplayName("65. Possible to edit news")
    @Step("2. Есть возможность отредактировать новость")
    @Description("Внесенные данные сохранены")
    public void possibleToEditNews65() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Editing", newsElements.creatingNewsHeader1.getText());

        newsElements.category.click();
        newsElements.publicationDate.click();

        newsElements.titleField.isDisplayed();
        newsElements.titleField.sendKeys("Edit Title");

        newsElements.publicationDate.isDisplayed();
        newsElements.publicationDate.click();
        newsElements.okButtonPublicationDate.isDisplayed();
        newsElements.okButtonPublicationDate.click();

        newsElements.publicationTime.isDisplayed();
        newsElements.publicationTime.click();
        newsElements.okButtonPublicationTime.isDisplayed();
        newsElements.okButtonPublicationTime.click();

        newsElements.description.isDisplayed();
        newsElements.description.sendKeys("Edit Description");

        String updatedCategory = newsElements.category.getText();
        String updatedTitle = newsElements.titleField.getText();
        String updatedDate = newsElements.publicationDate.getText();
        String updatedTime = newsElements.publicationTime.getText();
        String updatedDescription = newsElements.description.getText();

        newsElements.saveButton.isDisplayed();
        newsElements.saveButton.click();

        newsElements.titleNews.isDisplayed();
        Assertions.assertEquals("Edit Title", newsElements.titleNews.getText());

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();

        Assertions.assertEquals(updatedCategory, newsElements.category.getText());
        Assertions.assertEquals(updatedTitle, newsElements.titleField.getText());
        Assertions.assertEquals(updatedDate, newsElements.publicationDate.getText());
        Assertions.assertEquals(updatedTime, newsElements.publicationTime.getText());
        Assertions.assertEquals(updatedDescription, newsElements.description.getText());
    }

    @Test
    @DisplayName("66. Cancel edit news")
    @Step("2. Есть возможность отредактировать новость")
    @Description("Внесенные данные сохранены")
    public void cancelEditNews66() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Editing", newsElements.creatingNewsHeader1.getText());

        newsElements.category.click();
        newsElements.publicationDate.click();

        newsElements.titleField.isDisplayed();
        newsElements.titleField.sendKeys("Cancel Edit Title");

        newsElements.publicationDate.isDisplayed();
        newsElements.publicationDate.click();
        newsElements.okButtonPublicationDate.isDisplayed();
        newsElements.okButtonPublicationDate.click();

        newsElements.publicationTime.isDisplayed();
        newsElements.publicationTime.click();
        newsElements.okButtonPublicationTime.isDisplayed();
        newsElements.okButtonPublicationTime.click();

        newsElements.description.isDisplayed();
        newsElements.description.sendKeys("Cancel Edit Description");

        newsElements.cancelButton.isDisplayed();
        newsElements.cancelButton.click();

        newsElements.okButtonPublicationDate.isDisplayed();
        newsElements.okButtonPublicationDate.click();

        newsElements.titleNews.isDisplayed();
        Assertions.assertNotEquals("Cancel Edit Title", newsElements.titleNews.getText());

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();

        Assertions.assertNotEquals("Cancel Edit Title", newsElements.titleField.getText());
        Assertions.assertNotEquals("Cancel Edit Description", newsElements.description.getText());
    }

    @Test
    @DisplayName("67. Error msg when empty edits fields")
    @Step("2. Предупреждение об ошибке при редактировании на пустые поля")
    @Description("Внесенные данные сохранены")
    public void errorMsgWhenEmptyEditsFields67() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Editing", newsElements.creatingNewsHeader1.getText());

        newsElements.titleField.isDisplayed();
        newsElements.titleField.clear();

        newsElements.saveButton.isDisplayed();
        newsElements.saveButton.click();

        newsElements.saveButton.isDisplayed();
    }

    @Test
    @DisplayName("69. Cancel news editing")
    @Step("2. Отмена уведомления об отмене редактирования новости")
    @Description("Всплывающее окно закрылось, открыта страница с редактированием новости")
    public void cancelNewsEditing69() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Editing", newsElements.creatingNewsHeader1.getText());

        newsElements.cancelButton.isDisplayed();
        newsElements.cancelButton.click();

        newsElements.cancelButton2.isDisplayed();
        newsElements.cancelButton2.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Editing", newsElements.creatingNewsHeader1.getText());
    }

    @Test
    @DisplayName("70. Change news status from Active to Not Active")
    @Step("2. Смена статуса новости с Active на Not Active")
    @Description("Изменения сохранены новость в статусе Active")
    public void changeNewsStatusFromActiveToNotActive70() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.activeCheckbox.isDisplayed();
        Assertions.assertEquals("true", newsElements.activeCheckbox.getAttribute("checked"));
        newsElements.activeCheckbox.click();
        Assertions.assertEquals("false", newsElements.activeCheckbox.getAttribute("checked"));

        newsElements.saveButton.isDisplayed();
        newsElements.saveButton.click();

        newsElements.newsActiveStatus.isDisplayed();
        Assertions.assertEquals("NOT ACTIVE", newsElements.newsActiveStatus.getText());

        newsElements.noteAndPencilNewsButton.isDisplayed();
        newsElements.noteAndPencilNewsButton.click();

        newsElements.activeCheckbox.isDisplayed();
        Assertions.assertEquals("false", newsElements.activeCheckbox.getAttribute("checked"));
        newsElements.activeCheckbox.click();
        Assertions.assertEquals("true", newsElements.activeCheckbox.getAttribute("checked"));

        newsElements.saveButton.isDisplayed();
        newsElements.saveButton.click();

        newsElements.newsActiveStatus.isDisplayed();
        Assertions.assertEquals("ACTIVE", newsElements.newsActiveStatus.getText());
    }

    @Test
    @DisplayName("71. On news page, clicking 'three dots and stripes' button open news filter")
    @Step("2. На странице новостей при нажатии кнопки 'три точки и полоски' открывается фильтр новостей")
    @Description("Открылась страница с фильтром новостей")
    public void openFilterInNewsPage71() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterHeader.isDisplayed();
        Assertions.assertEquals("Filter news", newsElements.filterHeader.getText());
    }

    @Test
    @DisplayName("72. Search news through a filter by all criteria")
    @Step("2. Поиск новости через фильтр по всем возможным критериям")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsThroughFilterByAllCriteria72() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.category.isDisplayed();
        newsElements.category.click();
        newsElements.filterFrom.click();

        newsElements.filterFrom.isDisplayed();
        newsElements.filterFrom.setValue("23.05.2023");

        newsElements.filterUntil.isDisplayed();
        newsElements.filterUntil.setValue("23.05.2023");

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.newsHeader.isDisplayed();

        newsElements.filteredNewsDate1.isDisplayed();
        Assertions.assertEquals("23.05.2023", newsElements.filteredNewsDate1.getText());
    }

    @Test
    @DisplayName("73. Search news through a filter by Category")
    @Step("2. Поиск новости через фильтр по всем возможным критериям")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsThroughFilterByCategory73() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.category.isDisplayed();
        newsElements.category.click();
        newsElements.filterFrom.click();

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.newsHeader.isDisplayed();
    }

    @Test
    @DisplayName("74. Search news through a filter by date")
    @Step("2. Поиск новости через фильтр по дате")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsThroughFilterByDate74() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterFrom.isDisplayed();
        newsElements.filterFrom.setValue("23.05.2023");

        newsElements.filterUntil.isDisplayed();
        newsElements.filterUntil.setValue("23.05.2023");

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.filteredNewsDate1.isDisplayed();
        Assertions.assertEquals("23.05.2023", newsElements.filteredNewsDate1.getText());

        newsElements.filteredNewsDate2.isDisplayed();
        Assertions.assertEquals("23.05.2023", newsElements.filteredNewsDate2.getText());
    }

    @Test
    @DisplayName("75. Search news without filters")
    @Step("2. Поиск новости через фильтр без установки критерев поиска")
    @Description("Открыто окно с News отображаются все новости")
    public void searchNewsWithoutFilters75() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.newsHeader.isDisplayed();
    }

    @Test
    @DisplayName("76. Cancel news search with filters")
    @Step("2. Поиск новости через фильтр без установки критерев поиска")
    @Description("Открылось окно News без примененных фильтров")
    public void cancelNewsSearchWithFilters76() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.cancelButton.isDisplayed();
        newsElements.cancelButton.click();

        newsElements.newsHeader.isDisplayed();
    }

    @Test
    @DisplayName("77. Notification about absence result search")
    @Step("2. Уведомление об отсутствии новостей подходящих под критерии поиска по фильтру")
    @Description("Открыто окно с News отображается сообщение об отсутствии новостей подходящих под критерии поиска")
    public void notificationAboutAbsenceResultSearch77() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterFrom.isDisplayed();
        newsElements.filterFrom.setValue("01.01.2055");

        newsElements.filterUntil.isDisplayed();
        newsElements.filterUntil.setValue("01.01.2057");

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.thereIsNothingHereYet.isDisplayed();
        Assertions.assertEquals("There is nothing here yet…", newsElements.thereIsNothingHereYet.getText());
    }

    @Test
    @DisplayName("78. Name of Control Panel page")
    @Step("2. Названия страницы контрольной панели должно быть Control Panel")
    @Description("Наименование окна соответствует")
    public void nameOfControlPanelPage78() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.controlPanelHeader.isDisplayed();
        Assertions.assertEquals("Control panel", newsElements.controlPanelHeader.getText());
    }

    @Test
    @DisplayName("79. Click 'three dots and stripes' on control panel page open news filter")
    @Step("2. При нажатии на странице контрольной панели кнопки полоски с точками открывается окно фильтра новостей")
    @Description("Открылось окно фильтра новостей")
    public void openNewsFilterOnControlPanel79() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.controlPanelHeader.isDisplayed();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterHeader.isDisplayed();
        Assertions.assertEquals("Filter news", newsElements.filterHeader.getText());
    }

    @Test
    @DisplayName("80. Click plus button on control panel page open creating news page")
    @Step("2. При нажатии на странице контрольной панели кнопки + открывается страница создания новости")
    @Description("Открылось окно фильтра новостей")
    public void openCreatingPageOnControlPanel80() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.controlPanelHeader.isDisplayed();

        newsElements.plusButton.isDisplayed();
        newsElements.plusButton.click();

        newsElements.creatingNewsHeader1.isDisplayed();
        Assertions.assertEquals("Creating", newsElements.creatingNewsHeader1.getText());

        newsElements.creatingNewsHeader2.isDisplayed();
        Assertions.assertEquals("News", newsElements.creatingNewsHeader2.getText());
    }

    @Test
    @DisplayName("81. Delete news on control panel page")
    @Step("2. Удаление новости на странице контрольной панели")
    @Description("Новость удалена, открылось окно контрольной пынели удаленная новость отсутствует")
    public void deleteNewsOnControlPanel81() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.controlPanelHeader.isDisplayed();

        newsElements.expendNews.isDisplayed();
        newsElements.expendNews.click();

        newsElements.descriptionsNews.isDisplayed();
        String deletedDescription = newsElements.descriptionsNews.getText();

        newsElements.deleteNewsButton.isDisplayed();
        newsElements.deleteNewsButton.click();

        newsElements.okButton.isDisplayed();
        newsElements.okButton.click();

        newsElements.expendNews.isDisplayed();
        newsElements.expendNews.click();

        Assertions.assertNotEquals(deletedDescription, newsElements.descriptionsNews.getText());
    }

    @Test
    @DisplayName("82. Expand news on control panel page")
    @Step("2. При нажатии на странице контрольной панели стрелки вниз около новости информация о новости разворачивается")
    @Description("Новость удалена, открылось окно контрольной пынели удаленная новость отсутствует")
    public void expandNewsOnControlPanel82() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.controlPanelHeader.isDisplayed();

        newsElements.expendNews.isDisplayed();
        newsElements.expendNews.click();

        newsElements.descriptionsNews.isDisplayed();
    }

    @Test
    @DisplayName("88. Name of filter page in Control panel")
    @Step("2. Название страницы с фильтром новостей на странице контрольной панели должно быть Filter news")
    @Description("Открылась страница с фильтром новостей")
    public void nameOfFilterPageInControlPanel88() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterHeader.isDisplayed();
        Assertions.assertEquals("Filter news", newsElements.filterHeader.getText());
    }

    @Test
    @DisplayName("89. Search news through filter by all criteria in Control panel")
    @Step("2. Поиск новости через фильтр на странице контрольной панели по всем параметрам")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsThroughFilterByAllCriteriaInControlPanel89() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.category.isDisplayed();
        newsElements.category.click();
        newsElements.filterFrom.click();

        newsElements.filterFrom.isDisplayed();
        newsElements.filterFrom.click();
        newsElements.okButton.isDisplayed();
        newsElements.okButton.click();

        newsElements.filterUntil.isDisplayed();
        newsElements.filterUntil.click();
        newsElements.okButton.isDisplayed();
        newsElements.okButton.click();

        newsElements.activeCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.activeCheckBox.getAttribute("checked"));

        newsElements.nonActiveCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.nonActiveCheckBox.getAttribute("checked"));

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
    }

    @Test
    @DisplayName("90. Search news by category in Control panel")
    @Step("2. Поиск новости через фильтр на странице контрольной панели по категории")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsByCategoryInControlPanel90() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.category.isDisplayed();
        newsElements.category.click();
        newsElements.filterFrom.click();

        newsElements.activeCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.activeCheckBox.getAttribute("checked"));

        newsElements.nonActiveCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.nonActiveCheckBox.getAttribute("checked"));

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
    }

    @Test
    @DisplayName("91. Search news by date in Control panel")
    @Step("2. Поиск новости через фильтр на странице контрольной панели по всем параметрам")
    @Description("Открылась страница контрольной панели с фильтром новостей по выбранной дате")
    public void searchNewsByDateInControlPanel91() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterFrom.isDisplayed();
        newsElements.filterFrom.click();
        newsElements.okButton.isDisplayed();
        newsElements.okButton.click();

        newsElements.filterUntil.isDisplayed();
        newsElements.filterUntil.click();
        newsElements.okButton.isDisplayed();
        newsElements.okButton.click();

        newsElements.activeCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.activeCheckBox.getAttribute("checked"));

        newsElements.nonActiveCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.nonActiveCheckBox.getAttribute("checked"));

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
    }

    @Test
    @DisplayName("92. Search news without filters in Control panel")
    @Step("2. Поиск новостей через фильтр на странице контрольной панели без выбранных критериев")
    @Description("Открылась страница контрольной панели")
    public void searchNewsWithoutFiltersInControlPanel92() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.activeCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.activeCheckBox.getAttribute("checked"));

        newsElements.nonActiveCheckBox.isDisplayed();
        Assertions.assertEquals("true", newsElements.nonActiveCheckBox.getAttribute("checked"));

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
    }

    @Test
    @DisplayName("93. Cancel search news in Control panel")
    @Step("2. Отмена поиска новостей через фильтр на странице контрольной панели")
    @Description("Поиск по фильтру отменен")
    public void cancelSearchNewsInControlPanel93() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.cancelButton.isDisplayed();
        newsElements.cancelButton.click();

        newsElements.controlPanelHeader.isDisplayed();
    }

    @Test
    @DisplayName("94. Error msg when search by invalid date in Control panel")
    @Step("2. Уведомление об ошибке при поиске новостей через фильтр на странице контрольной панели по неподходящим критериям")
    @Description("Открылось окно контрольной панели с уведомлением об отсутствии новостей по подходящим критериям")
    public void errorMsgWhenSearchByInvalidDateInControlPanel94() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.filterFrom.isDisplayed();
        newsElements.filterFrom.sendKeys("01.01.2041");

        newsElements.filterUntil.isDisplayed();
        newsElements.filterUntil.sendKeys("01.01.2043");

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
        newsElements.nothingYetStatus.isDisplayed();
        Assertions.assertEquals("There is nothing here yet…", newsElements.nothingYetStatus.getText());
    }

    @Test
    @DisplayName("95. Search news by active status in Control panel")
    @Step("2. Поиск новостей через фильтр на странице контрольной панели по статусу Active")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsByActiveStatusInControlPanel95() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.nonActiveCheckBox.isDisplayed();
        newsElements.nonActiveCheckBox.click();
        Assertions.assertEquals("false", newsElements.nonActiveCheckBox.getAttribute("checked"));

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
        newsElements.newsActiveStatus.isDisplayed();
        Assertions.assertEquals("ACTIVE", newsElements.newsActiveStatus.getText());
    }

    @Test
    @DisplayName("96. Search news by Non active status in Control panel")
    @Step("2. Поиск новостей через фильтр на странице контрольной панели по статусу Active")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsByNonActiveStatusInControlPanel96() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.activeCheckBox.isDisplayed();
        newsElements.activeCheckBox.click();
        Assertions.assertEquals("false", newsElements.filterHeader.getAttribute("checked"));

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
        newsElements.newsActiveStatus.isDisplayed();
        Assertions.assertEquals("NOT ACTIVE", newsElements.newsActiveStatus.getText());
    }

    @Test
    @DisplayName("97. Search news by Active and NonActive status in Control panel")
    @Step("2. Поиск новостей через фильтр на странице контрольной панели по статусу Active")
    @Description("Открылась страница с фильтром новостей")
    public void searchNewsByActiveAndNonActiveStatusInControlPanel97() {

        newsElements.allNewsButton.isDisplayed();
        newsElements.allNewsButton.click();

        newsElements.noteAndPencilButton.isDisplayed();
        newsElements.noteAndPencilButton.click();

        newsElements.filterButton.isDisplayed();
        newsElements.filterButton.click();

        newsElements.activeCheckBox.isDisplayed();
        newsElements.activeCheckBox.click();
        Assertions.assertEquals("false", newsElements.filterHeader.getAttribute("checked"));

        newsElements.nonActiveCheckBox.isDisplayed();
        newsElements.nonActiveCheckBox.click();
        Assertions.assertEquals("false", newsElements.nonActiveCheckBox.getAttribute("checked"));

        newsElements.saveFilterButton.isDisplayed();
        newsElements.saveFilterButton.click();

        newsElements.controlPanelHeader.isDisplayed();
    }
}