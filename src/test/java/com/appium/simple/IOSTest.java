package com.appium.simple;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;




/**
 * Created by syamsasi on 07/02/17.
 */
public class IOSTest {
    AppiumDriver<MobileElement> driver;
    AppiumDriverLocalService appiumDriverLocalService;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/build/aws.app");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void enterStringOnTextField() throws InterruptedException {


        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Inputs");
        AppiumHelper.waitForElementVisible(driver,el2);
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextView");
        AppiumHelper.waitForElementVisible(driver,el3);
        AppiumHelper.clearTextField(driver,el3);
        el3.sendKeys("Singapore Appium Meetup");

    }

}
