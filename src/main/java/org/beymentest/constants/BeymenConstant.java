package org.beymentest.constants;

import org.openqa.selenium.By;

public class BeymenConstant {
    public static final By BEYMEN_SEARCH_INPUT = By.cssSelector("input[class=\"default-input o-header__search--input\"]");
    public static final By BEYMEN_MY_ACCOUNT_BUTTON = By.cssSelector("a[class=\"o-header__userInfo--item bwi-account-o -customer\"]");
    public static final By BEYMEN_FAVOURITES_BUTTON = By.cssSelector("a[class=\"o-header__userInfo--item bwi-favorite-o -favorite\"]");
    public static final By BEYMEN_CART_BUTTON = By.cssSelector("a[class=\"o-header__userInfo--item bwi-cart-o -cart\"]");
    public static final By BEYMEN_SHOW_MORE_BUTTON = By.id("moreContentButton");
    public static final By BEYMEN_RANDOM_PRODUCT = By.cssSelector("div[class=\"o-productList__item\"]");
    public static final By BEYMEN_PRODUCT_SIZE = By.xpath("//span[@class=\"m-variation__item\"  or @class=\"m-variation__item -criticalStock\"]");
    public static final By BEYMEN_ADD_CART_BUTTON = By.cssSelector("button[class=\"m-addBasketFavorite__basket btn\"]");
    public static final By BEYMEN_PRODUCT_PRICE = By.id("priceNew");
    public static final By BEYMEN_AMOUNT_IN_CART = By.id("quantitySelect0");
    public static final By BEYMEN_REMOVE_ITEM = By.id("removeCartItemBtn0");
    public static final By BEYMEN_CHECK_CART_EMPTY = By.id("emtyCart");
    public static final By BEYMEN_PRODUCT_PRICE_IN_CART = By.className("m-productPrice__salePrice");
}
