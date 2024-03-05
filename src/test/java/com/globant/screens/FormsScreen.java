package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Form components\")")
    private WebElement header;

    public FormsScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(header);
    }
}
