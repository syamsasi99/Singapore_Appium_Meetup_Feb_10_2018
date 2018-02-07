package com.appium.gestures;

import com.appium.simple.AppiumHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.HashMap;


// In java client 6.0, The TouchAction class has some deprecated methods, to see the new implementations, check the link below
// https://github.com/appium/java-client/blob/master/src/test/java/io/appium/java_client/android/AndroidTouchTest.java

/**
 * Created by syamsasi on 07/02/17.
 */
public class TouchTest extends BaseTest {

    @Test
    public void swipeRightTest() throws InterruptedException {

        //Thread.sleep(100000);

        if (driver instanceof AndroidDriver) {
            goToNativeComponents();
            swipeFromRightToLeft();
            swipeFromLeftToRight();
            swipeFromRightToLeft();
            swipeFromTopToBottom();
            swipeFromTopToBottom();
            swipeFromBottomToTop();
            swipeFromBottomToTop();
        }
        else{
            goToTextInputControl();
            scroll("right");
            scroll("left");
            goToNativeComponents();
            scroll("down");
            scroll("up");
        }

    }

    private void swipeFromBottomToTop() throws InterruptedException {
        Integer[] widthHeight = getDeviceScreenSize();
        int width = widthHeight[0];
        int height = widthHeight[1];

        int startX = width / 2;
        int startY = (height)*3 / 10;
        int endX = width / 2;
        int endY = ( height )*7/10;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(startX, startY).
                moveTo(endX, endY).release().perform();
        Thread.sleep(1000);
    }

    private void swipeFromTopToBottom() throws InterruptedException {

        Integer[] widthHeight = getDeviceScreenSize();
        int width = widthHeight[0];
        int height = widthHeight[1];

        int startX = width / 2;
        int startY = ( height )*7/10;
        int endX = width / 2;
        int endY = (height) / 10;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(startX, startY).
                moveTo(endX, endY).release().perform();
        Thread.sleep(1000);
    }

    private void swipeFromLeftToRight() throws InterruptedException {

        Integer[] widthHeight = getDeviceScreenSize();
        int width = widthHeight[0];
        int height = widthHeight[1];

        int startX = width / 10;
        int startY = ( height )/5;
        int endX = (width*9)/10;
        int endY = (height) / 5;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(startX, startY).
                moveTo(endX, endY).release().perform();
        Thread.sleep(1000);
    }

    private void swipeFromRightToLeft() throws InterruptedException {
        Integer[] widthHeight = getDeviceScreenSize();
        int width = widthHeight[0];
        int height = widthHeight[1];

        int startX = (width*9)/10;
        int startY = ( height )/5;
        int endX = width / 10;
        int endY = (height) / 5;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(startX, startY).
        moveTo(endX, endY).release().perform();
        Thread.sleep(1000);
    }

    public Integer[] getDeviceScreenSize() {
        Integer[] widthHeight=new Integer[2];
        if (driver instanceof AndroidDriver) {

            MobileElement element = driver.findElementByXPath("//android.widget.FrameLayout");
            widthHeight[0] = element.getSize().getWidth();
            widthHeight[1] = element.getSize().getHeight();

        }
        else{
            MobileElement element = driver.findElementByXPath("//XCUIElementTypeApplication");
            widthHeight[0] =element.getSize().getWidth();
            widthHeight[1] =element.getSize().getHeight();
        }
        return widthHeight;
    }


    private void goToTextInputControl() throws InterruptedException {

        if (driver instanceof AndroidDriver) {
            MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("ReferenceApp");
            AppiumHelper.waitForElementVisible(driver, el1);
            el1.click();
            Thread.sleep(1000);
            MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Input Controls']");
            AppiumHelper.waitForElementVisible(driver, el2);
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Text Input Control");

        }
        else{


            MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Inputs");
            AppiumHelper.waitForElementVisible(driver,el2);
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextView");
            AppiumHelper.waitForElementVisible(driver,el3);


        }
    }

    private void goToNativeComponents() throws InterruptedException {

        if (driver instanceof AndroidDriver) {
            MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("ReferenceApp");
            AppiumHelper.waitForElementVisible(driver, el1);
            el1.click();
            Thread.sleep(1000);
            MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Native Components']");
            AppiumHelper.waitForElementVisible(driver, el2);
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Image Collection']");

        }
        else{


            MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Native");
            AppiumHelper.waitForElementVisible(driver,el2);
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Scrolling View");
            AppiumHelper.waitForElementVisible(driver,el3);
            el3.click();
            Thread.sleep(2000);


        }
    }

    private void scroll(String direction) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: scroll", scrollObject);
        Thread.sleep(1000);

    }
}
