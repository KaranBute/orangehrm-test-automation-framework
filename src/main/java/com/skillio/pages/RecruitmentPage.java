package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.skillio.base.Keyword;
import com.skillio.locators.RecruitmentLocator;
import com.skillio.utils.WaitFor;

/**
 * RecruitmentPage — fully implemented.
 * FIXES: enterCandidateName, selectJobTitle, enterPositionCount were empty stubs.
 * All stubs are now implemented with proper locators and waits.
 */
public class RecruitmentPage {

    public RecruitmentPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitmentMenu;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successToast;

    // ── Navigation ────────────────────────────────────────────────────────────
    public void navigateToRecruitment() {
        WaitFor.elementToBeClickable(recruitmentMenu);
        recruitmentMenu.click();
        WaitFor.elementToBeVisible(By.xpath("//h5[normalize-space()='Vacancies']"));
    }

    // ── Vacancy form ──────────────────────────────────────────────────────────
    public void clickAddVacancy() {
        WaitFor.elementToBeClickable(addBtn);
        addBtn.click();
    }

    public void enterVacancyName(String name) {
        By field = By.xpath(RecruitmentLocator.VACANCY_NAME_INPUT);
        WaitFor.elementToBeVisible(field);
        WebElement el = Keyword.getDriver().findElement(field);
        el.clear();
        el.sendKeys(name);
    }

    /**
     * FIX: was empty stub. Selects job title from the custom Vue dropdown.
     */
    public void selectJobTitle(String title) {
        By dropdown = By.xpath(RecruitmentLocator.JOB_TITLE_DROPDOWN);
        WaitFor.elementToBeClickable(dropdown);
        Keyword.getDriver().findElement(dropdown).click();
        By option = By.xpath(String.format(RecruitmentLocator.LISTBOX_OPTION, title));
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    /**
     * FIX: was empty stub. Enters number of positions.
     */
    public void enterPositionCount(String count) {
        By field = By.xpath(RecruitmentLocator.POSITIONS_INPUT);
        WaitFor.elementToBeVisible(field);
        WebElement el = Keyword.getDriver().findElement(field);
        el.clear();
        el.sendKeys(count);
    }

    /**
     * FIX: was empty stub. Clicks the vacancy row in the list to open it.
     */
    public void openVacancy(String name) {
        By row = By.xpath(
            "//div[contains(@class,'oxd-table-body')]//div[normalize-space()='" + name + "']");
        WaitFor.elementToBeClickable(row);
        Keyword.getDriver().findElement(row).click();
    }

    // ── Candidate form ────────────────────────────────────────────────────────
    public void clickAddCandidate() {
        WaitFor.elementToBeClickable(addBtn);
        addBtn.click();
    }

    /**
     * FIX: was empty stub. Fills first and last name fields.
     */
    public void enterCandidateName(String first, String last) {
        By firstNameBy = By.xpath(RecruitmentLocator.FIRST_NAME_INPUT);
        By lastNameBy  = By.xpath(RecruitmentLocator.LAST_NAME_INPUT);
        WaitFor.elementToBeVisible(firstNameBy);
        WebElement fn = Keyword.getDriver().findElement(firstNameBy);
        fn.clear(); fn.sendKeys(first);
        WebElement ln = Keyword.getDriver().findElement(lastNameBy);
        ln.clear(); ln.sendKeys(last);
    }

    public void enterCandidateEmail(String email) {
        By emailBy = By.xpath(RecruitmentLocator.EMAIL_INPUT);
        WaitFor.elementToBeVisible(emailBy);
        WebElement el = Keyword.getDriver().findElement(emailBy);
        el.clear();
        el.sendKeys(email);
    }

    public void selectVacancyInSearch(String name) {
        By dropdown = By.xpath(RecruitmentLocator.VACANCY_DROPDOWN);
        WaitFor.elementToBeClickable(dropdown);
        Keyword.getDriver().findElement(dropdown).click();
        By option = By.xpath(String.format(RecruitmentLocator.LISTBOX_OPTION, name));
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void clickSave() {
        WaitFor.loaderToBeInvisible();
        WaitFor.elementToBeClickable(saveBtn);
        saveBtn.click();
    }

    // ── Validations ───────────────────────────────────────────────────────────
    public boolean isSuccessToastDisplayed() {
        WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.SUCCESS_TOAST));
        return Keyword.getDriver().findElement(
            By.xpath(RecruitmentLocator.SUCCESS_TOAST)).isDisplayed();
    }

    public boolean isRequiredErrorDisplayed() {
        WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.REQUIRED_ERROR));
        return Keyword.getDriver().findElement(
            By.xpath(RecruitmentLocator.REQUIRED_ERROR)).isDisplayed();
    }

    public boolean isEmailErrorDisplayed() {
        WaitFor.elementToBeVisible(By.xpath(RecruitmentLocator.EMAIL_FORMAT_ERROR));
        return Keyword.getDriver().findElement(
            By.xpath(RecruitmentLocator.EMAIL_FORMAT_ERROR)).isDisplayed();
    }
}