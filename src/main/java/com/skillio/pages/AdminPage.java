package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.skillio.base.Keyword;
import com.skillio.locators.AdminLocator;
import com.skillio.utils.WaitFor;

public class AdminPage {

    public AdminPage() {
        PageFactory.initElements(Keyword.getDriver(), this); // FIXED
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    public void clickAdd() {
        WaitFor.elementToBeClickable(By.xpath(AdminLocator.ADD_BUTTON));
        addButton.click();
    }
}