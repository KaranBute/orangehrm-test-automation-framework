package com.skillio.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillio.base.Keyword;

/** Central explicit wait + safe action utility for OrangeHRM dynamic DOM. */
public final class WaitFor {

    private WaitFor() {}

    private static final int DEFAULT_TIMEOUT_SEC = 30;
    private static final int POLLING_MS = 500;

    private static WebDriverWait buildWait() {
        RemoteWebDriver driver = Keyword.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SEC));
        wait.pollingEvery(Duration.ofMillis(POLLING_MS));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait;
    }

    public static void loaderToBeInvisible() {
        try {
            buildWait().until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".oxd-form-loader, .oxd-loading-spinner, .v3-spinner, .oxd-loading-spinner-container")));
        } catch (Exception ignored) {}
    }

    public static WebElement visible(By by) {
        try {
            return buildWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException("[WaitFor] TIMEOUT — NOT VISIBLE: " + by + "\nVerify locator and page state.", e);
        }
    }

    public static WebElement clickable(By by) {
        loaderToBeInvisible();
        try {
            return buildWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            throw new TimeoutException("[WaitFor] TIMEOUT — NOT CLICKABLE: " + by + "\nMay be hidden, disabled, or overlapped.", e);
        }
    }

    public static void elementToBeVisible(By by) { visible(by); }
    public static void elementToBeClickable(By by) { clickable(by); }

    public static void elementToBePresent(By by) {
        try {
            buildWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException("[WaitFor] TIMEOUT — NOT PRESENT: " + by, e);
        }
    }

    public static void elementToBeInvisible(By by) {
        try { buildWait().until(ExpectedConditions.invisibilityOfElementLocated(by)); }
        catch (Exception ignored) {}
    }

    public static void elementToBeVisible(WebElement element) {
        try { buildWait().until(ExpectedConditions.visibilityOf(element)); }
        catch (TimeoutException e) { throw new TimeoutException("[WaitFor] TIMEOUT — WebElement not visible.", e); }
    }

    public static void elementToBeClickable(WebElement element) {
        loaderToBeInvisible();
        try { buildWait().until(ExpectedConditions.elementToBeClickable(element)); }
        catch (TimeoutException e) { throw new TimeoutException("[WaitFor] TIMEOUT — WebElement not clickable.", e); }
    }

    public static void click(By by) {
        for (int i = 0; i < 3; i++) {
            try {
                WebElement element = clickable(by);
                scrollTo(element);
                element.click();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                sleep(500);
            }
        }
        WebElement element = visible(by);
        jsClick(element);
    }

    public static void click(WebElement element) {
        for (int i = 0; i < 3; i++) {
            try {
                elementToBeClickable(element);
                scrollTo(element);
                element.click();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                sleep(500);
            }
        }
        jsClick(element);
    }

    public static void type(By by, String text) {
        WebElement element = visible(by);
        scrollTo(element);
        try {
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
        } catch (ElementNotInteractableException e) {
            setValueByJs(element, text);
        }
    }

    public static void type(WebElement element, String text) {
        elementToBeVisible(element);
        scrollTo(element);
        try {
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
        } catch (ElementNotInteractableException e) {
            setValueByJs(element, text);
        }
    }

    public static void typeAndTab(By by, String text) {
        type(by, text);
        visible(by).sendKeys(Keys.TAB);
    }

    public static void typeAndTab(WebElement element, String text) {
        type(element, text);
        element.sendKeys(Keys.TAB);
    }

    public static void selectFromOpenListbox(String optionText) {
        By option = By.xpath("//div[@role='listbox']//span[normalize-space()='" + optionText + "']");
        click(option);
    }

    public static void listboxToBeVisible() { elementToBeVisible(By.cssSelector("div[role='listbox']")); }
    public static void listboxOptionToBeClickable(String optionText) { elementToBeClickable(By.xpath("//div[@role='listbox']//span[normalize-space()='" + optionText + "']")); }
    public static void suggestionListToBeVisible() { elementToBeVisible(By.xpath("//div[@role='listbox']//span")); }

    public static void urlToContain(String fragment) {
        try { buildWait().until(ExpectedConditions.urlContains(fragment)); }
        catch (TimeoutException e) { throw new TimeoutException("[WaitFor] TIMEOUT — URL does not contain: " + fragment, e); }
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Keyword.getDriver()).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    public static void jsClick(WebElement element) {
        ((JavascriptExecutor) Keyword.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void setValueByJs(WebElement element, String value) {
        ((JavascriptExecutor) Keyword.getDriver()).executeScript(
            "arguments[0].value=''; arguments[0].value=arguments[1];" +
            "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
            "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element, value);
    }

    public static void sleep(long millis) {
        try { Thread.sleep(millis); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public static WebElement elementToBeVisible1(By locator) {
        WebDriverWait wait = new WebDriverWait(Keyword.getDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
