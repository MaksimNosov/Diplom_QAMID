package ru.iteco.fmhandroid.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Элементы страниц Новостей
 */
public class NewsElements {

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/all_news_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement allNewsButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement newsHeader;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/filter_news_material_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filterButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/filter_news_title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filterHeader;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/edit_news_material_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement noteAndPencilButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='News editing button'])[1]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement noteAndPencilNewsButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement controlPanelHeader;

    @AndroidFindBy(accessibility = "Add news button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement plusButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/custom_app_bar_title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement creatingNewsHeader1;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/custom_app_bar_sub_title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement creatingNewsHeader2;

    @AndroidFindBy(accessibility = "Show dropdown menu")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement categoryButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_title_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement titleField;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_publish_date_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement publicationDate;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement okButtonPublicationDate;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_publish_time_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement publicationTime;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement okButtonPublicationTime;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_description_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement description;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/save_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement saveButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_category_text_auto_complete_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement category;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/cancel_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement cancelButton;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement cancelButton2;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/switcher")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement activeCheckbox;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[8]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement newsActiveStatus;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_publish_date_start_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filterFrom;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_publish_date_end_text_input_edit_text")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filterUntil;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/filter_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement saveFilterButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filteredNewsDate1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement filteredNewsDate2;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/empty_news_list_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement thereIsNothingHereYet;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement okButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Expand news card button\"])[1]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement expendNews;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_description_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement descriptionsNews;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement titleNews;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/filter_news_active_material_check_box")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement activeCheckBox;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/filter_news_inactive_material_check_box")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement nonActiveCheckBox;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/control_panel_empty_news_list_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement nothingYetStatus;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.CompoundButton")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement turnExpandNewsButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"News delete button\"])[1]")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement deleteNewsButton;

    public NewsElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }
}
