package com.appium.simple;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by syamsasi on 07/02/17.
 */
public class AndriodTest {
	AppiumDriver driver;
	//AppiumDriverLocalService appiumDriverLocalService;

	@Before
	public void setUp() throws MalformedURLException {
		// AppiumServiceBuilder builder = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				               //.withArgument(GeneralServerFlag.LOG_LEVEL, "info").usingAnyFreePort(); /*and so on*/;
				         //appiumDriverLocalService = builder.build();
				         //appiumDriverLocalService.start();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability("avd","Nexus_4_AVD");
		//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
		//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "");
		caps.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "/build/aws.apk");
		//driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), caps);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	}

	@After
	public void tearDown() {
		driver.quit();
		//appiumDriverLocalService.stop();
	}

	@Test
	public void enterStringonTextField() throws InterruptedException {

		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("ReferenceApp");
		AppiumHelper.waitForElementVisible(driver,el1);
		el1.click();
		Thread.sleep(1000);
		MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Input Controls']");
		AppiumHelper.waitForElementVisible(driver,el2);
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Text Input Control");
		AppiumHelper.waitForElementVisible(driver,el3);
		AppiumHelper.clearTextField(driver,el3);
		el3.sendKeys("Singapore Appium Meetup");
		Assert.assertEquals("Singapore Appium Meetup",el3.getAttribute("text"));

	}



}
