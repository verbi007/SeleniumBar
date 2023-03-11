package pages.threadQA;

import dataProvider.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumCore.SeleniumBasePage;

// page_url = http://85.192.34.140:8081/
public class MainPage extends SeleniumBasePage {
    private Actions action;

    @FindBy(xpath = "//*[text()='Elements']")
    private WebElement elementsLink;

    @FindBy(xpath = "//*[text()='Widgets']")
    private WebElement widgetsBtn;

    @FindBy(xpath = "//span[contains(text(), 'Slider')]")
    public WebElement sliderBtn;

    @FindBy(xpath = "//input[@type='range']")
    public WebElement slider;

    @FindBy(css = "#sliderValue")
    public WebElement inputSliderValue;

    public MainPage() {
        driver.get(ConfigProvider.URL_THREAD);
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public ElementsPage clickElementsLink() {
        elementsLink.click();
        return new ElementsPage();
    }
    public MainPage clickWidgetsBtn() {
        widgetsBtn.click();
        return this;
    }

    public MainPage clickSlider() {
        sliderBtn.click();
        return this;
    }

    public MainPage interactionWithSlider() {
        action.clickAndHold(slider).moveByOffset(6, 0).release().perform();
        return this;
    }

    public String checkSliderValue() {
        return inputSliderValue.getAttribute("value");
    }
}