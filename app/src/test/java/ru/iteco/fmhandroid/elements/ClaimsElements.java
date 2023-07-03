package ru.iteco.fmhandroid.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Элементы страниц Претензий
 */
public class ClaimsElements {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement claimsHeader;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/all_claims_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement allClaimsButton;

    @AndroidFindBy(accessibility = "Add new claim button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement plusButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/custom_app_bar_title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement creatingHeader;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/title_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement titleField;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/executor_drop_menu_auto_complete_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement executorField;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/date_in_plan_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement dateField;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement okButtonDate;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/time_in_plan_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement timeField;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement okButtonTime;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/description_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement descriptionField;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/save_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement saveButton;

    @AndroidFindBy(accessibility = "Filter claim list menu button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filterButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/claim_filter_dialog_title")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filterHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement topic;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[4]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement executor;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[6]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement planDate;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[7]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement planTime;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement claimsArea;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement topicInside;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/executor_name_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement executorInside;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/plane_date_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement planDateInside;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/plan_time_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement planTimeInside;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/author_label_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement authorInfo;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/create_data_label_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement createdInfo;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/item_filter_in_progress")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement inProgress;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/item_filter_open")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement openFilterStatus;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/item_filter_executed")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement executedFilterStatus;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/item_filter_cancelled")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement canceledFilterStatus;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/claim_list_filter_ok_material_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement okButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.ImageView[5]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement expendButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/status_label_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement claimStatus;

    @AndroidFindBy(accessibility = "button change status")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement setStatusButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement takeToWorkButton;

    @AndroidFindBy(accessibility = "button settings")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement notebookAndPencilButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/custom_app_bar_title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement editingHeader;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/custom_app_bar_sub_title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement editingHeader2;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/description_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement description;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/cancel_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement cancelButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/status_processing_image_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement gearButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement throwOffButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement toExecuteButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/editText")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement commentField;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement cancelCommentButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/comment_description_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement commentArea;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement commentArea2;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/title_material_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement titleClaimOnMainPage;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/add_comment_image_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement plusCommentButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement addCommentField;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/edit_comment_image_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement editCommentButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/description_material_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement topicDescription;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/executor_name_material_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement executorName;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement errorMsg;

    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"button edit comment\"])[2]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement editCommentArea2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement commentArea1;

    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"button edit comment\"])[1]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement editCommentArea1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup[1]/android.widget.CompoundButton")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement turnExpandClaimsButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/add_new_claim_material_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement addNewClaimOnMainPageButton;

    @AndroidFindBy(id = "android:id/date_picker_header_date")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement dateInCalendar;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/claim_filter_cancel_material_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement cancelFilterButton;

    @AndroidFindBy(id = "android:id/toggle_mode")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement clockModeButton;

    @AndroidFindBy(id = "android:id/top_label")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement typeTime;

    @AndroidFindBy(id = "android:id/label_hour")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement labelHour;

    @AndroidFindBy(id = "android:id/label_minute")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement labelMinute;

    @AndroidFindBy(id = "android:id/hours")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement hours;

    @AndroidFindBy(id = "android:id/minutes")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement minutes;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement addCommentArea;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/empty_claim_list_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement thereIsNothingHereYetMsg;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/plan_date_material_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement dateOnMainPage;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/plan_time_material_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement timeOnMainPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement claimAreaOnMainPage;

    public ClaimsElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
}
