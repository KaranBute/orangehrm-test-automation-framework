package com.skillio.stepdefinitions;

import com.skillio.pages.RecruitmentPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RecruitmentSteps {

    private RecruitmentPage rec;

    private RecruitmentPage getRec() {
        if (rec == null) {
            rec = new RecruitmentPage();
        }
        return rec;
    }

    // =========================
    // NAVIGATION
    // =========================

    @When("user navigates to Recruitment module")
    public void userNavigatesToRecruitmentModule() {
        getRec().navigateToRecruitment();
    }

    // =========================
    // VACANCY
    // =========================

    @When("user clicks Add Vacancy button in Recruitment")
    public void userClicksAddVacancyButton() {
        getRec().clickAddVacancy();
    }

    @When("user enters vacancy name {string} in Recruitment")
    public void userEntersVacancyName(String name) {
        getRec().enterVacancyName(name);
    }

    @When("user leaves vacancy name blank in Recruitment")
    public void userLeavesVacancyNameBlank() {
        getRec().clearVacancyName();
    }

    @When("user selects job title for vacancy {string} in Recruitment")
    public void userSelectsJobTitleForVacancy(String jobTitle) {
        getRec().selectJobTitle(jobTitle);
    }

    @When("user clicks Save Vacancy button in Recruitment")
    public void userClicksSaveVacancyButton() {
        getRec().clickSaveVacancy();
    }

    // =========================
    // CANDIDATE
    // =========================

    @When("user clicks Candidates tab in Recruitment")
    public void userClicksCandidatesTab() {
        getRec().clickCandidatesTab();
    }

    @When("user clicks Add Candidate button in Recruitment")
    public void userClicksAddCandidateButton() {
        getRec().clickAddCandidate();
    }

    @When("user enters candidate first name {string} and last name {string} in Recruitment")
    public void userEntersCandidateFirstAndLastName(String first, String last) {
        getRec().enterCandidateName(first, last);
    }

    @When("user enters candidate email {string} in Recruitment")
    public void userEntersCandidateEmail(String email) {
        getRec().enterCandidateEmail(email);
    }

    @When("user clicks Save Candidate button in Recruitment")
    public void userClicksSaveCandidateButton() {
        getRec().clickSaveCandidate();
    }

    @When("user clicks Search button in Recruitment module")
    public void userClicksSearchCandidatesButton() {
        getRec().clickSearch();
    }

    @When("user enters candidate keyword {string} in Recruitment")
    public void userEntersCandidateKeyword(String keyword) {
        getRec().enterCandidateKeyword(keyword);
    }

    @When("user selects vacancy {string} in candidate search form in Recruitment")
    public void userSelectsVacancyInCandidateSearchForm(String vacancy) {
        getRec().selectVacancy(vacancy);
    }

    // =========================
    // ASSERTIONS
    // =========================

    @Then("vacancy save success toast should be displayed in Recruitment")
    public void vacancySaveSuccessToastShouldBeDisplayed() {
        Assert.assertTrue(getRec().isSuccessToastVisible());
    }

    @Then("vacancy required field error should be displayed in Recruitment")
    public void vacancyRequiredFieldErrorShouldBeDisplayed() {
        Assert.assertTrue(getRec().isRequiredErrorVisible());
    }

    @Then("candidate save success toast should be displayed in Recruitment")
    public void candidateSaveSuccessToastShouldBeDisplayed() {
        Assert.assertTrue(getRec().isSuccessToastVisible());
    }

    @Then("candidate email format error should be displayed in Recruitment")
    public void candidateEmailFormatErrorShouldBeDisplayed() {
        Assert.assertTrue(getRec().isEmailFormatErrorVisible());
    }

    @Then("candidates search results should be displayed in Recruitment")
    public void candidatesSearchResultsShouldBeDisplayed() {
        Assert.assertTrue(getRec().isCandidatesListDisplayed());
    }

    @Then("Add Candidate page should be displayed in Recruitment")
    public void addCandidatePageShouldBeDisplayed() {
        Assert.assertTrue(getRec().isAddCandidatePageDisplayed());
    }

    @Then("candidates list or no records message should be displayed in Recruitment")
    public void candidatesListOrNoRecordsMessageShouldBeDisplayed() {
        Assert.assertTrue(getRec().isCandidateTableOrNoRecordsDisplayed());
    }

    @Then("candidates list for {string} should be displayed in Recruitment")
    public void candidatesListForShouldBeDisplayed(String value) {
        Assert.assertTrue(getRec().isCandidateTableOrNoRecordsDisplayed());
    }
    
    @When("user clicks Candidates tab")
    public void userClicksCandidatesTabOld() {
        getRec().clickCandidatesTab();
    }

    @When("user enters candidate keyword {string}")
    public void userEntersCandidateKeywordOld(String keyword) {
        getRec().enterCandidateKeyword(keyword);
    }

    @When("user clicks Search button in Recruitment")
    public void userClicksSearchButtonInRecruitmentOld() {
        getRec().clickSearch();
    }

    @Then("candidates list or no records message should be displayed")
    public void candidatesListOrNoRecordsOld() {
        Assert.assertTrue(getRec().isCandidateTableOrNoRecordsDisplayed());
    }

    @Then("candidates list for {string} should be displayed")
    public void candidatesListForOld(String value) {
        Assert.assertTrue(getRec().isCandidateTableOrNoRecordsDisplayed());
    }

    @When("user clicks on {string} button in Vacancies section")
    public void userClicksOnButtonInVacanciesSectionOld(String button) {
        getRec().clickAddVacancy();
    }

    @When("user enters vacancy name {string}")
    public void userEntersVacancyNameOld(String name) {
        getRec().enterVacancyName(name);
    }

    @When("user clicks Save Vacancy button")
    public void userClicksSaveVacancyButtonOld() {
        getRec().clickSaveVacancy();
    }

    @Then("field validation error {string} should appear under job title field")
    public void fieldValidationErrorUnderJobTitleOld(String error) {
        Assert.assertTrue(getRec().isRequiredErrorVisible());
    }
    
    @When("user clicks Add Candidate button")
    public void clickAddCandidate() {
        getRec().clickAddCandidate();
    }

    @When("user enters candidate first name {string} and last name {string}")
    public void enterCandidateName(String first, String last) {
        getRec().enterCandidateName(first, last);
    }

    @When("user enters candidate email {string}")
    public void enterCandidateEmail(String email) {
        getRec().enterCandidateEmail(email);
    }

    @When("user clicks Save Candidate button")
    public void saveCandidate() {
        getRec().clickSaveCandidate();
    }

    @Then("candidate save success toast should be displayed")
    public void verifyCandidateToast() {
        Assert.assertTrue(getRec().isSuccessToastDisplayed());
    }
    
    @When("user clicks Add Vacancy button")
    public void clickAddVacancy() {
        getRec().clickAddVacancy();
    }

    @When("user selects job title for vacancy {string}")
    public void selectJobTitle(String title) {
        getRec().selectJobTitle(title);
    }

    @Then("vacancy save success toast should be displayed")
    public void vacancyToast() {
        Assert.assertTrue(getRec().isSuccessToastDisplayed());
    }
}