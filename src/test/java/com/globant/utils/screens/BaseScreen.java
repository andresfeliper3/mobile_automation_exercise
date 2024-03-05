package com.globant.utils.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
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


    public BaseScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    public boolean isElementVisible(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }

    public void waitForElementVisible(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }


}
