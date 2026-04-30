package com.skillio.stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.skillio.base.Keyword;
import com.skillio.pages.*;
import com.skillio.utils.WaitFor;
import io.cucumber.java.en.*;

public class OrangeHRMSteps {

    // ── Page Objects ─────────────────────────────────────────────────────────
    private LoginPage               loginPage        = new LoginPage();
    private AdminPageExtended       adminPage        = new AdminPageExtended();
    private PimPageExtended         pimPage          = new PimPageExtended();
    private LeavePageExtended       leavePage        = new LeavePageExtended();
    private RecruitmentPageExtended recruitmentPage  = new RecruitmentPageExtended();
    private MyInfoPageExtended      myInfoPage       = new MyInfoPageExtended();
    private DashboardPageExtended   dashboardPage    = new DashboardPageExtended();

    // =========================================================================
    //  SHARED
    // =========================================================================

    @Given("user is on the OrangeHRM login page")
    public void userIsOnLoginPage() {
        WaitFor.elementToBeVisible(By.name("username"));
    }

    @And("user navigates to Admin module")
    public void userNavigatesToAdminModule() {
        Keyword.clickOn("xpath", "//span[normalize-space()='Admin']");
        WaitFor.urlToContain("viewSystemUsers");
    }

    // =========================================================================
    //  MODULE 1 – LOGIN
    // =========================================================================

    // TC_LOGIN_05
    @Then("the password field type should be {string}")
    public void thePasswordFieldTypeShouldBe(String expectedType) {
        String actualType = Keyword.getDriver()
            .findElement(By.name("password"))
            .getAttribute("type");
        Assert.assertEquals(actualType, expectedType,
            "[TC_LOGIN_05] Password field type mismatch.");
    }

    // =========================================================================
    //  MODULE 2 – ADMIN
    // =========================================================================

    // TC_ADMIN_01, 02, 03
    @When("user clicks {string} button on User Management page")
    public void userClicksAddButtonOnUserManagementPage(String btnLabel) {
        adminPage.clickAddUser();
    }

    @And("user selects user role {string}")
    public void userSelectsUserRole(String role) {
        adminPage.selectUserRole(role);
    }

    @And("user types employee name {string} in employee name field")
    public void userTypesEmployeeName(String hint) {
        adminPage.typeAndSelectEmployee(hint);
    }

    @And("user selects status {string}")
    public void userSelectsStatus(String status) {
        adminPage.selectStatus(status);
    }

    @And("user enters new system username {string}")
    public void userEntersNewSystemUsername(String username) {
        adminPage.enterUsername(username);
    }

    @And("user enters password {string} and confirm password {string}")
    public void userEntersPasswordAndConfirmPassword(String pwd, String confirmPwd) {
        adminPage.enterPasswordAndConfirm(pwd, confirmPwd);
    }

    @And("user clicks Save on Add User form")
    public void userClicksSaveOnAddUserForm() {
        adminPage.clickSave();
    }

    @Then("success toast message should be displayed")
    public void successToastMessageShouldBeDisplayed() {
        adminPage.assertSuccessToastDisplayed();
    }

    @And("user {string} should appear in the users list")
    public void userShouldAppearInUsersList(String username) {
        adminPage.assertUserVisibleInList(username);
    }

    @Then("password mismatch error {string} should be displayed")
    public void passwordMismatchErrorShouldBeDisplayed(String expectedMsg) {
        adminPage.assertPasswordMismatchError(expectedMsg);
    }

    @Then("username error {string} should be displayed")
    public void usernameErrorShouldBeDisplayed(String expectedMsg) {
        adminPage.assertAlreadyExistsError(expectedMsg);
    }

    // TC_ADMIN_04
    @When("user enters search username {string} in user search form")
    public void userEntersSearchUsername(String username) {
        adminPage.enterSearchUsername(username);
    }

    @And("user clicks Search button on user management page")
    public void userClicksSearchOnUserManagementPage() {
        adminPage.clickSearch();
    }

    @Then("user record with username {string} should be visible in results")
    public void userRecordWithUsernameShouldBeVisibleInResults(String username) {
        adminPage.assertSearchResultVisible(username);
    }

    // TC_ADMIN_05
    @When("user navigates to {string} section under Admin")
    public void userNavigatesToSectionUnderAdmin(String section) {
        adminPage.navigateToJobSection(section);
    }

    @And("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String item) {
        adminPage.clickJobTitles();
    }

    @Then("the Job Titles page heading should be displayed")
    public void theJobTitlesPageHeadingShouldBeDisplayed() {
        adminPage.assertJobTitlesHeadingDisplayed();
    }

    // =========================================================================
    //  MODULE 3 – PIM
    // =========================================================================

    @When("user navigates to PIM module")
    public void userNavigatesToPimModule() {
        pimPage.navigateToPim();
    }

    @And("user clicks Add Employee button")
    public void userClicksAddEmployeeButton() {
        pimPage.clickAddEmployee();
    }

    @And("user enters first name {string}, last name {string} and employee id {string}")
    public void userEntersEmployeeDetails(String firstName, String lastName, String empId) {
        pimPage.enterEmployeeDetails(firstName, lastName, empId);
    }

    @And("user clicks Save on Add Employee form")
    public void userClicksSaveOnAddEmployeeForm() {
        pimPage.clickSave();
    }

    @Then("employee save success toast should be displayed")
    public void employeeSaveSuccessToastShouldBeDisplayed() {
        pimPage.assertSuccessToastDisplayed();
    }

    @Then("required field validation error should be shown on employee form")
    public void requiredFieldValidationErrorOnEmployeeForm() {
        pimPage.assertRequiredErrorDisplayed();
    }

    @Then("duplicate employee ID error should be shown")
    public void duplicateEmployeeIdErrorShouldBeShown() {
        pimPage.assertDuplicateIdErrorDisplayed();
    }

    @And("user searches for employee with name {string}")
    public void userSearchesForEmployeeWithName(String name) {
        pimPage.searchByName(name);
    }

    @And("user clicks Search on the employee list")
    public void userClicksSearchOnEmployeeList() {
        pimPage.clickSearch();
    }

    @Then("at least one employee result should be visible in the list")
    public void atLeastOneEmployeeResultShouldBeVisible() {
        pimPage.assertSearchResultsVisible();
    }

    @Then("the Employee List page heading should be visible")
    public void theEmployeeListPageHeadingShouldBeVisible() {
        pimPage.assertEmployeeListHeadingVisible();
    }

    // =========================================================================
    //  MODULE 4 – LEAVE
    // =========================================================================

    @When("user navigates to Leave module")
    public void userNavigatesToLeaveModule() {
        leavePage.navigateToLeave();
    }

    @And("user clicks on Apply leave link")
    public void userClicksOnApplyLeaveLink() {
        leavePage.clickApplyLeave();
    }

    @And("user clicks on Leave List link")
    public void userClicksOnLeaveListLink() {
        leavePage.clickLeaveList();
    }

    @And("user selects leave type {string}")
    public void userSelectsLeaveType(String leaveType) {
        leavePage.selectLeaveType(leaveType);
    }

    @And("user enters from date {string} and to date {string}")
    public void userEntersFromAndToDates(String fromDate, String toDate) {
        leavePage.enterDates(fromDate, toDate);
    }

    @And("user enters leave comment {string}")
    public void userEntersLeaveComment(String comment) {
        leavePage.enterComment(comment);
    }

    @And("user enters leave comment with 251 characters")
    public void userEntersLeaveCommentWith251Characters() {
        leavePage.enterOverlongComment();
    }

    @And("user clicks Apply button")
    public void userClicksApplyButton() {
        leavePage.clickApply();
    }

    @And("user clicks Search on the leave list form")
    public void userClicksSearchOnLeaveListForm() {
        leavePage.clickSearch();
    }

    @Then("leave apply success toast should be displayed")
    public void leaveApplySuccessToastShouldBeDisplayed() {
        leavePage.assertSuccessToastDisplayed();
    }

    @Then("date validation error should be displayed on leave form")
    public void dateValidationErrorShouldBeDisplayedOnLeaveForm() {
        leavePage.assertDateValidationErrorDisplayed();
    }

    @Then("leave type required validation error should be displayed")
    public void leaveTypeRequiredValidationErrorShouldBeDisplayed() {
        leavePage.assertLeaveTypeRequiredErrorDisplayed();
    }

    @Then("leave list results should be displayed")
    public void leaveListResultsShouldBeDisplayed() {
        leavePage.assertLeaveListResultsDisplayed();
    }

    @Then("comment length should not exceed 250 characters in the field")
    public void commentLengthShouldNotExceed250() {
        leavePage.assertCommentNotExceedsLength(250);
    }

    // =========================================================================
    //  MODULE 5 – RECRUITMENT
    // =========================================================================

    @When("user navigates to Recruitment module")
    public void userNavigatesToRecruitmentModule() {
        recruitmentPage.navigateToRecruitment();
    }

    @And("user clicks Add Vacancy button")
    public void userClicksAddVacancyButton() {
        recruitmentPage.clickAdd();
    }

    @And("user enters vacancy name {string}")
    public void userEntersVacancyName(String vacancyName) {
        recruitmentPage.enterVacancyName(vacancyName);
    }

    @And("user leaves vacancy name blank")
    public void userLeavesVacancyNameBlank() {
        recruitmentPage.leaveVacancyNameBlank();
    }

    @And("user selects job title {string}")
    public void userSelectsJobTitle(String jobTitle) {
        recruitmentPage.selectJobTitle(jobTitle);
    }

    @And("user clicks Save Vacancy button")
    public void userClicksSaveVacancyButton() {
        recruitmentPage.clickSaveVacancy();
    }

    @Then("vacancy save success toast should be displayed")
    public void vacancySaveSuccessToastShouldBeDisplayed() {
        recruitmentPage.assertSuccessToastDisplayed();
    }

    @Then("vacancy required field error should be displayed")
    public void vacancyRequiredFieldErrorShouldBeDisplayed() {
        recruitmentPage.assertRequiredErrorDisplayed();
    }

    @And("user clicks Candidates tab")
    public void userClicksCandidatesTab() {
        recruitmentPage.clickCandidatesTab();
    }

    @And("user clicks Add Candidate button")
    public void userClicksAddCandidateButton() {
        recruitmentPage.clickAdd();
    }

    @And("user enters candidate first name {string} and last name {string}")
    public void userEntersCandidateName(String firstName, String lastName) {
        recruitmentPage.enterCandidateName(firstName, lastName);
    }

    @And("user selects candidate vacancy {string}")
    public void userSelectsCandidateVacancy(String vacancyName) {
        recruitmentPage.selectCandidateVacancy(vacancyName);
    }

    @And("user enters candidate email {string}")
    public void userEntersCandidateEmail(String email) {
        recruitmentPage.enterCandidateEmail(email);
    }

    @And("user clicks Save Candidate button")
    public void userClicksSaveCandidateButton() {
        recruitmentPage.clickSaveCandidate();
    }

    @Then("candidate save success toast should be displayed")
    public void candidateSaveSuccessToastShouldBeDisplayed() {
        recruitmentPage.assertSuccessToastDisplayed();
    }

    // =========================================================================
    //  MODULE 6 – MY INFO
    // =========================================================================

    @When("user navigates to My Info module")
    public void userNavigatesToMyInfoModule() {
        myInfoPage.navigateToMyInfo();
    }

    @And("user clicks on Personal Details tab")
    public void userClicksOnPersonalDetailsTab() {
        myInfoPage.clickPersonalDetailsTab();
    }

    @And("user selects nationality {string}")
    public void userSelectsNationality(String nationality) {
        myInfoPage.selectNationality(nationality);
    }

    @And("user enters date of birth {string}")
    public void userEntersDateOfBirth(String dob) {
        myInfoPage.enterDateOfBirth(dob);
    }

    @And("user clicks Save on Personal Details form")
    public void userClicksSaveOnPersonalDetailsForm() {
        myInfoPage.clickSave();
    }

    @Then("personal details success toast should be displayed")
    public void personalDetailsSuccessToastShouldBeDisplayed() {
        myInfoPage.assertSuccessToastDisplayed();
    }

    @Then("date of birth validation error should be displayed")
    public void dateOfBirthValidationErrorShouldBeDisplayed() {
        myInfoPage.assertDobValidationErrorDisplayed();
    }

    // =========================================================================
    //  MODULE 7 – DASHBOARD
    // =========================================================================

    @Then("the Dashboard header {string} should be visible")
    public void theDashboardHeaderShouldBeVisible(String headerText) {
        dashboardPage.assertDashboardHeaderVisible(headerText);
    }

    @And("the Time at Work widget should be displayed on Dashboard")
    public void theTimeAtWorkWidgetShouldBeDisplayed() {
        dashboardPage.assertTimeAtWorkWidgetDisplayed();
    }
}