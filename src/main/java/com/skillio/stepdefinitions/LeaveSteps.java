package com.skillio.stepdefinitions;

import org.testng.Assert;
import com.skillio.pages.LeavePage;
import io.cucumber.java.en.*;

public class LeaveSteps {

    // ✅ Single object (lazy initialization)
    private LeavePage leave;

    private LeavePage getLeavePage() {
        if (leave == null) {
            leave = new LeavePage();
        }
        return leave;
    }

    // ── Navigation ─────────────────────────────────────────

    @When("user navigates to Leave module")
    public void userNavigatesToLeaveModule() {
        getLeavePage().navigateToLeave();
    }

    @When("user clicks {string} option")
    public void userClicksOption(String option) {
        getLeavePage().clickLeaveSubMenu(option);
    }

    @When("user selects leave type {string}")
    public void userSelectsLeaveType(String leaveType) {
        getLeavePage().selectLeaveType(leaveType);
    }

    @When("user enters from date {string} and to date {string}")
    public void userEntersFromDateAndToDate(String fromDate, String toDate) {
        getLeavePage().enterFromDate(fromDate);
        getLeavePage().enterToDate(toDate);
    }

    @When("user enters comment {string}")
    public void userEntersComment(String comment) {
        getLeavePage().enterComment(comment);
    }

    @When("user clicks Apply button")
    public void userClicksApplyButton() {
        getLeavePage().clickApplyButton();
    }

    @When("user filters by status {string}")
    public void userFiltersByStatus(String status) {
        getLeavePage().filterByStatus(status);
    }

    @When("user opens first pending leave request")
    public void userOpensFirstPendingLeaveRequest() {
        getLeavePage().openFirstPendingRequest();
    }

    @When("user opens a leave request with status {string}")
    public void userOpensLeaveRequestWithStatus(String status) {
        getLeavePage().openLeaveRequestByStatus(status);
    }

    @When("user clicks Approve button")
    public void userClicksApproveButton() {
        getLeavePage().clickApprove();
    }

    @When("user clicks Reject button")
    public void userClicksRejectButton() {
        getLeavePage().clickReject();
    }

    @When("user clicks Cancel button on leave request")
    public void userClicksCancelButtonOnLeaveRequest() {
        getLeavePage().clickCancel();
    }

    // ─── THEN ─────────────────────────────────────────────

    @Then("leave request should be submitted with status {string}")
    public void leaveRequestShouldBeSubmitted(String expectedStatus) {
        Assert.assertTrue(
            getLeavePage().isSuccessToastDisplayed(),
            "Leave submission failed. Expected status: " + expectedStatus
        );
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        String actual = getLeavePage().getDateOrValidationError();
        Assert.assertTrue(
            actual.contains(expectedMessage),
            "Expected error [" + expectedMessage + "] but got: " + actual
        );
    }

    @Then("leave status should change to {string}")
    public void leaveStatusShouldChangeTo(String expectedStatus) {
        String actual = getLeavePage().getLeaveStatusText();
        Assert.assertEquals(
            actual, expectedStatus,
            "Leave status mismatch after action"
        );
    }

    @Then("field validation error {string} should appear under leave type")
    public void fieldValidationErrorShouldAppearUnderLeaveType(String expectedError) {
        Assert.assertEquals(
            getLeavePage().getLeaveTypeValidationError(),
            expectedError,
            "Leave type validation error mismatch"
        );
    }

    @Then("leave entitlement list should be visible with leave types")
    public void leaveEntitlementListShouldBeVisible() {
        Assert.assertTrue(
            getLeavePage().isLeaveListTableVisible(),
            "Leave list table not visible"
        );
    }

    @Then("the leave calendar should be displayed for current month")
    public void theLeaveCalendarShouldBeDisplayed() {
        Assert.assertTrue(
            getLeavePage().isLeaveCalendarDisplayed(),
            "Leave calendar not displayed"
        );
    }

    @Then("leave duration should display {string}")
    public void leaveDurationShouldDisplay(String expectedDuration) {
        String actual = getLeavePage().getLeaveDurationText();
        Assert.assertEquals(
            actual, expectedDuration,
            "Leave duration mismatch"
        );
    }
}