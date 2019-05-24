package com.vendesilk.ui.element.core;

import com.vendesilk.ui.element.behavior.Clickable;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.support.WorkingMemory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseButton extends BaseElement {

    private WebElement element;
    private RemoteWebDriver driver;
    private By locator;
    private Clickable mouse;
    //final static Logger log = Logger.getLogger(BaseButton.class);

    public BaseButton(RemoteWebDriver driver, By locator) {
        super(driver, locator);
        this.mouse = new Clickable();
        this.driver = driver;
        this.locator = locator;

    }

    /**
     * Generic basse  click event
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void click() throws ApplicationException, ScriptException {
        mouse.click(driver, locator);

    }

    /**
     * Performs click event if element is exist
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
     * Performs a click on the button and exit the modal dialog.
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void clickButtonAndExitModalDialog() throws ApplicationException, ScriptException {
        mouse.click(driver, locator);
        WorkingMemory wMem = WorkingMemory.getInstance();
        String parent = wMem.getMemory("MODAL_DIALOG_PARENT");
        driver.switchTo().window(parent);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //log.error("exception :", e);
        }
    }

    /**
     * Verify the element is disabled.
     * @return return <CODE>true</CODE> the element is disabled
     */
    @Override
    public boolean isDisabled() {
        boolean status = false;
        try {
            this.element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!element.isEnabled()) {
                status = true;
            } else if (element.getAttribute("disabled") != null) {
                status = true;
            } else if (element.getAttribute("class").contains("rtbDisabled")) {
                status = true;
            }
        } catch (TimeoutException e) {
            throw new ApplicationException("Time out after waiting for element");
        } catch (ElementNotVisibleException e) {
            throw new ScriptException("Element Not Clickable");
        } catch (InvalidElementStateException e) {
            throw new ApplicationException("Element Not editable");
        } catch (StaleElementReferenceException e) {
            throw new ScriptException("Element No longer attached to page DOM");
        } catch (NoSuchElementException e) {
            throw new ApplicationException("No such element with expression : " + locator);
        } finally {
            return status;
        }
    }

    /**
     * Verify if the element is enabled
     * @return return <CODE>true</CODE> the element is enabled
     * @throws ApplicationException
     * @throws ScriptException
     */
    @Override
    public boolean isEnabled() throws ApplicationException, ScriptException {
        try {
            this.element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            if (element.getAttribute("disabled") != null) {
                return false;
            } else if (element.getAttribute("class").contains("rtbDisabled")) {
                return false;
            }
            return element.isEnabled();
        } catch (TimeoutException e) {
            throw new ApplicationException("Time out after waiting for element");
        } catch (ElementNotVisibleException e) {
            throw new ScriptException("Element Not Clickable");
        } catch (InvalidElementStateException e) {
            throw new ApplicationException("Element Not editable");
        } catch (StaleElementReferenceException e) {
            throw new ScriptException("Element No longer attached to page DOM");
        } catch (NoSuchElementException e) {
            throw new ApplicationException("No such element with expression : " + locator);
        }
    }

    /**
     * Memorize element text
     * @param memoryKey
     */
    public void memorizeElementText(String memoryKey) {
        element = driver.findElement(locator);
        String memText = element.getAttribute("value").toString();
        WorkingMemory wMem = WorkingMemory.getInstance();
        wMem.setMemory(memoryKey, memText);
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
