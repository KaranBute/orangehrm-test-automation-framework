package com.skillio.stepdefinitions;

import com.skillio.base.Keyword;
import com.skillio.pages.LoginPage;

import io.cucumber.java.en.Given;

/**
 * SharedSteps — common step definitions reused across multiple feature files.
 *
 * IMPORTANT: Cucumber shares step definitions across all glue-code classes.
 * This class centralizes the "user is logged into OrangeHRM as {string}" step
 * that is referenced in Background blocks across Admin, PIM, Leave, Recruitment,
 * and MyInfo features.
 *
 * If DashboardSteps.java already defines @Given("user is logged into OrangeHRM")
 * (without a role parameter), these two steps do NOT conflict — they are
 * distinct patterns. Place this class in the same package as other step definitions.
 */
public class SharedSteps {

    private LoginPage loginPage = new LoginPage();

    /**
     * Launches OrangeHRM and logs in based on the specified role.
     *
     * Supported roles:
     *   "Admin"    → Admin / admin123
     *   "Employee" → Orange / admin123 (OrangeHRM demo employee account)
     *
     * @param role the role string from the feature file ("Admin" or "Employee")
     */
    @Given("user is logged into OrangeHRM as {string}")
    public void userIsLoggedIntoOrangeHRMAs(String role) {
        Keyword.getDriver().get(
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );

        if ("Admin".equalsIgnoreCase(role)) {
            loginPage.loginWithCredentials("Admin", "admin123");
        } else if ("Employee".equalsIgnoreCase(role)) {
            // OrangeHRM public demo employee login — adjust if using a different account
            loginPage.loginWithCredentials("Orange", "admin123");
        } else {
            throw new IllegalArgumentException(
                "Unknown role [" + role + "]. Supported values: Admin, Employee"
            );
        }
    }
}