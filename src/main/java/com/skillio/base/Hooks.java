package com.skillio.base;

import com.skillio.utils.App;
import com.skillio.utils.WaitFor;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;

import static com.skillio.base.Keyword.*;

/**
 * Hooks — Cucumber lifecycle. Runs before/after each scenario.
 * FIX: Added waitForHomePageToLoad after URL launch so subsequent steps
 * don't interact with the page before it's fully rendered.
 */
public class Hooks {

    @Before
    public void setUp() {
        System.out.println("[Hooks] @Before — setting up browser.");
        openBrowser(App.getBrowserName());
        launchUrl(App.getappUrl("qa"));
        // Wait for login page to be ready before any scenario step runs
        WaitFor.elementToBeVisible(By.name("username"));
        System.out.println("[Hooks] Login page ready.");
    }

    @After
    public void tearDown() {
        System.out.println("[Hooks] @After — quitting browser.");
        quitBrowser();
    }
}