package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class SwipeScreen extends BaseScreen {
    private static final int TOTAL_CARDS_AMOUNT = 6;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    private WebElement header;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FULLY OPEN SOURCE\")")
    private WebElement firstCardTitle;

    @AndroidFindBy(accessibility = "Carousel")
    private WebElement carousel;

    public SwipeScreen(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public boolean isHeaderVisible(){
        return isElementVisible(header);
    }

    public boolean isFirstCardTitleVisible() {
        try {
            return isElementVisible(firstCardTitle);
        } catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }


    public boolean areElementsVisible() {
        return isHeaderVisible() && isFirstCardTitleVisible();
    }

    public void swipeRight() {
        Dimension size = androidDriver.manage().window().getSize();
        // Define the start and end coordinates for the swipe
        int startX = 1180; // Start from the right side of the screen
        int startY = 1568; // Y coordinate doesn't change for horizontal swipe
        int endX = 360;   // End at the left side of the screen
        int endY = 500;   // Y coordinate doesn't change for horizontal swipe

        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "swipe");
        Sequence sequence = new Sequence(pointerInput, 1)
                .addAction(pointerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(pointerInput.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
                .addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));
    }

    public void swipeToTheLastCard(int swipedCardsAmount) {
        for(int i = 0; i < TOTAL_CARDS_AMOUNT - 1 -swipedCardsAmount; i++) {
            swipeRight();
        }
    }

}
