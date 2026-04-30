package com.skillio.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.skillio.base.Keyword;

/**
 * WaitFor — centralised explicit-wait utility.
 * Every page/step must call this instead of Thread.sleep().
 */
public class WaitFor {

    private WaitFor() {}

    private static final int DEFAULT_TIMEOUT_SEC = 30;
    private static final int POLLING_MS = 500;

    private static WebDriverWait buildWait() {
        RemoteWebDriver driver = Keyword.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SEC));
        wait.pollingEvery(Duration.ofMillis(POLLING_MS));
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    // ── Loader/spinner handling ───────────────────────────────────────────────
    /**
     * Waits for OrangeHRM's loading spinner to disappear.
     * FIX: Updated CSS covers both known spinner class names.
     * Call before every Save/Submit click.
     */
    public static void loaderToBeInvisible() {
        try {
            buildWait().until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".oxd-form-loader, .oxd-loading-spinner, .v3-spinner")));
        } catch (Exception e) {
            // Spinner may not appear at all for fast responses — safe to continue.
        }
    }

    // ── By-based waits ────────────────────────────────────────────────────────
    public static void elementToBeVisible(By by) {
        try {
            buildWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException(
                "[WaitFor] TIMEOUT — NOT VISIBLE: " + by +
                "\n  Verify locator and page state.", e);
        }
    }

    public static void elementToBeClickable(By by) {
        loaderToBeInvisible();
        try {
            buildWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            throw new TimeoutException(
                "[WaitFor] TIMEOUT — NOT CLICKABLE: " + by +
                "\n  May be hidden, disabled, or overlapped.", e);
        }
    }

    public static void elementToBePresent(By by) {
        try {
            buildWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException("[WaitFor] TIMEOUT — NOT PRESENT: " + by, e);
        }
    }

    public static void elementToBeInvisible(By by) {
        try {
            buildWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            System.err.println("[WaitFor] WARNING — element still visible: " + by);
        }
    }

    // ── WebElement-based waits ────────────────────────────────────────────────
    public static void elementToBeVisible(WebElement element) {
        try {
            buildWait().until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new TimeoutException("[WaitFor] TIMEOUT — WebElement not visible.", e);
        }
    }

    public static void elementToBeClickable(WebElement element) {
        loaderToBeInvisible();
        try {
            buildWait().until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new TimeoutException("[WaitFor] TIMEOUT — WebElement not clickable.", e);
        }
    }

    // ── Helpers for OrangeHRM dropdowns and auto-complete ────────────────────
    /** Waits for the Vue custom listbox to appear after clicking a dropdown. */
    public static void listboxToBeVisible() {
        elementToBeVisible(By.cssSelector("div[role='listbox']"));
    }

    /** Waits for a specific listbox option to be clickable. */
    public static void listboxOptionToBeClickable(String optionText) {
        elementToBeClickable(By.xpath(
            "//div[@role='listbox']//span[normalize-space()='" + optionText + "']"));
    }

    /** Waits for the type-ahead suggestion list after typing in a hint field. */
    public static void suggestionListToBeVisible() {
        elementToBeVisible(By.xpath("//div[@role='listbox']//span"));
    }

    /** Waits for URL to contain a given fragment (useful for navigation checks). */
    public static void urlToContain(String fragment) {
        try {
            buildWait().until(ExpectedConditions.urlContains(fragment));
        } catch (TimeoutException e) {
            throw new TimeoutException(
                "[WaitFor] TIMEOUT — URL does not contain: " + fragment, e);
        }
    }
}