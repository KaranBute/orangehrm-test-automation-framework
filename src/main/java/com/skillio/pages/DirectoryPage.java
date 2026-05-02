
package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.DirectoryLocator;
import com.skillio.utils.WaitFor;

public class DirectoryPage {

    public DirectoryPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = DirectoryLocator.DIRECTORY_MENU)
    private WebElement directoryMenu;

    @FindBy(xpath = DirectoryLocator.SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = DirectoryLocator.RESET_BUTTON)
    private WebElement resetButton;

    public void navigateToDirectory() {
        WaitFor.click(directoryMenu);
        WaitFor.elementToBeVisible(By.xpath(DirectoryLocator.SEARCH_BUTTON));
    }

    public void enterEmployeeName(String name) {
        WaitFor.type(By.xpath(DirectoryLocator.EMPLOYEE_NAME_INPUT), name);
        try {
            By option = By.xpath("//div[@role='listbox']//span[1]");
            WaitFor.elementToBeVisible(option);
            WaitFor.click(option);
        } catch (Exception ignored) {}
    }

    public void clickSearch() {
        WaitFor.click(searchButton);
    }

    public void clickReset() {
        WaitFor.click(resetButton);
    }

    public boolean isResultsDisplayed() {
        try {
            By result = By.xpath(DirectoryLocator.DIRECTORY_RESULTS_CONTAINER + " | //p[contains(@class,'orangehrm-directory-card-header')]");
            WaitFor.elementToBeVisible(result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoRecordsMessageDisplayed() {
        try {
            WaitFor.elementToBeVisible(By.xpath(DirectoryLocator.NO_RECORDS_MESSAGE));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmployeeNameInputEmpty() {
        try {
            WaitFor.elementToBeVisible(By.xpath(DirectoryLocator.EMPLOYEE_NAME_INPUT));
            String value = Keyword.getDriver().findElement(By.xpath(DirectoryLocator.EMPLOYEE_NAME_INPUT)).getAttribute("value");
            return value == null || value.trim().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
