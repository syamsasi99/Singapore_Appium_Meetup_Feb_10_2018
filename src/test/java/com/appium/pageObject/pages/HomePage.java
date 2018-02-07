package com.appium.pageObject.pages;


import com.appium.pageObject.objects.HomePageObject;
import com.appium.pageObject.utils.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by syamsasi on 07/02/17.
 */
public class HomePage {

    AppiumDriver driver;

    HomePageObject homePageObject;

    public HomePage(AppiumDriver<?> driver) {
        this.driver = driver;
        homePageObject=  new HomePageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),homePageObject);
    }


    public HomePage clickMenu() {
        AppiumHelper.waitForElementVisible(driver,homePageObject.menuButton);
        homePageObject.menuButton.click();
        return new HomePage(driver);
    }

    public InputControlsPage clickInputControls() {
        AppiumHelper.waitForElementVisible(driver,homePageObject.inputControls);
        homePageObject.inputControls.click();
        return new InputControlsPage(driver);
    }
}
