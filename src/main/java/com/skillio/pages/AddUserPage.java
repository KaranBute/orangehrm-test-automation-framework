package com.skillio.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;

public class AddUserPage {

    public AddUserPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = "//label[normalize-space()='User Role']/following::div[contains(@class,'oxd-select-text-input')][1]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text-input')][1]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//label[normalize-space()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[normalize-space()='Password']/following::input[1]")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[normalize-space()='Confirm Password']/following::input[1]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    public void selectUserRole(String role) {
        WaitFor.elementToBeClickable(userRoleDropdown);
        userRoleDropdown.click();

        By option = By.xpath("//div[@role='listbox']//span[normalize-space()='" + role + "']");
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void selectUserRoleAdmin() {
        selectUserRole("Admin");
    }

    public void enterEmployeeNameAndSelect(String Manda ) {
        By mandaInput = By.xpath("//input[@placeholder='Type for hints...']");
        WaitFor.elementToBeVisible(mandaInput);

        WebElement input = Keyword.getDriver().findElement(mandaInput);
        input.clear();
        input.sendKeys(Manda);

        WaitFor.elementToBeVisible(By.xpath("//div[@role='listbox']"));

        List<WebElement> suggestions = Keyword.getDriver()
                .findElements(By.xpath("//div[@role='listbox']//span"));

        if (suggestions.isEmpty()) {
            throw new RuntimeException("[AddUserPage] No employee suggestions found.");
        }

        suggestions.get(0).click();
    }

    public void selectStatus(String status) {
        WaitFor.elementToBeClickable(statusDropdown);
        statusDropdown.click();

        By option = By.xpath("//div[@role='listbox']//span[normalize-space()='" + status + "']");
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void selectStatusEnabled() {
        selectStatus("Enabled");
    }

    public void enterUsername(String JohnDoe) {
        WaitFor.elementToBeVisible(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(JohnDoe);
    }

    public void enterPassword(String password) {
        WaitFor.elementToBeVisible(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WaitFor.elementToBeVisible(confirmPasswordInput);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void enterPasswordAndConfirm(String password) {
        enterPassword(password);
        enterConfirmPassword(password);
    }

    public void enterPasswordAndConfirm(String password, String confirmPassword) {
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
    }

    public void clickSave() {
        WaitFor.loaderToBeInvisible();
        WaitFor.elementToBeClickable(saveButton);
        saveButton.click();
    }
}