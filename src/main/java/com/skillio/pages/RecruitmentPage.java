package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.RecruitmentLocator;
import com.skillio.utils.WaitFor;

public class RecruitmentPage {

    public RecruitmentPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = RecruitmentLocator.RECRUITMENT_MENU)
    private WebElement recruitmentMenu;

    @FindBy(xpath = RecruitmentLocator.ADD_BUTTON)
    private WebElement addButton;

    @FindBy(xpath = RecruitmentLocator.SAVE_BUTTON)
    private WebElement saveButton;

    private final By candidatesTab = By.xpath("//a[normalize-space()='Candidates']");
    private final By vacanciesTab = By.xpath("//a[normalize-space()='Vacancies']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");

    public void navigateToRecruitment() {
        WaitFor.click(recruitmentMenu);
        WaitFor.elementToBeVisible(By.xpath("//a[normalize-space()='Candidates'] | //h6[contains(normalize-space(),'Recruitment')]") );
    }

    public void clickAddVacancy() {
        try { WaitFor.click(vacanciesTab); } catch (Exception ignored) {}
        WaitFor.click(By.xpath(RecruitmentLocator.ADD_BUTTON));
        WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.VACANCY_NAME_INPUT));
    }

    public void enterVacancyName(String name) {
        WaitFor.type(By.xpath(RecruitmentLocator.VACANCY_NAME_INPUT), name);
    }

    public void clearVacancyName() {
        WaitFor.type(By.xpath(RecruitmentLocator.VACANCY_NAME_INPUT), "");
    }

    public void selectJobTitle(String jobTitle) {
        WaitFor.click(By.xpath(RecruitmentLocator.JOB_TITLE_DROPDOWN));
        WaitFor.click(By.xpath(String.format(RecruitmentLocator.LISTBOX_OPTION, jobTitle)));
    }

    public void enterPositionCount(String count) {
        WaitFor.type(By.xpath(RecruitmentLocator.POSITIONS_INPUT), count);
    }

    public void clickSaveVacancy() {
        WaitFor.click(saveButton);
    }

    public void clickCandidatesTab() {
        WaitFor.click(candidatesTab);
        WaitFor.elementToBeVisible(By.xpath("//h6[contains(normalize-space(),'Candidates')] | //button[normalize-space()='Add']"));
    }

    public void clickAddCandidate() {
        WaitFor.click(By.xpath(RecruitmentLocator.ADD_BUTTON));
        WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.FIRST_NAME_INPUT));
    }

    public void enterCandidateName(String firstName, String lastName) {
        WaitFor.type(By.xpath(RecruitmentLocator.FIRST_NAME_INPUT), firstName);
        WaitFor.type(By.xpath(RecruitmentLocator.LAST_NAME_INPUT), lastName);
    }

    public void enterCandidateEmail(String email) {
        WaitFor.type(By.xpath(RecruitmentLocator.EMAIL_INPUT), email);
    }

    public void selectVacancy(String vacancy) {
        WaitFor.click(By.xpath(RecruitmentLocator.VACANCY_DROPDOWN));
        WaitFor.click(By.xpath(String.format(RecruitmentLocator.LISTBOX_OPTION, vacancy)));
    }

    public void clickSaveCandidate() {
        WaitFor.click(saveButton);
    }

    public void clickSearch() {
        WaitFor.click(searchButton);
    }

    public boolean isSuccessToastVisible() {
        try { WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.SUCCESS_TOAST)); return true; }
        catch (Exception e) { return false; }
    }

    public boolean isRequiredErrorVisible() {
        try { WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.REQUIRED_ERROR)); return true; }
        catch (Exception e) { return false; }
    }

    public boolean isEmailFormatErrorVisible() {
        try { WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.EMAIL_FORMAT_ERROR)); return true; }
        catch (Exception e) { return false; }
    }

    public boolean isCandidatesListDisplayed() {
        try {
            By tableOrNoRec = By.xpath("//div[contains(@class,'oxd-table')] | //span[normalize-space()='No Records Found']");
            WaitFor.elementToBeVisible(tableOrNoRec);
            return true;
        } catch (Exception e) { return false; }
    }
    
    public void enterCandidateKeyword(String keyword) {

        By keywordInput = By.xpath(
            "//label[normalize-space()='Keywords']/following::input[1]"
        );

        WaitFor.elementToBeVisible(keywordInput);

        WebElement input = Keyword.getDriver().findElement(keywordInput);
        input.clear();
        input.sendKeys(keyword);
    }
    
    public boolean isAddCandidatePageDisplayed() {

        try {

            By heading = By.xpath(
                "//h6[normalize-space()='Add Candidate']"
            );

            WaitFor.elementToBeVisible(heading);

            return Keyword.getDriver()
                    .findElement(heading)
                    .isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isCandidateTableOrNoRecordsDisplayed() {

        try {
            By table = By.xpath("//div[contains(@class,'oxd-table-body')]");

            WaitFor.elementToBeVisible(table);

            return Keyword.getDriver()
                    .findElement(table)
                    .isDisplayed();

        } catch (Exception e) {

            try {
                By noRecords = By.xpath("//span[normalize-space()='No Records Found']");

                WaitFor.elementToBeVisible(noRecords);

                return Keyword.getDriver()
                        .findElement(noRecords)
                        .isDisplayed();

            } catch (Exception ex) {
                return false;
            }
        }
        }
        
        public boolean isSuccessToastDisplayed() {

            try {

                By toast = By.xpath("//div[contains(@class,'oxd-toast-content')]");

                WaitFor.elementToBeVisible(toast);

                return Keyword.getDriver().findElement(toast).isDisplayed();

            } catch (Exception e) {
                return false;
            }
        
    }
    
        
        
}
