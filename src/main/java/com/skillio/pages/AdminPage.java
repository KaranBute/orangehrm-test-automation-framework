package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;

public class AdminPage {

    public AdminPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    // ─── LOCATORS ──────────────────────────────────────────────────────────

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement passwordInput;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast-content')]")
    private WebElement successToast;

    @FindBy(xpath = "//span[contains(text(),'Passwords do not match')]")
    private WebElement passwordMismatchError;

    @FindBy(xpath = "//span[normalize-space()='Already exists']")
    private WebElement alreadyExistsError;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement searchUsernameInput;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchBtn;

    @FindBy(xpath = "//h6[normalize-space()='Job Titles']")
    private WebElement jobTitlesHeading;

    // ─── ACTIONS ──────────────────────────────────────────────────────────

    public void clickAdd() {
        WaitFor.elementToBeClickable(addButton);
        addButton.click();
    }

    public void selectUserRole(String role) {
        WaitFor.elementToBeClickable(userRoleDropdown);
        userRoleDropdown.click();
        By option = By.xpath("//div[@class='oxd-select-dropdown']//span[normalize-space()='" + role + "']");
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void typeAndSelectEmployee(String hint) {
        WaitFor.elementToBeVisible(employeeNameInput);
        employeeNameInput.clear();
        employeeNameInput.sendKeys(hint);

        By suggestion = By.xpath("//div[@role='listbox']//span[1]");
        WaitFor.elementToBeClickable(suggestion);
        Keyword.getDriver().findElement(suggestion).click();
    }

    public void selectStatus(String status) {
        WaitFor.elementToBeClickable(statusDropdown);
        statusDropdown.click();
        By option = By.xpath("//div[@class='oxd-select-dropdown']//span[normalize-space()='" + status + "']");
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void enterUsername(String username) {
        WaitFor.elementToBeVisible(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPasswordAndConfirm(String pwd, String confirmPwd) {
        WaitFor.elementToBeVisible(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(pwd);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPwd);
    }

    public void clickSave() {
        WaitFor.elementToBeClickable(saveBtn);
        saveBtn.click();
    }

    public void clickSearch() {
        WaitFor.elementToBeClickable(searchBtn);
        searchBtn.click();
    }

    public void navigateToJobSection(String section) {
        By locator = By.xpath("//span[normalize-space()='" + section + "']");
        WaitFor.elementToBeClickable(locator);
        Keyword.getDriver().findElement(locator).click();
    }

    public void clickJobTitles() {
        By locator = By.xpath("//a[normalize-space()='Job Titles']");
        WaitFor.elementToBeClickable(locator);
        Keyword.getDriver().findElement(locator).click();
    }

    // ─── VALIDATIONS ──────────────────────────────────────────────────────

    public void assertSuccessToastDisplayed() {
        WaitFor.elementToBeVisible(successToast);
        Assert.assertTrue(successToast.isDisplayed(), "Success toast not displayed.");
    }

    public void assertUserVisibleInList(String username) {
        By locator = By.xpath("//div[@class='oxd-table-card']//div[normalize-space()='" + username + "']");
        WaitFor.elementToBeVisible(locator);
        Assert.assertTrue(Keyword.getDriver().findElement(locator).isDisplayed(),
            "User '" + username + "' not found in list.");
    }

    public void assertPasswordMismatchError(String expectedMsg) {
        WaitFor.elementToBeVisible(passwordMismatchError);
        Assert.assertTrue(passwordMismatchError.getText().contains(expectedMsg),
            "Password mismatch error not shown.");
    }

    public void assertAlreadyExistsError(String expectedMsg) {
        WaitFor.elementToBeVisible(alreadyExistsError);
        Assert.assertTrue(alreadyExistsError.getText().contains(expectedMsg),
            "'Already exists' error not shown.");
    }

    public void assertSearchResultVisible(String username) {
        assertUserVisibleInList(username);
    }

    public void assertJobTitlesHeadingDisplayed() {
        WaitFor.elementToBeVisible(jobTitlesHeading);
        Assert.assertTrue(jobTitlesHeading.isDisplayed(), "Job Titles heading not visible.");
    }
}
