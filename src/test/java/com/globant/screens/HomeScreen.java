package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy
    private WebElement WebViewIcon;

    @AndroidFindBy
    private WebElement loginIcon;

    @AndroidFindBy
    private WebElement formsIcon;

    @AndroidFindBy
    private WebElement swipeIcon;

    @AndroidFindBy
    private WebElement dragIcon;

    public HomeScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }


}
