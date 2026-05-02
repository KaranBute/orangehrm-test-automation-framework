package com.skillio.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.skillio.base.Keyword;
import com.skillio.locators.DashboardLocator;
import com.skillio.utils.WaitFor;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Keyword.getDriver(), this);
    }

    @FindBy(xpath = DashboardLocator.DASHBOARD_HEADER)
    private WebElement dashboardHeader;

    @FindBy(xpath = DashboardLocator.TIME_AT_WORK_WIDGET)
    private WebElement timeAtWorkWidget;

    private By pageHeaderLocator = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]");
    private By menuSearchInput   = By.xpath("//input[@placeholder='Search']");

    public String getPageHeader() {
        WaitFor.elementToBeVisible(pageHeaderLocator);
        return Keyword.getDriver().findElement(pageHeaderLocator).getText().trim();
    }

    public boolean isWidgetDisplayed(String widgetName) {
        try {
            By widget = By.xpath("//*[normalize-space()='" + widgetName + "']");
            WaitFor.elementToBeVisible(widget);
            return Keyword.getDriver().findElement(widget).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void searchMenu(String searchText) {
        WaitFor.elementToBeVisible(menuSearchInput);
        WebElement el = Keyword.getDriver().findElement(menuSearchInput);
        el.clear();
        el.sendKeys(searchText);
    }

    public boolean isAdminMenuVisible() {
        try {
            By adminMenu = By.xpath("//span[normalize-space()='Admin']");
            WaitFor.elementToBeVisible(adminMenu);
            return Keyword.getDriver().findElement(adminMenu).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSideNavMenu(String menuItem) {
        By navItem = By.xpath("//span[normalize-space()='" + menuItem + "']");
        WaitFor.elementToBeClickable(navItem);
        Keyword.getDriver().findElement(navItem).click();
    }

    public void assertDashboardHeaderVisible(String expectedText) {
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='" + expectedText + "']"));
        Assert.assertTrue(dashboardHeader.isDisplayed(),
            "Dashboard header '" + expectedText + "' not visible.");
    }

    public void assertTimeAtWorkWidgetDisplayed() {
        WaitFor.elementToBeVisible(By.xpath(DashboardLocator.TIME_AT_WORK_WIDGET));
        Assert.assertTrue(timeAtWorkWidget.isDisplayed(), "'Time at Work' widget not visible.");
    }

    public boolean isDashboardVisible() {
        try {
            WaitFor.elementToBeVisible(By.xpath(DashboardLocator.DASHBOARD_HEADER));
            return Keyword.getDriver().findElement(By.xpath(DashboardLocator.DASHBOARD_HEADER)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
