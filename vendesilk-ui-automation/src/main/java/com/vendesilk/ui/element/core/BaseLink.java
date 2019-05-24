package com.vendesilk.ui.element.core;

import com.vendesilk.ui.element.behavior.Clickable;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.support.WorkingMemory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseLink extends BaseElement {
    private WebElement element;
    private RemoteWebDriver driver;
    private By locator;
    private Clickable mouse;
    private static final String INNER_HTML = "innerHTML";
    //final static Logger log = Logger.getLogger(BaseLink.class);;

    public BaseLink(RemoteWebDriver driver, By locator) {
        super(driver, locator);
        this.driver = driver;
        this.locator = locator;
        this.mouse = new Clickable();

    }

    /**
     * Performs a click in the middle of the element.
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void click() throws ApplicationException, ScriptException {
        mouse.click(driver, locator);
    }

    /**
     * Performs a click on the element if it exists.
     */
    public void clickIfExists() {
        try {

            waitTillElementVisible(5000);
            mouse.click(driver, locator);

        } catch (Exception e) {
            //log.error("exception :", e);
        }
    }

    /**
     * Verify if the element has the exact text as given.
     * @param text value to compare with.
     * @return <CODE>true</CODE> if element text equals to the provided text.
     */
    @Override
    public boolean verifyElementTextIs(String text) {
        element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        return element.getText().compareTo(text) == 0 || element.getAttribute(INNER_HTML).compareTo(text) == 0;
    }

    /**
     * Verify if the element text has the exact text ignoring case sensitive.
     * @param text value to compare with.
     * @return <CODE>true</CODE> if the element text equals to provided
     * text(ignoring case sensitive).
     */
    @Override
    public boolean verifyElementTextIsIgnoreCase(String text) {
        element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        return element.getText().compareToIgnoreCase(text) == 0 || element.getAttribute(INNER_HTML).compareToIgnoreCase(text) == 0;
    }

    /**
     * Verify if the element contains the provided text.
     * @param text value to compare with.
     * @return <CODE>true</CODE> if element contains the provided text.
     */
    @Override
    public boolean verifyElementTextContains(String text) {
        element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        return element.getText().contains(text) || element.getAttribute(INNER_HTML).contains(text);
    }

    /**
     * Verify if the element has the exact memorized text.
     * @param memoryKey is the memorized text to compare with.
     * @return <CODE>true</CODE> if element text equals to the memorized text.
     */
    @Override
    public boolean verifyElementMemorizedTextIs(String memoryKey) {
        element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        return element.getText().compareTo(memVal) == 0 || element.getAttribute(INNER_HTML).compareTo(memVal) == 0;
    }

    /**
     * Verify if the element has the exact memorized text ignoring case
     * sensitive.
     * @param memoryKey is the memorized text to compare with.
     * @return <CODE>true</CODE> if element text equals to the memorized
     * text(ignoring case sensitive).
     */
    @Override
    public boolean verifyElementMemorizedTextIsIgnoreCase(String memoryKey) {
        element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        return element.getText().compareToIgnoreCase(memVal) == 0 || element.getAttribute(INNER_HTML).compareToIgnoreCase(memVal) == 0;
    }

    /**
     * Verify if the element contains provided memorized text.
     * @param memoryKey is the memorized text to compare with.
     * @return <CODE>true</CODE> if element contains the memorized text.
     */
    @Override
    public boolean verifyElementContainsMemorizedText(String memoryKey) {
        element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        return element.getText().contains(memVal) || element.getAttribute(INNER_HTML).contains(memVal);
    }

    /**
     * Performs a click on the button and exit the modal dialog.
     */
    public void clickLinkAndExitModalDialog() {
        element = driver.findElement(locator);
        element.click();
        WorkingMemory wMem = WorkingMemory.getInstance();
        String parent = wMem.getMemory("MODAL_DIALOG_PARENT");
        driver.switchTo().window(parent);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //log.error("exception :", e);
        }
    }

    public boolean verifyElementMemorizedTextIsIncreasedBy(String memoryKey, String count) {
        element = driver.findElement(locator);
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        Integer increasedMemVal = Integer.parseInt(memVal) + Integer.parseInt(count);

        return element.getAttribute("textContent").compareTo(increasedMemVal.toString()) == 0;
    }

    /**
     * Mouse hover on an element
     */
    public void mouseHover() {
        try {
            element = driver.findElement(locator);
            String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                    "arguments[0].dispatchEvent(evObj);";
            ((JavascriptExecutor) driver).executeScript(javaScript, element);
        } catch (Exception e) {
            //log.error("Exception :", e);
        }
    }

    /**
     * Mouse hover on an element and click on it
     */
    public void mouseHoverAndClick() {
        try {
            element = driver.findElement(locator);

            String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                    "arguments[0].dispatchEvent(evObj);";
            ((JavascriptExecutor) driver).executeScript(javaScript, element);
            element.click();
        } catch (Exception e) {
            //log.error("Exception :", e);
        }
    }
}
