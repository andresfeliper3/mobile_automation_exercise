package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.SwipeScreen;
import com.globant.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {

    @Test
    public void swipeCardsOnTheSwipeSectionTest() {
        HomeScreen homeScreen = getHomeScreen();
        SwipeScreen swipeScreen = homeScreen.clickOnSwipeOption();

        Assert.assertTrue(swipeScreen.isFirstCardTitleVisible());
        swipeScreen.swipeRight();
        Assert.assertFalse(swipeScreen.isFirstCardTitleVisible());

        swipeScreen.swipeToTheLastCard(1);
    }
}
