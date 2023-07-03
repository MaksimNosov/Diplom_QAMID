package ru.iteco.fmhandroid.setup;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

/**
 * Действия
 */
public class Actions {

    public static void tapByCoordinates(int x, int y, PerformsTouchActions driver) {

        new TouchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }
}
