package com.skillio.locators;

/**
 * LoginLocator — all locators for the OrangeHRM login page.
 * Strategy: prefer name attribute > CSS > xpath for stability.
 */
public class LoginLocator {
    private LoginLocator() {}

    public static final String USERNAME        = "//input[@name='username']";
    public static final String PASSWORD        = "//input[@name='password']";
    public static final String LOGIN_BUTTON    = "//button[@type='submit']";
    public static final String LOGIN_ERROR     = "p.oxd-alert-content-text"; // CSS
    public static final String DASHBOARD_HEADER = "//h6[normalize-space()='Dashboard']";
    public static final String USERNAME_ERROR  =
        "//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]" +
        "//span[contains(@class,'oxd-input-field-error')]";
    public static final String PASSWORD_ERROR  =
        "//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]" +
        "//span[contains(@class,'oxd-input-field-error')]";
}