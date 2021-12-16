package org.beymentest;

import org.beymentest.base.BaseTest;
import org.beymentest.page.MainPage;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest
{
    MainPage mainPage;

    @Before
    public void before() {
        mainPage = new MainPage(getWebDriver());
    }

    @Test
    public void mainTest() throws InterruptedException {
        mainPage.isHomePageLoaded().
                isMyAccountExist().
                isFavouritesExist().
                isCartExist().
                searchProduct("Pantolon").
                pageScrollDown().
                clickShowMore().
                pageScrollTop().
                waitSecond(2).
                clickRandomProduct().
                clickRandomSize().
                waitSecond(2).
                addToCart().
                checkPriceMatch().
                increaseAmount().
                waitSecond(2).
                removeItem();
    }

    @After
    public void after() {
        tearDown();
    }
}
