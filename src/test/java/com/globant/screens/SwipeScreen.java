package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class SwipeScreen extends BaseScreen {
    private static final int TOTAL_CARDS_AMOUNT = 6;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    private WebElement header;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FULLY OPEN SOURCE\")")
    private WebElement firstCardTitle;

    @AndroidFindBy(accessibility = "card")
    private List<WebElement> presentCards;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You found me!!!\")")
    private WebElement youFoundMeText;

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
        swipe(1180, 1568, 360, 500);
    }

    public void swipeToTheLastCard() {
        for(int i = 0; i < TOTAL_CARDS_AMOUNT; i++) {
            swipeRight();
        }
    }

    public int getPresentCardsSize() {
        return presentCards.size();
    }

    public void swipeVertically() {
        swipe(670, 890, 670, 150);
    }

    public void swipeToBottom() {
        swipe(970, 890, 670, 150);
        for(int i = 0; i < 25; i++) {
            swipe(720, 2000, 720, 1800);
        }
    }

    private void swipe(int startX, int startY, int endX, int endY) {
        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "swipe");
        Sequence sequence = new Sequence(pointerInput, 1)
                .addAction(pointerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(pointerInput.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
                .addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));
    }

    public String getYouFoundMeText() {
        return youFoundMeText.getText();
    }
}
