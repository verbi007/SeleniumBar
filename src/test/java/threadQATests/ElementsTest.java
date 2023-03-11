package threadQATests;

import com.github.javafaker.Faker;
import com.mifmif.common.regex.Main;
import dataProvider.ConfigProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.threadQA.ElementsPage;
import pages.threadQA.MainPage;
import pages.threadQA.WebTablesRow;
import seleniumCore.SeleniumBaseTest;

import java.util.ArrayList;
import java.util.List;

public class ElementsTest extends SeleniumBaseTest {

    private Faker faker;

    @Test
    @DisplayName("Text box")
    public void testBoxTest() {
        faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String curAddress = faker.address().fullAddress();
        String perAddress = faker.address().secondaryAddress();
        String[] expectedArrayValues = new String[]{name, email, curAddress, perAddress};

        String[] actualArrayValues = new MainPage()
                .clickElementsLink()
                .clickTextBoxBtn()
                .fillInputFields(name, email, curAddress, perAddress)
                .getArrayValues();

        Assertions.assertArrayEquals(expectedArrayValues, actualArrayValues, "Incorrect values in field result");
    }

    @Test
    @DisplayName("Check Box")
    public void testCheckBox() {
        String actualYouHaveSelected = new MainPage()
                .clickElementsLink()
                .clickCheckBox()
                .clickExpandAllBtn()
                .clickCheckBoxPrivate()
                .getTextYouHaveSelectedCheckBox();

        Assertions.assertEquals("private", actualYouHaveSelected, "Incorrect value in field 'You have selected'");
    }


    @Test
    @DisplayName("Radio Button")
    public void testRadioButton() {
        String actualYouHaveSelected = new MainPage()
                .clickElementsLink()
                .clickRadioButton()
                .clickImpressiveRadioBtn()
                .getTextYouHaveSelectedRadioBtn();

        Assertions.assertEquals("Impressive", actualYouHaveSelected, "Incorrect value in field 'You have selected'");
    }

    @Test
    @DisplayName("Web Tables")
    public void testWebTables() {
        faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        int age = faker.number().numberBetween(20, 30);
        int salary = faker.number().numberBetween(50000, 100000);
        String department = faker.app().name();
        WebTablesRow expectedRow = new WebTablesRow(firstName, lastName, email, age, salary, department);

        WebTablesRow actualRow = new MainPage()
                .clickElementsLink()
                .clickWebTables()
                .clickAddBtn()
                .fillInputModalFields(firstName, lastName, email, age, salary, department)
                .searchByFirstName(firstName)
                .addValuesInNewRow();

        Assertions.assertEquals(expectedRow, actualRow, "Incorrect values in row");
    }

    @Test
    @DisplayName("Buttons")
    public void testButtons() {
        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("You have done a double click");
        expectedResults.add("You have done a right click");
        expectedResults.add("You have done a dynamic click");

        List<String> actualResults = new MainPage()
                .clickElementsLink()
                .clickButtons()
                .doubleClickOnTheBtn()
                .rightClickOnTheBtn()
                .clickClickMe()
                .getListResultClicks();

        Assertions.assertEquals(expectedResults, actualResults, "Incorrect values in result list");
    }

    @Test
    @DisplayName("Links")
    public void testLinks() {
        String actualUrl = new MainPage()
                .clickElementsLink()
                .clickLinks()
                .clickHomeLink()
                .getCurrentUrlPage();

        Assertions.assertEquals(ConfigProvider.URL_THREAD, actualUrl);
    }

}
