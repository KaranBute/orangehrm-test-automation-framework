package com.skillio.locators;

public class LeaveLocator {
    private LeaveLocator() {}

    public static final String LEAVE_MENU            = "//span[normalize-space()='Leave']";
    public static final String APPLY_LINK            = "//a[normalize-space()='Apply']";
    public static final String LEAVE_LIST_LINK       = "//a[normalize-space()='Leave List']";
    public static final String LEAVE_TYPE_DROPDOWN   =
        "//label[normalize-space()='Leave Type']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String FROM_DATE_INPUT       =
        "//label[normalize-space()='From Date']/following::input[1]";
    public static final String TO_DATE_INPUT         =
        "//label[normalize-space()='To Date']/following::input[1]";
    public static final String COMMENT_TEXTAREA      =
        "//label[normalize-space()='Comments']/following::textarea[1]";
    public static final String APPLY_BUTTON          = "//button[normalize-space()='Apply']";
    public static final String STATUS_FILTER_DROPDOWN =
        "//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String SEARCH_BUTTON         = "//button[normalize-space()='Search']";
    public static final String APPROVE_BTN           = "//button[normalize-space()='Approve']";
    public static final String REJECT_BTN            = "//button[normalize-space()='Reject']";
    public static final String DATE_ERROR            =
        "//span[contains(text(),'Should be after')]";
    public static final String SUCCESS_TOAST         =
        "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    /** Usage: String.format(LeaveLocator.LISTBOX_OPTION, "Annual Leave") */
    public static final String LISTBOX_OPTION        =
        "//div[@role='listbox']//span[normalize-space()='%s']";
}