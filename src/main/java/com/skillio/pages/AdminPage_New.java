package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.AdminLocator;
import com.skillio.utils.WaitFor;

public class AdminPage_New {

    public AdminPage_New() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = AdminLocator.ADMIN_MENU)
    private WebElement adminMenu;

    @FindBy(xpath = AdminLocator.ADD_BUTTON)
    private WebElement addButton;

    @FindBy(xpath = AdminLocator.USER_ROLE_DROPDOWN)
    private WebElement userRoleDropdown;

    @FindBy(xpath = AdminLocator.EMPLOYEE_NAME_INPUT)
    private WebElement employeeNameInput;

    @FindBy(xpath = AdminLocator.STATUS_DROPDOWN)
    private WebElement statusDropdown;

    @FindBy(xpath = AdminLocator.USERNAME_INPUT)
    private WebElement usernameInput;

    @FindBy(xpath = AdminLocator.PASSWORD_INPUT)
    private WebElement passwordInput;

    @FindBy(xpath = AdminLocator.CONFIRM_PASSWORD_INPUT)
    private WebElement confirmPasswordInput;

    @FindBy(xpath = AdminLocator.SAVE_BUTTON)
    private WebElement saveButton;

    private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private final By searchUsernameInput = By.xpath("//label[normalize-space()='Username']/following::input[1]");
    private final By passwordMismatchError = By.xpath("//span[contains(text(),'Passwords do not match')]");
    private final By usernameExistsError = By.xpath("//span[contains(text(),'Already exists')]");
    private final By jobTitlesHeading = By.xpath("//h6[normalize-space()='Job Titles']");

    public void clickAdminMenu() {
        WaitFor.click(adminMenu);
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Admin']"));
    }

    public void clickAddUser() {
        WaitFor.click(addButton);
        WaitFor.elementToBeVisible(usernameInput);
    }

    public void selectUserRole(String role) {
        WaitFor.click(userRoleDropdown);
        By roleOption = By.xpath("//div[@role='listbox']//span[normalize-space()='" + role + "']");
        WaitFor.click(roleOption);
    }

    public void typeEmployeeName(String name) {
        WaitFor.elementToBeVisible(employeeNameInput);
        employeeNameInput.clear();
        employeeNameInput.sendKeys(name);
        // Wait for autocomplete suggestion
        By suggestion = By.xpath("//div[@role='listbox']//span[contains(normalize-space(),'" + name + "')]");
        try {
            WaitFor.elementToBeVisible(suggestion);
            Keyword.getDriver().findElement(suggestion).click();
        } catch (Exception ignored) {
            // If no suggestion appears, continue
        }
    }

    public void selectStatus(String status) {
        WaitFor.click(statusDropdown);
        By statusOption = By.xpath("//div[@role='listbox']//span[normalize-space()='" + status + "']");
        WaitFor.click(statusOption);
    }

    public void enterUsername(String username) {
        WaitFor.elementToBeVisible(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPasswordAndConfirm(String password, String confirmPassword) {
        WaitFor.elementToBeVisible(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WaitFor.elementToBeVisible(confirmPasswordInput);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickSave() {
        WaitFor.click(saveButton);
    }

    public void enterSearchUsername(String username) {
        WaitFor.elementToBeVisible(searchUsernameInput);
        Keyword.getDriver().findElement(searchUsernameInput).clear();
        Keyword.getDriver().findElement(searchUsernameInput).sendKeys(username);
    }

    public void clickSearch() {
        WaitFor.click(searchBtn);
    }

    public void clickAdminSubMenuItem(String item) {
        By link = By.xpath("//a[normalize-space()='" + item + "'] | //li[normalize-space()='" + item + "']");
        WaitFor.click(link);
    }

    public boolean isUserInList(String username) {
        try {
            By userRow = By.xpath(String.format(AdminLocator.USER_ROW_BY_USERNAME, username));
            WaitFor.elementToBeVisible(userRow);
            return Keyword.getDriver().findElement(userRow).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPasswordMismatchError() {
        try {
            WaitFor.elementToBeVisible(passwordMismatchError);
            return Keyword.getDriver().findElement(passwordMismatchError).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public String getUsernameAlreadyExistsError() {
        try {
            WaitFor.elementToBeVisible(usernameExistsError);
            return Keyword.getDriver().findElement(usernameExistsError).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isJobTitlesPageHeadingVisible() {
        try {
            WaitFor.elementToBeVisible(jobTitlesHeading);
            return Keyword.getDriver().findElement(jobTitlesHeading).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getUsernameAlreadyExistsError1() {
        try {
            By error = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");
            WaitFor.elementToBeVisible(error);
            return Keyword.getDriver().findElement(error).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
