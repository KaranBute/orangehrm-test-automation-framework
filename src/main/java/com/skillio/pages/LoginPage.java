package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.skillio.base.Keyword;
import com.skillio.locators.LoginLocator;
import com.skillio.utils.WaitFor;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(name = "username")
    private WebElement userNameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInBtn;

    @FindBy(css = "p.oxd-alert-content-text")
    private WebElement loginErrorMsg;

    public void enterUserName(String userName) {
        WaitFor.elementToBeVisible(userNameField);
        userNameField.clear();
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WaitFor.elementToBeVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn() {
        WaitFor.elementToBeClickable(signInBtn);
        signInBtn.click();
    }

    public void loginWithCredentials(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickSignInBtn();
    }

    public void navigateToLoginPage() {
        // Already on login page from Hooks; ensure it's visible
        WaitFor.elementToBeVisible(By.name("username"));
    }

    public void clickLoginButton() {
        WaitFor.elementToBeClickable(signInBtn);
        signInBtn.click();
    }

    public String getLoginErrorMessage() {
        WaitFor.elementToBeVisible(By.cssSelector("p.oxd-alert-content-text"));
        return loginErrorMsg.getText().trim();
    }

    public String getUsernameFieldError() {
        WaitFor.elementToBeVisible(By.xpath(LoginLocator.USERNAME_ERROR));
        return Keyword.getDriver().findElement(By.xpath(LoginLocator.USERNAME_ERROR)).getText().trim();
    }

    public String getPasswordFieldError() {
        WaitFor.elementToBeVisible(By.xpath(LoginLocator.PASSWORD_ERROR));
        return Keyword.getDriver().findElement(By.xpath(LoginLocator.PASSWORD_ERROR)).getText().trim();
    }
}
