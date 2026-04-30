package com.skillio.stepdefinitions;

import org.testng.Assert;

import com.skillio.base.Keyword;
import com.skillio.pages.LoginPage;
import com.skillio.utils.App;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    // ✅ Single object (fixed)
    private LoginPage login = new LoginPage();

    @When("user enters invalid credential")
    public void enterInvalidCredentials() {
        login.loginWithCredentials("admn", "admn234");
    }

    @Then("check if the error message appears")
    public void verifyLoginErrorMsg() {
        String actual = login.getLoginErrorMessage();
        Assert.assertEquals(actual, "Invalid credentials");
    }

    @When("user enters valid credentials")
    public void enterValidCredentials() {
        login.loginWithCredentials(
            App.getUsername("qa"),
            App.getPassword("qa")
        );
    }

    @Then("user should be redirected to the dashboard")
    public void verifyRedirectionToDashboard() {
        String header = login.getDashboardHeaderText();
        Assert.assertTrue(
            header.contains("Dashboard"),
            "Dashboard not displayed after login"
        );
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        login.loginWithCredentials(username, password);
    }

    @Then("the login result should be {string}")
    public void the_login_result_should_be(String result) {

        if ("success".equalsIgnoreCase(result)) {
            Assert.assertTrue(
                login.getDashboardHeaderText().contains("Dashboard"),
                "Expected successful login but dashboard not found"
            );
        } else {
            String err = login.getLoginErrorMessage();

            Assert.assertTrue(
                err.equalsIgnoreCase("Invalid credentials")
                || login.getUsernameFieldError().length() > 0
                || login.getPasswordFieldError().length() > 0,
                "Expected failure but no proper validation message found"
            );
        }
    }

    @When("user clicks the login button")
    public void userClicksTheLoginButton() {
        login.clickSignInBtn();   // ✅ fixed
    }

    @When("user enters password {string} in the password field")
    public void userEntersPasswordInPasswordField(String password) {
        login.enterPassword(password);   // ✅ fixed
    }

    // ─── THEN ────────────────────────────────────────────────────────────────

    @Then("username field validation error {string} should be displayed")
    public void usernameFieldValidationErrorShouldBeDisplayed(String expectedError) {
        String actual = login.getUsernameFieldError();
        Assert.assertEquals(actual, expectedError,
            "Username field validation error mismatch");
    }

    @Then("password field validation error {string} should be displayed")
    public void passwordFieldValidationErrorShouldBeDisplayed(String expectedError) {
        String actual = login.getPasswordFieldError();
        Assert.assertEquals(actual, expectedError,
            "Password field validation error mismatch");
    }

    @Then("login error message {string} should be displayed")
    public void loginErrorMessageShouldBeDisplayed(String expectedMessage) {
        String actual = login.getLoginErrorMessage();
        Assert.assertEquals(actual, expectedMessage,
            "Login error message mismatch");
    }

    @Then("the login page title should contain {string}")
    public void theLoginPageTitleShouldContain(String expectedText) {
        String title = Keyword.getDriver().getTitle();
        Assert.assertTrue(title.contains(expectedText),
            "Page title [" + title + "] does not contain: " + expectedText);
    }

    @Then("the password field type should be {string}")
    public void thePasswordFieldTypeShouldBe(String expectedType) {
        String actualType = login.getPasswordFieldError();
        Assert.assertEquals(actualType, expectedType,
            "Password field type attribute mismatch");
    }
}