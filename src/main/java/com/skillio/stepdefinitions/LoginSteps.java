package com.skillio.stepdefinitions;

import com.skillio.base.Keyword;
import com.skillio.pages.LoginPage;
import com.skillio.utils.WaitFor;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage;

    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    @Given("user is on the OrangeHRM login page")
    public void userIsOnTheOrangeHRMLoginPage() {
        WaitFor.elementToBeVisible(By.name("username"));
    }

    @When("user enters userName {string} and password {string}")
    public void userEntersUserNameAndPassword(String username, String password) {
        getLoginPage().enterUserName(username);
        getLoginPage().enterPassword(password);
    }

    @When("user clicks the login button")
    public void userClicksTheLoginButton() {
        getLoginPage().clickSignInBtn();
    }

    @When("user enters password {string} in the password field")
    public void userEntersPasswordInThePasswordField(String password) {
        getLoginPage().enterPassword(password);
    }

    @Then("user should be redirected to the dashboard")
    public void userShouldBeRedirectedToTheDashboard() {
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));

        Assert.assertTrue(
                Keyword.getDriver()
                        .findElement(By.xpath("//h6[normalize-space()='Dashboard']"))
                        .isDisplayed(),
                "Dashboard not visible after login");
    }

    @Then("login error message {string} should be displayed")
    public void loginErrorMessageShouldBeDisplayed(String expectedMsg) {
        WaitFor.elementToBeVisible(By.cssSelector("p.oxd-alert-content-text"));

        String actual = Keyword.getDriver()
                .findElement(By.cssSelector("p.oxd-alert-content-text"))
                .getText()
                .trim();

        Assert.assertEquals(actual, expectedMsg, "Login error message mismatch");
    }

    @Then("userName field validation error {string} should be displayed")
    public void userNameFieldValidationErrorShouldBeDisplayed(String errorMsg) {
        Assert.assertEquals(
                getLoginPage().getUsernameFieldError(),
                errorMsg,
                "Username field validation error mismatch");
    }

    @Then("password field validation error {string} should be displayed")
    public void passwordFieldValidationErrorShouldBeDisplayed(String errorMsg) {
        Assert.assertEquals(
                getLoginPage().getPasswordFieldError(),
                errorMsg,
                "Password field validation error mismatch");
    }

    // renamed to avoid duplicate with other step classes
    @Then("the login password field type should be {string}")
    public void theLoginPasswordFieldTypeShouldBe(String expectedType) {
        String actual = Keyword.getDriver()
                .findElement(By.name("password"))
                .getAttribute("type");

        Assert.assertEquals(actual, expectedType, "Password field type mismatch");
    }

    @Then("the login page title should contain {string}")
    public void theLoginPageTitleShouldContain(String expectedText) {
        String title = Keyword.getDriver().getTitle();

        Assert.assertTrue(
                title.contains(expectedText),
                "Page title '" + title + "' does not contain '" + expectedText + "'");
    }

    @Then("the login result should be {string}")
    public void theLoginResultShouldBe(String result) {
        if ("success".equalsIgnoreCase(result)) {
            WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));

            Assert.assertTrue(
                    Keyword.getDriver()
                            .findElement(By.xpath("//h6[normalize-space()='Dashboard']"))
                            .isDisplayed(),
                    "Expected Dashboard after successful login");
        } else {
            try {
                WaitFor.elementToBeVisible(By.cssSelector("p.oxd-alert-content-text"));
            } catch (Exception e) {
                WaitFor.elementToBeVisible(
                        By.xpath("//span[contains(@class,'oxd-input-field-error')]"));
            }
        }
    }
    
    @Then("the password field type should be {string}")
    public void passwordType(String type) {
        String actual = Keyword.getDriver()
            .findElement(By.name("password"))
            .getAttribute("type");

        Assert.assertEquals(actual, type);
    }
}