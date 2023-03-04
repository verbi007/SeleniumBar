package threadQATests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.threadQA.MainPage;
import seleniumCore.SeleniumBaseTest;

public class SliderTest extends SeleniumBaseTest {

    @Test
    public void checkSlider() throws InterruptedException {
        String expectedValue = new MainPage()
                .clickWidgetsBtn()
                .clickSlider()
                .interactionWithSlider()
                .checkSliderValue();
        Assertions.assertEquals(expectedValue, "50");
    }
}
