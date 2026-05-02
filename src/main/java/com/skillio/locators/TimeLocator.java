package com.skillio.locators;

/**
 * TimeLocator — XPath/CSS locators for the Time module.
 * OrangeHRM: https://opensource-demo.orangehrmlive.com
 */
public interface TimeLocator {

    // ── Left-nav menu ─────────────────────────────────────
    String TIME_MENU = "//span[normalize-space()='Time']";

    // ── Sub-menus ─────────────────────────────────────────
    String ATTENDANCE_SUBMENU = "//ul[contains(@class,'oxd-main-menu')]//span[normalize-space()='Attendance']";
    String TIMESHEETS_SUBMENU = "//ul[contains(@class,'oxd-main-menu')]//span[normalize-space()='Timesheets']";
    String REPORTS_SUBMENU = "//ul[contains(@class,'oxd-main-menu')]//span[normalize-space()='Reports']";

    // ── Attendance ────────────────────────────────────────
    String MY_ATTENDANCE_OPTION = "//a[normalize-space()='My Attendance']";
    String PUNCH_IN_OUT_BUTTON = "//button[normalize-space()='In' or normalize-space()='Out' or normalize-space()='Punch In/Out']";
    String PUNCH_SUCCESS_MESSAGE = "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";

    // ── Timesheets ────────────────────────────────────────
    String MY_TIMESHEETS_OPTION = "//a[normalize-space()='My Timesheets']";
    String ADD_TIMESHEET_BUTTON = "//button[normalize-space()='Add Timesheet']";
    String TIMESHEET_DATE_INPUT = "//input[@placeholder='yyyy-mm-dd']";
    String CREATE_TIMESHEET_BUTTON = "//button[normalize-space()='Create']";
    String TIMESHEET_SUCCESS_TOAST = "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    String TIMESHEET_DATE_ERROR = "//span[contains(@class,'oxd-input-field-error-message')]";

    // ── Reports ───────────────────────────────────────────
    String PROJECT_REPORTS_OPTION = "//a[normalize-space()='Project Reports']";
    String PROJECT_NAME_DROPDOWN = "//label[normalize-space()='Project Name']/following::input[1]";
    String TIME_REPORT_BUTTON = "//button[normalize-space()='View Report']";
    String REPORT_TABLE = "//div[contains(@class,'oxd-table')]";

    // ── Attendance records page heading ───────────────────
    String ATTENDANCE_PAGE_HEADING = "//h6[normalize-space()='My Attendance' or normalize-space()='Attendance']";
}
