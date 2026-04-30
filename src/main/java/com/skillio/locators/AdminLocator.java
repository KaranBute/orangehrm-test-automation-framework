package com.skillio.locators;

/**
 * AdminLocator — locators for Admin → User Management → Users.
 */
public class AdminLocator {
    private AdminLocator() {}

    public static final String ADMIN_MENU             = "//span[normalize-space()='Admin']";
    public static final String ADD_BUTTON             = "//button[normalize-space()='Add']";
    public static final String USER_ROLE_DROPDOWN     =
        "//label[normalize-space()='User Role']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String USER_ROLE_ADMIN        =
        "//div[@role='listbox']//span[normalize-space()='Admin']";
    public static final String USER_ROLE_ESS          =
        "//div[@role='listbox']//span[normalize-space()='ESS']";
    public static final String EMPLOYEE_NAME_INPUT    =
        "//input[@placeholder='Type for hints...']";
    public static final String STATUS_DROPDOWN        =
        "//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String STATUS_ENABLED         =
        "//div[@role='listbox']//span[normalize-space()='Enabled']";
    public static final String STATUS_DISABLED        =
        "//div[@role='listbox']//span[normalize-space()='Disabled']";
    public static final String USERNAME_INPUT         =
        "//label[normalize-space()='Username']/following::input[1]";
    public static final String PASSWORD_INPUT         =
        "//label[normalize-space()='Password']/following::input[1]";
    public static final String CONFIRM_PASSWORD_INPUT =
        "//label[normalize-space()='Confirm Password']/following::input[1]";
    public static final String SAVE_BUTTON            =
        "//button[normalize-space()='Save']";
    public static final String SUCCESS_TOAST          =
        "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    /**
     * Row by username in the users table.
     * Usage: String.format(AdminLocator.USER_ROW_BY_USERNAME, "Admin777")
     */
    public static final String USER_ROW_BY_USERNAME   =
        "//div[contains(@class,'oxd-table-body')]//div[normalize-space()='%s']";
}