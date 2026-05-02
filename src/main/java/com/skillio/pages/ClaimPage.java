package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.ClaimLocator;
import com.skillio.utils.WaitFor;

public class ClaimPage {

    public ClaimPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    public void navigateToClaim() {
        By menu = By.xpath(ClaimLocator.CLAIM_MENU);
        WaitFor.elementToBeClickable(menu);
        Keyword.getDriver().findElement(menu).click();
        WaitFor.urlToContain("claim");
    }

    public void clickOption(String option) {
        By menuOption = By.xpath("//a[normalize-space()='" + option + "']");
        WaitFor.elementToBeClickable(menuOption);
        Keyword.getDriver().findElement(menuOption).click();

        if (option.equalsIgnoreCase("Submit Claim")) {
            WaitFor.elementToBeVisible(By.xpath(ClaimLocator.SUBMIT_CLAIM_PAGE));
        } else if (option.equalsIgnoreCase("Assign Claim")) {
            WaitFor.elementToBeVisible(By.xpath(ClaimLocator.ASSIGN_CLAIM_PAGE));
        } else {
            WaitFor.elementToBeVisible(By.xpath(ClaimLocator.CLAIM_TABLE_OR_NO_RECORD));
        }
    }

    public void selectEvent(String eventName) {
        selectDropdownOption(ClaimLocator.EVENT_DROPDOWN, eventName);
    }

    public void selectCurrency(String currencyName) {
        selectDropdownOption(ClaimLocator.CURRENCY_DROPDOWN, currencyName);
    }

    private void selectDropdownOption(String dropdownXpath, String visibleText) {
        By dropdown = By.xpath(dropdownXpath);
        WaitFor.elementToBeClickable(dropdown);
        Keyword.getDriver().findElement(dropdown).click();

        By listbox = By.xpath(ClaimLocator.LISTBOX);
        WaitFor.elementToBeVisible(listbox);

        By option = By.xpath(
                String.format(ClaimLocator.LISTBOX_OPTION_CONTAINS, visibleText));

        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void enterRemarks(String remarks) {
        By remarksBox = By.xpath(ClaimLocator.REMARKS_TEXTAREA);
        WaitFor.elementToBeVisible(remarksBox);

        WebElement element = Keyword.getDriver().findElement(remarksBox);
        element.clear();
        element.sendKeys(remarks);
    }

    public void clickCreateButton() {
        By createButton = By.xpath(ClaimLocator.CREATE_BUTTON);
        WaitFor.elementToBeClickable(createButton);
        Keyword.getDriver().findElement(createButton).click();
    }

    public void clickSearchButton() {
        By searchButton = By.xpath(ClaimLocator.SEARCH_BUTTON);
        WaitFor.elementToBeClickable(searchButton);
        Keyword.getDriver().findElement(searchButton).click();
    }

    public boolean isTableVisible() {
        return isClaimsTableOrNoRecordsDisplayed();
    }

    public boolean isSubmitPageVisible() {
        try {
            By page = By.xpath(ClaimLocator.SUBMIT_CLAIM_PAGE);
            WaitFor.elementToBeVisible(page);
            return Keyword.getDriver().findElement(page).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAssignPageVisible() {
        try {
            By page = By.xpath(ClaimLocator.ASSIGN_CLAIM_PAGE);
            WaitFor.elementToBeVisible(page);
            return Keyword.getDriver().findElement(page).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorVisible() {
        try {
            By error = By.xpath(ClaimLocator.REQUIRED_ERROR);
            WaitFor.elementToBeVisible(error);
            return Keyword.getDriver().findElement(error).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isClaimsTableOrNoRecordsDisplayed() {
        try {
            By result = By.xpath(ClaimLocator.CLAIM_TABLE_OR_NO_RECORD);
            WaitFor.elementToBeVisible(result);
            return Keyword.getDriver().findElement(result).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}