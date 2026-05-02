package com.skillio.locators;

public interface LeaveLocator {

    public static final String LEAVE_MENU = "//span[normalize-space()='Leave']";
    public static final String APPLY_LINK = "//a[normalize-space()='Apply']";
    public static final String LEAVE_LIST_LINK = "//a[normalize-space()='Leave List']";
    public static final String LEAVE_CALENDAR_LINK = "//a[normalize-space()='Leave Calendar']";
    public static final String LEAVE_TYPE_DROPDOWN = "//label[normalize-space()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]";
    public static final String FROM_DATE_INPUT = "//label[normalize-space()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String TO_DATE_INPUT = "//label[normalize-space()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String COMMENT_TEXTAREA = "//textarea[contains(@class,'oxd-textarea')]";
    public static final String APPLY_BUTTON = "//button[normalize-space()='Apply']";
    public static final String STATUS_FILTER_DROPDOWN = "//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]";
    public static final String SEARCH_BUTTON = "//button[normalize-space()='Search']";
    public static final String APPROVE_BTN = "//button[normalize-space()='Approve']";
    public static final String REJECT_BTN = "//button[normalize-space()='Reject']";
    public static final String DATE_ERROR = "//span[contains(normalize-space(),'Should be after') or contains(normalize-space(),'should be after') or contains(normalize-space(),'Invalid') or contains(normalize-space(),'Required')]";
    public static final String SUCCESS_TOAST = "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    public static final String LISTBOX_OPTION = "//div[@role='listbox']//span[normalize-space()='%s']";
}
