package com.skillio.locators;

/**
 * BuzzLocator — XPath/CSS locators for the Buzz module.
 */
public interface BuzzLocator {

    public static final String BUZZ_MENU =
        "//span[normalize-space()='Buzz']";

    // Post composition area
    public static final String POST_TEXT_AREA =
        "//textarea[@placeholder=\"What's on your mind?\"]";
    public static final String SHARE_POST_BUTTON =
        "//button[normalize-space()='Share']";
    public static final String SHARE_PHOTOS_BUTTON =
        "//button[normalize-space()='Share Photos']";
    public static final String PHOTO_UPLOAD_AREA =
        "//div[contains(@class,'photo-upload') or @type='file' or contains(@class,'file-input')]";

    // Feed
    public static final String FIRST_POST_IN_FEED =
        "(//div[contains(@class,'orangehrm-buzz-post')])[1]";
    public static final String FIRST_POST_LIKE_BUTTON =
        "(//button[contains(@class,'like') or .//i[contains(@class,'heart')]])[1]";
    public static final String FIRST_POST_LIKE_COUNT =
        "(//button[contains(@class,'like')]/following-sibling::span | " +
        "//button[contains(@class,'like')]//span[contains(@class,'count')])[1]";

    // Share button disabled state — attribute check done in page class
    public static final String SHARE_BUTTON_DISABLED =
        "//button[normalize-space()='Share' and @disabled]";
}
