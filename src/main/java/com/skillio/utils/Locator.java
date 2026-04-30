package com.skillio.utils;

/**
 * Locator — legacy interface kept for backward compatibility with AdminTestCase.
 * New code should use the classes in com.skillio.locators.*
 *
 * FIX: employeeNamemandaakhiluser XPath was too broad (matched any 'manda' employee).
 * Updated to use a more specific partial match that still works reliably.
 */
public interface Locator {

    String username               = "//input[@name='username']";
    String password               = "//input[@name='password']";
    String signInButton           = "//button[@type='submit']";
    String Admin                  = "//span[normalize-space()='Admin']";
    String addButton              = "//button[normalize-space()='Add']";
    String userRole               =
        "//label[normalize-space()='User Role']/following::div[contains(@class,'oxd-select-text')][1]";
    String userRoleAdmin          =
        "//div[@role='listbox']//span[normalize-space()='Admin']";
    String employeeName           = "//input[@placeholder='Type for hints...']";
    // FIX: was 'manda' — too broad. Use 'manda akhil' to narrow the match.
    String employeeNameSuggestion =
        "//div[@role='listbox']//span[contains(normalize-space(),'manda akhil')]";
    String status                 =
        "//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]";
    String statusEnabled          =
        "//div[@role='listbox']//span[normalize-space()='Enabled']";
    String usernameForNewUser     =
        "//label[normalize-space()='Username']/following::input[1]";
    String passwordForNewUser     =
        "//label[normalize-space()='Password']/following::input[1]";
    String confirmPasswordForNewUser =
        "//label[normalize-space()='Confirm Password']/following::input[1]";
    String saveButton             = "//button[normalize-space()='Save']";
}