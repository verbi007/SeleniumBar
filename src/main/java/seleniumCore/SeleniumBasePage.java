package seleniumCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void setDriver(WebDriver webDriver, WebDriverWait webDriverWait) {
         driver = webDriver;
         wait = webDriverWait;
    }
}
