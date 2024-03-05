package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.LoginScreen;
import com.globant.utils.tests.BaseTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(dataProvider = "signUpData")
    public void successfulSignUpTest(String email, String password) {
        HomeScreen homeScreen = getHomeScreen();
        LoginScreen loginScreen = homeScreen.clickOnLoginOption();
        loginScreen.clickOnSignUpMenu();
        loginScreen.fillOutSignUpForm(email, password);
    }
}
