package com.skillio.locators;

/**
 * DirectoryLocator — XPath/CSS locators for the Directory module.
 */
public interface DirectoryLocator {

    // ── Left-nav menu ─────────────────────────────────────
    public static final String DIRECTORY_MENU =
        "//span[normalize-space()='Directory']";

    // ── Search filters ────────────────────────────────────
    public static final String EMPLOYEE_NAME_INPUT =
        "//input[@placeholder='Type for hints...']";
    public static final String JOB_TITLE_DROPDOWN =
        "//label[normalize-space()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String LOCATION_DROPDOWN =
        "//label[normalize-space()='Location']/following::div[contains(@class,'oxd-select-text')][1]";

    /**
     * Dynamic option in any open listbox.
     * Usage: String.format(DirectoryLocator.LISTBOX_OPTION, "New York")
     */
    public static final String LISTBOX_OPTION =
        "//div[@role='listbox']//span[normalize-space()='%s']";

    // ── Action buttons ────────────────────────────────────
    public static final String SEARCH_BUTTON =
        "//button[normalize-space()='Search']";
    public static final String RESET_BUTTON =
        "//button[normalize-space()='Reset']";

    // ── Results ───────────────────────────────────────────
    public static final String DIRECTORY_RESULTS_CONTAINER =
        "//div[contains(@class,'orangehrm-directory-card-container')] | //div[contains(@class,'orangehrm-directory-card')]";
    public static final String NO_RECORDS_MESSAGE =
        "//span[normalize-space()='No Records Found']";

    /**
     * Employee card by name.
     * Usage: String.format(DirectoryLocator.EMPLOYEE_CARD_BY_NAME, "Admin")
     */
    public static final String EMPLOYEE_CARD_BY_NAME =
        "//p[contains(@class,'emp-name') and normalize-space()='%s']";
}
