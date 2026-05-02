package com.skillio.stepdefinitions;

import com.skillio.pages.MyInfoPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class MyInfoSteps {

    private MyInfoPage myInfoPage;

    private MyInfoPage getMyInfoPage() {
        if (myInfoPage == null) {
            myInfoPage = new MyInfoPage();
        }
        return myInfoPage;
    }

    @When("user navigates to My Info module")
    public void userNavigatesToMyInfoModule() {
        getMyInfoPage().navigateToMyInfo();
    }

    @When("user clicks on Personal Details tab in My Info")
    public void userClicksOnPersonalDetailsTab() {
        getMyInfoPage().clickPersonalDetailsTab();
    }

    @When("user clicks on Contact Details tab in My Info")
    public void userClicksOnContactDetailsTab() {
        getMyInfoPage().clickContactDetailsTab();
    }

    @When("user selects nationality {string} in My Info")
    public void userSelectsNationality(String nationality) {
        getMyInfoPage().selectNationality(nationality);
    }

    @When("user selects gender {string} in My Info")
    public void userSelectsGender(String gender) {
        getMyInfoPage().selectGender(gender);
    }

    @When("user enters date of birth {string} in My Info")
    public void userEntersDateOfBirth(String dob) {
        getMyInfoPage().enterDob(dob);
    }

    @When("user enters street1 {string} in My Info")
    public void userEntersStreet1(String street) {
        getMyInfoPage().enterStreet1(street);
    }

    @When("user enters city {string} in My Info")
    public void userEntersCity(String city) {
        getMyInfoPage().enterCity(city);
    }

    @When("user enters mobile number {string} in My Info")
    public void userEntersMobileNumber(String mobile) {
        getMyInfoPage().enterMobileNumber(mobile);
    }

    @When("user clicks Save on Personal Details form")
    public void userClicksSaveOnPersonalDetailsForm() {
        getMyInfoPage().clickSave();
    }

    @Then("personal details success toast should be displayed")
    public void personalDetailsSuccessToastShouldBeDisplayed() {
        Assert.assertTrue(
                getMyInfoPage().isSuccessToastDisplayed(),
                "Personal details success toast not visible!");
    }

    @Then("date of birth validation error should be displayed in My Info")
    public void dateOfBirthValidationErrorShouldBeDisplayed() {
        Assert.assertTrue(
                getMyInfoPage().isDobErrorDisplayed(),
                "Date of birth validation error not visible!");
    }

    @Then("mobile number validation error should be displayed in My Info")
    public void mobileNumberValidationErrorShouldBeDisplayed() {
        Assert.assertTrue(
                getMyInfoPage().isMobileErrorDisplayed(),
                "Mobile number validation error not visible!");
    }
    
    @When("user clicks on Personal Details tab")
    public void userClicksOnPersonalDetailsTabOld() {
        getMyInfoPage().clickPersonalDetailsTab();
    }

    @When("user clicks on Contact Details tab")
    public void userClicksOnContactDetailsTabOld() {
        getMyInfoPage().clickContactDetailsTab();
    }

    @When("user enters street1 {string}")
    public void userEntersStreet1Old(String street) {
        getMyInfoPage().enterStreet1(street);
    }

    @When("user enters city {string}")
    public void userEntersCityOld(String city) {
        getMyInfoPage().enterCity(city);
    }

    @When("user enters mobile number {string}")
    public void userEntersMobileNumberOld(String mobile) {
        getMyInfoPage().enterMobileNumber(mobile);
    }

    @When("user enters date of birth {string}")
    public void userEntersDateOfBirthOld(String dob) {
        getMyInfoPage().enterDob(dob);
    }

    @Then("date of birth validation error should be displayed")
    public void dobErrorOld() {
        Assert.assertTrue(getMyInfoPage().isDobErrorDisplayed());
    }

    @Then("mobile number validation error should be displayed")
    public void mobileErrorOld() {
        Assert.assertTrue(getMyInfoPage().isMobileErrorDisplayed());
    }
}