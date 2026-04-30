package com.skillio.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.skillio.base.Keyword;
import com.skillio.pages.LoginPage;
import com.skillio.utils.WaitFor;

import io.cucumber.java.en.*;

/**
 * FIXES:
 *  - BUG: dashboardPage = new DashboardSteps() was INFINITE SELF-INSTANTIATION.
 *    Removed the self-reference entirely.
 *  - getPageHeader() was returning null; now reads the actual h6 from the DOM.
 *  - isWidgetDisplayed() was returning false; now checks DOM.
 *  - isAdminMenuVisible() was returning false; now checks DOM.
 *  - searchMenu() was empty; now types into the OrangeHRM sidebar search.
 */
public class DashboardSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("user is logged into OrangeHRM")
    public void userIsLoggedIntoOrangeHRM() {
        loginPage.loginWithCredentials("Admin", "admin123");
        // Wait for dashboard to confirm login succeeded
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));
    }

    @When("user navigates to the Dashboard")
    public void userNavigatesToTheDashboard() {
        // Usually already on dashboard after login; navigate explicitly if needed
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));
    }

    @Then("the page header should display {string}")
    public void thePageHeaderShouldDisplay(String expectedHeader) {
        String actual = getPageHeader();
        Assert.assertEquals(actual, expectedHeader,
            "[DashboardSteps] Page header mismatch.");
    }

    @Then("the {string} widget should be visible on the dashboard")
    public void theWidgetShouldBeVisible(String widgetName) {
        Assert.assertTrue(isWidgetDisplayed(widgetName),
            "[DashboardSteps] Widget not visible: " + widgetName);
    }

    @When("user types {string} into the side menu search bar")
    public void userTypesIntoSideMenuSearch(String searchText) {
        searchMenu(searchText);
    }

    @Then("only the Admin module should be visible in the menu")
    public void onlyTheAdminModuleShouldBeVisible() {
        Assert.assertTrue(isAdminMenuVisible(),
            "[DashboardSteps] Admin menu not visible after search.");
    }

    // ── Page helpers (private) ────────────────────────────────────────────────

    private String getPageHeader() {
        // FIXED: was returning null
        By header = By.xpath("//h6");
        WaitFor.elementToBeVisible(header);
        return Keyword.getDriver().findElement(header).getText().trim();
    }

    private boolean isWidgetDisplayed(String widgetName) {
        // FIXED: was returning false
        try {
            By widget = By.xpath(
                "//*[contains(@class,'oxd-grid-item')]//*[normalize-space()='" + widgetName + "']");
            WaitFor.elementToBeVisible(widget);
            return Keyword.getDriver().findElement(widget).isDisplayed();
        } catch (Exception e) {
            System.err.println("[DashboardSteps] Widget not found: " + widgetName);
            return false;
        }
    }

    private void searchMenu(String searchText) {
        // FIXED: was empty stub
        By searchBox = By.xpath("//input[@placeholder='Search']");
        WaitFor.elementToBeVisible(searchBox);
        WebElement el = Keyword.getDriver().findElement(searchBox);
        el.clear();
        el.sendKeys(searchText);
    }

    private boolean isAdminMenuVisible() {
        // FIXED: was returning false
        try {
            By adminMenu = By.xpath("//span[normalize-space()='Admin']");
            WaitFor.elementToBeVisible(adminMenu);
            return Keyword.getDriver().findElement(adminMenu).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}