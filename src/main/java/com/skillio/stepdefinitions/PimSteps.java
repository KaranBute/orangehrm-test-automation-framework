package com.skillio.stepdefinitions;

import com.skillio.pages.PimPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class PimSteps {

    private PimPage pimPage;

    private PimPage getPimPage() {
        if (pimPage == null) {
            pimPage = new PimPage();
        }
        return pimPage;
    }

    @When("user navigates to PIM module")
    public void userNavigatesToPIMModule() {
        getPimPage().navigateToPim();
    }

    @When("user clicks Add Employee button in PIM")
    public void userClicksAddEmployeeButton() {
        getPimPage().clickAddEmployee();
    }

    @When("user enters first name {string}, last name {string} and employee id {string} in PIM")
    public void userEntersFirstNameLastNameAndEmployeeId(String first, String last, String empId) {
        getPimPage().enterEmployeeDetails(first, last, empId);
    }

    @When("user clicks Save on Add Employee form")
    public void userClicksSaveOnAddEmployeeForm() {
        getPimPage().clickSave();
    }

    @When("user searches for employee with name {string} in PIM")
    public void userSearchesForEmployeeWithName(String name) {
        getPimPage().searchByName(name);
    }

    @When("user clicks Search on the employee list in PIM")
    public void userClicksSearchOnTheEmployeeList() {
        getPimPage().clickSearch();
    }

    @Then("employee save success toast should be displayed in PIM")
    public void employeeSaveSuccessToastShouldBeDisplayed() {
        getPimPage().assertSuccessToastDisplayed();
    }

    @Then("required field validation error should be shown on employee form in PIM")
    public void requiredFieldValidationErrorShouldBeShown() {
        getPimPage().assertRequiredErrorDisplayed();
    }

    @Then("duplicate employee ID error should be shown in PIM")
    public void duplicateEmployeeIdErrorShouldBeShown() {
        getPimPage().assertDuplicateIdErrorDisplayed();
    }

    @Then("at least one employee result should be visible in the list in PIM")
    public void atLeastOneEmployeeResultShouldBeVisible() {
        getPimPage().assertSearchResultsVisible();
    }

    @Then("the Employee List page heading should be visible in PIM")
    public void theEmployeeListPageHeadingShouldBeVisible() {
        getPimPage().assertEmployeeListHeadingVisible();
    }
    
    @When("user searches for employee with name {string}")
    public void userSearchesForEmployeeWithNameOld(String name) {
        getPimPage().searchByName(name);
    }

    @When("user clicks Search on the employee list")
    public void userClicksSearchOnEmployeeListOld() {
        getPimPage().clickSearch();
    }

    @Then("at least one employee result should be visible in the list")
    public void employeeResultVisibleOld() {
        getPimPage().assertSearchResultsVisible();
    }
    
    @When("user clicks Add Employee button")
    public void clickAddEmployee() {
        getPimPage().clickAddEmployee();
    }

    @When("user enters first name {string}, last name {string} and employee id {string}")
    public void enterEmployee(String f, String l, String id) {
        getPimPage().enterEmployeeDetails(f, l, id);
    }

    @Then("required field validation error should be shown on employee form")
    public void empError() {
        getPimPage().assertRequiredErrorDisplayed();
    }
}