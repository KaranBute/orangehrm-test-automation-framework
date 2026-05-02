package com.skillio.locators;

/**
 * MaintenanceLocator — XPath/CSS locators for the Maintenance module.
 */
public interface MaintenanceLocator {

    public static final String MAINTENANCE_MENU =
        "//span[normalize-space()='Maintenance']";
    public static final String PURGE_RECORDS_SUBMENU =
        "//a[normalize-space()='Purge Records']";
    public static final String EMPLOYEE_RECORDS_OPTION =
        "//a[normalize-space()='Employee Records']";
    public static final String CANDIDATE_RECORDS_OPTION =
        "//a[normalize-space()='Candidate Records']";
    public static final String ACCESS_LOGS_OPTION =
        "//a[normalize-space()='Access Logs']";

    // Purge search
    public static final String PURGE_EMPLOYEE_NAME_INPUT =
        "//input[@placeholder='Type for hints...']";
    public static final String PURGE_SEARCH_BUTTON =
        "//button[normalize-space()='Search']";
    public static final String PURGE_RESULTS_TABLE =
        "//div[contains(@class,'oxd-table-body')]";
    public static final String ACCESS_LOGS_TABLE =
        "//div[contains(@class,'oxd-table')]";
    public static final String PAGE_HEADING =
        "//h6[contains(@class,'oxd-text--h6')]";
}
