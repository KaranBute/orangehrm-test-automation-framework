package com.skillio.locators;

public interface ClaimLocator {

    String CLAIM_MENU = "//span[normalize-space()='Claim']";

    String SUBMIT_CLAIM_OPTION = "//a[normalize-space()='Submit Claim']";
    String MY_CLAIMS_OPTION = "//a[normalize-space()='My Claims']";
    String ASSIGN_CLAIM_OPTION = "//a[normalize-space()='Assign Claim']";
    String EMPLOYEE_CLAIMS_OPTION = "//a[normalize-space()='Employee Claims']";

    String EVENT_DROPDOWN =
            "//label[normalize-space()='Event']/following::div[contains(@class,'oxd-select-text')][1]";

    String CURRENCY_DROPDOWN =
            "//label[normalize-space()='Currency']/following::div[contains(@class,'oxd-select-text')][1]";

    String REMARKS_TEXTAREA =
            "//label[normalize-space()='Remarks']/following::textarea[1]";

    String CREATE_BUTTON = "//button[normalize-space()='Create']";
    String SEARCH_BUTTON = "//button[normalize-space()='Search']";

    String REQUIRED_ERROR =
            "//span[contains(@class,'oxd-input-field-error-message') and normalize-space()='Required']";

    String CLAIM_TABLE_OR_NO_RECORD =
            "//div[contains(@class,'oxd-table')] | //span[normalize-space()='No Records Found']";

    String SUBMIT_CLAIM_PAGE =
            "//h6[contains(normalize-space(),'Submit Claim')] | //label[normalize-space()='Event']";

    String ASSIGN_CLAIM_PAGE =
            "//h6[contains(normalize-space(),'Assign Claim')] | //input[@placeholder='Type for hints...']";

    String LISTBOX = "//div[@role='listbox']";

    String LISTBOX_OPTION_CONTAINS =
            "//div[@role='listbox']//span[contains(normalize-space(),'%s')]";
}