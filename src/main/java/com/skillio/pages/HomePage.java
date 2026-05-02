package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;

/**
 * FIXES:
 *  - Replaced threadLocal.get() with getDriver() (enforces null-check).
 *  - Removed duplicate clickAdminMenu1().
 */
public class HomePage {

    public HomePage() {
        PageFactory.initElements(Keyword.getDriver(), this); // FIXED
    }

    @FindBy(xpath = "//span[normalize-space()='Admin']")
    private WebElement adminMenuLink;
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    private WebElement pimMenuLink;
    @FindBy(xpath = "//span[normalize-space()='Leave']")
    private WebElement leaveMenuLink;
    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitmentMenuLink;
    @FindBy(xpath = "//span[normalize-space()='My Info']")
    private WebElement myInfoMenuLink;

    public void waitForHomePageToLoad() {
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));
    }

    public void waitForAdminMenuToBeVisible() {
        WaitFor.elementToBeVisible(By.xpath("//span[normalize-space()='Admin']"));
    }

    public void clickAdminMenu() {
        WaitFor.elementToBeClickable(adminMenuLink);
        adminMenuLink.click();
    }

    public void clickPimMenu() {
        WaitFor.elementToBeClickable(pimMenuLink);
        pimMenuLink.click();
    }

    public void clickLeaveMenu() {
        WaitFor.elementToBeClickable(leaveMenuLink);
        leaveMenuLink.click();
    }

    public void clickRecruitmentMenu() {
        WaitFor.elementToBeClickable(recruitmentMenuLink);
        recruitmentMenuLink.click();
    }

    public void clickMyInfoMenu() {
        WaitFor.elementToBeClickable(myInfoMenuLink);
        myInfoMenuLink.click();
    }
}