package sauceDemoTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.saucedemo.AuthPage;
import pages.saucedemo.MainPage;
import seleniumCore.SeleniumBaseTest;


public class CartTests extends SeleniumBaseTest {
    @Test
    @Epic("SauceDemo")
    @Feature("Cart")
    @Story("Add to Cart")
    @Description("Check add to cart")
    public void checkAddToCart() {
        boolean displayedIcon = new AuthPage()
                .fillAuth()
                .addToCart()
                .checkGoodsInCart();
        Assertions.assertTrue(displayedIcon, "Item not removed from cart");
    }


    @Test
    @Epic("SauceDemo")
    @Feature("Cart")
    @Story("Remove from cart")
    @Flaky
    @Description("Check remove from cart")
    public void removeFromCart() {
        MainPage mainPage = new AuthPage()
                .fillAuth()
                .addToCart();
        mainPage.removeWithCart();
        Assertions.assertFalse(mainPage.checkGoodsInCart(), "Item not removed from cart");
    }
}
