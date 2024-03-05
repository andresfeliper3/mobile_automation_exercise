package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginScreen extends BaseScreen {

    public static final String EMAIL_INPUT_TEXT = "Email";

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    private WebElement loginMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    private WebElement signUpMenu;

    public LoginScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public String getEmailInputText() {
        return emailInput.getText();
    }

    public boolean isEmailInputVisible() {
        return isElementVisible(emailInput);
    }

    public boolean isLoginMenuVisible() {
        return isElementVisible(loginMenu);
    }

    public boolean isSignUpMenuVisible() {
        return isElementVisible(signUpMenu);
    }

    public boolean areElementsVisible() {
        return isEmailInputVisible() && isLoginMenuVisible() && isSignUpMenuVisible();
    }

}
