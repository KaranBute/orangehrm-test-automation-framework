package com.skillio.stepdefinitions;

import org.testng.Assert;

import com.skillio.pages.AdminPage_New;
import com.skillio.pages.LoginPage;
import com.skillio.base.Keyword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for Admin_New.feature (TC_ADMIN_01 to TC_ADMIN_05).
 * Delegates all UI interactions to AdminPage_New — no WebDriver code here.
 */
public class AdminSteps_New {

    private AdminPage_New adminPage = new AdminPage_New();
    private LoginPage loginPage     = new LoginPage();

    // ─── GIVEN ───────────────────────────────────────────────────────────────

    /**
     * Shared step already defined in DashboardSteps:
     *   @Given("user is logged into OrangeHRM as {string}")
     * This file adds the Admin navigation step used in the Background.
     */
    @Given("user navigates to Admin module")
    public void userNavigatesToAdminModule() {
        adminPage.clickAdminMenu();
    }

    // ─── WHEN ────────────────────────────────────────────────────────────────

    @When("user clicks {string} button on User Management page")
    public void userClicksButtonOnUserManagementPage(String buttonLabel) {
        adminPage.clickAddUser();
    }

    @When("user selects user role {string}")
    public void userSelectsUserRole(String role) {
        adminPage.selectUserRole(role);
    }

    @When("user types employee name {string} in employee name field")
    public void userTypesEmployeeNameInField(String employeeName) {
        adminPage.typeEmployeeName(employeeName);
    }

    @When("user selects status {string}")
    public void userSelectsStatus(String status) {
        adminPage.selectStatus(status);
    }

    @When("user enters new system username {string}")
    public void userEntersNewSystemUsername(String username) {
        adminPage.enterUsername(username);
    }

    @When("user enters password {string} and confirm password {string}")
    public void userEntersPasswordAndConfirmPassword(String password, String confirmPassword) {
        adminPage.enterPasswordAndConfirm(password, confirmPassword);
    }

    @When("user clicks Save on Add User form")
    public void userClicksSaveOnAddUserForm() {
        adminPage.clickSave();
    }

    @When("user enters search username {string} in user search form")
    public void userEntersSearchUsername(String username) {
        adminPage.enterSearchUsername(username);
    }

    @When("user clicks Search button on user management page")
    public void userClicksSearchButtonOnUserManagementPage() {
        adminPage.clickSearch();
    }

    @When("user navigates to {string} section under Admin")
    public void userNavigatesToSectionUnderAdmin(String section) {
        adminPage.clickAdminSubMenu(section);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        adminPage.clickAdminSubMenuItem(menuItem);
    }

    // ─── THEN ────────────────────────────────────────────────────────────────

    @Then("user {string} should appear in the users list")
    public void userShouldAppearInTheUsersList(String username) {
        Assert.assertTrue(adminPage.isUserInList(username),
            "User [" + username + "] was not found in the users list");
    }

    @Then("password mismatch error {string} should be displayed")
    public void passwordMismatchErrorShouldBeDisplayed(String expectedMessage) {
        Assert.assertEquals(adminPage.getPasswordMismatchError(), expectedMessage,
            "Password mismatch validation message mismatch");
    }

    @Then("username error {string} should be displayed")
    public void usernameErrorShouldBeDisplayed(String expectedError) {
        Assert.assertEquals(adminPage.getUsernameAlreadyExistsError(), expectedError,
            "Username already-exists error message mismatch");
    }

    @Then("user record with username {string} should be visible in results")
    public void userRecordWithUsernameShouldBeVisible(String username) {
        Assert.assertTrue(adminPage.isUserInList(username),
            "Search result does not contain user: " + username);
    }

    @Then("the Job Titles page heading should be displayed")
    public void theJobTitlesPageHeadingShouldBeDisplayed() {
        Assert.assertTrue(adminPage.isJobTitlesPageHeadingVisible(),
            "Job Titles page heading is not visible");
    }
}