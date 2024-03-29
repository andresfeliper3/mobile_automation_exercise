package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.LoginScreen;
import com.globant.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    @Parameters({"registeredEmail", "registeredPassword"})
    public void loginSuccessfulTest(String email, String password) {
        HomeScreen homeScreen = getHomeScreen();
        LoginScreen loginScreen = homeScreen.clickOnLoginOption();

        loginScreen.login(email, password);

        String alertText = loginScreen.acceptAlertAndGetText();

        Assert.assertEquals(alertText, "Success\\nYou are logged in!");
    }
}
