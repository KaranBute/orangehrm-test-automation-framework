package com.skillio.locators;

public class MyInfoLocator {
    private MyInfoLocator() {}

    public static final String MY_INFO_MENU          = "//span[normalize-space()='My Info']";
    public static final String PERSONAL_DETAILS_TAB  = "//a[normalize-space()='Personal Details']";
    public static final String CONTACT_DETAILS_TAB   = "//a[normalize-space()='Contact Details']";
    public static final String EMERGENCY_TAB          = "//a[normalize-space()='Emergency Contacts']";
    public static final String FIRST_NAME             = "//input[@name='firstName']";
    public static final String LAST_NAME              = "//input[@name='lastName']";
    public static final String NATIONALITY_DROPDOWN   =
        "//label[normalize-space()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String DOB_INPUT              =
        "//label[normalize-space()='Date of Birth']/following::input[1]";
    public static final String STREET1_INPUT          =
        "//label[normalize-space()='Street 1']/following::input[1]";
    public static final String CITY_INPUT             =
        "//label[normalize-space()='City']/following::input[1]";
    public static final String ADD_BUTTON             = "//button[normalize-space()='Add']";
    public static final String CONTACT_NAME_INPUT     =
        "//label[normalize-space()='Name']/following::input[1]";
    public static final String RELATIONSHIP_INPUT     =
        "//label[normalize-space()='Relationship']/following::input[1]";
    public static final String HOME_PHONE_INPUT       =
        "//label[normalize-space()='Home Telephone']/following::input[1]";
    public static final String SAVE_BUTTON            = "//button[normalize-space()='Save']";
    public static final String SUCCESS_TOAST          =
        "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    public static final String DOB_ERROR              =
        "//span[contains(text(),'Should be a valid date')]";
    /** Usage: String.format(MyInfoLocator.LISTBOX_OPTION, "Indian") */
    public static final String LISTBOX_OPTION         =
        "//div[@role='listbox']//span[normalize-space()='%s']";
}