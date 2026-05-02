package com.skillio.stepdefinitions;

import org.testng.Assert;
import com.skillio.pages.ClaimPage;
import io.cucumber.java.en.*;

public class ClaimSteps {

    ClaimPage claim = new ClaimPage();

    // =========================
    // NAVIGATION
    // =========================

    @Given("user navigates to Claim module")
    public void navigateClaim() {
        claim.navigateToClaim();
    }

    // =========================
    // ACTIONS
    // =========================

    @When("user clicks claim menu item {string}")
    public void clickOption(String opt) {
        claim.clickOption(opt);
    }

    @When("user selects claim event {string}")
    public void selectEvent(String event) {
        claim.selectEvent(event);
    }

    @When("user selects claim currency {string}")
    public void selectCurrency(String currency) {
        claim.selectCurrency(currency);
    }

    @When("user enters claim remarks {string}")
    public void enterRemarks(String text) {
        claim.enterRemarks(text);
    }

    @When("user clicks Create Claim button")
    public void clickCreate() {
        claim.clickCreateButton();
    }

    // =========================
    // ASSERTIONS (RENAMED TO AVOID DUPLICATES)
    // =========================

    @Then("claims list should be displayed in Claim module")
    public void verifyList() {
        Assert.assertTrue(
            claim.isTableVisible(),
            "Claim list is not visible"
        );
    }

    @Then("submit claim page should be displayed in Claim module")
    public void verifySubmitPage() {
        Assert.assertTrue(
            claim.isSubmitPageVisible(),
            "Submit Claim page not visible"
        );
    }

    @Then("assign claim page should be displayed in Claim module")
    public void verifyAssignPage() {
        Assert.assertTrue(
            claim.isAssignPageVisible(),
            "Assign Claim page not visible"
        );
    }

    @Then("claim required error should be displayed in Claim module")
    public void verifyError() {
        Assert.assertTrue(
            claim.isErrorVisible(),
            "Required error not displayed"
        );
    }
    
    @Then("submit claim page should be displayed")
    public void submitClaimPageOld() {
        Assert.assertTrue(claim.isSubmitPageVisible());
    }

    @Then("assign claim page should be displayed successfully")
    public void assignClaimPageOld() {
        Assert.assertTrue(claim.isAssignPageVisible());
    }

    @Then("claims list should be displayed")
    public void claimsListOld() {
        Assert.assertTrue(claim.isTableVisible());
    }

    @Then("claim required error should be displayed")
    public void claimRequiredErrorOld() {
        Assert.assertTrue(claim.isErrorVisible());
    }
}