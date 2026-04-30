package com.skillio.stepdefinitions;

import org.testng.Assert;

import com.skillio.pages.RecruitmentPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecruitmentSteps {

    // ───────────────── PAGE OBJECT ─────────────────

    private RecruitmentPage rec = new RecruitmentPage();

    // =========================================================
    // NAVIGATION
    // =========================================================

    @When("user navigates to Recruitment module")
    public void userNavigatesToRecruitmentModule() {
        rec.navigateToRecruitment();
    }

    // =========================================================
    // VACANCY CREATION
    // =========================================================

    @When("user clicks on {string} button in Vacancies section")
    public void userClicksOnButtonInVacanciesSection(String button) {
        rec.clickAddVacancy();
    }

    @When("user enters vacancy name {string}")
    public void userEntersVacancyName(String vacancyName) {
        rec.enterVacancyName(vacancyName);
    }

    @When("user selects job title {string}")
    public void userSelectsJobTitle(String jobTitle) {
        rec.selectJobTitle(jobTitle);
    }

    @When("user enters number of positions {string}")
    public void userEntersNumberOfPositions(String positions) {
        rec.enterPositionCount(positions);
    }

    @When("user leaves job title blank")
    public void userLeavesJobTitleBlank() {
        // Intentionally left blank
    }

    // DUPLICATE FIXED
    @When("user clicks Save Vacancy button")
    public void userClicksSaveVacancyButton() {
        rec.clickSave();
    }

    @When("user opens vacancy {string}")
    public void userOpensVacancy(String vacancyName) {
        rec.openVacancy(vacancyName);
    }

    // =========================================================
    // CANDIDATE FLOW
    // =========================================================

    @When("user clicks {string} in candidates section")
    public void userClicksInCandidatesSection(String button) {
        rec.clickAddCandidate();
    }

    @When("user enters candidate first name {string} and last name {string}")
    public void userEntersCandidateFirstNameAndLastName(String firstName, String lastName) {
        rec.enterCandidateName(firstName, lastName);
    }

    @When("user enters candidate email {string}")
    public void userEntersCandidateEmail(String email) {
        rec.enterCandidateEmail(email);
    }

    @When("user selects vacancy {string} in candidate search form")
    public void userSelectsVacancyInCandidateSearchForm(String vacancyName) {
        rec.selectVacancyInSearch(vacancyName);
    }

    // DUPLICATE FIXED
    @When("user clicks Search button in Recruitment")
    public void userClicksSearchButtonInRecruitment() {
        rec.clickSearch();
    }

    // =========================================================
    // SEARCH / EDIT
    // =========================================================

    @When("user searches for vacancy {string} in vacancies list")
    public void userSearchesForVacancyInVacanciesList(String vacancyName) {
        rec.searchVacancy(vacancyName);
    }

    @When("user clicks Edit on vacancy {string}")
    public void userClicksEditOnVacancy(String vacancyName) {
        rec.clickEditVacancy(vacancyName);
    }

    @When("user updates number of positions to {string}")
    public void userUpdatesNumberOfPositions(String positions) {
        rec.updateNumberOfPositions(positions);
    }

    // =========================================================
    // CANDIDATE ACTIONS
    // =========================================================

    @When("user searches for candidate {string} by vacancy {string}")
    public void userSearchesForCandidateByVacancy(String candidate, String vacancy) {
        rec.searchCandidateByVacancy(candidate, vacancy);
    }

    @When("user opens candidate profile for {string}")
    public void userOpensCandidateProfileFor(String candidateName) {
        rec.openCandidateProfile(candidateName);
    }

    @When("user clicks {string} action button")
    public void userClicksActionButton(String action) {
        rec.clickCandidateAction(action);
    }

    @When("user enters note {string}")
    public void userEntersNote(String note) {
        rec.enterActionNote(note);
    }

    @When("user confirms the action")
    public void userConfirmsTheAction() {
        rec.clickConfirmAction();
    }

    // =========================================================
    // ASSERTIONS
    // =========================================================

    @Then("vacancy {string} should appear in the vacancies list")
    public void vacancyShouldAppearInTheVacanciesList(String vacancyName) {

        Assert.assertTrue(
                rec.isVacancyInList(vacancyName),
                "Vacancy not found: " + vacancyName);
    }

    @Then("field validation error {string} should appear under job title field")
    public void fieldValidationErrorShouldAppearUnderJobTitleField(String expectedError) {

        Assert.assertEquals(
                rec.getJobTitleError(),
                expectedError,
                "Job title validation mismatch");
    }

    @Then("candidate {string} should be added under {string} vacancy")
    public void candidateShouldBeAddedUnderVacancy(String candidateName, String vacancyName) {

        Assert.assertTrue(
                rec.isCandidateInList(candidateName),
                "Candidate not found: " + candidateName);
    }

    @Then("field validation error {string} should appear")
    public void fieldValidationErrorShouldAppear(String expectedError) {

        Assert.assertTrue(
                rec.isValidationErrorDisplayed(expectedError),
                "Validation error not displayed: " + expectedError);
    }

    @Then("candidates list for {string} should be displayed")
    public void candidatesListForVacancyShouldBeDisplayed(String vacancyName) {

        Assert.assertTrue(
                rec.isCandidateTableVisible(),
                "Candidate list not visible for vacancy: " + vacancyName);
    }

    @Then("vacancy {string} should show {string} positions")
    public void vacancyShouldShowPositions(String vacancyName, String positions) {

        Assert.assertTrue(
                rec.isVacancyPositionUpdated(vacancyName, positions),
                "Vacancy positions not updated correctly");
    }

    @Then("field validation error {string} should appear under first name")
    public void fieldValidationErrorShouldAppearUnderFirstName(String expectedError) {

        Assert.assertEquals(
                rec.getFirstNameError(),
                expectedError,
                "First name validation mismatch");
    }

    @Then("candidate status should change to {string}")
    public void candidateStatusShouldChangeTo(String expectedStatus) {

        Assert.assertEquals(
                rec.getCandidateStatusText(),
                expectedStatus,
                "Candidate status mismatch");
    }
}