package com.vendesilk.ui.element.core;

import com.vendesilk.ui.element.behavior.Typable;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.FrameworkException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.support.KeyBoard;
import com.vendesilk.ui.support.WorkingMemory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTextField extends BaseElement {
    protected WebElement baseTextFieldElement;
    protected KeyBoard keyBoard;
    protected RemoteWebDriver baseTextFieldDriver;
    private Typable typable;
    //final static Logger log = Logger.getLogger(BaseButton.class);

    public BaseTextField(RemoteWebDriver baseTextFieldDriver, By locator) throws FrameworkException {
        super(baseTextFieldDriver, locator);
        this.baseTextFieldDriver = baseTextFieldDriver;
        this.locator = locator;
        keyBoard = new KeyBoard();
        typable = new Typable();
    }

    /**
     * Enter text to the textFiled baseTextFieldElement
     * @param text
     * @throws ScriptException
     * @throws ApplicationException
     */
    public void enterText(String text) throws ScriptException, ApplicationException {
        typable.enterText(baseTextFieldDriver, locator, text);
    }

    /**
     * Checks if a text field is editable
     */
    public boolean isEditable() throws ScriptException, ApplicationException {
        return typable.isEditable(baseTextFieldDriver, locator);
    }

    /**
     * Performs a click on the middle of the baseTextFieldElement.
     */
    public void click() {
        baseTextFieldElement = baseTextFieldDriver.findElement(locator);
        baseTextFieldElement.click();
    }

    /**
     * Performs a click on the baseTextFieldElement if it exists.
     */
    public void clickIfExists() {
        try {

            waitTillElementVisible(5000);
            click();

        } catch (Exception e) {
            //log.info("exception occured while clicking textfield :", e);
        }

    }

    /**
     * Clears the textField baseTextFieldElement
     */
    public void clear() throws ScriptException, ApplicationException {
        typable.clear(baseTextFieldDriver, locator);
    }

    /**
     * Gets the value of the textField baseTextFieldElement
     */
    public void memorizeElementText(String memoryKey) throws ScriptException, ApplicationException {
        String text = typable.getValue(baseTextFieldDriver, locator);
        WorkingMemory wMem = WorkingMemory.getInstance();
        wMem.setMemory(memoryKey, text);
    }

    /**
     * Gets the maximum length of the textField Element is match with given
     * value
     */
    public boolean verifyMaxLengthIs(Integer length) throws ScriptException, ApplicationException {
        int maxLen = typable.getMaxLength(baseTextFieldDriver, locator);
        return maxLen == length;

    }

    /**
     * Enter text to the textField and memorize for later use.
     *
     * @param text
     * @param key
     */
    public void enterTextWhileMemorizing(String text, String key) throws ScriptException, ApplicationException {
        typable.enterTextWhileMemorizing(baseTextFieldDriver, locator, text, key);
    }

    public boolean verifyElementMemorizedValueIs(String memoryKey) throws ScriptException, ApplicationException {
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        return typable.getValue(baseTextFieldDriver, locator).compareTo(memVal) == 0;
    }

    public void enterMemorizedValue(String memoryKey) throws ScriptException, ApplicationException {
        baseTextFieldElement = baseTextFieldDriver.findElement(locator);
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);

        typable.enterText(baseTextFieldDriver, locator, memVal);
    }

    /**
     * Verify if the button text has the exact text ignoring case sensitive.
     *
     * @param text value to compare with.
     * @return <CODE>true</CODE> if button text equals to the provided text
     * (ignoring case sensitive).
     */
    @Override
    public boolean verifyElementTextIsIgnoreCase(String text) throws ScriptException, ApplicationException {
        return typable.getValue(baseTextFieldDriver, locator).compareToIgnoreCase(text) == 0;
    }


    @Override
    public boolean verifyElementTextIs(String text) {
        baseTextFieldElement = (new WebDriverWait(baseTextFieldDriver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        String data = baseTextFieldElement.getText();
        String value = baseTextFieldElement.getAttribute("value");
        if (data.equalsIgnoreCase(text) || value.equalsIgnoreCase(text)) {
            return true;
        }
        return false;
    }

    /**
     * Verify if the baseTextFieldElement has the exact memorized text
     * sensitive.
     *
     * @param memoryKey is the memorized text to compare with.
     * @return <CODE>true</CODE> if baseTextFieldElement text equals to the
     * memorized text(case sensitive).
     */
    @Override
    public boolean verifyElementMemorizedTextIs(String memoryKey) throws ScriptException, ApplicationException {

        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        return typable.getValue(baseTextFieldDriver, locator).compareTo(memVal) == 0;
    }

    /**
     * Verify if the baseTextFieldElement has the exact memorized text ignoring
     * case sensitive.
     *
     * @param memoryKey is the memorized text to compare with.
     * @return <CODE>true</CODE> if baseTextFieldElement text equals to the
     * memorized text(ignoring case sensitive).
     */
    @Override
    public boolean verifyElementMemorizedTextIsIgnoreCase(String memoryKey) throws ScriptException, ApplicationException {
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        return typable.getValue(baseTextFieldDriver, locator).compareToIgnoreCase(memVal) == 0;
    }

    /**
     * Verify if the baseTextFieldElement contains provided memorized text.
     *
     * @param memoryKey is the memorized text to compare with.
     * @return <CODE>true</CODE> if baseTextFieldElement contains the memorized
     * text.
     */
    @Override
    public boolean verifyElementContainsMemorizedText(String memoryKey) throws ScriptException, ApplicationException {
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        return typable.getValue(baseTextFieldDriver, locator).contains(memVal);
    }

    /**
     * Verify if the baseTextFieldElement contains the entered text, which is
     * not case sensitive
     */

    public boolean verifyElementContainsMemorizedTextIgnoreCase(String memoryKey) throws ScriptException, ApplicationException {
        String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
        if (memVal == null) {
            return false;
        }
        memVal = memVal.toLowerCase();

        return typable.getValue(baseTextFieldDriver, locator).toLowerCase().contains(memVal);
    }

    public void enterTextForcefully(String text) {
        WebElement element = baseTextFieldDriver.findElement(locator);
        element.click();
        keyBoard.clearTextField();
        keyBoard.typeText(text);
    }

    public void enterTextIfExists(String text) throws ScriptException, ApplicationException {
        Boolean isPresent = !baseTextFieldDriver.findElements(locator).isEmpty();
        if (isPresent) {
            baseTextFieldElement = baseTextFieldDriver.findElement(locator);
            typable.enterText(baseTextFieldDriver, locator, text);
        } else {
            // ignore clicking

        }

    }

    /**
     * @ret Verify the baseTextFieldElement is disabled. return
     * <CODE>true</CODE> the baseTextFieldElement is disabled.
     */
    @Override
    public boolean isDisabled() {
        this.baseTextFieldElement = (new WebDriverWait(baseTextFieldDriver, 5000 / 1000)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (!baseTextFieldElement.isEnabled()) {
            return true;
        } else if (baseTextFieldElement.getAttribute("disabled") != null) {
            return true;
        } else if (baseTextFieldElement.getAttribute("class").contains("rtbDisabled")) {
            return true;
        }

        return false;
    }

    /**
     * @ret Verify if the baseTextFieldElement is enabled. return
     * <CODE>true</CODE> the baseTextFieldElement is enabled.
     */
    @Override
    public boolean isEnabled() {
        this.baseTextFieldElement = (new WebDriverWait(baseTextFieldDriver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
        if (baseTextFieldElement.getAttribute("class").contains("rtbDisabled")) {
            return false;
        }

        return baseTextFieldElement.isEnabled();
    }

    /**
     * Verifies whether the baseTextFieldElement exists.
     *
     * @return <code>true</code> if the baseTextFieldElement is found in the
     * current context.
     */
    @Override
    public boolean verifyElementExists() {
        return !baseTextFieldDriver.findElements(locator).isEmpty();
    }

    /**
     * Verify if the given text field is empty or not
     *
     * @author ChathuryaD
     */

    public boolean isEmpty() throws ScriptException, ApplicationException {
        this.baseTextFieldElement = baseTextFieldDriver.findElement(locator);
        return typable.isEmpty(baseTextFieldDriver, locator);
    }

}