package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

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

    public HomeScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public WebViewScreen clickOnWebViewOption() {
        if(isElementVisible(webViewOption))
            webViewOption.click();
        return new WebViewScreen(androidDriver);
    }

    public void clickOnLoginOption() {
        loginOption.click();
    }

    public void clickOnFormsOption() {
        formsOption.click();
    }

    public void clickOnSwipeOption() {
        swipeOption.click();
    }

    public void clickOnDragOption() {
        dragOption.click();
    }


}
