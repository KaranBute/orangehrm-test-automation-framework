package com.skillio.stepdefinitions;

import org.testng.Assert;
import com.skillio.pages.MaintenancePage;
import io.cucumber.java.en.*;

public class MaintenanceSteps {

    private MaintenancePage maintenancePage;

    private MaintenancePage getMaintenancePage() {
        if (maintenancePage == null) {
            maintenancePage = new MaintenancePage();
        }
        return maintenancePage;
    }

    // =========================
    // NAVIGATION
    // =========================

    @When("user navigates to Maintenance module")
    public void userNavigatesToMaintenanceModule() {
        getMaintenancePage().navigateToMaintenance();
    }

    // =========================
    // ACTIONS
    // =========================

    @When("user clicks {string} option in Maintenance module")
    public void userClicksOptionInMaintenance(String option) {
        getMaintenancePage().clickOption(option);
    }

    @When("user enters employee name {string} in maintenance purge search")
    public void userEntersEmployeeNameInPurgeSearch(String name) {
        getMaintenancePage().enterEmployeeNameInPurge(name);
    }

    @When("user clicks Search button in Maintenance purge")
    public void userClicksSearchButtonInPurge() {
        getMaintenancePage().clickSearchInPurge();
    }

    @When("user clicks Search button in Maintenance purge without any input")
    public void userClicksSearchButtonInPurgeWithoutInput() {
        getMaintenancePage().clickSearchWithoutInput();
    }

    // =========================
    // ASSERTIONS (RENAMED)
    // =========================

    @Then("maintenance module landing page should be displayed in Maintenance module")
    public void maintenanceLandingPageShouldBeDisplayed() {
        Assert.assertTrue(
            getMaintenancePage().isLandingPageDisplayed(),
            "Expected Maintenance module landing page heading."
        );
    }

    @Then("employee purge search results should be displayed in Maintenance module")
    public void employeePurgeSearchResultsShouldBeDisplayed() {
        Assert.assertTrue(
            getMaintenancePage().isPurgeResultsDisplayed(),
            "Expected purge results table to be visible."
        );
    }

    @Then("access logs table should be displayed in Maintenance module")
    public void accessLogsTableShouldBeDisplayed() {
        Assert.assertTrue(
            getMaintenancePage().isAccessLogsTableDisplayed(),
            "Expected access logs table to be visible."
        );
    }

    @Then("candidate records purge page should be displayed in Maintenance module")
    public void candidateRecordsPurgePageShouldBeDisplayed() {
        Assert.assertTrue(
            getMaintenancePage().isLandingPageDisplayed(),
            "Expected Candidate Records purge page to be visible."
        );
    }

    @Then("maintenance purge search should return results or show appropriate message")
    public void purgeSearchShouldReturnResultsOrMessage() {
        Assert.assertTrue(
            getMaintenancePage().isPurgeSearchResponseDisplayed(),
            "Expected either results or 'No Records Found' message."
        );
    }
    
    @When("user clicks {string} option in Maintenance")
    public void maintenanceOption(String option) {
        getMaintenancePage().clickOption(option);
    }

    @Then("candidate records purge page should be displayed")
    public void candidatePurge() {
        Assert.assertTrue(getMaintenancePage().isLandingPageDisplayed());
    }
}