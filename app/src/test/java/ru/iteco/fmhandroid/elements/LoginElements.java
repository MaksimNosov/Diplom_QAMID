package ru.iteco.fmhandroid.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Элементы страницы Авторизации
 */
public class LoginElements {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement loginField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement passwordField;

    @AndroidFindBy(accessibility = "Save")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement loginButton;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/splash_screen_circular_progress_indicator")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement loader;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/splashscreen_image_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement loadingImg;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/splashscreen_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement loadingCitation;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/authorization_image_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement authorizationButton;

    @AndroidFindBy(id = "android:id/title")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement logOutButton;

    public LoginElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
    }
}