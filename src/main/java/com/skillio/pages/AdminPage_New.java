package com.skillio.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;

/**
 * AdminPage_New — supports TC_ADMIN_01 to TC_ADMIN_05.
 * Covers: Add User, Duplicate Username, Password Mismatch, Search User, Job Titles.
 */
public class AdminPage_New {

    public AdminPage_New() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    // ─── LOCATORS ──────────────────────────────────────────────────────────

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenuLink;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addUserBtn;

    // User Role dropdown (OrangeHRM uses custom oxd-select-wrapper)
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]")
    private WebElement userRoleDropdown;

    // Employee name typeahead
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    // Status dropdown
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[2]")
    private WebElement statusDropdown;

    // Username input on Add User form
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[1]")
    private WebElement usernameInput;

    // Password field
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement passwordInput;

    // Confirm password field
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;

    // Password mismatch error
    @FindBy(xpath = "//span[text()='Passwords do not match']")
    private WebElement passwordMismatchError;

    // Already-exists error on username field
    @FindBy(xpath = "//span[text()='Already exists']")
    private WebElement alreadyExistsError;

    // Search form — username field
    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement searchUsernameInput;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchBtn;

    // Results table rows
    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private List<WebElement> tableRows;

    // Job Titles page heading
    @FindBy(xpath = "//h6[normalize-space()='Job Titles']")
    private WebElement jobTitlesHeading;

    // ─── ACTIONS ──────────────────────────────────────────────────────────

    public void clickAdminMenu() {
        WaitFor.elementToBeClickable(adminMenuLink);
        adminMenuLink.click();
    }

    public void clickAddUser() {
        WaitFor.elementToBeClickable(addUserBtn);
        addUserBtn.click();
    }

    /**
     * Select user role via OrangeHRM custom dropdown.
     * Clicks the wrapper, then selects the option by visible text.
     */
    public void selectUserRole(String role) {
        WaitFor.elementToBeClickable(userRoleDropdown);
        userRoleDropdown.click();
        By option = By.xpath("//div[@class='oxd-select-dropdown']//span[text()='" + role + "']");
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void typeEmployeeName(String name) {
        WaitFor.elementToBeVisible(employeeNameInput);
        employeeNameInput.clear();
        employeeNameInput.sendKeys(name);
        // Wait for autocomplete suggestion and click first match
        By suggestion = By.xpath("//div[@class='oxd-autocomplete-dropdown']//span");
        WaitFor.elementToBeClickable(suggestion);
        Keyword.getDriver().findElement(suggestion).click();
    }

    public void selectStatus(String status) {
        WaitFor.elementToBeClickable(statusDropdown);
        statusDropdown.click();
        By option = By.xpath("//div[@class='oxd-select-dropdown']//span[text()='" + status + "']");
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void enterUsername(String username) {
        WaitFor.elementToBeVisible(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPasswordAndConfirm(String password, String confirm) {
        WaitFor.elementToBeVisible(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirm);
    }

    public void clickSave() {
        WaitFor.elementToBeClickable(saveBtn);
        saveBtn.click();
    }

    public void enterSearchUsername(String username) {
        WaitFor.elementToBeVisible(searchUsernameInput);
        searchUsernameInput.clear();
        searchUsernameInput.sendKeys(username);
    }

    public void clickSearch() {
        WaitFor.elementToBeClickable(searchBtn);
        searchBtn.click();
    }

    public void clickAdminSubMenu(String section) {
        By sectionMenu = By.xpath("//span[text()='" + section + "']");
        WaitFor.elementToBeClickable(sectionMenu);
        Keyword.getDriver().findElement(sectionMenu).click();
    }

    public void clickAdminSubMenuItem(String item) {
        By menuItem = By.xpath("//a[normalize-space()='" + item + "']");
        WaitFor.elementToBeClickable(menuItem);
        Keyword.getDriver().findElement(menuItem).click();
    }

    // ─── VALIDATIONS ──────────────────────────────────────────────────────

    public boolean isUserInList(String username) {
        By userCell = By.xpath("//div[@class='oxd-table-card']//div[normalize-space()='" + username + "']");
        WaitFor.elementToBeVisible(userCell);
        return Keyword.getDriver().findElement(userCell).isDisplayed();
    }

    public String getPasswordMismatchError() {
        WaitFor.elementToBeVisible(passwordMismatchError);
        return passwordMismatchError.getText();
    }

    public String getUsernameAlreadyExistsError() {
        WaitFor.elementToBeVisible(alreadyExistsError);
        return alreadyExistsError.getText();
    }

    public boolean isJobTitlesPageHeadingVisible() {
        WaitFor.elementToBeVisible(jobTitlesHeading);
        return jobTitlesHeading.isDisplayed();
    }
}