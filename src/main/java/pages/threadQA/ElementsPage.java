package pages.threadQA;

import dataProvider.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumCore.SeleniumBasePage;

import java.util.ArrayList;
import java.util.List;


// page_url = http://85.192.34.140:8081/elements

public class ElementsPage extends SeleniumBasePage {
    private Actions action;

    @FindBy(css = "body")
    private WebElement pageBody;

    @FindBy(xpath = "//span[text()='Text Box']/..")
    private WebElement textBoxBtn;

    @FindBy(xpath = "//span[text()='Check Box']/..")
    private WebElement checkBoxBtn;

    @FindBy(xpath = "//span[text()='Radio Button']/..")
    private WebElement radioButtonBtn;

    @FindBy(xpath = "//span[text()='Web Tables']/..")
    private WebElement webTablesBtn;

    @FindBy(xpath = "//span[text()='Buttons']/..")
    private WebElement buttonsBtn;

    @FindBy(xpath = "//span[text()='Links']/..")
    private WebElement linksBtn;

    @FindBy(css = "#userName")
    private WebElement inputUserName;

    @FindBy(css = "#userEmail")
    private WebElement inputUserEmail;

    @FindBy(css = "#currentAddress")
    private WebElement textareaCurrentAddress;

    @FindBy(css = "#permanentAddress")
    private WebElement textareaPermanentAddress;

    @FindBy(css = "#submit")
    private WebElement buttonSubmit;

    @FindBy(css = "#name")
    private WebElement pName;

    @FindBy(css = "#email")
    private WebElement pEmail;

    @FindBy(css = "p#currentAddress")
    private WebElement pCurrentAddress;

    @FindBy(css = "p#permanentAddress")
    private WebElement pPermanentAddress;

    @FindBy(css = ".rct-option-expand-all")
    private WebElement buttonExpandAll;

    @FindBy(xpath = "//*[@for='tree-node-private']")
    private WebElement treeNodePrivate;


    @FindBy(css = "#result span.text-success")
    private WebElement resultCheckBox;

    @FindBy(xpath = "//*[@for='impressiveRadio']")
    private WebElement impressiveRadioBtn;

    @FindBy(css = ".text-success")
    private WebElement resultRadioButton;

    @FindBy(css = "#addNewRecordButton")
    private WebElement addBtnWebTables;

    @FindBy(css = "#firstName")
    private WebElement firstNameModal;

    @FindBy(css = "#lastName")
    private WebElement lastNameModal;

    @FindBy(css = "#userEmail")
    private WebElement emailModal;

    @FindBy(css = "#age")
    private WebElement ageModal;

    @FindBy(css = "#salary")
    private WebElement salaryModal;

    @FindBy(css = "#department")
    private WebElement departmentModal;

    @FindBy(css = "#submit")
    private WebElement submitBtnModal;

    @FindBy(css = "#searchBox")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@class='rt-tr -odd']/div[@class='rt-td']")
    private List<WebElement> firstRowValues;

    @FindBy(css = "#doubleClickBtn")
    private WebElement doubleClickBtn;

    @FindBy(css = "#rightClickBtn")
    private WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeBtn;

    @FindBy(css = ".mt-4 p")
    private List<WebElement> resultClicksButtons;

    @FindBy(css = "#simpleLink")
    private WebElement homeLink;

    /*
    *   Implementation
    */
    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    public ElementsPage clickTextBoxBtn() {
        textBoxBtn.click();
        return this;
    }

    public ElementsPage clickCheckBox() {
        checkBoxBtn.click();
        return this;
    }

    public ElementsPage clickRadioButton() {
        radioButtonBtn.click();
        return this;
    }

    public ElementsPage clickWebTables() {
        webTablesBtn.click();
        return this;
    }

    public ElementsPage clickButtons() {
        buttonsBtn.click();
        return this;
    }

    public ElementsPage clickLinks() {
        linksBtn.click();
        return this;
    }

    public ElementsPage fillInputFields(String name, String email, String curAddress, String perAddress) {
        inputUserName.sendKeys(name);
        inputUserEmail.sendKeys(email);
        textareaCurrentAddress.sendKeys(curAddress);
        textareaPermanentAddress.sendKeys(perAddress);
        buttonSubmit.click();
        return this;
    }

    public String getName() {
        return splitValues(pName.getText());
    }

    public String getEmail() {
        return splitValues(pEmail.getText());
    }

    public String getCurAddress() {
        return splitValues(pCurrentAddress.getText());
    }

    public String getPerAddress() {
        return splitValues(pPermanentAddress.getText());
    }

    private String splitValues(String val) {
            return val.split(":")[1];
    }

    public String[] getArrayValues() {
        return new String[]{getName(), getEmail(), getCurAddress(), getPerAddress()};
    }

    public ElementsPage clickExpandAllBtn() {
        buttonExpandAll.click();
        return this;
    }

    public ElementsPage clickCheckBoxPrivate() {
        treeNodePrivate.click();
        return this;
    }

    public String getTextYouHaveSelectedCheckBox() {
        return resultCheckBox.getText();
    }

    public ElementsPage clickImpressiveRadioBtn() {
        impressiveRadioBtn.click();
        return this;
    }

    public String getTextYouHaveSelectedRadioBtn() {
        return resultRadioButton.getText();
    }

    public ElementsPage clickAddBtn() {
        addBtnWebTables.click();
        return this;
    }

    public ElementsPage fillInputModalFields(String firstName, String lastName, String email, int age, int salary, String department) {
        firstNameModal.sendKeys(firstName);
        lastNameModal.sendKeys(lastName);
        emailModal.sendKeys(email);
        ageModal.sendKeys(String.valueOf(age));
        salaryModal.sendKeys(String.valueOf(salary));
        departmentModal.sendKeys(department);
        submitBtnModal.click();
        return this;
    }

    public ElementsPage searchByFirstName(String firstName) {
        searchBox.sendKeys(firstName);
        return this;
    }

    public WebTablesRow addValuesInNewRow() {
        WebTablesRow newRow = new WebTablesRow();
        List<String> values = new ArrayList<>();

        firstRowValues.forEach(val -> values.add(val.getText()));

        newRow.setFirstName(values.get(0));
        newRow.setLastName(values.get(1));
        newRow.setAge(Integer.parseInt(values.get(2)));
        newRow.setEmail(values.get(3));
        newRow.setSalary(Integer.parseInt(values.get(4)));
        newRow.setDepartment(values.get(5));
        return newRow;
    }

    public ElementsPage doubleClickOnTheBtn() {
        action = new Actions(driver);
        action.doubleClick(doubleClickBtn).perform();
        return this;
    }

    public ElementsPage rightClickOnTheBtn() {
        action = new Actions(driver);
        action.contextClick(rightClickBtn).perform();
        return this;
    }

    public ElementsPage clickClickMe() {
        clickMeBtn.click();
        return this;
    }

    public List<String> getListResultClicks() {
        List<String> list = new ArrayList<>();
        resultClicksButtons.forEach(val -> list.add(val.getText()));
        return list;
    }

    public ElementsPage clickHomeLink() {
        homeLink.click();
//        wait.until(ExpectedConditions.urlToBe(ConfigProvider.URL_THREAD));
        return this;
    }

    public String getCurrentUrlPage() {
        return driver.getCurrentUrl();
    }

}
