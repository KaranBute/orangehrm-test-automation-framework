Feature: Buzz  Social Post Management

  Background:
    Given user is logged into OrangeHRM as "Admin"
    And user navigates to Buzz module

  @positive @buzz
  Scenario: TC_BUZZ_01 - Admin can share a text post on Buzz
    When user clicks on post text area
    And user enters buzz post text "Hello"
    And user clicks Share Post button
    Then buzz post should appear in the feed

  @positive @buzz
  Scenario: TC_BUZZ_02 - Like button updates like count on first post
    When user clicks the like button on the first post
    Then the like count should be updated on the first post

  @negative @buzz
  Scenario: TC_BUZZ_03 - Share button is disabled when post text area is empty
    When user clicks on post text area without entering any text
    Then share post button should remain disabled

  @positive @buzz
  Scenario: TC_BUZZ_04 - Share Photos button opens photo upload area
    When user clicks "Share Photos" button on Buzz
    Then photo upload area should be displayed
