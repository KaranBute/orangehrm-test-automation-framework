package com.skillio.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;


public class LeavePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LeavePage() {
        this.driver = Keyword.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By leaveMenu = By.xpath("//span[normalize-space()='Leave']");
    private final By applyLink = By.xpath("//a[normalize-space()='Apply']");
    private final By leaveListLink = By.xpath("//a[normalize-space()='Leave List']");
    private final By leaveCalendarLink = By.xpath("//a[normalize-space()='Leave Calendar']");

    private final By leaveTypeDropdown = By.xpath("//label[normalize-space()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private final By fromDateInput = By.xpath("//label[normalize-space()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By toDateInput = By.xpath("//label[normalize-space()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By commentTextarea = By.xpath("//textarea[contains(@class,'oxd-textarea')]");
    private final By applyButton = By.xpath("//button[normalize-space()='Apply']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By successToast = By.xpath("//div[contains(@class,'oxd-toast') and contains(.,'Success')]");
    private final By requiredError = By.xpath("//span[normalize-space()='Required']");

    private WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void safeClick(By locator) {
        for (int i = 0; i < 3; i++) {
            try {
                WebElement element = clickable(locator);
                scrollToElement(element);
                element.click();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                sleep(700);
            }
        }

        WebElement element = clickable(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private void typeDate(By locator, String date) {
        WebElement element = visible(locator);
        scrollToElement(element);

        try {
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(date);
            element.sendKeys(Keys.TAB);
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value=''; arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true })); arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                    element,
                    date
            );
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void navigateToLeave() {
        safeClick(leaveMenu);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(applyLink),
                ExpectedConditions.visibilityOfElementLocated(leaveListLink)
        ));
    }

    public void clickApply() {
        safeClick(applyLink);
        visible(By.xpath("//h6[contains(normalize-space(),'Apply Leave') or contains(normalize-space(),'Leave')]"));
    }

    public void clickApplyLeave() {
        clickApply();
    }

    public void clickLeaveList() {
        safeClick(leaveListLink);
    }

    public void clickLeaveCalendar() {
        safeClick(leaveCalendarLink);
    }

    public void clickLeaveSubMenu(String option) {
        By optionLink = By.xpath("//a[normalize-space()='" + option + "']");
        safeClick(optionLink);
    }

    public void selectLeaveType(String leaveType) {
        safeClick(leaveTypeDropdown);

        By option = By.xpath("//div[@role='listbox']//span[normalize-space()='" + leaveType + "']");
        safeClick(option);
    }

    public void enterFromDate(String date) {
        typeDate(fromDateInput, date);
    }

    public void enterToDate(String date) {
        typeDate(toDateInput, date);
    }

    public void enterComment(String comment) {
        WebElement element = visible(commentTextarea);
        scrollToElement(element);
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(comment);
    }

    public void clickApplyButton() {
        safeClick(applyButton);
    }

    public void clickSearch() {
        safeClick(searchButton);
    }

    public boolean isLeaveSuccessToastVisible() {
        try {
            visible(successToast);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isDateErrorDisplayed() {
        try {
            By error = By.xpath(
                    "//span[contains(normalize-space(),'Should be after') " +
                    "or contains(normalize-space(),'should be after') " +
                    "or contains(normalize-space(),'Invalid') " +
                    "or contains(normalize-space(),'Required')]"
            );
            visible(error);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLeaveTypeValidationErrorDisplayed() {
        try {
            visible(requiredError);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLeaveListTableVisible() {
        try {
            By tableOrNoRecord = By.xpath(
                    "//div[contains(@class,'oxd-table')] | " +
                    "//span[normalize-space()='No Records Found']"
            );
            visible(tableOrNoRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLeaveCalendarDisplayed() {
        try {
            By calendarPage = By.xpath(
                    "//h6[contains(normalize-space(),'Leave Calendar')] | " +
                    "//div[contains(@class,'calendar')] | " +
                    "//div[contains(@class,'orangehrm-calendar')]"
            );
            visible(calendarPage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getCommentFieldLength() {
        try {
            WebElement element = visible(commentTextarea);
            String value = element.getAttribute("value");
            return value == null ? 0 : value.length();
        } catch (Exception e) {
            return 0;
        }
    }
    
    public void selectLeaveType1(String type) {

        By dropdown = By.xpath("//label[text()='Leave Type']/following::div[contains(@class,'oxd-select-text')][1]");
        WaitFor.elementToBeClickable(dropdown);
        Keyword.getDriver().findElement(dropdown).click();

        By option = By.xpath("//div[@role='listbox']//span[contains(text(),'" + type + "')]");
        WaitFor.elementToBeVisible(option);
        Keyword.getDriver().findElement(option).click();
    }
}