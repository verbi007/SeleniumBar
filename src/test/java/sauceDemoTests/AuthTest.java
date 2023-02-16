package sauceDemoTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.saucedemo.AuthPage;
import seleniumCore.SeleniumBaseTest;


public class AuthTest extends SeleniumBaseTest {
    @Test
    @Epic("SauceDemo")
    @Story("Authorization test")
    @Step("Проверка авторизации")
    @Description("Auth positive")
    public void checkAuthPositive() {
        String titleMainPage = new AuthPage()
                .fillAuth()
                .getTitle();
        Assertions.assertEquals("PRODUCTS", titleMainPage, "Wrong page title");
    }

}
