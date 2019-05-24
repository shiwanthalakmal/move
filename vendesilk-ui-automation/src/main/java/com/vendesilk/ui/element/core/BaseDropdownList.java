package com.vendesilk.ui.element.core;

import com.vendesilk.ui.element.behavior.Selectable;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.support.WorkingMemory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public abstract class BaseDropdownList extends BaseElement {
    private WebElement element;
    private RemoteWebDriver driver;
    private By locator;
    private Selectable selectable;
    //final static Logger log = Logger.getLogger(BaseDropdownList.class);

    public BaseDropdownList(RemoteWebDriver driver, By locator) {
        super(driver, locator);
        this.driver = driver;
        this.locator = locator;
        this.selectable = new Selectable();
    }

    /**
     * Selects an option from the dropdown using the option index.
     * @param index is the position of the option to be selected.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void select(Integer index) throws ScriptException, ApplicationException {
        selectable.select(driver, locator, index);
    }

    /**
     * Selects an option from the dropdown by the option text.
     * @param option is the text to be selected from the dropdown.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void selectByOption(String option) throws ScriptException, ApplicationException {
        selectable.selectByOption(driver, locator, option);
    }

    /**
     * Selects last option from the dropdown.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void selectLastOption() throws ScriptException, ApplicationException {
        WebElement element = driver.findElement(locator);
        int size = element.findElements(By.tagName("option")).size() - 1;
        selectable.select(driver, locator, size);
    }

    /**
     * Selects an option from the dropdown that contains the given text.
     * @param option is the text to be selected from the dropdown.
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void selectByOptionContains(String option) throws ScriptException, ApplicationException {
        selectable.selectByOptionContains(driver, locator, option);

    }

    /**
     * Verify if the element's option has the exact text as given.
     * @param text value to compare with.
     * @return <CODE>true</CODE> if element text equals to the provided text.
     * @throws ScriptException
     * @throws ApplicationException
     */
    @Override
    public boolean verifyElementTextIs(String text) throws ScriptException, ApplicationException {
        return selectable.verifyElementTextIs(driver, locator, text);
    }

    /**
     * Verify if the element text has the exact text ignoring case sensitive.
     * @param text value to compare with.
     * @return
     * @throws ScriptException
     * @throws ApplicationException
     */
    @Override
    public boolean verifyElementTextIsIgnoreCase(String text) throws ScriptException, ApplicationException {
        return selectable.verifyElementTextIsIgnoreCase(driver, locator, text);
    }

    /**
     * Verify if the element contains the provided text.
     * @param text value to compare with.
     * @return <CODE>true</CODE> if element contains the provided text.
     */
    @Override
    public boolean verifyElementTextContains(String text) {
        element = driver.findElement(locator);
        return element.getText().contains(text);
    }

    /**
     * Verify if the element has the exact memorized text.
     * @param memoryKey is the memorized text to compare with.
     * @return
     * @throws ScriptException
     * @throws ApplicationException
     */
    @Override
    public boolean verifyElementMemorizedTextIs(String memoryKey) throws ScriptException, ApplicationException {
        return selectable.verifyElementMemorizedTextIs(driver, locator, memoryKey);
    }

    /**
     * Verify if the element has the exact memorized text ignoring case
     * @param memoryKey is the memorized text to compare with.
     * @return
     * @throws ScriptException
     * @throws ApplicationException
     */
    @Override
    public boolean verifyElementMemorizedTextIsIgnoreCase(String memoryKey) throws ScriptException, ApplicationException {
        return selectable.verifyElementMemorizedTextIsIgnoreCase(driver, locator, memoryKey);
    }

    /**
     * Verify if the element contains provided memorized text.
     * @param memoryKey is the memorized text to compare with.
     * @return <CODE>true</CODE> if element contains the memorized text.
     */
    @Override
    public boolean verifyElementContainsMemorizedText(String memoryKey) {
        element = driver.findElement(locator);
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);

        if (memVal == null) {
            return false;
        }

        return element.getText().contains(memVal);
    }

    /**
     * Verify if the element's selected option is equal memorized text.
     * @param memoryKey is the memorized text to compare with.
     * @return
     * @throws ScriptException
     * @throws ApplicationException
     */
    public boolean verifyElementIsSelectedMemorizedText(String memoryKey) throws ScriptException, ApplicationException {
        return selectable.verifyElementIsSelectedMemorizedText(driver, locator, memoryKey);
    }

    /**
     * @ret Verify the element is disabled. return <CODE>true</CODE> the element
     * is disabled.
     */
    @Override
    public boolean isDisabled() {
        this.element = driver.findElement(locator);
        if (!element.isEnabled()) {
            return true;
        } else if (element.getAttribute("disabled") != null) {
            return true;
        } else if (element.getAttribute("class").contains("rtbDisabled")) {
            return true;
        }

        return false;
    }

    /**
     * @ret Verify if the element is enabled. return <CODE>true</CODE> the
     * element is enabled.
     */
    @Override
    public boolean isEnabled() {
        this.element = driver.findElement(locator);

        if (element.getAttribute("class").contains("rtbDisabled")) {
            return false;
        }
        return element.isEnabled();
    }

    /**
     * memorized the dropdown's selected option's text
     * @param memKey
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void memorizedSelectedOptionText(String memKey) throws ScriptException, ApplicationException {
        selectable.memorizedSelectedOptionText(driver, locator, memKey);
    }

    public String getTextOfSelectedOption() throws ScriptException, ApplicationException {
        return selectable.getTextOfSelectedOption(driver, locator);
    }

    /**
     * Select Random option from drop down and memorize
     * @param memoryKey
     */
    public void selectAndMemorizedRandomOption(String memoryKey) throws ScriptException, ApplicationException {
        Select dropDown = new Select(driver.findElement(locator));
        dropDown.selectByIndex(new Random().nextInt(dropDown.getOptions().size()));
        memorizedSelectedOptionText(memoryKey);
    }


}
