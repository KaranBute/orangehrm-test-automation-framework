package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.skillio.base.Keyword;
import com.skillio.utils.WaitFor;

public class DashboardPage {

    WebDriver driver = Keyword.getDriver();

    // Locators
    private By pageHeaderTitle = By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]");
    private By menuSearchInput = By.xpath("//input[@placeholder='Search']");
    private By adminMenuLink = By.xpath("//a[contains(@href, 'viewAdminModule')]");

    private By getWidgetHeader(String widgetName) {
        return By.xpath("//p[text()='" + widgetName + "']");
    }

    public String getPageHeader() {
        return driver.findElement(pageHeaderTitle).getText();
    }

    public boolean isWidgetDisplayed(String widgetName) {
        return driver.findElement(getWidgetHeader(widgetName)).isDisplayed();
    }

    public void searchMenu(String searchText) {
        driver.findElement(menuSearchInput).clear();
        driver.findElement(menuSearchInput).sendKeys(searchText);
    }

    public boolean isAdminMenuVisible() {
        return driver.findElement(adminMenuLink).isDisplayed();
    }
    
 

    // ─── LOCATORS ──────────────────────────────────────────────────────────

    private By pageHeaderTitle1   = By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]");
    private By menuSearchInput1   = By.xpath("//input[@placeholder='Search']");
    private By adminMenuLink1     = By.xpath("//a[contains(@href, 'viewAdminModule')]");

    private By getWidgetHeader1(String widgetName) {
        return By.xpath("//p[text()='" + widgetName + "']");
    }

    // ─── EXISTING METHODS (unchanged) ─────────────────────────────────────

    public String getPageHeader1() {
        WaitFor.elementToBeVisible(pageHeaderTitle);
        return driver.findElement(pageHeaderTitle).getText();
    }

    public boolean isWidgetDisplayed1(String widgetName) {
        By widget = getWidgetHeader(widgetName);
        WaitFor.elementToBeVisible(widget);
        return driver.findElement(widget).isDisplayed();
    }

    public void searchMenu1(String searchText) {
        driver.findElement(menuSearchInput).clear();
        driver.findElement(menuSearchInput).sendKeys(searchText);
    }

    public boolean isAdminMenuVisible1() {
        return driver.findElement(adminMenuLink).isDisplayed();
    }

    // ─── NEW METHOD (TC_DASH_05) ──────────────────────────────────────────

    /**
     * Clicks a menu item in the left-hand side navigation.
     * Example: clickSideNavMenu("Admin") navigates to the Admin module.
     *
     * @param menuItem visible text of the nav span (e.g., "Admin", "PIM", "Leave")
     */
    public void clickSideNavMenu(String menuItem) {
        By navItem = By.xpath("//span[text()='" + menuItem + "']");
        WaitFor.elementToBeClickable(navItem);
        driver.findElement(navItem).click();
    }
}
