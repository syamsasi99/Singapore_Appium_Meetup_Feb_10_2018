package com.appium.pageObject.pages;


import com.appium.pageObject.objects.InputControlsPageObject;
import com.appium.pageObject.utils.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by syamsasi on 07/02/17.
 */
public class InputControlsPage {

    AppiumDriver driver;
    InputControlsPageObject inputControlsPageObject;

    public InputControlsPage(AppiumDriver driver) {
        this.driver = driver;
        inputControlsPageObject =new InputControlsPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),inputControlsPageObject);
    }


    public InputControlsPage enterText(String keys) {
        AppiumHelper.waitForElementVisible(driver,inputControlsPageObject.textField);
        inputControlsPageObject.textField.sendKeys(keys);
        return new InputControlsPage(driver);
    }

    public String getCurrentTextValue() {
        AppiumHelper.waitForElementVisible(driver,inputControlsPageObject.textField);
        return inputControlsPageObject.textField.getAttribute("text");
    }
}
