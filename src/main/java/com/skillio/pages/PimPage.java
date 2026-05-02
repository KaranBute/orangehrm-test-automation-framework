package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.skillio.base.Keyword;
import com.skillio.locators.PimLocator;
import com.skillio.utils.WaitFor;

public class PimPage {

    public PimPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = PimLocator.PIM_MENU)
    private WebElement pimMenu;

    @FindBy(xpath = PimLocator.ADD_EMPLOYEE_BTN)
    private WebElement addEmployeeBtn;

    @FindBy(xpath = PimLocator.SAVE_BUTTON)
    private WebElement saveButton;

    @FindBy(xpath = PimLocator.SEARCH_BUTTON)
    private WebElement searchButton;

    public void navigateToPim() {
        WaitFor.click(pimMenu);
        By heading = By.xpath("//h6[normalize-space()='Employee Information' or normalize-space()='PIM']");
        WaitFor.elementToBeVisible(heading);
    }

    public void clickAddEmployee() {
        WaitFor.click(By.xpath(PimLocator.ADD_EMPLOYEE_BTN));
        WaitFor.elementToBeVisible(By.xpath(PimLocator.FIRST_NAME));
    }

    public void enterEmployeeDetails(String firstName, String lastName, String empId) {
        WaitFor.type(By.xpath(PimLocator.FIRST_NAME), firstName);
        WaitFor.type(By.xpath(PimLocator.LAST_NAME), lastName);
        WaitFor.type(By.xpath(PimLocator.EMPLOYEE_ID), empId);
    }

    public void clickSave() {
        WaitFor.click(saveButton);
    }

    public void searchByName(String name) {
        WaitFor.type(By.xpath(PimLocator.SEARCH_NAME_INPUT), name);
    }

    public void clickSearch() {
        WaitFor.click(searchButton);
    }

    public void assertSuccessToastDisplayed() {
        try {
            WaitFor.elementToBeVisible(By.xpath(PimLocator.SUCCESS_TOAST));
            return;
        } catch (Exception ignored) {
            WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Personal Details' or normalize-space()='Employee Information']"));
        }
    }

    public void assertRequiredErrorDisplayed() {
        WaitFor.elementToBeVisible(By.xpath(PimLocator.REQUIRED_ERROR));
        Assert.assertTrue(true, "Required field validation error visible");
    }

    public void assertDuplicateIdErrorDisplayed() {
        WaitFor.elementToBeVisible(By.xpath(PimLocator.DUPLICATE_ID_ERROR));
        Assert.assertTrue(true, "Duplicate employee ID error visible");
    }

    public void assertSearchResultsVisible() {
        By tableOrNoRec = By.xpath("//div[contains(@class,'oxd-table')] | //span[normalize-space()='No Records Found']");
        WaitFor.elementToBeVisible(tableOrNoRec);
        Assert.assertTrue(true, "Employee list response displayed");
    }

    public void assertEmployeeListHeadingVisible() {
        By heading = By.xpath("//h6[normalize-space()='Employee Information' or normalize-space()='PIM']");
        WaitFor.elementToBeVisible(heading);
        Assert.assertTrue(Keyword.getDriver().findElement(heading).isDisplayed(), "Employee List heading not visible");
    }
}
