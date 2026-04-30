package com.skillio.base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.skillio.exceptions.InvalidBrowserNameException;

/**
 * Keyword — keyword-driven framework engine.
 * FIX 1: All interactions use explicit waits. NO Thread.sleep() anywhere.
 * FIX 2: Window maximised; implicit wait REMOVED (mixing breaks explicit waits).
 * FIX 3: NoSuchElementException and TimeoutException caught with clear messages.
 * FIX 4: ThreadLocal keeps drivers isolated for parallel execution.
 */
public class Keyword {

    public static final ThreadLocal<RemoteWebDriver> threadLocal = new ThreadLocal<>();
    private static final int WAIT_TIMEOUT_SECONDS = 30;

    // ── Driver access ────────────────────────────────────────────────────────
    public static RemoteWebDriver getDriver() {
        RemoteWebDriver driver = threadLocal.get();
        if (driver == null) {
            throw new RuntimeException(
                "[Keyword] WebDriver NOT initialised. " +
                "Ensure Hooks @Before has run before this step.");
        }
        return driver;
    }

    // ── Browser lifecycle ────────────────────────────────────────────────────
    public static void openBrowser(String browserName) {
        System.out.println("[Keyword] Opening browser: " + browserName);
        if (browserName == null || browserName.trim().isEmpty())
            throw new InvalidBrowserNameException("null/empty");

        RemoteWebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome": {
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--disable-notifications", "--disable-popup-blocking");
                driver = new ChromeDriver(opts);
                break;
            }
            case "firefox":
                driver = new FirefoxDriver(new FirefoxOptions());
                break;
            default:
                throw new InvalidBrowserNameException(browserName);
        }

        threadLocal.set(driver);
        driver.manage().window().maximize(); // FIX: prevents element-not-interactable errors
        // FIX: page load timeout only — NO implicit wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        System.out.println("[Keyword] Browser launched and maximised.");
    }

    public static void launchUrl(String url) {
        System.out.println("[Keyword] Launching URL: " + url);
        getDriver().get(url);
    }

    public static void quitBrowser() {
        RemoteWebDriver driver = threadLocal.get();
        if (driver == null) { System.out.println("[Keyword] No driver to quit."); return; }
        try {
            driver.quit();
            System.out.println("[Keyword] Browser closed.");
        } catch (Exception e) {
            System.err.println("[Keyword] Error quitting: " + e.getMessage());
        } finally {
            threadLocal.remove(); // FIX: prevents memory leak in parallel runs
        }
    }

    // ── Keyword actions (all use explicit waits) ─────────────────────────────
    /** Waits for clickability, clears field, types text. */
    public static void enterText(String locatorType, String locatorValue, String text) {
        System.out.println("[Keyword] enterText [" + locatorType + "] " + locatorValue);
        WebElement el = getElementClickable(locatorType, locatorValue);
        el.clear();
        el.sendKeys(text);
    }

    /** Waits for clickability, then clicks. */
    public static void clickOn(String locatorType, String locatorValue) {
        System.out.println("[Keyword] clickOn [" + locatorType + "] " + locatorValue);
        getElementClickable(locatorType, locatorValue).click();
    }

    /** Waits for visibility, returns text. */
    public static String getText(String locatorType, String locatorValue) {
        return getElementVisible(locatorType, locatorValue).getText().trim();
    }

    public static boolean isElementDisplayed(String locatorType, String locatorValue) {
        try { return getElementVisible(locatorType, locatorValue).isDisplayed(); }
        catch (Exception e) { return false; }
    }

    // ── Internal helpers ─────────────────────────────────────────────────────
    private static WebElement getElementVisible(String type, String value) {
        try {
            return buildWait().until(
                ExpectedConditions.visibilityOfElementLocated(buildBy(type, value)));
        } catch (TimeoutException e) {
            throw new TimeoutException(
                "[Keyword] TIMEOUT — element NOT VISIBLE: [" + type + "] " + value +
                "\n  Check locator is correct and page has loaded.", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                "[Keyword] NOT FOUND: [" + type + "] " + value);
        }
    }

    private static WebElement getElementClickable(String type, String value) {
        try {
            return buildWait().until(
                ExpectedConditions.elementToBeClickable(buildBy(type, value)));
        } catch (TimeoutException e) {
            throw new TimeoutException(
                "[Keyword] TIMEOUT — element NOT CLICKABLE: [" + type + "] " + value +
                "\n  Element may be hidden, disabled, or overlapped.", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                "[Keyword] NOT FOUND: [" + type + "] " + value);
        }
    }

    private static WebDriverWait buildWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    private static By buildBy(String type, String value) {
        switch (type.trim().toLowerCase()) {
            case "id":              return By.id(value);
            case "name":            return By.name(value);
            case "classname":       return By.className(value);
            case "tagname":         return By.tagName(value);
            case "linktext":        return By.linkText(value);
            case "partiallinktext": return By.partialLinkText(value);
            case "cssselector":     return By.cssSelector(value);
            case "xpath":           return By.xpath(value);
            default: throw new InvalidSelectorException(
                "[Keyword] Unknown locator type: '" + type + "'");
        }
    }
}