package com.appium.pageObject.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by syamsasi on 07/02/17.
 */
public class InputControlsPageObject {

    @AndroidFindBy(accessibility = "Text Input Control")
    public MobileElement textField;
}
