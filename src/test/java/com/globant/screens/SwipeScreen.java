package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    private WebElement header;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FULLY OPEN SOURCE\")")
    private WebElement firstCardTitle;

    public SwipeScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public boolean isHeaderVisible(){
        return isElementVisible(header);
    }

    public boolean isFirstCardTitleVisible() {
        return isElementVisible(firstCardTitle);
    }

    public boolean areElementsVisible() {
        return isHeaderVisible() && isFirstCardTitleVisible();
    }

}
