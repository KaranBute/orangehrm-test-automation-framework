package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.MyInfoLocator;
import com.skillio.utils.WaitFor;

public class MyInfoPage {

    public MyInfoPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = MyInfoLocator.MY_INFO_MENU)
    private WebElement myInfoMenu;

    @FindBy(xpath = MyInfoLocator.PERSONAL_DETAILS_TAB)
    private WebElement personalDetailsTab;

    @FindBy(xpath = MyInfoLocator.CONTACT_DETAILS_TAB)
    private WebElement contactDetailsTab;

    @FindBy(xpath = MyInfoLocator.SAVE_BUTTON)
    private WebElement saveButton;

    private final By mobileInput = By.xpath("//label[normalize-space()='Mobile']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By genderMaleRadio = By.xpath("//label[normalize-space()='Male']//span | //input[@type='radio' and @value='1']/following-sibling::span");
    private final By genderFemaleRadio = By.xpath("//label[normalize-space()='Female']//span | //input[@type='radio' and @value='2']/following-sibling::span");
    private final By mobileError = By.xpath("//span[contains(@class,'oxd-input-field-error-message') or contains(normalize-space(),'phone') or contains(normalize-space(),'valid')]");

    public void navigateToMyInfo() {
        WaitFor.click(myInfoMenu);
        WaitFor.elementToBeVisible(By.xpath(MyInfoLocator.PERSONAL_DETAILS_TAB));
    }

    public void clickPersonalDetailsTab() {
        WaitFor.click(personalDetailsTab);
    }

    public void clickContactDetailsTab() {
        WaitFor.click(contactDetailsTab);
    }

    public void selectNationality(String nationality) {
        WaitFor.click(By.xpath(MyInfoLocator.NATIONALITY_DROPDOWN));
        WaitFor.click(By.xpath(String.format(MyInfoLocator.LISTBOX_OPTION, nationality)));
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            WaitFor.click(genderMaleRadio);
        } else {
            WaitFor.click(genderFemaleRadio);
        }
    }

    public void enterDob(String dob) {
        WaitFor.typeAndTab(By.xpath(MyInfoLocator.DOB_INPUT), dob);
    }

    public void enterStreet1(String street) {
        WaitFor.type(By.xpath(MyInfoLocator.STREET1_INPUT), street);
    }

    public void enterCity(String city) {
        WaitFor.type(By.xpath(MyInfoLocator.CITY_INPUT), city);
    }

    public void enterMobileNumber(String mobile) {
        WaitFor.type(mobileInput, mobile);
    }

    public void clickSave() {
        WaitFor.click(saveButton);
    }

    public boolean isSuccessToastDisplayed() {
        try { WaitFor.elementToBeVisible(By.xpath(MyInfoLocator.SUCCESS_TOAST)); return true; }
        catch (Exception e) { return false; }
    }

    public boolean isDobErrorDisplayed() {
        try { WaitFor.elementToBeVisible(By.xpath(MyInfoLocator.DOB_ERROR)); return true; }
        catch (Exception e) { return false; }
    }

    public boolean isMobileErrorDisplayed() {
        try { WaitFor.elementToBeVisible(mobileError); return true; }
        catch (Exception e) { return false; }
    }
    
    public boolean isMobileErrorDisplayed1() {
        try {
            By err = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");
            WaitFor.elementToBeVisible(err);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
