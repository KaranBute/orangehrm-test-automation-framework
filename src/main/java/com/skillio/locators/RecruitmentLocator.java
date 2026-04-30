package com.skillio.locators;

/** RecruitmentLocator — Recruitment module locators. Moved from utils/ to locators/. */
public class RecruitmentLocator {
    private RecruitmentLocator() {}

    public static final String RECRUITMENT_MENU   = "//span[normalize-space()='Recruitment']";
    public static final String ADD_BUTTON         = "//button[normalize-space()='Add']";
    public static final String VACANCY_NAME_INPUT =
        "//label[normalize-space()='Vacancy Name']/following::input[1]";
    public static final String JOB_TITLE_DROPDOWN =
        "//label[normalize-space()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String POSITIONS_INPUT    =
        "//label[normalize-space()='Number of Positions']/following::input[1]";
    public static final String FIRST_NAME_INPUT   = "//input[@name='firstName']";
    public static final String LAST_NAME_INPUT    = "//input[@name='lastName']";
    public static final String EMAIL_INPUT        =
        "//label[normalize-space()='Email']/following::input[1]";
    public static final String VACANCY_DROPDOWN   =
        "//label[normalize-space()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]";
    public static final String SAVE_BUTTON        = "//button[normalize-space()='Save']";
    public static final String SUCCESS_TOAST      =
        "//div[contains(@class,'oxd-toast') and contains(@class,'success')]";
    public static final String REQUIRED_ERROR     = "//span[normalize-space()='Required']";
    public static final String EMAIL_FORMAT_ERROR =
        "//span[contains(text(),'Expected format')]";
    /** Usage: String.format(RecruitmentLocator.LISTBOX_OPTION, "Software Engineer") */
    public static final String LISTBOX_OPTION     =
        "//div[@role='listbox']//span[normalize-space()='%s']";
    /** Usage: String.format(RecruitmentLocator.CANDIDATE_ROW_BY_NAME, "Alice Walker") */
    public static final String CANDIDATE_ROW_BY_NAME =
        "//div[contains(@class,'oxd-table-body')]//div[normalize-space()='%s']";
}