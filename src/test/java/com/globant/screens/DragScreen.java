package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    private WebElement header;


    public DragScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(header);
    }


}
