package com.skillio.locators;

public interface RecruitmentLocator {

    public static final String RECRUITMENT_MENU = "//span[normalize-space()='Recruitment']";
    public static final String ADD_BUTTON = "//button[normalize-space()='Add']";
    public static final String VACANCY_NAME_INPUT = "//label[normalize-space()='Vacancy Name']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String JOB_TITLE_DROPDOWN = "//label[normalize-space()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]";
    public static final String POSITIONS_INPUT = "//label[normalize-space()='Number of Positions']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String FIRST_NAME_INPUT = "//input[@name='firstName']";
    public static final String LAST_NAME_INPUT = "//input[@name='lastName']";
    public static final String EMAIL_INPUT = "//label[normalize-space()='Email']/ancestor::div[contains(@class,'oxd-input-group')]//input";
    public static final String VACANCY_DROPDOWN = "//label[normalize-space()='Vacancy']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]";
    public static final String SAVE_BUTTON = "//button[normalize-space()='Save']";
    public static final String SUCCESS_TOAST = "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    public static final String REQUIRED_ERROR = "//span[normalize-space()='Required']";
    public static final String EMAIL_FORMAT_ERROR = "//span[contains(normalize-space(),'Expected format') or contains(normalize-space(),'email') or contains(normalize-space(),'Invalid')]";
    public static final String LISTBOX_OPTION = "//div[@role='listbox']//span[normalize-space()='%s']";
    public static final String CANDIDATE_ROW_BY_NAME = "//div[contains(@class,'oxd-table-body')]//div[normalize-space()='%s']";
}
