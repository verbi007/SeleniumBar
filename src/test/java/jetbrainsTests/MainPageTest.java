package jetbrainsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.jetbrains.MainPage;
import seleniumCore.SeleniumBaseTest;


public class MainPageTest extends SeleniumBaseTest {

    @Epic("Jetbrains Demo")
    @Test
    @Step("Search")
    public void search() {
        new MainPage().searchButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[data-test='search-input']"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();

        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test='search-input']"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
    }

    @Epic("Jetbrains Demo")
    @Test
    @Step("Tools menu")
    public void toolsMenu() {
        new MainPage().toolsMenu.click();

        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='main-submenu']"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Epic("Jetbrains Demo")
    @Test
    @Step("Navigation to all tools")
    public void navigationToAllTools() {
        MainPage mainPage = new MainPage();
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
