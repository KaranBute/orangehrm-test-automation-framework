package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.locators.PimLocator;
import com.skillio.utils.WaitFor;

public class PimPage {

    public PimPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    // LOCATORS
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addEmployeeBtn;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "employeeId")
    private WebElement empId;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;

    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successToast;

    @FindBy(xpath = "//span[text()='Already exists']")
    private WebElement duplicateIdError;

    @FindBy(xpath = "//span[text()='Required']")
    private WebElement requiredError;

    // ACTIONS
    public void navigateToPim() {
        WaitFor.elementToBeClickable(pimMenu);
        pimMenu.click();
    }

    public void clickAddEmployee() {
        WaitFor.elementToBeClickable(addEmployeeBtn);
        addEmployeeBtn.click();
    }

    public void enterEmployeeDetails(String fName, String lName, String id) {

        if (!fName.isEmpty()) {
            WaitFor.elementToBeVisible(firstName);
            firstName.clear();
            firstName.sendKeys(fName);
        }

        if (!lName.isEmpty()) {
            lastName.clear();
            lastName.sendKeys(lName);
        }

        if (!id.isEmpty()) {
            empId.clear();
            empId.sendKeys(id);
        }
    }

    public void clickSave() {
        WaitFor.elementToBeClickable(saveBtn);
        saveBtn.click();
    }

    public void searchEmployee(String name) {
        // You can extend with search locator
    }

    public void clearNameFields() {
        firstName.clear();
        lastName.clear();
    }

    // BUSINESS METHOD
    public void addEmployee(String fName, String lName, String id) {
        navigateToPim();
        clickAddEmployee();
        enterEmployeeDetails(fName, lName, id);
        clickSave();
    }

    // VALIDATIONS
    public boolean isSuccessToastDisplayed() {
        WaitFor.elementToBeVisible(successToast);
        return successToast.isDisplayed();
    }

    public boolean isDuplicateIdErrorDisplayed() {
        return duplicateIdError.isDisplayed();
    }

    public boolean isRequiredErrorDisplayed() {
        return requiredError.isDisplayed();
    }
    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

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

    public void navigateToMyInfo() {
        WaitFor.elementToBeClickable(myInfoMenu);
        myInfoMenu.click();
    }

    public void clickTab(String tabName) {
        By tab = By.xpath("//a[normalize-space()='" + tabName + "']");
        WaitFor.elementToBeClickable(tab);
        Keyword.getDriver().findElement(tab).click();
    }

    // ─── PERSONAL DETAILS ─────────────────────────────────────────────────

    public void selectNationality(String nationality) {
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

	public boolean isEmployeePresentInResults(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNoRecordsMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmployeeTableVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	public void uploadProfilePhoto(String filePath) {
		// TODO Auto-generated method stub
		
	}

	public void selectEmploymentStatusFilter(String status) {
		// TODO Auto-generated method stub
		
	}

	public void clickProfilePhotoUpload() {
		// TODO Auto-generated method stub
		
	}

	public void ensureSearchFilterVisible() {
		// TODO Auto-generated method stub
		
	}

	public void selectJobTitle(String jobTitle) {
	
	}
	public void clickSearch() {
	    WaitFor.elementToBeClickable(By.xpath(PimLocator.SEARCH_BUTTON));
	    Keyword.getDriver().findElement(By.xpath(PimLocator.SEARCH_BUTTON)).click();
	}

	public void openEmployeeRecord(String employeeName) {
		// TODO Auto-generated method stub
		
	}

	public void enterEmployeeId(String id) {
		// TODO Auto-generated method stub
		
	}
}