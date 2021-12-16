package org.beymentest.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.beymentest.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertTrue;
import static org.beymentest.constants.BeymenConstant.*;

public class MainPage extends BasePage {

    private static Logger logger = (Logger) LogManager.getLogger(MainPage.class);
    private String productPrice;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage waitSecond(int time) throws InterruptedException {
        Thread.sleep(time*1000);
        return this;
    }

    public MainPage isHomePageLoaded() {
        assertTrue("Anasayfa açılamadı.", findElement(BEYMEN_SEARCH_INPUT).isDisplayed());
        logger.debug("Anasayfa yüklendi");
        return this;
    }

    public MainPage isMyAccountExist() {
        assertTrue("Hesabım butonu bulunamadı.", findElement(BEYMEN_MY_ACCOUNT_BUTTON).isDisplayed());
        logger.debug("Hesabım butonu bulundu");
        return this;
    }

    public MainPage isFavouritesExist() {
        assertTrue("Favorilerim butonu bulunamadı.", findElement(BEYMEN_FAVOURITES_BUTTON).isDisplayed());
        logger.debug("Favorilerim butonu bulundu");
        return this;
    }

    public MainPage isCartExist() {
        assertTrue("Sepetim butonu bulunamadı.", findElement(BEYMEN_CART_BUTTON).isDisplayed());
        logger.debug("Sepetim butonu bulundu");
        return this;
    }

    public MainPage searchProduct(String productName) {
        findElement(BEYMEN_SEARCH_INPUT).sendKeys(productName);
        findElement(BEYMEN_SEARCH_INPUT).sendKeys(Keys.ENTER);
        logger.debug(productName + " adlı ürün arandı");
        return this;
    }

    public MainPage pageScrollDown() throws InterruptedException {
        Thread.sleep(2000);
        scrollToDown();
        Thread.sleep(2000);
        logger.debug("Sayfa sonuna scroll edildi");
        return this;
    }

    public MainPage pageScrollTop() throws InterruptedException {
        scrollToTop();
        Thread.sleep(2000);
        logger.debug("Sayfanın başına scroll edildi");
        return this;
    }

    public MainPage clickShowMore() {
        findElement(BEYMEN_SHOW_MORE_BUTTON).click();
        logger.debug("Daha Fazla Göster butonuna tıklandı");
        return this;
    }

    public MainPage clickRandomProduct() {
        Random rnd = new Random();
        List<WebElement> Products = findElements(BEYMEN_RANDOM_PRODUCT);
        WebElement rndProduct = Products.get(rnd.nextInt(Products.size()));
        rndProduct.click();
        logger.debug("Rastgele bir ürün seçildi");
        return this;
    }

    public  MainPage clickRandomSize() {
       Random rnd = new Random();
       List<WebElement> Sizes = findElements(BEYMEN_PRODUCT_SIZE);
       WebElement rndSize = Sizes.get(rnd.nextInt(Sizes.size()));
       rndSize.click();
       logger.debug("Rastgele beden seçildi");
       return this;
    }

    public MainPage addToCart() throws InterruptedException {
        productPrice = findElement(BEYMEN_PRODUCT_PRICE).getText();
        findElement(BEYMEN_ADD_CART_BUTTON).click();
        waitSecond(2);
        logger.debug("Ürün sepete eklendi fiyat: " + productPrice);
        findElement(BEYMEN_CART_BUTTON).click();
        logger.debug("Sepetim sayfasına gidildi");
        return this;
    }

    public MainPage checkPriceMatch() {
        String latestPrice = findElement(BEYMEN_PRODUCT_PRICE_IN_CART).getText();
        Assert.assertEquals("Fiyatlar birbirine uymuyor.",productPrice,latestPrice);
        logger.debug("Ürün sayfasındaki fiyat ile sepetteki fiyat aynı");
        return this;
    }

    public MainPage increaseAmount() {
        try {
            comboBoxSelector(BEYMEN_AMOUNT_IN_CART,"2");
        }
        catch (NoSuchElementException err) {
            Assert.assertTrue("Ürün adedi 1 tane kaldığı için teste devam edilemiyor." + err,false);
        }
        logger.debug("Ürün adedi arttırıldı");
        String productAmount = findElement(BEYMEN_AMOUNT_IN_CART).getAttribute("value");
        Assert.assertEquals("Ürün adedi uyuşmuyor","2", productAmount );
        return this;
    }

    public MainPage removeItem() {
        findElement(BEYMEN_REMOVE_ITEM).click();
        logger.debug("Ürün sepetten silindi");
        Assert.assertTrue("Sepette ürün mevcut",findElement(BEYMEN_CHECK_CART_EMPTY).isDisplayed());
        return this;
    }


}
