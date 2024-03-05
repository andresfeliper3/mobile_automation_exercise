package com.globant.tests;

import com.globant.screens.*;
import com.globant.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuBarTest extends BaseTest {

    @Test
    public void menuBarNavigationTest() {
        HomeScreen homeScreen = getHomeScreen();
        WebViewScreen webViewScreen = homeScreen.clickOnWebViewOption();

        Assert.assertTrue(webViewScreen.isHeaderVisible());

        LoginScreen loginScreen = webViewScreen.clickOnLoginOption();
        Assert.assertTrue(loginScreen.areElementsVisible());
        Assert.assertEquals(loginScreen.getEmailInputText(), LoginScreen.EMAIL_INPUT_TEXT);

        FormsScreen formsScreen = loginScreen.clickOnFormsOption();
        Assert.assertTrue(formsScreen.isHeaderVisible());

        SwipeScreen swipeScreen = formsScreen.clickOnSwipeOption();
        Assert.assertTrue(swipeScreen.areElementsVisible());

        DragScreen dragScreen = swipeScreen.clickOnDragOption();
        Assert.assertTrue(dragScreen.isHeaderVisible());

    }
}
