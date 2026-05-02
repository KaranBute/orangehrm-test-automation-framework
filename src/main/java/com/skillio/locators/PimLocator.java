package com.skillio.locators;

public interface PimLocator {

    public static final String PIM_MENU            = "//span[normalize-space()='PIM']";
    public static final String ADD_EMPLOYEE_BTN    = "//button[normalize-space()='Add']";
    public static final String SEARCH_NAME_INPUT   =
        "(//input[@placeholder='Type for hints...'])[1]";
    public static final String SEARCH_BUTTON       = "//button[normalize-space()='Search']";
    public static final String FIRST_NAME          = "//input[@name='firstName']";
    public static final String MIDDLE_NAME         = "//input[@name='middleName']";
    public static final String LAST_NAME           = "//input[@name='lastName']";
    public static final String EMPLOYEE_ID         = "//input[@name='employeeId']";
    public static final String SAVE_BUTTON         = "//button[@type='submit']";
    public static final String SUCCESS_TOAST       =
        "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    public static final String REQUIRED_ERROR      = "//span[normalize-space()='Required']";
    public static final String DUPLICATE_ID_ERROR  =
        "//span[normalize-space()='Employee Id already exists']";
    public static final String DELETE_SELECTED_BTN =
        "//button[normalize-space()='Delete Selected']";
    public static final String CONFIRM_DELETE_BTN  =
        "//button[normalize-space()='Yes, Delete']";
}