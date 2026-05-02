package com.skillio.stepdefinitions;

import org.testng.Assert;
import com.skillio.pages.TimePage;
import io.cucumber.java.en.*;

public class TimeSteps {

    private TimePage timePage;

    private TimePage getTimePage() {
        if (timePage == null) {
            timePage = new TimePage();
        }
        return timePage;
    }

    @Given("user navigates to Time module")
    public void userNavigatesToTimeModule() {
        getTimePage().navigateToTime();
    }

    @When("user clicks {string} sub menu in Time module")
    public void userClicksSubMenuInTimeModule(String subMenu) {
        getTimePage().clickSubMenu(subMenu);
    }

    @When("user clicks {string} option in Time module")
    public void userClicksOptionInTimeModule(String option) {
        getTimePage().clickOption(option);
    }

    @When("user clicks Punch In Out button in Time module")
    public void userClicksPunchInOutButton() {
        getTimePage().clickPunchInOut();
    }

    @Then("punch in success message should be displayed in Time module")
    public void punchInSuccessMessageShouldBeDisplayed() {
        Assert.assertTrue(
                getTimePage().isPunchSuccessDisplayed(),
                "Expected punch in success toast but it was not visible.");
    }

    @When("user clicks Add Timesheet button in Time module")
    public void userClicksAddTimesheetButton() {
        getTimePage().clickAddTimesheet();
    }

    @When("user selects current week date in Time module")
    public void userSelectsCurrentWeekDate() {
        getTimePage().selectCurrentWeekDate();
    }

    @When("user clicks Create Timesheet button in Time module")
    public void userClicksCreateTimesheetButton() {
        getTimePage().clickCreateTimesheet();
    }

    @Then("timesheet should be created successfully in Time module")
    public void timesheetShouldBeCreatedSuccessfully() {
        Assert.assertTrue(
                getTimePage().isTimesheetCreatedSuccessfully(),
                "Expected timesheet success confirmation but none was found.");
    }

    @When("user clicks Time Report button in Time module")
    public void userClicksTimeReportButton() {
        getTimePage().clickViewReport();
    }

    @Then("project report should be displayed in Time module")
    public void projectReportShouldBeDisplayed() {
        Assert.assertTrue(
                getTimePage().isReportDisplayed(),
                "Expected project report table but it was not visible.");
    }

    @When("user clicks Create Timesheet button without selecting a date in Time module")
    public void userClicksCreateTimesheetWithoutDate() {
        getTimePage().clickCreateTimesheetWithoutDate();
    }

    @Then("timesheet date validation error should be displayed in Time module")
    public void timesheetDateValidationErrorShouldBeDisplayed() {
        Assert.assertTrue(
                getTimePage().isTimesheetDateErrorDisplayed(),
                "Expected validation error for missing date but none appeared.");
    }

    @Then("attendance records page should be displayed in Time module")
    public void attendanceRecordsPageShouldBeDisplayed() {
        Assert.assertTrue(
                getTimePage().isAttendancePageDisplayed(),
                "Expected attendance records page heading to be visible.");
    }
    
    @When("user clicks {string} sub menu")
    public void userClicksSubMenuOld(String subMenu) {
        getTimePage().clickSubMenu(subMenu);
    }

    @When("user clicks {string} option")
    public void userClicksOptionOld(String option) {
        getTimePage().clickOption(option);
    }

    @When("user clicks Punch In\\/Out button")
    public void userClicksPunchInOutOld() {
        getTimePage().clickPunchInOut();
    }

    @Then("punch in success message should be displayed")
    public void punchSuccessOld() {
        Assert.assertTrue(getTimePage().isPunchSuccessDisplayed());
    }

    @Then("attendance records page should be displayed")
    public void attendanceRecordsOld() {
        Assert.assertTrue(getTimePage().isAttendancePageDisplayed());
    }
}