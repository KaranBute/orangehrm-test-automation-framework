package com.skillio.stepdefinitions;

import com.skillio.pages.LeavePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LeaveSteps {

    private LeavePage leavePage;

    private LeavePage getLeavePage() {
        if (leavePage == null) {
            leavePage = new LeavePage();
        }
        return leavePage;
    }

    @When("user navigates to Leave module")
    public void userNavigatesToLeaveModule() {
        getLeavePage().navigateToLeave();
    }

    @When("user clicks on Apply leave link")
    public void userClicksOnApplyLeaveLink() {
        getLeavePage().clickApplyLeave();
    }

    @When("user clicks on Leave List link")
    public void userClicksOnLeaveListLink() {
        getLeavePage().clickLeaveList();
    }

    @When("user clicks on Leave Calendar link")
    public void userClicksOnLeaveCalendarLink() {
        getLeavePage().clickLeaveCalendar();
    }

    @When("user selects leave type {string}")
    public void userSelectsLeaveType(String leaveType) {
        getLeavePage().selectLeaveType(leaveType);
    }

    // renamed to avoid duplicate with other modules
    @When("user enters leave from date {string} and leave to date {string}")
    public void userEntersLeaveFromDateAndLeaveToDate(String fromDate, String toDate) {
        getLeavePage().enterFromDate(fromDate);
        getLeavePage().enterToDate(toDate);
    }

    @When("user enters leave comment {string}")
    public void userEntersLeaveComment(String comment) {
        getLeavePage().enterComment(comment);
    }

    @When("user enters leave comment with 251 characters")
    public void userEntersLeaveCommentWith251Characters() {
        getLeavePage().enterComment("A".repeat(251));
    }

    @When("user clicks Apply button")
    public void userClicksApplyButton() {
        getLeavePage().clickApplyButton();
    }

    @When("user clicks Search on the leave list form")
    public void userClicksSearchOnTheLeaveListForm() {
        getLeavePage().clickSearch();
    }

    @Then("leave apply success toast should be displayed")
    public void leaveApplySuccessToastShouldBeDisplayed() {
        Assert.assertTrue(
                getLeavePage().isLeaveSuccessToastVisible(),
                "Leave success toast not visible!");
    }

    @Then("leave list results should be displayed")
    public void leaveListResultsShouldBeDisplayed() {
        Assert.assertTrue(
                getLeavePage().isLeaveListTableVisible(),
                "Leave list results table not visible!");
    }

    @Then("leave date validation error should be displayed")
    public void leaveDateValidationErrorShouldBeDisplayed() {
        Assert.assertTrue(
                getLeavePage().isDateErrorDisplayed(),
                "Leave date validation error not visible!");
    }

    @Then("leave type required validation error should be displayed")
    public void leaveTypeRequiredValidationErrorShouldBeDisplayed() {
        Assert.assertTrue(
                getLeavePage().isLeaveTypeValidationErrorDisplayed(),
                "Leave type required validation error not visible!");
    }

    @Then("the leave calendar should be displayed")
    public void theLeaveCalendarShouldBeDisplayed() {
        Assert.assertTrue(
                getLeavePage().isLeaveCalendarDisplayed(),
                "Leave calendar not displayed!");
    }

    @Then("leave comment length should not exceed 250 characters in the field")
    public void leaveCommentLengthShouldNotExceed250() {
        int len = getLeavePage().getCommentFieldLength();

        Assert.assertTrue(
                len <= 250,
                "Comment length " + len + " exceeds 250 characters!");
    }
}