package ru.iteco.fmhandroid.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Элементы вкладки About
 */
public class AboutElements {

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/about_version_title_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement version;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/about_version_value_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement versionValue;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/about_privacy_policy_value_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement linkPrivacyPolicy;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/about_terms_of_use_value_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement linkTermsOfUse;

    @AndroidFindBy(id = "com.android.chrome:id/title")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement chromeWelcome;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/about_company_info_label_text_view")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement manufacturerInformation;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/about_back_image_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement backButton;

    public AboutElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }
}
