package pages.threadQA;

import org.openqa.selenium.support.PageFactory;
import seleniumCore.SeleniumBasePage;

public class WindowsWidgets extends SeleniumBasePage {

    public WindowsWidgets() {
        PageFactory.initElements(driver, this);
    }
}
