package com.vendesilk.ui.element.core;

import com.vendesilk.ui.element.behavior.Clickable;
import com.vendesilk.ui.element.behavior.Tickable;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseCheckBox extends BaseElement {
    private WebElement element;
    private RemoteWebDriver driver;
    private By locator;
    private Clickable mouse;
    private Tickable tickable;

    //final static Logger log = Logger.getLogger(BaseCheckBox.class);

    public BaseCheckBox(RemoteWebDriver driver, By locator) {
        super(driver, locator);
        mouse = new Clickable();
        this.driver = driver;
        this.locator = locator;
        tickable = new Tickable();
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
     * Ticks the Checkbox if it is not selected.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void check() throws ScriptException, ApplicationException {
        tickable.check(driver, locator);
    }

    /**
     * Unticks the Checkbox if it already selected.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void unCheck() throws ScriptException, ApplicationException {
        tickable.unCheck(driver, locator);
    }

    /**
     * Click check-box is available.
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void clickIfExists() throws ApplicationException, ScriptException {
        Boolean isPresent = !driver.findElements(locator).isEmpty();
        if (isPresent) {
            mouse.click(driver, locator);
        }

    }

    /**
     * Verify the element is disabled.
     * @return return <CODE>true</CODE> the element is disabled.
     */
    @Override
    public boolean isDisabled() {
        boolean status = false;
        try{
            this.element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!element.isEnabled()) {
                status = true;
            } else if (element.getAttribute("disabled") != null) {
                status = true;
            } else if (element.getAttribute("class").contains("rtbDisabled")) {
                status = true;
            }
        }catch (TimeoutException e) {
            throw new ApplicationException("Time out after waiting for element");
        }catch (ElementNotVisibleException e) {
            throw new ScriptException("Element Not Clickable");
        }catch (InvalidElementStateException e) {
            throw new ApplicationException("Element Not editable");
        }catch (StaleElementReferenceException e) {
            throw new ScriptException("Element No longer attached to page DOM");
        }catch (NoSuchElementException e){
            throw new ApplicationException("No such element with expression : " +locator);
        }finally {
            return status;
        }
    }

    /**
     * Verify if the element is enabled.
     * @return return <CODE>true</CODE> the element is enabled.
     * @throws ApplicationException
     * @throws ScriptException
     */
    @Override
    public boolean isEnabled() throws ApplicationException, ScriptException {
        try{
            this.element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            if (element.getAttribute("class").contains("rtbDisabled")) {
                return false;
            }
            return element.isEnabled();
        }catch (TimeoutException e) {
            throw new ApplicationException("Time out after waiting for element");
        }catch (ElementNotVisibleException e) {
            throw new ScriptException("Element Not Clickable");
        }catch (InvalidElementStateException e) {
            throw new ApplicationException("Element Not editable");
        }catch (StaleElementReferenceException e) {
            throw new ScriptException("Element No longer attached to page DOM");
        }catch (NoSuchElementException e){
            throw new ApplicationException("No such element with expression : " +locator);
        }

    }

    /**
     * Verify if the element is checked.
     * @return <CODE>true</CODE> the element is checked.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public boolean verifyChecked() throws ScriptException, ApplicationException {
        return tickable.verifyChecked(driver, locator);
    }

    /**
     * Verify if the element is not checked.
     * @return <CODE>true</CODE> the element is not checked.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public boolean verifyUnchecked() throws ScriptException, ApplicationException {
        return tickable.verifyUnchecked(driver, locator);
    }

}
