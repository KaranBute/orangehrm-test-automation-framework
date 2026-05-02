package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.MaintenanceLocator;
import com.skillio.utils.WaitFor;

public class MaintenancePage {

    public MaintenancePage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = MaintenanceLocator.MAINTENANCE_MENU)
    private WebElement maintenanceMenu;

    private final By pageHeading = By.xpath(MaintenanceLocator.PAGE_HEADING);
    private final By searchButton = By.xpath(MaintenanceLocator.PURGE_SEARCH_BUTTON);
    private final By nameInput = By.xpath(MaintenanceLocator.PURGE_EMPLOYEE_NAME_INPUT);
    private final By tableOrNoRec = By.xpath("//div[contains(@class,'oxd-table')] | //span[normalize-space()='No Records Found']");

    public void navigateToMaintenance() {
        WaitFor.click(maintenanceMenu);
        try {
            By confirmPasswordInput = By.xpath("//input[@type='password']");
            WaitFor.elementToBeVisible(confirmPasswordInput);
            WaitFor.type(confirmPasswordInput, "admin123");
            WaitFor.click(By.xpath("//button[normalize-space()='Confirm']"));
        } catch (Exception ignored) {}
        WaitFor.elementToBeVisible(pageHeading);
    }

    public void clickOption(String option) {
        if (option.equalsIgnoreCase("Employee Records") || option.equalsIgnoreCase("Candidate Records")) {
            try { WaitFor.click(By.xpath(MaintenanceLocator.PURGE_RECORDS_SUBMENU)); } catch (Exception ignored) {}
        }
        By link = By.xpath("//a[normalize-space()='" + option + "'] | //li[normalize-space()='" + option + "'] | //span[normalize-space()='" + option + "']");
        WaitFor.click(link);
    }

    public void enterEmployeeNameInPurge(String name) {
        WaitFor.type(nameInput, name);
        try { WaitFor.click(By.xpath("//div[@role='listbox']//span[1]")); } catch (Exception ignored) {}
    }

    public void clickSearchInPurge() { WaitFor.click(searchButton); }
    public void clickSearchWithoutInput() { WaitFor.click(searchButton); }

    public boolean isLandingPageDisplayed() {
        try { WaitFor.elementToBeVisible(pageHeading); return true; } catch (Exception e) { return false; }
    }

    public boolean isPurgeResultsDisplayed() {
        try { WaitFor.elementToBeVisible(tableOrNoRec); return true; } catch (Exception e) { return false; }
    }

    public boolean isAccessLogsTableDisplayed() {
        try { WaitFor.elementToBeVisible(tableOrNoRec); return true; } catch (Exception e) { return false; }
    }

    public boolean isPurgeSearchResponseDisplayed() {
        try { WaitFor.elementToBeVisible(tableOrNoRec); return true; } catch (Exception e) { return false; }
    }
}
