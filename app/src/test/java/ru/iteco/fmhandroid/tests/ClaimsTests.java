package ru.iteco.fmhandroid.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoSuchElementException;
import ru.iteco.fmhandroid.elements.ClaimsElements;
import ru.iteco.fmhandroid.setup.Actions;
import ru.iteco.fmhandroid.setup.CreateDriver;
import ru.iteco.fmhandroid.setup.Login;
import ru.iteco.fmhandroid.setup.TestListener;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Класс для тестирования Претензий
 */
@ExtendWith(TestListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClaimsTests extends CreateDriver {
    ClaimsElements claimsElements;
    Faker faker = new Faker(new Locale("en"));

    @BeforeEach
    @Step("1. Запуск приложения и успешная авторизация")
    public void createDriverAndLoginToApp() throws MalformedURLException {

        CreateDriver createDriver = new CreateDriver();
        createDriver.createDriver();

        Login login = new Login();
        login.loginToApp();

        claimsElements = new ClaimsElements(driver);

    }

    @Test
    @DisplayName("20. Claims block turn/expand")
    @Step("2. При нажатии на главном экране на поле новостей сворачивается/разворачивается блок с новостями")
    @Description("20. Блок развернулся с списком новостей")
    public void claimsBlockTurnAndExpand20() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.turnExpandClaimsButton.isDisplayed();
        claimsElements.turnExpandClaimsButton.click();

        try {
            claimsElements.allClaimsButton.isDisplayed();
        } catch (NoSuchElementException e) {
            claimsElements.turnExpandClaimsButton.click();
        }
        claimsElements.allClaimsButton.isDisplayed();
    }

    @Test
    @DisplayName("21. Go to selected claim on main page")
    @Step("2. При нажатии на претензию в блоке птерензий на главном экране осуществляется переход к выбранной претензии")
    @Description("Открылось окно с выбранной претензией и информации о ней")
    public void goToSelectedClaimOnMainPage21() {

        claimsElements.topicDescription.isDisplayed();
        String topicValue = claimsElements.topicDescription.getText();

        claimsElements.executorName.isDisplayed();
        String executorValue = claimsElements.executorName.getText();

        claimsElements.dateOnMainPage.isDisplayed();
        String dateValue = claimsElements.dateOnMainPage.getText();

        claimsElements.timeOnMainPage.isDisplayed();
        String timeValue = claimsElements.timeOnMainPage.getText();

        claimsElements.claimAreaOnMainPage.isDisplayed();
        claimsElements.claimAreaOnMainPage.click();

        claimsElements.topicInside.isDisplayed();
        Assertions.assertEquals(topicValue, claimsElements.topicInside.getText());

        claimsElements.executorInside.isDisplayed();
        Assertions.assertEquals(executorValue, claimsElements.executorInside.getText());

        claimsElements.planDateInside.isDisplayed();
        Assertions.assertEquals(dateValue, claimsElements.planDateInside.getText());

        claimsElements.planTimeInside.isDisplayed();
        Assertions.assertEquals(timeValue, claimsElements.planTimeInside.getText());

        claimsElements.description.isDisplayed();
    }


    @Test
    @DisplayName("28. Name claims page")
    @Step("2. Название страницы с претензиями должно быть Claims")
    @Description("Название страницы Claims")
    public void nameClaimsPage28() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.claimsHeader.isDisplayed();
        Assertions.assertEquals("Claims", claimsElements.claimsHeader.getText());
    }

    @Test
    @DisplayName("29. Go on claims page to claims filter through hamburger button")
    @Step("2. Переход на странице претензий на фильтр претензий через кнопку гамбургер")
    @Description("Открывается окно фильтра")
    public void openFilterOnClaimsPage29() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();
        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.filterHeader.isDisplayed();
    }

    @Test
    @DisplayName("30. Add new claim with plus button")
    @Step("2. Переход на странице претензий к созданию претензий через кнопку +")
    @Description("Открылось окно создания претензии")
    public void addNewClaimWithPlusButton30() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();
        claimsElements.plusButton.isDisplayed();
        claimsElements.plusButton.click();

        claimsElements.creatingHeader.isDisplayed();
        Assertions.assertEquals("Creating", claimsElements.creatingHeader.getText());
    }

    @Test
    @DisplayName("31. Go to selected claim")
    @Step("2. Переход на странице с претензией к выбранной претензии")
    @Description("Открыта страница с выбранной претензей и с расширенной информацией по ней")
    public void goToSelectedClaim31() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.topic.isDisplayed();

        String topicText = claimsElements.topic.getText();
        String executorText = claimsElements.executor.getText();
        String planDateValue = claimsElements.planDate.getText();
        String planTimeValue = claimsElements.planTime.getText();

        claimsElements.claimsArea.isDisplayed();
        claimsElements.claimsArea.click();

        claimsElements.topicInside.isDisplayed();

        String topicTextInside = claimsElements.topicInside.getText();
        String executorTextInside = claimsElements.executorInside.getText();
        String planDateValueInside = claimsElements.planDateInside.getText();
        String planTimeValueInside = claimsElements.planTimeInside.getText();

        Assertions.assertEquals(topicText, topicTextInside);
        Assertions.assertEquals(executorText, executorTextInside);
        Assertions.assertEquals(planDateValue, planDateValueInside);
        Assertions.assertEquals(planTimeValue, planTimeValueInside);

        claimsElements.authorInfo.isDisplayed();
        claimsElements.createdInfo.isDisplayed();
    }

    @Test
    @DisplayName("32. Change claim status from open to progress")
    @Step("2. Изменение статуса претензии с Open на In progress")
    @Description("На странице претензии отображается статус In progress")
    public void changeClaimStatusFromOpenToProgress32() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();

        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.setStatusButton.isDisplayed();
        claimsElements.setStatusButton.click();

        claimsElements.takeToWorkButton.isDisplayed();
        claimsElements.takeToWorkButton.click();

        Assertions.assertEquals("In progress", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("33. Go to change claim page")
    @Step("2. Переход на страницу с редактированием претензии")
    @Description("Открылось окно с редактированием претензии")
    public void goToChangeClaimPage33() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());
    }

    @Test
    @DisplayName("34. Change all fields in claim without executor")
    @Step("2. Редактирование всех полей в претензии кроме поля Executor")
    @Description("Открыто окно с выбранной претензией изменения сохранены")
    public void changeAllFieldsInClaimWithoutExecutor34() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.titleField.sendKeys("TestTitle");
        claimsElements.dateField.sendKeys("01.01.2023");
        claimsElements.timeField.sendKeys("10:45");
        claimsElements.descriptionField.sendKeys("Test Description");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        Assertions.assertEquals("TestTitle", claimsElements.topicInside.getText());
        Assertions.assertEquals("01.01.2023", claimsElements.planDateInside.getText());
        Assertions.assertEquals("10:45", claimsElements.planTimeInside.getText());
        Assertions.assertEquals("Test Description", claimsElements.description.getText());
    }

    @Test
    @DisplayName("35. Possible to cancel editing claim if changes are made to all fields")
    @Step("2. Можно отменить редактирование претензии при внесенных изменениях во все поля")
    @Description("Открыто окно с выбранной претензией изменений нет")
    public void cancelAllChangesInFieldsClaim35() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.topicInside.isDisplayed();
        String initialTitleValue = claimsElements.topicInside.getText();
        String initialExecutorValue = claimsElements.executorInside.getText();
        String initialDateValue = claimsElements.planDateInside.getText();
        String initialTimeValue = claimsElements.planTimeInside.getText();
        String initialDescriptionValue = claimsElements.description.getText();

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();
        claimsElements.editingHeader.isDisplayed();

        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.titleField.isDisplayed();
        claimsElements.titleField.sendKeys("TestTitle");
        claimsElements.executorField.sendKeys("TestExecutor2");
        claimsElements.dateField.sendKeys("01.01.2023");
        claimsElements.timeField.sendKeys("10:45");
        claimsElements.descriptionField.sendKeys("Test Description");

        claimsElements.cancelButton.isDisplayed();
        claimsElements.cancelButton.click();

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.topicInside.isDisplayed();
        Assertions.assertEquals(initialTitleValue, claimsElements.topicInside.getText());
        Assertions.assertEquals(initialExecutorValue, claimsElements.executorInside.getText());
        Assertions.assertEquals(initialDateValue, claimsElements.planDateInside.getText());
        Assertions.assertEquals(initialTimeValue, claimsElements.planTimeInside.getText());
        Assertions.assertEquals(initialDescriptionValue, claimsElements.description.getText());
    }

    @Test
    @DisplayName("36. Cancel entry comment and change claims status with Throw dff")
    @Step("2. Отмена внесения комментария и смены статуса претензнии через статус Throw off")
    @Description("Окно закрылось, статус претензии не изменен, комментарий не добавлен")
    public void cancelEntryCommentAndChangeClaimsStatusWithThrowOff36() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();
        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.gearButton.isDisplayed();
        claimsElements.gearButton.click();

        claimsElements.takeToWorkButton.isDisplayed();
        claimsElements.takeToWorkButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("In progress", claimsElements.claimStatus.getText());

        claimsElements.gearButton.isDisplayed();
        claimsElements.gearButton.click();

        claimsElements.throwOffButton.isDisplayed();
        claimsElements.throwOffButton.click();

        claimsElements.commentField.isDisplayed();
        claimsElements.commentField.sendKeys("Test comment");

        claimsElements.cancelCommentButton.isDisplayed();
        claimsElements.cancelCommentButton.click();

        Assertions.assertEquals("In progress", claimsElements.claimStatus.getText());
        claimsElements.addCommentArea.isDisplayed();
        Assertions.assertEquals("Add comment", claimsElements.addCommentArea.getText());
    }

    @Test
    @DisplayName("37. Change claim status from In progress to Open with comment saved")
    @Step("2. Изменение статуса претензии с In progress на Open с сохранением комментария")
    @Description("Окно закрылось, статус претензии изменен на Open, комментарий сохранен")
    public void changeClaimStatusToOpenAndAddComment37() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();
        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.gearButton.isDisplayed();
        claimsElements.gearButton.click();

        claimsElements.takeToWorkButton.isDisplayed();
        claimsElements.takeToWorkButton.click();
        Assertions.assertEquals("In progress", claimsElements.claimStatus.getText());

        claimsElements.gearButton.isDisplayed();
        claimsElements.gearButton.click();

        claimsElements.throwOffButton.isDisplayed();
        claimsElements.throwOffButton.click();

        claimsElements.commentField.isDisplayed();
        claimsElements.commentField.sendKeys("Test Comment");

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.commentArea.isDisplayed();
        Assertions.assertEquals("Test Comment", claimsElements.commentArea.getText());
    }

    @Test
    @DisplayName("38. Change claim status from In progress to Executed with comment saved")
    @Step("2. Изменение статуса претензии с In progress на Executed с сохранением комментария")
    @Description("Окно закрылось, статус претензии изменен на Executed, комментарий сохранен")
    public void changeClaimStatusToExecutedAndAddComment38() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();
        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.gearButton.isDisplayed();
        claimsElements.gearButton.click();

        claimsElements.takeToWorkButton.isDisplayed();
        claimsElements.takeToWorkButton.click();
        Assertions.assertEquals("In progress", claimsElements.claimStatus.getText());

        claimsElements.gearButton.isDisplayed();
        claimsElements.gearButton.click();

        claimsElements.toExecuteButton.isDisplayed();
        claimsElements.toExecuteButton.click();

        claimsElements.commentField.isDisplayed();
        claimsElements.commentField.sendKeys("Test Comment");

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Executed", claimsElements.claimStatus.getText());

        claimsElements.commentArea.isDisplayed();
        Assertions.assertEquals("Test Comment", claimsElements.commentArea.getText());
    }

    @Test
    @DisplayName("39. Close claim, change status to Canceled")
    @Step("2. Закрытие претензии, изменение статуса на Canceled")
    @Description("Статус претензии изменен на Canceled")
    public void closeClaimChangeStatusToCanceled39() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();
        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.gearButton.isDisplayed();
        claimsElements.gearButton.click();

        claimsElements.toExecuteButton.isDisplayed();
        claimsElements.toExecuteButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Canceled", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("49. Create claim with valid data")
    @Step("2. Создание претензии с валидными данными")
    @Description("Претензия создана и отображается в списке Claims")
    public void loaderDisplayed49() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.plusButton.isDisplayed();
        claimsElements.plusButton.click();

        claimsElements.creatingHeader.isDisplayed();
        Assertions.assertEquals("Creating", claimsElements.creatingHeader.getText());

        claimsElements.titleField.isDisplayed();
        claimsElements.titleField.sendKeys("Test Title");

        claimsElements.executorField.isDisplayed();
        claimsElements.executorField.click();

        Actions.tapByCoordinates(708, 1206, driver);

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.click();

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.click();

        claimsElements.okButtonTime.isDisplayed();
        claimsElements.okButtonTime.click();

        claimsElements.descriptionField.isDisplayed();
        claimsElements.descriptionField.sendKeys("Test Description");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.topicDescription.isDisplayed();
        Assertions.assertEquals("Test Title", claimsElements.topicDescription.getText());

        claimsElements.executorName.isDisplayed();
        Assertions.assertEquals("Ivanov Ivan Ivanovich", claimsElements.executorName.getText());
    }

    @Test
    @DisplayName("50. Cancel creating claim")
    @Step("2. Отмена создания претензии")
    @Description("Создание претензии отменено, в списке претензий нет новой претензии")
    public void cancelCreatingClaim50() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.plusButton.isDisplayed();
        claimsElements.plusButton.click();

        claimsElements.creatingHeader.isDisplayed();
        Assertions.assertEquals("Creating", claimsElements.creatingHeader.getText());

        claimsElements.titleField.isDisplayed();
        claimsElements.titleField.sendKeys("Test Cancel Creating");

        claimsElements.executorField.isDisplayed();
        claimsElements.executorField.click();

        Actions.tapByCoordinates(708, 1206, driver);

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.click();

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.click();

        claimsElements.okButtonTime.isDisplayed();
        claimsElements.okButtonTime.click();

        claimsElements.descriptionField.isDisplayed();
        claimsElements.descriptionField.sendKeys("Test Description");

        claimsElements.cancelButton.isDisplayed();
        claimsElements.cancelButton.click();

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.claimsHeader.isDisplayed();
        claimsElements.topic.isDisplayed();
        Assertions.assertNotEquals("Test Cancel Creating", claimsElements.topic.getText());
    }

    @Test
    @DisplayName("51. Notice Cancellation of Cancel of Claim")
    @Step("2. Отмена уведомления об отмене соднания претензии")
    @Description("Создание претензии отменено, в списке претензий нет новой претензии")
    public void noticeCancellationOfCancelOfClaim51() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.plusButton.isDisplayed();
        claimsElements.plusButton.click();

        claimsElements.creatingHeader.isDisplayed();
        Assertions.assertEquals("Creating", claimsElements.creatingHeader.getText());

        claimsElements.titleField.isDisplayed();
        claimsElements.titleField.sendKeys("Test Cancel Creating");

        claimsElements.executorField.isDisplayed();
        claimsElements.executorField.click();

        Actions.tapByCoordinates(708, 1206, driver);

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.click();

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.click();

        claimsElements.okButtonTime.isDisplayed();
        claimsElements.okButtonTime.click();

        claimsElements.descriptionField.isDisplayed();
        claimsElements.descriptionField.sendKeys("Test Description");

        claimsElements.cancelButton.isDisplayed();
        claimsElements.cancelButton.click();

        claimsElements.cancelCommentButton.isDisplayed();
        claimsElements.cancelCommentButton.click();

        claimsElements.creatingHeader.isDisplayed();
    }

    @Test
    @DisplayName("52. Claim should have Open status when empty or invalid executor")
    @Step("2. При вводе исполнителя не из списка или его отсутствии в создании претензии, претензия должна иметь статус Open")
    @Description("Создание претензии отменено, в списке претензий нет новой претензии")
    public void claimShouldHaveOpenStatusWhenEmptyOrInvalidExecutor52() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.plusButton.isDisplayed();
        claimsElements.plusButton.click();

        claimsElements.creatingHeader.isDisplayed();
        Assertions.assertEquals("Creating", claimsElements.creatingHeader.getText());

        claimsElements.titleField.isDisplayed();
        claimsElements.titleField.sendKeys("Valid Title");

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.sendKeys("01.01.0001");

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.sendKeys("00:01");

        claimsElements.descriptionField.isDisplayed();
        claimsElements.descriptionField.sendKeys("Valid Description");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.claimsHeader.isDisplayed();
        claimsElements.claimsArea.isDisplayed();
        claimsElements.claimsArea.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("53. Error message when create claim with empty fields")
    @Step("2. Сообщение об ошибке на пустые поля при создании претензии")
    @Description("Всплывает окно с уведомлением об ошибке на пустое поле")
    public void errorMessageWhenCreateClaimWithEmptyFields53() throws InterruptedException {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.plusButton.isDisplayed();
        claimsElements.plusButton.click();

        claimsElements.creatingHeader.isDisplayed();
        Assertions.assertEquals("Creating", claimsElements.creatingHeader.getText());

        claimsElements.executorField.isDisplayed();
        claimsElements.executorField.click();

        Thread.sleep(1000);

        Actions.tapByCoordinates(708, 1206, driver);

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.click();

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.click();

        claimsElements.okButtonTime.isDisplayed();
        claimsElements.okButtonTime.click();

        claimsElements.descriptionField.isDisplayed();
        claimsElements.descriptionField.sendKeys("Test Description");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.errorMsg.isDisplayed();
        Assertions.assertEquals("Fill empty fields", claimsElements.errorMsg.getText());
    }

    @Test
    @DisplayName("54. Title field has limit of 50 symbols")
    @Step("2. Поле Title при создании претензии имеет ограничение в 50 символов")
    @Description("Всплывает окно с уведомлением об ошибке на пустое поле")
    public void titleFieldHasLimitOf50Symbols54() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.plusButton.isDisplayed();
        claimsElements.plusButton.click();

        claimsElements.creatingHeader.isDisplayed();
        Assertions.assertEquals("Creating", claimsElements.creatingHeader.getText());

        String invalidTitle = faker.random().hex(51);

        claimsElements.titleField.sendKeys(invalidTitle);

        Assertions.assertNotEquals(invalidTitle, claimsElements.titleField.getText());
    }

    @Test
    @DisplayName("55. Title claim editing screen should be 'Editing Claims'")
    @Step("2. Названия экрана с редактированием претензии должно быть Editing Claims")
    @Description("На странице претензии отображается статус In progress")
    public void titleClaimEditingShouldBeEditingClaims55() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.editingHeader2.isDisplayed();
        Assertions.assertEquals("Claims", claimsElements.editingHeader2.getText());
    }

    @Test
    @DisplayName("56. Claim for editing has data entered earlier")
    @Step("2. При открытии окна редактирования претензии, отображаются данные введенные ранее")
    @Description("В полях есть данные")
    public void claimForEditingHasDataEnteredEarlier56() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();

        Assertions.assertNotEquals("", claimsElements.titleField.getText());
        Assertions.assertNotEquals("", claimsElements.dateField.getText());
        Assertions.assertNotEquals("", claimsElements.timeField.getText());
        Assertions.assertNotEquals("", claimsElements.descriptionField.getText());
    }

    @Test
    @DisplayName("57. Possible to edit claim")
    @Step("2. Есть возможность отредактировать претензию")
    @Description("Все внесенные изменения сохранены")
    public void possibleToEditClaim57() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();

        claimsElements.titleField.isDisplayed();
        claimsElements.titleField.sendKeys("Edit Title");

        claimsElements.executorField.isDisplayed();
        claimsElements.executorField.click();

        Actions.tapByCoordinates(708, 1206, driver);

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.sendKeys("22.02.2022");

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.sendKeys("12:00");

        claimsElements.descriptionField.isDisplayed();
        claimsElements.descriptionField.sendKeys("New Description");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        Assertions.assertEquals("Edit Title", claimsElements.topicInside.getText());
        Assertions.assertEquals("22.02.2022", claimsElements.planDateInside.getText());
        Assertions.assertEquals("12:00", claimsElements.planTimeInside.getText());
        Assertions.assertEquals("New Description", claimsElements.description.getText());
    }

    @Test
    @DisplayName("58. Cancel claim editing")
    @Step("2. Отмена редактирования претензии")
    @Description("Редактирование претензии отменено")
    public void cancelClaimEditing58() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.cancelButton.isDisplayed();
        claimsElements.cancelButton.click();

        claimsElements.okButtonTime.isDisplayed();
        claimsElements.okButtonTime.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("59. Cancel claim edit cancellation notice")
    @Step("2. Отмена уведомления об отмене редактирования претензии")
    @Description("Отмена редактирования отменено, открыто окно с редактированием претензии")
    public void cancelClaimEditCancellationNotice59() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.cancelButton.isDisplayed();
        claimsElements.cancelButton.click();

        claimsElements.cancelCommentButton.isDisplayed();
        claimsElements.cancelCommentButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());
    }

    @Test
    @DisplayName("60. Warning for empty fields error in claim editing")
    @Step("2. Предупреждение на ошибку пустых полей в редактировании претензии")
    @Description("Отмена редактирования отменено, открыто окно с редактированием претензии")
    public void warningForEmptyFieldsErrorInClaimEditing60() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.clear();

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.errorMsg.isDisplayed();
        Assertions.assertEquals("Fill empty fields", claimsElements.errorMsg.getText());
    }

    @Test
    @DisplayName("61. Change Status From Open To In Progress When Edit Executor")
    @Step("2. При редактировании исполнителя и дальнейшем сохранении статус претензии меняется с Open на In progress")
    @Description("Отмена редактирования отменено, открыто окно с редактированием претензии")
    public void changeStatusFromOpenToInProgressWhenEditExecutor61() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.executorField.isDisplayed();
        claimsElements.executorField.click();

        Actions.tapByCoordinates(708, 1206, driver);

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("In progress", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("62. Data of Executor field not save if enter values that not included in list")
    @Step("2. Не сохраняются данные поля Executor если внести значения не входящие в список")
    @Description("Изменения не сохранены, статус претензии не изменен")
    public void dataOfExecutorFieldNotSaveIfEnterNotIncludedValue62() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.notebookAndPencilButton.isDisplayed();
        claimsElements.notebookAndPencilButton.click();

        claimsElements.editingHeader.isDisplayed();
        Assertions.assertEquals("Editing", claimsElements.editingHeader.getText());

        claimsElements.executorField.sendKeys("Test Executor");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());
        Assertions.assertEquals("NOT ASSIGNED", claimsElements.executorInside.getText());
    }

    @Test
    @DisplayName("83. Add comment to Claim")
    @Step("2. Добавление комментария в претензии")
    @Description("Изменения не сохранены, статус претензии не изменен")
    public void addCommentToClaim83() throws InterruptedException {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        Thread.sleep(1000);

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.plusCommentButton.isDisplayed();
        claimsElements.plusCommentButton.click();

        claimsElements.addCommentField.isDisplayed();
        claimsElements.addCommentField.sendKeys("Test comment");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.commentArea.isDisplayed();
        Assertions.assertEquals("Test comment", claimsElements.commentArea.getText());
    }

    @Test
    @DisplayName("84. Cancel add comment")
    @Step("2. Отмена добавления комментария в претензию")
    @Description("Изменения не сохранены, статус претензии не изменен")
    public void cancelAddComment84() throws InterruptedException {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        Thread.sleep(1000);

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.plusCommentButton.isDisplayed();
        claimsElements.plusCommentButton.click();

        claimsElements.addCommentField.isDisplayed();
        claimsElements.addCommentField.sendKeys("Test comment Test");

        claimsElements.cancelButton.isDisplayed();
        claimsElements.cancelButton.click();

        claimsElements.commentArea.isDisplayed();
        Assertions.assertNotEquals("Test comment Test", claimsElements.commentArea.getText());
    }

    @Test
    @DisplayName("85. Error notification when save empty comment")
    @Step("2. Уведомление об ошибке при попытке сохранить пустой комментарий")
    @Description("Подсвечивается снизу ошибка о пустом комментарии, изменения не сохраняются остается открыта страница для внесения комментария")
    public void errorNotificationWhenSaveEmptyComment85() throws InterruptedException {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        Thread.sleep(1000);

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.plusCommentButton.isDisplayed();
        claimsElements.plusCommentButton.click();

        claimsElements.addCommentField.isDisplayed();

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.saveButton.isDisplayed();
    }

    @Test
    @DisplayName("86. Change comment in claims")
    @Step("2. Редактирование комментария в претензии")
    @Description("Измененный комментарий сохранен")
    public void changeCommentInClaims86() throws InterruptedException {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        Thread.sleep(1000);

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        claimsElements.plusCommentButton.isDisplayed();
        claimsElements.plusCommentButton.click();

        claimsElements.addCommentField.isDisplayed();
        claimsElements.addCommentField.sendKeys("Test comment");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.commentArea.isDisplayed();
        Assertions.assertEquals("Test comment", claimsElements.commentArea.getText());

        claimsElements.editCommentButton.isDisplayed();
        claimsElements.editCommentButton.click();

        claimsElements.addCommentField.isDisplayed();
        claimsElements.addCommentField.sendKeys("Test comment change");

        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.commentArea.isDisplayed();
        Assertions.assertEquals("Test comment change", claimsElements.commentArea.getText());
    }

    @Test
    @DisplayName("87. Add multiple comments to one claim")
    @Step("2. Добавление нескольких комментариев в одну претензию")
    @Description("Комментарий сохранен")
    public void addMultipleCommentsToOneClaim87() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());

        try {
            claimsElements.commentArea1.isDisplayed();
            claimsElements.editCommentArea1.isDisplayed();
            claimsElements.editCommentArea1.click();
        } catch (NoSuchElementException e) {
            claimsElements.plusCommentButton.isDisplayed();
            claimsElements.plusCommentButton.click();
        }
        claimsElements.addCommentField.isDisplayed();
        claimsElements.addCommentField.sendKeys("New Comment 1");
        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.commentArea1.isDisplayed();
        Assertions.assertEquals("New Comment 1", claimsElements.commentArea1.getText());

        try {
            claimsElements.commentArea2.isDisplayed();
            claimsElements.editCommentArea2.isDisplayed();
            claimsElements.editCommentArea2.click();
        } catch (NoSuchElementException e) {
            claimsElements.plusCommentButton.isDisplayed();
            claimsElements.plusCommentButton.click();
        }
        claimsElements.addCommentField.isDisplayed();
        claimsElements.addCommentField.sendKeys("New Comment 2");
        claimsElements.saveButton.isDisplayed();
        claimsElements.saveButton.click();

        claimsElements.commentArea2.isDisplayed();
        Assertions.assertEquals("New Comment 2", claimsElements.commentArea2.getText());
    }

    @Test
    @DisplayName("98. Name filter page on claim page")
    @Step("2. Название страницы с фильтром на странице претензий должно быть Filtering")
    @Description(" Открылась страница Filtering")
    public void nameFilterPageOnClaimPage98() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.filterHeader.isDisplayed();
        Assertions.assertEquals("Filtering", claimsElements.filterHeader.getText());
    }

    @Test
    @DisplayName("99. Search claim by status Open")
    @Step("2. Поиск претензии через фильтр на странице претензий по статусу Open")
    @Description("Открылась страница с претензиями по выбранному критерию поиска")
    public void searchClaimByStatusOpen99() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Open", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("100. Search claim by status In progress")
    @Step("2. Поиск претензии через фильтр на странице претензий по статусу In progress")
    @Description("Открылась страница с претензиями по выбранному критерию поиска")
    public void searchClaimByStatusInProgress100() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.openFilterStatus.isDisplayed();
        claimsElements.openFilterStatus.click();

        Assertions.assertEquals("false", claimsElements.openFilterStatus.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("In progress", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("101. Search claim by status Executed")
    @Step("2. Поиск претензии через фильтр на странице претензий по статусу Executed")
    @Description("Открылась страница с претензиями по выбранному критерию поиска")
    public void searchClaimByStatusExecuted101() throws InterruptedException {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.openFilterStatus.isDisplayed();
        claimsElements.openFilterStatus.click();

        Assertions.assertEquals("false", claimsElements.openFilterStatus.getAttribute("checked"));

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.executedFilterStatus.isDisplayed();
        claimsElements.executedFilterStatus.click();

        Assertions.assertEquals("true", claimsElements.executedFilterStatus.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        Thread.sleep(1000);

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Executed", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("102. Search claim by status Canceled")
    @Step("2. Поиск претензии через фильтр на странице претензий по статусу Canceled")
    @Description("Открылась страница с претензиями по выбранному критерию поиска")
    public void searchClaimByStatusCanceled102() throws InterruptedException {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.openFilterStatus.isDisplayed();
        claimsElements.openFilterStatus.click();

        Assertions.assertEquals("false", claimsElements.openFilterStatus.getAttribute("checked"));

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();

        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.canceledFilterStatus.isDisplayed();
        claimsElements.canceledFilterStatus.click();

        Assertions.assertEquals("true", claimsElements.canceledFilterStatus.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        Thread.sleep(1000);

        claimsElements.expendButton.isDisplayed();
        claimsElements.expendButton.click();

        claimsElements.claimStatus.isDisplayed();
        Assertions.assertEquals("Canceled", claimsElements.claimStatus.getText());
    }

    @Test
    @DisplayName("103. Search claim by all status")
    @Step("2. Поиск претензии через фильтр на странице претензий по всем статусам")
    @Description("Открылась страница с претензиями по выбранному критерию поиска")
    public void searchClaimByAllStatus103() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.openFilterStatus.isDisplayed();
        Assertions.assertEquals("true", claimsElements.openFilterStatus.getAttribute("checked"));

        claimsElements.inProgress.isDisplayed();
        Assertions.assertEquals("true", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.executedFilterStatus.isDisplayed();
        claimsElements.executedFilterStatus.click();

        Assertions.assertEquals("true", claimsElements.executedFilterStatus.getAttribute("checked"));

        claimsElements.canceledFilterStatus.isDisplayed();
        claimsElements.canceledFilterStatus.click();

        Assertions.assertEquals("true", claimsElements.canceledFilterStatus.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.expendButton.isDisplayed();
    }

    @Test
    @DisplayName("104. Search claim without status")
    @Step("2. Уведомление об ошибке поиска претензии при невалидных параметрах поиска")
    @Description(" Открылась страница с претензиями и уведомлением об ошибке поиска претензий")
    public void searchClaimWithoutStatus104() {

        claimsElements.titleClaimOnMainPage.isDisplayed();

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.openFilterStatus.isDisplayed();
        claimsElements.openFilterStatus.click();
        Assertions.assertEquals("false", claimsElements.openFilterStatus.getAttribute("checked"));

        claimsElements.inProgress.isDisplayed();
        claimsElements.inProgress.click();
        Assertions.assertEquals("false", claimsElements.inProgress.getAttribute("checked"));

        claimsElements.executedFilterStatus.isDisplayed();
        Assertions.assertEquals("false", claimsElements.executedFilterStatus.getAttribute("checked"));

        claimsElements.canceledFilterStatus.isDisplayed();
        Assertions.assertEquals("false", claimsElements.canceledFilterStatus.getAttribute("checked"));

        claimsElements.okButton.isDisplayed();
        claimsElements.okButton.click();

        claimsElements.thereIsNothingHereYetMsg.isDisplayed();
        Assertions.assertEquals("There is nothing here yet…", claimsElements.thereIsNothingHereYetMsg.getText());
    }

    @Test
    @DisplayName("105. Cancel search claim")
    @Step("2. Отмена поиска претензии через фильтр на странице претензий")
    @Description("Поиск по фильтру отменен, открыта страница с претензиями")
    public void cancelSearchClaim105() {

        claimsElements.allClaimsButton.isDisplayed();
        claimsElements.allClaimsButton.click();

        claimsElements.filterButton.isDisplayed();
        claimsElements.filterButton.click();

        claimsElements.filterHeader.isDisplayed();

        claimsElements.cancelFilterButton.isDisplayed();
        claimsElements.cancelFilterButton.click();

        claimsElements.claimsHeader.isDisplayed();
    }

    @Test
    @DisplayName("106. Calendar must have current date selected")
    @Step("2. В календаре должна быть выбрана текущая дата")
    @Description("Открылся календарь с выбранной текущей датой")
    public void calendarMustHaveCurrentDateSelected106() {

        claimsElements.addNewClaimOnMainPageButton.isDisplayed();
        claimsElements.addNewClaimOnMainPageButton.click();

        claimsElements.creatingHeader.isDisplayed();

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.click();

        claimsElements.dateInCalendar.isDisplayed();
        Assertions.assertEquals(claimsElements.dateInCalendar.getText(), LocalDate.now().format(DateTimeFormatter.ofPattern("E, MMM d", Locale.US)));
    }

    @Test
    @DisplayName("107. Date in creation must match date selected in calendar")
    @Step("2. Дата в создании претензии должна соответствовать дате выбранной в календаре")
    @Description("Дата сохранилась в поле дата в создании претензии")
    public void dateInCreationMustMatchDateSelectedInCalendar107() {

        claimsElements.addNewClaimOnMainPageButton.isDisplayed();
        claimsElements.addNewClaimOnMainPageButton.click();

        claimsElements.creatingHeader.isDisplayed();

        claimsElements.dateField.isDisplayed();
        claimsElements.dateField.click();

        claimsElements.okButtonDate.isDisplayed();
        claimsElements.okButtonDate.click();

        claimsElements.dateField.isDisplayed();
        Assertions.assertEquals(claimsElements.dateField.getText(), LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @Test
    @DisplayName("108. Change clock view when choose time")
    @Step("2. Изменения вида часов при выборе времени")
    @Description("Вид часов изменился на цифровые")
    public void changeClockViewWhenChooseTime108() {

        claimsElements.addNewClaimOnMainPageButton.isDisplayed();
        claimsElements.addNewClaimOnMainPageButton.click();

        claimsElements.creatingHeader.isDisplayed();

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.click();

        claimsElements.clockModeButton.isDisplayed();
        claimsElements.clockModeButton.click();

        claimsElements.typeTime.isDisplayed();
        claimsElements.labelHour.isDisplayed();
        claimsElements.labelMinute.isDisplayed();
    }

    @Test
    @DisplayName("109. Cancel choose time")
    @Step("2. Отмена выбора времени на часах")
    @Description("Часы закрылись выбор времени отменен")
    public void cancelChooseTime109() {

        claimsElements.addNewClaimOnMainPageButton.isDisplayed();
        claimsElements.addNewClaimOnMainPageButton.click();

        claimsElements.creatingHeader.isDisplayed();

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.click();

        claimsElements.cancelCommentButton.isDisplayed();
        claimsElements.cancelCommentButton.click();

        claimsElements.creatingHeader.isDisplayed();
    }

    @Test
    @DisplayName("110. Time  in claim must correspond selected time")
    @Step("2. Время отображающееся в претензии должно соответствовать выбранному времени на часах")
    @Description("В создании претензии отображается выбранное время")
    public void timeInClaimMustCorrespondSelectedTime110() {

        claimsElements.addNewClaimOnMainPageButton.isDisplayed();
        claimsElements.addNewClaimOnMainPageButton.click();

        claimsElements.creatingHeader.isDisplayed();

        claimsElements.timeField.isDisplayed();
        claimsElements.timeField.click();

        claimsElements.hours.isDisplayed();
        claimsElements.minutes.isDisplayed();

        String hour = claimsElements.hours.getText();
        String minute = claimsElements.minutes.getText();

        claimsElements.okButtonTime.isDisplayed();
        claimsElements.okButtonTime.click();

        claimsElements.timeField.isDisplayed();

        Assertions.assertEquals((hour + ":" + minute), claimsElements.timeField.getText());
    }
}