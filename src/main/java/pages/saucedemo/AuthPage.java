package pages.saucedemo;

import dataProvider.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumCore.SeleniumBasePage;

// page_url = https://www.saucedemo.com/
public class AuthPage extends SeleniumBasePage {
    @FindBy(css = "#user-name")
    public WebElement inputUsername;

    @FindBy(css = "#password")
    public WebElement inputPassword;

    @FindBy(css = "#login-button")
    public WebElement loginButton;


    public AuthPage() {
        driver.get(ConfigProvider.URL_SAUCE);
        PageFactory.initElements(driver, this);
    }

    public MainPage fillAuth() {
        inputUsername.sendKeys(ConfigProvider.USERNAME);
        inputPassword.sendKeys(ConfigProvider.PASSWORD);
        loginButton.click();
        return new MainPage();
    }
}
