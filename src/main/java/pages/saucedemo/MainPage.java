package pages.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumCore.SeleniumBasePage;

public class MainPage extends SeleniumBasePage {
    @FindBy(css = ".inventory_list")
    public WebElement divSauceLabsAllThe;

    @FindBy(css = "a[id='item_4_title_link'] .inventory_item_name")
    public WebElement divSauceLabsBackpack;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    public WebElement buttonAddCartSauceLabs;

    @FindBy(css = "#remove-sauce-labs-backpack")
    public WebElement buttonRemoveSauceLabsBackpack;

    @FindBy(css = ".title")
    public WebElement spanProducts;

    @FindBy(css = "span[class^='shopping']")
    public WebElement spanShoppingCart;

    @FindBy(css = "#react-burger-menu-btn")
    public WebElement buttonReactBurgerMenu;

    @FindBy(css = "#logout_sidebar_link")
    public WebElement linkLogoutSidebar;


    

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return spanProducts.getText();
    }

    public MainPage addToCart() {
        buttonAddCartSauceLabs.click();
        return this;
    }

    public MainPage removeWithCart() {
        buttonRemoveSauceLabsBackpack.click();
        return this;
    }
    
    public boolean checkGoodsInCart() {
        return spanProducts.isDisplayed();
    }

    public MainPage clickBurger() {
        buttonReactBurgerMenu.click();
        return this;
    }

    public MainPage clickLogOutButton() {
        linkLogoutSidebar.click();
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
    
    
}
