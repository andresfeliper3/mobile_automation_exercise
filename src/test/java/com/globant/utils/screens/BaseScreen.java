package com.globant.utils.screens;

import com.globant.screens.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    protected AndroidDriver androidDriver;
    protected WebDriverWait webDriverWait;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Webview\")")
    private WebElement webViewOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    private WebElement loginOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Forms\")")
    private WebElement formsOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe\")")
    private WebElement swipeOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag\")")
    private WebElement dragOption;

    public BaseScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    public boolean isElementVisible(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }

    public void waitForElementVisible(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForAlertVisible() {
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public WebViewScreen clickOnWebViewOption() {
        if(isElementVisible(webViewOption))
            webViewOption.click();
        return new WebViewScreen(androidDriver);
    }

    public LoginScreen clickOnLoginOption() {
        if(isElementVisible(loginOption))
            loginOption.click();
        return new LoginScreen(androidDriver);
    }

    public FormsScreen clickOnFormsOption() {
        if(isElementVisible(formsOption))
            formsOption.click();
        return new FormsScreen(androidDriver);
    }

    public SwipeScreen clickOnSwipeOption() {
        if(isElementVisible(swipeOption))
            swipeOption.click();
        return new SwipeScreen(androidDriver);
    }

    public DragScreen clickOnDragOption() {
        if(isElementVisible(dragOption))
            dragOption.click();
        return new DragScreen(androidDriver);
    }

}
