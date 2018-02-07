package com.appium.pageObject.tests;

import com.appium.pageObject.pages.HomePage;
import com.appium.pageObject.pages.InputControlsPage;
import com.appium.pageObject.utils.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by syamsasi on 07/02/17.
 */
public class EnterTextTest extends BaseTest{


        HomePage homePage;

        @Test
        public void enterText() throws InterruptedException {
            homePage = new HomePage(driver);
            String inputString="Singapore Appium Meetup";
            InputControlsPage inputControlsPage = homePage.clickMenu().clickInputControls().enterText(inputString);
            Thread.sleep(2000);
            Assert.assertEquals(inputControlsPage.getCurrentTextValue(),inputString);
        }
    }


