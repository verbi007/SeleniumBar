package sauceDemoTests;

import dataProvider.ConfigProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.saucedemo.AuthPage;
import seleniumCore.SeleniumBaseTest;

public class LogoutTest extends SeleniumBaseTest {

    @Test
    @Epic("SauceDemo")
    @Feature("Logout")
    @Description("Logout from burger")
    public void checkLogOutFromBurger() {
        String actualUrl = new AuthPage()
                .fillAuth()
                .clickBurger()
                .clickLogOutButton()
                .getUrl();

        Assertions.assertEquals(ConfigProvider.URL_SAUCE, actualUrl);
    }
}
