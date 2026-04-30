package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.skillio.base.Keyword;
import com.skillio.locators.AdminLocator;
import com.skillio.utils.WaitFor;

/**
 * FIXES:
 *  - getDriver() used throughout instead of threadLocal.get().
 *  - Employee name auto-complete uses contains() to handle partial matches
 *    reliably (OrangeHRM sometimes trims/formats the displayed name).
 *  - All dropdowns wait for listbox before selecting option.
 */
public class AddUserPage {

    public AddUserPage() {
        PageFactory.initElements(Keyword.getDriver(), this); // FIXED
    }

    @FindBy(xpath = "//label[normalize-space()='User Role']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//label[normalize-space()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[normalize-space()='Password']/following::input[1]")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[normalize-space()='Confirm Password']/following::input[1]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    public void selectUserRoleAdmin() {
        WaitFor.elementToBeClickable(userRoleDropdown);
        userRoleDropdown.click();
        WaitFor.listboxOptionToBeClickable("Admin");
        Keyword.getDriver().findElement(By.xpath(AdminLocator.USER_ROLE_ADMIN)).click();
    }

    /**
     * Types employee name hint, waits for suggestion list, then clicks the
     * first suggestion that contains the hint text (case-insensitive).
     * FIX: uses contains() instead of exact match — OrangeHRM may display
     * the name with extra formatting.
     */
    public void enterEmployeeNameAndSelect(String hint) {
        By inputBy = By.xpath(AdminLocator.EMPLOYEE_NAME_INPUT);
        WaitFor.elementToBeVisible(inputBy);
        WebElement input = Keyword.getDriver().findElement(inputBy);
        input.clear();
        input.sendKeys(hint);

        // Wait for suggestion list to appear
        WaitFor.suggestionListToBeVisible();

        // Click first suggestion that contains the hint text
        java.util.List<WebElement> suggestions = Keyword.getDriver()
            .findElements(By.xpath("//div[@role='listbox']//span"));
        for (WebElement s : suggestions) {
            if (s.getText().toLowerCase().contains(hint.toLowerCase().split(" ")[0])) {
                s.click();
                System.out.println("[AddUserPage] Selected suggestion: " + s.getText());
                return;
            }
        }
        throw new RuntimeException(
            "[AddUserPage] No suggestion found containing: " + hint);
    }

    public void selectStatusEnabled() {
        WaitFor.elementToBeClickable(statusDropdown);
        statusDropdown.click();
        WaitFor.listboxOptionToBeClickable("Enabled");
        Keyword.getDriver().findElement(By.xpath(AdminLocator.STATUS_ENABLED)).click();
    }

    public void enterUsername(String username) {
        WaitFor.elementToBeVisible(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPasswordAndConfirm(String password) {
        WaitFor.elementToBeVisible(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        WaitFor.elementToBeVisible(confirmPasswordInput);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
    }

    public void clickSave() {
        WaitFor.loaderToBeInvisible();
        WaitFor.elementToBeClickable(saveButton);
        saveButton.click();
    }
}