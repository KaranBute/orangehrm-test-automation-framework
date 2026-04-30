package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;

public class LeavePage {

    public LeavePage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    // ── Locators ─────────────────────────────────────────────────────────────

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu;

    @FindBy(xpath = "//a[text()='Apply']")
    private WebElement applyLink;

    @FindBy(xpath = "//a[text()='Leave List']")
    private WebElement leaveListLink;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successToast;

    @FindBy(xpath = "//span[contains(text(),'Should be after')]")
    private WebElement dateError;

    @FindBy(xpath = "//button[normalize-space()='Approve']")
    private WebElement approveBtn;

    @FindBy(xpath = "//button[normalize-space()='Reject']")
    private WebElement rejectBtn;

    // ── Actions ──────────────────────────────────────────────────────────────

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithCredentials(username, password);
    }

    public void navigateToLeave() {
        WaitFor.elementToBeClickable(leaveMenu);
        leaveMenu.click();
    }

    public void clickApply() {
        WaitFor.elementToBeClickable(applyLink);
        applyLink.click();
    }

    public void clickLeaveList() {
        WaitFor.elementToBeClickable(leaveListLink);
        leaveListLink.click();
    }

    public void applyLeave(String leaveType, String fromDate, String toDate, String comment) {
        // Extend: select leaveType dropdown, enter dates, enter comment
        // Keeping as stub — extend with actual locators
    }

    public void selectLeaveType(String leaveType) {
        // Extend with dropdown selection
    }

    public void enterFromDate(String fromDate) {
        // Extend with date picker locator
    }

    public void enterToDate(String toDate) {
        // Extend with date picker locator
    }

    public void enterComment(String comment) {
        // Extend with comment textarea locator
    }

    public void filterByStatus(String status) {
        // Extend with status dropdown locator
    }

    public void openFirstPendingRequest() {
        // Extend: click first row in leave list
    }

    public void clickApprove() {
        WaitFor.elementToBeClickable(approveBtn);
        approveBtn.click();
    }

    public void clickReject() {
        WaitFor.elementToBeClickable(rejectBtn);
        rejectBtn.click();
    }

    public void clickSubmit() {
        WaitFor.elementToBeClickable(submitBtn);
        submitBtn.click();
    }

    // ── Validations ──────────────────────────────────────────────────────────

    public boolean isSuccessToastDisplayed() {
        WaitFor.elementToBeVisible(successToast);
        return successToast.isDisplayed();
    }

    public boolean isDateErrorDisplayed() {
        return dateError.isDisplayed();
    }
    
    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu1;

    // Leave type dropdown (custom OrangeHRM selector)
    @FindBy(xpath = "//label[text()='Leave Type']/following::div[@class='oxd-select-wrapper'][1]")
    private WebElement leaveTypeDropdown;

    // From date input
    @FindBy(xpath = "//label[text()='From Date']/following::input[@placeholder='yyyy-dd-mm'][1]")
    private WebElement fromDateInput;

    // To date input
    @FindBy(xpath = "//label[text()='To Date']/following::input[@placeholder='yyyy-dd-mm'][1]")
    private WebElement toDateInput;

    // Comment textarea
    @FindBy(xpath = "//label[text()='Comments']/following::textarea[1]")
    private WebElement commentInput;

    // Apply / Submit button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn1;

    // Status filter dropdown
    @FindBy(xpath = "//label[text()='Status']/following::div[@class='oxd-select-wrapper'][1]")
    private WebElement statusFilterDropdown;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchBtn;

    // Success toast
    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successToast1;

    // Date validation error
    @FindBy(xpath = "//span[contains(text(),'Should be after') or contains(text(),'after from date')]")
    private WebElement dateError1;

    // Leave type required error
    @FindBy(xpath = "//label[text()='Leave Type']/following::span[text()='Required'][1]")
    private WebElement leaveTypeError;

    // My Leave / Leave List table
    @FindBy(xpath = "//div[@class='oxd-table-body']")
    private WebElement leaveTable;

    // Leave calendar container
    @FindBy(xpath = "//div[@class='attendance-calendar']")
    private WebElement leaveCalendar;

    // Duration text shown after dates are entered (e.g., "0.00 Day(s)")
    @FindBy(xpath = "//p[contains(@class,'oxd-text') and contains(text(),'Day')]")
    private WebElement leaveDurationText;

    // Leave status cell in My Leave list
    @FindBy(xpath = "(//div[@class='oxd-table-card']//div)[6]")
    private WebElement leaveStatusCell;

    // Cancel button inside a leave request
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    // Approve / Reject buttons
    @FindBy(xpath = "//button[normalize-space()='Approve']")
    private WebElement approveBtn1;

    @FindBy(xpath = "//button[normalize-space()='Reject']")
    private WebElement rejectBtn1;

    // ─── NAVIGATION ───────────────────────────────────────────────────────

    public void navigateToLeave1() {
        WaitFor.elementToBeClickable(leaveMenu);
        leaveMenu.click();
    }

    public void clickLeaveSubMenu(String option) {
        By menuOption = By.xpath("//a[normalize-space()='" + option + "']");
        WaitFor.elementToBeClickable(menuOption);
        Keyword.getDriver().findElement(menuOption).click();
    }

    // ─── APPLY LEAVE FORM ─────────────────────────────────────────────────

    public void selectLeaveType1(String leaveType) {
        WaitFor.elementToBeClickable(leaveTypeDropdown);
        leaveTypeDropdown.click();
        By option = By.xpath(
            "//div[@class='oxd-select-dropdown']//span[normalize-space()='" + leaveType + "']"
        );
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void enterFromDate1(String date) {
        WaitFor.elementToBeVisible(fromDateInput);
        fromDateInput.clear();
        fromDateInput.sendKeys(date);
    }

    public void enterToDate1(String date) {
        WaitFor.elementToBeVisible(toDateInput);
        toDateInput.clear();
        toDateInput.sendKeys(date);
    }

    public void enterComment1(String comment) {
        WaitFor.elementToBeVisible(commentInput);
        commentInput.clear();
        commentInput.sendKeys(comment);
    }

    public void clickApplyButton() {
        WaitFor.elementToBeClickable(submitBtn);
        submitBtn.click();
    }

    // ─── LEAVE LIST / ADMIN ACTIONS ───────────────────────────────────────

    public void filterByStatus1(String status) {
        WaitFor.elementToBeClickable(statusFilterDropdown);
        statusFilterDropdown.click();
        By option = By.xpath(
            "//div[@class='oxd-select-dropdown']//span[normalize-space()='" + status + "']"
        );
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
        WaitFor.elementToBeClickable(searchBtn);
        searchBtn.click();
    }

    public void openFirstPendingRequest1() {
        By firstRow = By.xpath("(//div[@class='oxd-table-card'])[1]");
        WaitFor.elementToBeClickable(firstRow);
        Keyword.getDriver().findElement(firstRow).click();
    }

    public void openLeaveRequestByStatus(String status) {
        By row = By.xpath(
            "//div[@class='oxd-table-card'][.//div[normalize-space()='" + status + "']]"
        );
        WaitFor.elementToBeClickable(row);
        Keyword.getDriver().findElement(row).click();
    }

    public void clickApprove1() {
        WaitFor.elementToBeClickable(approveBtn);
        approveBtn.click();
    }

    public void clickReject1() {
        WaitFor.elementToBeClickable(rejectBtn);
        rejectBtn.click();
    }

    public void clickCancel() {
        WaitFor.elementToBeClickable(cancelBtn);
        cancelBtn.click();
    }

    // Delegate login to LoginPage — avoids duplicating login logic
    public void login1(String username, String password) {
        new LoginPage().loginWithCredentials(username, password);
    }

    // ─── VALIDATIONS ──────────────────────────────────────────────────────

    public boolean isSuccessToastDisplayed1() {
        WaitFor.elementToBeVisible(successToast);
        return successToast.isDisplayed();
    }

    public String getDateOrValidationError() {
        WaitFor.elementToBeVisible(dateError);
        return dateError.getText();
    }

    public String getLeaveTypeValidationError() {
        WaitFor.elementToBeVisible(leaveTypeError);
        return leaveTypeError.getText();
    }

    public boolean isLeaveListTableVisible() {
        WaitFor.elementToBeVisible(leaveTable);
        return leaveTable.isDisplayed();
    }

    public boolean isLeaveCalendarDisplayed() {
        WaitFor.elementToBeVisible(leaveCalendar);
        return leaveCalendar.isDisplayed();
    }

    public String getLeaveDurationText() {
        WaitFor.elementToBeVisible(leaveDurationText);
        return leaveDurationText.getText();
    }

    public String getLeaveStatusText() {
        WaitFor.elementToBeVisible(leaveStatusCell);
        return leaveStatusCell.getText();
    }

    // Legacy aliases kept for LeaveSteps.java compatibility
    public void clickLeaveList1() {
        clickLeaveSubMenu("Leave List");
    }

    public void clickApply1() {
        clickLeaveSubMenu("Apply");
    }

    public void applyLeave1(String leaveType, String from, String to, String comment) {
        selectLeaveType(leaveType);
        enterFromDate(from);
        enterToDate(to);
        if (comment != null && !comment.isEmpty()) {
            enterComment(comment);
        }
        clickApplyButton();
    }

    public boolean isDateErrorDisplayed1() {
        return dateError.isDisplayed();
    }

}
