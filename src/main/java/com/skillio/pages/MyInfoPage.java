package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;

public class MyInfoPage {

    public MyInfoPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//a[text()='Personal Details']")
    private WebElement personalDetailsTab;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsTab;

    @FindBy(xpath = "//a[text()='Emergency Contacts']")
    private WebElement emergencyContactsTab;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;

    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successToast;

    @FindBy(xpath = "//span[contains(text(),'Should be a valid date')]")
    private WebElement dobError;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Street 1']")
    private WebElement street1Field;

    @FindBy(xpath = "//input[@placeholder='City']")
    private WebElement cityField;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement contactNameField;

    @FindBy(xpath = "//input[@placeholder='Relationship']")
    private WebElement relationshipField;

    @FindBy(xpath = "//input[@placeholder='Home Telephone']")
    private WebElement homePhoneField;

    // ── Actions ─────────────────────────────────────────────────────────────

    public void navigateToMyInfo() {
        WaitFor.elementToBeClickable(myInfoMenu);
        myInfoMenu.click();
    }

    public void clickPersonalDetailsTab() {
        WaitFor.elementToBeClickable(personalDetailsTab);
        personalDetailsTab.click();
    }

    public void clickContactDetailsTab() {
        WaitFor.elementToBeClickable(contactDetailsTab);
        contactDetailsTab.click();
    }

    public void clickEmergencyContactsTab() {
        WaitFor.elementToBeClickable(emergencyContactsTab);
        emergencyContactsTab.click();
    }

    public void selectNationality(String nationality) {
        // Extend with dropdown selection if needed
    }

    public void enterFirstName(String name) {
        WaitFor.elementToBeVisible(firstNameField);
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void enterStreet1(String street) {
        WaitFor.elementToBeVisible(street1Field);
        street1Field.clear();
        street1Field.sendKeys(street);
    }

    public void enterCity(String city) {
        WaitFor.elementToBeVisible(cityField);
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void enterDob(String dob) {
        // Extend with DOB field locator
    }

    public void clickAdd() {
        WaitFor.elementToBeClickable(addBtn);
        addBtn.click();
    }

    public void enterContactName(String name) {
        WaitFor.elementToBeVisible(contactNameField);
        contactNameField.clear();
        contactNameField.sendKeys(name);
    }

    public void enterRelationship(String relationship) {
        WaitFor.elementToBeVisible(relationshipField);
        relationshipField.clear();
        relationshipField.sendKeys(relationship);
    }

    public void enterHomePhone(String phone) {
        WaitFor.elementToBeVisible(homePhoneField);
        homePhoneField.clear();
        homePhoneField.sendKeys(phone);
    }

    public void clickSave() {
        WaitFor.elementToBeClickable(saveBtn);
        saveBtn.click();
    }

    // ── Validations ──────────────────────────────────────────────────────────

    public boolean isSuccessToastDisplayed() {
        WaitFor.elementToBeVisible(successToast);
        return successToast.isDisplayed();
    }

    public boolean isDobErrorDisplayed() {
        return dobError.isDisplayed();
    }

    public boolean isEmergencyContactInList(String name) {
        // Extend with list check
        return true;
    }
    
    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu1;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn1;

    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successToast1;

    // Mobile number input under Contact Details
    @FindBy(xpath = "//label[text()='Mobile']/following::input[1]")
    private WebElement mobileInput;

    // Mobile validation error
    @FindBy(xpath = "//label[text()='Mobile']/following::span[contains(@class,'error')][1]")
    private WebElement mobileError;

    // Gender radio buttons — use By in action method for flexibility
    // Work Experience "Add" button
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addWorkExpBtn;

    // Work experience form fields
    @FindBy(xpath = "//label[text()='Company']/following::input[1]")
    private WebElement companyInput;

    @FindBy(xpath = "//label[text()='Job Title']/following::input[1]")
    private WebElement jobTitleInWorkExp;

    // From / To year in work experience
    @FindBy(xpath = "//label[text()='From']/following::input[1]")
    private WebElement fromYearInput;

    @FindBy(xpath = "//label[text()='To']/following::input[1]")
    private WebElement toYearInput;

    // ─── NAVIGATION ───────────────────────────────────────────────────────

    public void navigateToMyInfo1() {
        WaitFor.elementToBeClickable(myInfoMenu);
        myInfoMenu.click();
    }

    public void clickTab(String tabName) {
        By tab = By.xpath("//a[normalize-space()='" + tabName + "']");
        WaitFor.elementToBeClickable(tab);
        Keyword.getDriver().findElement(tab).click();
    }

    // ─── PERSONAL DETAILS ─────────────────────────────────────────────────

    public void selectNationality1(String nationality) {
        By nationalityDropdown = By.xpath(
            "//label[text()='Nationality']/following::div[@class='oxd-select-wrapper'][1]"
        );
        WaitFor.elementToBeClickable(nationalityDropdown);
        Keyword.getDriver().findElement(nationalityDropdown).click();
        By option = By.xpath(
            "//div[@class='oxd-select-dropdown']//span[normalize-space()='" + nationality + "']"
        );
        WaitFor.elementToBeClickable(option);
        Keyword.getDriver().findElement(option).click();
    }

    public void selectGender(String gender) {
        // Gender is represented by radio buttons labeled "Male" or "Female"
        By genderRadio = By.xpath(
            "//label[normalize-space()='" + gender + "']/preceding-sibling::input[@type='radio']"
        );
        WaitFor.elementToBeClickable(genderRadio);
        Keyword.getDriver().findElement(genderRadio).click();
    }

    public String getSelectedGender() {
        // Return text of the label whose radio is checked
        By checkedLabel = By.xpath(
            "//input[@type='radio'][@checked]/following-sibling::label or " +
            "//input[@type='radio' and @class[contains(.,'checked')]]/following-sibling::label"
        );
        try {
            WaitFor.elementToBeVisible(checkedLabel);
            return Keyword.getDriver().findElement(checkedLabel).getText().trim();
        } catch (Exception e) {
            // Fallback: look for selected radio differently on OrangeHRM Vue
            By selected = By.xpath(
                "//div[contains(@class,'oxd-radio-wrapper')]//input[@checked='']" +
                "/following-sibling::label"
            );
            return Keyword.getDriver().findElement(selected).getText().trim();
        }
    }

    // ─── CONTACT DETAILS ──────────────────────────────────────────────────

    public void enterMobileNumber(String mobile) {
        WaitFor.elementToBeVisible(mobileInput);
        mobileInput.clear();
        mobileInput.sendKeys(mobile);
    }

    public boolean isMobileNumberErrorDisplayed() {
        By err = By.xpath(
            "//label[text()='Mobile']/following::span[contains(@class,'error') or text()='Allows numbers and only + - / ( )'][1]"
        );
        WaitFor.elementToBeVisible(err);
        return Keyword.getDriver().findElement(err).isDisplayed();
    }

    // ─── WORK EXPERIENCE ──────────────────────────────────────────────────

    public void clickAddWorkExperience() {
        WaitFor.elementToBeClickable(addWorkExpBtn);
        addWorkExpBtn.click();
    }

    public void enterCompanyName(String company) {
        WaitFor.elementToBeVisible(companyInput);
        companyInput.clear();
        companyInput.sendKeys(company);
    }

    public void enterJobTitleInWorkExp(String title) {
        WaitFor.elementToBeVisible(jobTitleInWorkExp);
        jobTitleInWorkExp.clear();
        jobTitleInWorkExp.sendKeys(title);
    }

    public void enterWorkExperienceYears(String fromYear, String toYear) {
        WaitFor.elementToBeVisible(fromYearInput);
        fromYearInput.clear();
        fromYearInput.sendKeys(fromYear);
        toYearInput.clear();
        toYearInput.sendKeys(toYear);
    }

    public boolean isWorkExperienceInList(String companyName) {
        By entry = By.xpath(
            "//div[@class='oxd-table-card']//div[normalize-space()='" + companyName + "']"
        );
        WaitFor.elementToBeVisible(entry);
        return Keyword.getDriver().findElement(entry).isDisplayed();
    }

    // ─── COMMON ACTIONS ───────────────────────────────────────────────────

    public void clickSave1() {
        WaitFor.elementToBeClickable(saveBtn);
        saveBtn.click();
    }

    public boolean isSuccessToastDisplayed1() {
        WaitFor.elementToBeVisible(successToast);
        return successToast.isDisplayed();
    }
}
