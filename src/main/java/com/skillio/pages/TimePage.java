package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.TimeLocator;
import com.skillio.utils.WaitFor;
import java.time.LocalDate;

public class TimePage {

    public TimePage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = TimeLocator.TIME_MENU)
    private WebElement timeMenu;

    public void navigateToTime() {
        WaitFor.elementToBeClickable(timeMenu);
        timeMenu.click();
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Time']"));
    }

    public void clickSubMenu(String subMenu) {
        By link = By.xpath("//ul[contains(@class,'oxd-main-menu')]//span[normalize-space()='" + subMenu + "']" +
            " | //a[normalize-space()='" + subMenu + "']");
        WaitFor.elementToBeClickable(link);
        Keyword.getDriver().findElement(link).click();
    }

    public void clickOption(String option) {
        By link = By.xpath("//a[normalize-space()='" + option + "']");
        WaitFor.elementToBeClickable(link);
        Keyword.getDriver().findElement(link).click();
    }

    public void clickPunchInOut() {
        By btn = By.xpath(TimeLocator.PUNCH_IN_OUT_BUTTON);
        WaitFor.elementToBeClickable(btn);
        Keyword.getDriver().findElement(btn).click();
    }

    public boolean isPunchSuccessDisplayed() {
        try {
            By toast = By.xpath(TimeLocator.PUNCH_SUCCESS_MESSAGE);
            WaitFor.elementToBeVisible(toast);
            return Keyword.getDriver().findElement(toast).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddTimesheet() {
        By btn = By.xpath(TimeLocator.ADD_TIMESHEET_BUTTON);
        WaitFor.elementToBeClickable(btn);
        Keyword.getDriver().findElement(btn).click();
        WaitFor.elementToBeVisible(By.xpath(TimeLocator.TIMESHEET_DATE_INPUT));
    }

    public void selectCurrentWeekDate() {
        String date = LocalDate.now().toString(); // yyyy-MM-dd
        By dateInput = By.xpath(TimeLocator.TIMESHEET_DATE_INPUT);
        WaitFor.elementToBeVisible(dateInput);
        WebElement el = Keyword.getDriver().findElement(dateInput);
        el.clear();
        el.sendKeys(date);
    }

    public void clickCreateTimesheet() {
        By btn = By.xpath(TimeLocator.CREATE_TIMESHEET_BUTTON);
        WaitFor.elementToBeClickable(btn);
        Keyword.getDriver().findElement(btn).click();
    }

    public void clickCreateTimesheetWithoutDate() {
        // Navigate to add timesheet and click create without filling date
        By dateInput = By.xpath(TimeLocator.TIMESHEET_DATE_INPUT);
        try {
            WaitFor.elementToBeVisible(dateInput);
            WebElement el = Keyword.getDriver().findElement(dateInput);
            el.clear();
        } catch (Exception ignored) {}
        By btn = By.xpath(TimeLocator.CREATE_TIMESHEET_BUTTON);
        WaitFor.elementToBeClickable(btn);
        Keyword.getDriver().findElement(btn).click();
    }

    public boolean isTimesheetCreatedSuccessfully() {
        try {
            By toast = By.xpath(TimeLocator.TIMESHEET_SUCCESS_TOAST);
            WaitFor.elementToBeVisible(toast);
            return Keyword.getDriver().findElement(toast).isDisplayed();
        } catch (Exception e) {
            // also accept navigation to timesheet week view
            try {
                By timesheetGrid = By.xpath("//div[contains(@class,'oxd-sheet')]");
                WaitFor.elementToBeVisible(timesheetGrid);
                return Keyword.getDriver().findElement(timesheetGrid).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public boolean isTimesheetDateErrorDisplayed() {
        try {
            By errLoc = By.xpath(TimeLocator.TIMESHEET_DATE_ERROR);
            WaitFor.elementToBeVisible(errLoc);
            return Keyword.getDriver().findElement(errLoc).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickViewReport() {
        By btn = By.xpath(TimeLocator.TIME_REPORT_BUTTON);
        WaitFor.elementToBeClickable(btn);
        Keyword.getDriver().findElement(btn).click();
    }

    public boolean isReportDisplayed() {
        try {
            By table = By.xpath(TimeLocator.REPORT_TABLE);
            WaitFor.elementToBeVisible(table);
            return Keyword.getDriver().findElement(table).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAttendancePageDisplayed() {
        try {
            By heading = By.xpath(TimeLocator.ATTENDANCE_PAGE_HEADING);
            WaitFor.elementToBeVisible(heading);
            return Keyword.getDriver().findElement(heading).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickSubMenu1(String name) {
        By menu = By.xpath("//span[normalize-space()='Time']");
        WaitFor.elementToBeClickable(menu);
        Keyword.getDriver().findElement(menu).click();

        By sub = By.xpath("//a[normalize-space()='" + name + "']");
        WaitFor.elementToBeClickable(sub);
        Keyword.getDriver().findElement(sub).click();
    }
}
