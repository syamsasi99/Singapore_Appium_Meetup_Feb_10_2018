package com.appium.pageObject.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by syamsasi on 07/02/17.
 */
public class HomePageObject {

    @AndroidFindBy(accessibility = "ReferenceApp")
    public MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Input Controls']")
    public MobileElement inputControls;

}
