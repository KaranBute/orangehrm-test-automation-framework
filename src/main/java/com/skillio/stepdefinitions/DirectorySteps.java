package com.skillio.stepdefinitions;

import org.testng.Assert;
import com.skillio.pages.DirectoryPage;
import io.cucumber.java.en.*;

public class DirectorySteps {

    private DirectoryPage directoryPage;

    private DirectoryPage getDirectoryPage() {
        if (directoryPage == null) {
            directoryPage = new DirectoryPage();
        }
        return directoryPage;
    }

    // =========================
    // NAVIGATION
    // =========================

    @Given("user navigates to Directory module")
    public void userNavigatesToDirectoryModule() {
        getDirectoryPage().navigateToDirectory();
    }

    // =========================
    // ACTIONS
    // =========================

    @When("user enters employee name {string} in directory search")
    public void userEntersEmployeeNameInDirectorySearch(String name) {
        getDirectoryPage().enterEmployeeName(name);
    }

    @When("user clicks Search button in Directory module")
    public void userClicksSearchButtonInDirectory() {
        getDirectoryPage().clickSearch();
    }

    @When("user clicks Reset button in Directory module")
    public void userClicksResetButtonInDirectory() {
        getDirectoryPage().clickReset();
    }

    // =========================
    // ASSERTIONS (RENAMED)
    // =========================

    @Then("directory results should be displayed in Directory module")
    public void directoryResultsShouldBeDisplayed() {
        Assert.assertTrue(
            getDirectoryPage().isResultsDisplayed(),
            "Expected directory results to be displayed."
        );
    }

    @Then("directory should show no records found message in Directory module")
    public void directoryShouldShowNoRecordsFoundMessage() {
        Assert.assertTrue(
            getDirectoryPage().isNoRecordsMessageDisplayed(),
            "Expected 'No Records Found' message in directory."
        );
    }

    @Then("directory search fields should be cleared in Directory module")
    public void directorySearchFieldsShouldBeCleared() {
        Assert.assertTrue(
            getDirectoryPage().isEmployeeNameInputEmpty(),
            "Expected employee name field to be empty after Reset."
        );
    }
    
    @When("user clicks Search button in directory")
    public void userClicksSearchButtonInDirectoryOld() {
        getDirectoryPage().clickSearch();
    }

    @Then("directory should show no records found message")
    public void directoryNoRecordsOld() {
        Assert.assertTrue(getDirectoryPage().isNoRecordsMessageDisplayed());
    }
    
    @Then("directory results should be displayed")
    public void directoryResults() {
        Assert.assertTrue(getDirectoryPage().isResultsDisplayed());
    }
}