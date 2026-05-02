package com.skillio.locators;

public interface MyInfoLocator {

    public static final String MY_INFO_MENU = "//span[normalize-space()='My Info']";
    public static final String PERSONAL_DETAILS_TAB = "//a[normalize-space()='Personal Details']";
    public static final String CONTACT_DETAILS_TAB = "//a[normalize-space()='Contact Details']";
    public static final String EMERGENCY_TAB = "//a[normalize-space()='Emergency Contacts']";
    public static final String FIRST_NAME = "//input[@name='firstName']";
    public static final String LAST_NAME = "//input[@name='lastName']";
    public static final String NATIONALITY_DROPDOWN = "//label[normalize-space()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]";
    public static final String DOB_INPUT = "//label[normalize-space()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String STREET1_INPUT = "//label[normalize-space()='Street 1']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String CITY_INPUT = "//label[normalize-space()='City']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String ADD_BUTTON = "//button[normalize-space()='Add']";
    public static final String CONTACT_NAME_INPUT = "//label[normalize-space()='Name']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String RELATIONSHIP_INPUT = "//label[normalize-space()='Relationship']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String HOME_PHONE_INPUT = "//label[normalize-space()='Home Telephone']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String SAVE_BUTTON = "//button[normalize-space()='Save']";
    public static final String SUCCESS_TOAST = "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    public static final String DOB_ERROR = "//span[contains(normalize-space(),'Should be a valid date') or contains(normalize-space(),'should be before') or contains(normalize-space(),'Invalid')]";
    public static final String LISTBOX_OPTION = "//div[@role='listbox']//span[normalize-space()='%s']";
}
