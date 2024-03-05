package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    private WebElement headerText;

    public WebViewScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(headerText);
    }




}
