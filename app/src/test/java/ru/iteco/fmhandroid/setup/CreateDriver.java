package ru.iteco.fmhandroid.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;


/**
 * Класс для создания драйвера Андроид или iOS
 */
public class CreateDriver {
    public static AppiumDriver driver;

    public enum PlatForm {Android, iOs}

    PlatForm platForm = PlatForm.Android; // здесь прописать необходимую платформу (Android или iOs)

    public void createDriver() throws MalformedURLException, IllegalArgumentException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        if (platForm == PlatForm.Android) {
            desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(DEVICE_NAME, "Pixel_6_Pro_API_29");
            desiredCapabilities.setCapability(APP_PACKAGE, "ru.iteco.fmhandroid");
            desiredCapabilities.setCapability(APP_ACTIVITY, "ru.iteco.fmhandroid.ui.AppActivity");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        } else if (platForm == PlatForm.iOs) {
            desiredCapabilities.setCapability(PLATFORM_NAME, "iOS");
            desiredCapabilities.setCapability(DEVICE_NAME, "iPhone 11");
            desiredCapabilities.setCapability("appium:bundleId", "something");
            desiredCapabilities.setCapability("appium:automationName", "XCUITest");
            desiredCapabilities.setCapability("appium:includeSafariInWebviews", true);
            driver = new IOSDriver(remoteUrl, desiredCapabilities);
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public CreateDriver() {
        PageFactory.initElements(driver, Duration.ofSeconds(60));
    }
}
