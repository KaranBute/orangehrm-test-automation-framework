package com.skillio.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.skillio.base.Keyword;
import com.skillio.pages.LoginPage;
import com.skillio.utils.WaitFor;

import io.cucumber.java.en.*;

public class DashboardSteps {

    private LoginPage loginPage;

    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    @Given("user is logged into OrangeHRM as {string}")
    public void userIsLoggedIntoOrangeHRMAs(String role) {
        getLoginPage().loginWithCredentials("Admin", "admin123");
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));
    }

    @Given("user is logged into OrangeHRM")
    public void userIsLoggedIntoOrangeHRM() {
        getLoginPage().loginWithCredentials("Admin", "admin123");
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));
    }

    @When("user navigates to the Dashboard")
    public void userNavigatesToTheDashboard() {
        WaitFor.elementToBeVisible(By.xpath("//h6[normalize-space()='Dashboard']"));
    }

    @When("user clicks on {string} from the left side navigation menu")
    public void userClicksOnFromLeftSideNav(String menuItem) {
        By navItem = By.xpath("//span[normalize-space()='" + menuItem + "']");
        WaitFor.elementToBeClickable(navItem);
        Keyword.getDriver().findElement(navItem).click();

        By header = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module') or normalize-space()='" + menuItem + "']");
        WaitFor.elementToBeVisible(header);
    }

    @Then("the dashboard page header should display {string}")
    public void theDashboardPageHeaderShouldDisplay(String expectedHeader) {
        By header = By.xpath("//h6");
        WaitFor.elementToBeVisible(header);

        String actual = Keyword.getDriver().findElement(header).getText().trim();

        Assert.assertEquals(
                actual,
                expectedHeader,
                "[DashboardSteps] Page header mismatch.");
    }

    @Then("the {string} widget should be visible on the dashboard")
    public void theWidgetShouldBeVisible(String widgetName) {
        By widget = By.xpath("//*[normalize-space()='" + widgetName + "']");
        WaitFor.elementToBeVisible(widget);

        Assert.assertTrue(
                Keyword.getDriver().findElement(widget).isDisplayed(),
                "[DashboardSteps] Widget not visible: " + widgetName);
    }

    @When("user types {string} into the side menu search bar")
    public void userTypesIntoSideMenuSearch(String searchText) {
        By searchBox = By.xpath("//input[@placeholder='Search']");
        WaitFor.elementToBeVisible(searchBox);

        WebElement el = Keyword.getDriver().findElement(searchBox);
        el.clear();
        el.sendKeys(searchText);
    }

    @Then("only the Admin module should be visible in the menu")
    public void onlyTheAdminModuleShouldBeVisible() {
        By adminMenu = By.xpath("//span[normalize-space()='Admin']");
        WaitFor.elementToBeVisible(adminMenu);

        Assert.assertTrue(
                Keyword.getDriver().findElement(adminMenu).isDisplayed(),
                "[DashboardSteps] Admin menu not visible after search.");
    }
    
    @Then("the page header should display {string}")
    public void thePageHeaderShouldDisplayOld(String expectedHeader) {
        theDashboardPageHeaderShouldDisplay(expectedHeader);
    }
}