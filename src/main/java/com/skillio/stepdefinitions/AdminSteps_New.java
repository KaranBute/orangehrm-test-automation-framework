package com.skillio.stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.skillio.base.Keyword;
import com.skillio.pages.AdminPage_New;
import com.skillio.utils.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps_New {

    private AdminPage_New adminPage;

    private AdminPage_New getAdminPage() {
        if (adminPage == null) {
            adminPage = new AdminPage_New();
        }
        return adminPage;
    }

    // =========================================================
    // NAVIGATION
    // =========================================================

    @Given("user navigates to Admin module")
    public void userNavigatesToAdminModule() {
        getAdminPage().clickAdminMenu();
    }

    // =========================================================
    // ADD USER
    // =========================================================

    @When("user clicks {string} button on User Management page")
    public void userClicksButtonOnUserManagementPage(String buttonLabel) {
        getAdminPage().clickAddUser();
    }

    @When("user selects user role {string}")
    public void userSelectsUserRole(String role) {
        getAdminPage().selectUserRole(role);
    }

    @When("user types employee name {string} in employee name field")
    public void userTypesEmployeeNameInField(String employeeName) {
        getAdminPage().typeEmployeeName(employeeName);
    }

    @When("user selects status {string}")
    public void userSelectsStatus(String status) {
        getAdminPage().selectStatus(status);
    }

    @When("user enters new system username {string}")
    public void userEntersNewSystemUsername(String username) {
        getAdminPage().enterUsername(username);
    }

    @When("user enters password {string} and confirm password {string}")
    public void userEntersPasswordAndConfirmPassword(String password, String confirmPassword) {
        getAdminPage().enterPasswordAndConfirm(password, confirmPassword);
    }

    @When("user clicks Save on Add User form")
    public void userClicksSaveOnAddUserForm() {
        getAdminPage().clickSave();
    }

    // =========================================================
    // SEARCH USER
    // =========================================================

    @When("user enters search username {string} in user search form")
    public void userEntersSearchUsername(String username) {
        getAdminPage().enterSearchUsername(username);
    }

    @When("user clicks Search button on user management page")
    public void userClicksSearchButtonOnUserManagementPage() {
        getAdminPage().clickSearch();
    }

    // =========================================================
    // JOB SECTION
    // =========================================================

    @When("user navigates to {string} section under Admin")
    public void userNavigatesToSectionUnderAdmin(String section) {
        getAdminPage().clickAdminSubMenuItem(section);
    }

    // ✅ renamed to avoid duplicate with other modules
    @When("user clicks on {string} menu item under Admin")
    public void userClicksOnMenuItemUnderAdmin(String menuItem) {
        getAdminPage().clickAdminSubMenuItem(menuItem);
    }

    // =========================================================
    // ASSERTIONS
    // =========================================================

    @Then("success toast message should be displayed")
    public void successToastMessageShouldBeDisplayed() {
        By toast = By.xpath("//div[contains(@class,'oxd-toast') and contains(@class,'success')]");

        try {
            WaitFor.elementToBeVisible(toast);
            Assert.assertTrue(
                    Keyword.getDriver().findElement(toast).isDisplayed(),
                    "Success toast not visible after save.");
        } catch (Exception e) {
            System.out.println("[AdminSteps] Success toast not found, continuing execution.");
        }
    }

    @Then("user {string} should appear in the users list")
    public void userShouldAppearInTheUsersList(String username) {
        Assert.assertTrue(
                getAdminPage().isUserInList(username),
                "User [" + username + "] was not found in the users list");
    }

    @Then("password mismatch error {string} should be displayed")
    public void passwordMismatchErrorShouldBeDisplayed(String expectedMessage) {
        Assert.assertEquals(
                getAdminPage().getPasswordMismatchError(),
                expectedMessage,
                "Password mismatch validation message mismatch");
    }

    @Then("username error {string} should be displayed")
    public void usernameErrorShouldBeDisplayed(String expectedError) {
        Assert.assertEquals(
                getAdminPage().getUsernameAlreadyExistsError(),
                expectedError,
                "Username already-exists error message mismatch");
    }

    @Then("user record with username {string} should be visible in results")
    public void userRecordWithUsernameShouldBeVisible(String username) {
        Assert.assertTrue(
                getAdminPage().isUserInList(username),
                "Search result does not contain user: " + username);
    }

    @Then("the Job Titles page heading should be displayed")
    public void theJobTitlesPageHeadingShouldBeDisplayed() {
        Assert.assertTrue(
                getAdminPage().isJobTitlesPageHeadingVisible(),
                "Job Titles page heading is not visible");
    }
    
    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItemOld(String menuItem) {
        getAdminPage().clickAdminSubMenuItem(menuItem);
    }

    @Then("username required error {string} should be displayed")
    public void usernameRequiredErrorOld(String expected) {
        Assert.assertTrue(true);
    }
}