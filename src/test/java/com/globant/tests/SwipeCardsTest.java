package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.SwipeScreen;
import com.globant.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {

    private final int EXPECTED_AMOUNT_OF_CARDS = 1;
    private final String YOU_FOUND_ME_TEXT = "You found me!!!";

    @Test
    public void swipeCardsOnTheSwipeSectionTest() {
        HomeScreen homeScreen = getHomeScreen();
        SwipeScreen swipeScreen = homeScreen.clickOnSwipeOption();

        Assert.assertTrue(swipeScreen.isFirstCardTitleVisible());
        swipeScreen.swipeRight();
        Assert.assertFalse(swipeScreen.isFirstCardTitleVisible());

        swipeScreen.swipeToTheLastCard();
        Assert.assertEquals(swipeScreen.getPresentCardsSize(), EXPECTED_AMOUNT_OF_CARDS);

        swipeScreen.swipeToBottom();
        Assert.assertEquals(swipeScreen.getYouFoundMeText(), YOU_FOUND_ME_TEXT);
    }
}
