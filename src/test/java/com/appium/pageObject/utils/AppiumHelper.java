package com.appium.pageObject.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by syamsasi on 07/02/17.
 */
public class AppiumHelper {

    public static WebElement driver(AppiumDriver driver,By by) {
        return driver.findElement(by);

    }

    public static void waitForElementVisible(AppiumDriver driver, MobileElement ele) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void clearTextField(AppiumDriver driver, MobileElement element) {
        if (driver instanceof IOSDriver) {
            try {

                element.click();
                /* Java client 6 Beta
                TouchAction action = new TouchAction(driver);
                LongPressOptions longPressOptions = new LongPressOptions();
                longPressOptions.withDuration(Duration.ofSeconds(3)).withElement(ElementOption.element(element));
                action.longPress(longPressOptions).perform();
                */

                TouchAction action = new TouchAction(driver);
                action.longPress(element).release().perform();
                MobileElement selectAll = (MobileElement) driver.findElementByAccessibilityId("Select All");
                waitForElementVisible(driver,selectAll);
                selectAll.click();
                MobileElement delete = (MobileElement) driver.findElementByAccessibilityId("delete");
                waitForElementVisible(driver,delete);
                delete.click();



            }
            catch(Exception e){
                System.out.println(e.getMessage());

            }

        }
        else{
            element.clear();
        }
    }
}
