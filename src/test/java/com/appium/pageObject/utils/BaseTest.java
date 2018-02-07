package com.appium.pageObject.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by syamsasi on 07/02/17.
 */
public class BaseTest {
    public AppiumDriver driver;
    DesiredCapabilities caps;
    public WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability("avd","Nexus_4_AVD");
        caps.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/build/aws.apk");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
