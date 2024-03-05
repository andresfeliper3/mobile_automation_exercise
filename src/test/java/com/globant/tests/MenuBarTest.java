package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.WebViewScreen;
import com.globant.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuBarTest extends BaseTest {

    @Test
    public void menuBarNavigationTest() {
        HomeScreen homeScreen = getHomeScreen();
        WebViewScreen webViewScreen = homeScreen.clickOnWebViewOption();

        Assert.assertTrue(webViewScreen.isHeaderVisible());

        homeScreen.clickOnLoginOption();

        /*
        homeScreen.clickOnFormsOption();
        homeScreen.clickOnSwipeOption();
        homeScreen.clickOnDragOption();

         */
    }
}
