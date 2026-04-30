package com.skillio.stepdefinitions;

import org.testng.Assert;
import com.skillio.pages.MyInfoPage;
import io.cucumber.java.en.*;

public class MyInfoSteps {

    // ✅ Single object
    private MyInfoPage myInfo = new MyInfoPage();

    // ─── NAVIGATION ─────────────────────────────────────

    @When("user navigates to My Info module")
    public void userNavigatesToMyInfoModule() {
        myInfo.navigateToMyInfo();
    }

    @When("user clicks on {string} tab")
    public void userClicksOnTab(String tabName) {
        myInfo.clickTab(tabName);
    }

    // ─── PERSONAL DETAILS ───────────────────────────────

    @When("user selects nationality {string}")
    public void userSelectsNationality(String nationality) {
        myInfo.selectNationality(nationality);
    }

    @When("user enters date of birth {string}")
    public void userEntersDateOfBirth(String dob) {
        myInfo.enterDob(dob);
    }

    @When("user selects gender {string}")
    public void userSelectsGender(String gender) {
        myInfo.selectGender(gender);
    }

    @When("user enters first name with 30 characters {string}")
    public void userEntersFirstName(String name) {
        myInfo.enterFirstName(name);
    }

    // ─── CONTACT DETAILS ───────────────────────────────

    @When("user enters street1 {string}")
    public void userEntersStreet1(String street) {
        myInfo.enterStreet1(street);
    }

    @When("user enters city {string}")
    public void userEntersCity(String city) {
        myInfo.enterCity(city);
    }

    @When("user enters mobile number {string}")
    public void userEntersMobileNumber(String mobileNumber) {
        myInfo.enterMobileNumber(mobileNumber);
    }

    // ─── EMERGENCY CONTACT ─────────────────────────────

    @When("user clicks Add button")
    public void userClicksAddButton() {
        myInfo.clickAdd();
    }

    @When("user enters contact name {string}")
    public void userEntersContactName(String name) {
        myInfo.enterContactName(name);
    }

    @When("user enters relationship {string}")
    public void userEntersRelationship(String relationship) {
        myInfo.enterRelationship(relationship);
    }

    @When("user enters home phone {string}")
    public void userEntersHomePhone(String phone) {
        myInfo.enterHomePhone(phone);
    }

    // ─── WORK EXPERIENCE ───────────────────────────────

    @When("user clicks Add button on work experience section")
    public void userClicksAddWorkExperience() {
        myInfo.clickAddWorkExperience();
    }

    @When("user enters company {string}")
    public void userEntersCompany(String companyName) {
        myInfo.enterCompanyName(companyName);
    }

    @When("user enters job title {string}")
    public void userEntersJobTitle(String jobTitle) {
        myInfo.enterJobTitleInWorkExp(jobTitle);
    }

    @When("user enters work experience from year {string} to year {string}")
    public void userEntersWorkExperience(String fromYear, String toYear) {
        myInfo.enterWorkExperienceYears(fromYear, toYear);
    }

    @When("user clicks Save button")
    public void userClicksSaveButton() {
        myInfo.clickSave();
    }

    // ─── THEN ─────────────────────────────────────────

    @Then("success toast message should be displayed")
    public void successToastMessageShouldBeDisplayed() {
        Assert.assertTrue(myInfo.isSuccessToastDisplayed(),
            "Success toast not displayed");
    }

    @Then("nationality should be saved as {string}")
    public void nationalityShouldBeSavedAs(String nationality) {
        Assert.assertTrue(myInfo.isSuccessToastDisplayed(),
            "Nationality not saved: " + nationality);
    }

    @Then("field validation error should appear under date of birth")
    public void fieldValidationErrorUnderDob() {
        Assert.assertTrue(myInfo.isDobErrorDisplayed(),
            "DOB validation error not shown");
    }

    @Then("field validation error should appear for mobile number field")
    public void mobileValidationError() {
        Assert.assertTrue(myInfo.isMobileNumberErrorDisplayed(),
            "Mobile validation error not shown");
    }

    @Then("emergency contact {string} should be listed")
    public void emergencyContactShouldBeListed(String name) {
        Assert.assertTrue(myInfo.isEmergencyContactInList(name),
            "Contact not found: " + name);
    }

    @Then("work experience entry {string} should be listed")
    public void workExperienceEntryShouldBeListed(String companyName) {
        Assert.assertTrue(myInfo.isWorkExperienceInList(companyName),
            "Work experience not found: " + companyName);
    }

    @Then("gender should be saved as {string}")
    public void genderShouldBeSavedAs(String expectedGender) {
        Assert.assertEquals(myInfo.getSelectedGender(), expectedGender,
            "Gender mismatch");
    }

    @Then("the name should be saved successfully without any error")
    public void nameSavedSuccessfully() {
        Assert.assertTrue(myInfo.isSuccessToastDisplayed(),
            "Name not saved");
    }
}