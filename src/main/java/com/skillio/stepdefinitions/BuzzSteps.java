package com.skillio.stepdefinitions;

import org.testng.Assert;
import com.skillio.pages.BuzzPage;
import io.cucumber.java.en.*;

public class BuzzSteps {

    private BuzzPage buzzPage;

    private BuzzPage getBuzzPage() {
        if (buzzPage == null) {
            buzzPage = new BuzzPage();
        }
        return buzzPage;
    }

    // =========================
    // NAVIGATION
    // =========================

    @Given("user navigates to Buzz module")
    public void userNavigatesToBuzzModule() {
        getBuzzPage().navigateToBuzz();
    }

    // =========================
    // POST CREATION
    // =========================

    @When("user clicks on buzz post text area")
    public void userClicksOnPostTextArea() {
        getBuzzPage().clickPostTextArea();
    }

    @When("user enters buzz post text {string}")
    public void userEntersBuzzPostText(String text) {
        getBuzzPage().enterPostText(text);
    }

    @When("user clicks Share Post button on Buzz")
    public void userClicksSharePostButton() {
        getBuzzPage().clickSharePost();
    }

    @Then("buzz post should appear in the feed")
    public void buzzPostShouldAppearInTheFeed() {
        Assert.assertTrue(
            getBuzzPage().isFirstPostVisible(),
            "Expected a post to appear in the Buzz feed."
        );
    }

    // =========================
    // LIKE FUNCTIONALITY
    // =========================

    @When("user clicks the like button on the first post in Buzz")
    public void userClicksLikeButtonOnFirstPost() {
        getBuzzPage().clickLikeOnFirstPost();
    }

    @Then("the like count should be updated on the first post in Buzz")
    public void theLikeCountShouldBeUpdatedOnFirstPost() {
        Assert.assertTrue(
            getBuzzPage().isLikeCountUpdated(),
            "Expected like count to be visible after clicking like."
        );
    }

    // =========================
    // NEGATIVE SCENARIO
    // =========================

    @When("user clicks on buzz post text area without entering any text")
    public void userClicksOnPostTextAreaWithoutText() {
        getBuzzPage().clickPostTextArea();
    }

    @Then("share post button should remain disabled on Buzz")
    public void sharePostButtonShouldRemainDisabled() {
        Assert.assertTrue(
            getBuzzPage().isShareButtonDisabled(),
            "Expected Share Post button to be disabled when text area is empty."
        );
    }

    // =========================
    // PHOTO UPLOAD
    // =========================

    @When("user clicks {string} button on Buzz module")
    public void userClicksButtonOnBuzz(String buttonLabel) {
        getBuzzPage().clickSharePhotos();
    }

    @Then("photo upload area should be displayed on Buzz")
    public void photoUploadAreaShouldBeDisplayed() {
        Assert.assertTrue(
            getBuzzPage().isPhotoUploadAreaDisplayed(),
            "Expected photo upload area to appear after clicking 'Share Photos'."
        );
    }
    
    @When("user clicks on post text area")
    public void userClicksOnPostTextAreaOld() {
        getBuzzPage().clickPostTextArea();
    }

    @When("user clicks Share Post button")
    public void userClicksSharePostButtonOld() {
        getBuzzPage().clickSharePost();
    }

    @When("user clicks on post text area without entering any text")
    public void userClicksOnPostTextAreaWithoutTextOld() {
        getBuzzPage().clickPostTextArea();
    }

    @Then("share post button should remain disabled")
    public void sharePostButtonShouldRemainDisabledOld() {
        Assert.assertTrue(getBuzzPage().isShareButtonDisabled());
    }

    @When("user clicks the like button on the first post")
    public void userClicksLikeButtonOnFirstPostOld() {
        getBuzzPage().clickLikeOnFirstPost();
    }

    @Then("the like count should be updated on the first post")
    public void likeCountUpdatedOld() {
        Assert.assertTrue(getBuzzPage().isLikeCountUpdated());
    }
}