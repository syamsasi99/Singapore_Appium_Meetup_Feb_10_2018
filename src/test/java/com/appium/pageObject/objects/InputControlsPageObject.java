package com.appium.pageObject.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * Created by syamsasi on 07/02/17.
 */
public class InputControlsPageObject {

    @iOSFindBy(xpath = "//XCUIElementTypeTextView")
    @AndroidFindBy(accessibility = "Text Input Control")
    public MobileElement textField;
}
