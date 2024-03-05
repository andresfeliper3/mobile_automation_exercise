package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    public static final String EMAIL_INPUT_TEXT = "Email";

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement passwordRepeatInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    private WebElement loginMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    private WebElement signUpMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SIGN UP\")")
    private WebElement signUpButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LOGIN\")")
    private WebElement loginButton;


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

    public void clickOnSignUpMenu() {
        waitForElementVisible(signUpMenu);
        signUpMenu.click();
    }

    public void signUp(String email, String password) {
        fillOutSignUpForm(email, password);
        clickOnSignUpButton();
    }
    private void fillOutSignUpForm(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordRepeatInput.sendKeys(password);
    }

    private void clickOnSignUpButton() {
        waitForElementVisible(signUpButton);
        signUpButton.click();
    }


    public String acceptAlertAndGetText() {
        waitForAlertVisible();
        Alert alert = androidDriver.switchTo().alert();
        String alertText = alert.getText();
        alertText = alertText.replace("\n", "\\n");
        alert.accept();
        return alertText;
    }

    public void login(String email, String password) {
        fillOutLoginForm(email, password);
        clickOnLoginButton();
    }

    private void fillOutLoginForm(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    private void clickOnLoginButton() {
        waitForElementVisible(loginButton);
        loginButton.click();
    }
}
