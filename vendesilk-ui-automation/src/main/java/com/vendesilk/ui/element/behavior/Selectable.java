package com.vendesilk.ui.element.behavior;

import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.support.WorkingMemory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;
import java.util.List;

public class Selectable {
    private Select select;

    /**
     * Generic select option
     *
     * @param driver
     * @param locator
     * @param index
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void select(RemoteWebDriver driver, By locator, Integer index) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            select.selectByIndex(index);
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
     * Select particular item by using option tag
     *
     * @param driver
     * @param locator
     * @param option
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void selectByOption(RemoteWebDriver driver, By locator, String option) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> itr = options.iterator();
            int elementIndex = -1;
            for (int i = 0; itr.hasNext(); i++) {
                WebElement elem = itr.next();
                if (elem.getText().compareTo(option) == 0) {
                    elementIndex = i;
                }
            }
            select.selectByIndex(elementIndex);
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
     * Select particular item by using option contains value
     *
     * @param driver
     * @param locator
     * @param option
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void selectByOptionContains(RemoteWebDriver driver, By locator, String option) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> itr = options.iterator();
            int elementIndex = -1;
            for (int i = 0; itr.hasNext(); i++) {
                WebElement elem = itr.next();
                if (elem.getText().contains(option)) {
                    elementIndex = i;
                }
            }
            select.selectByIndex(elementIndex);
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
     * Verify the particular item exact text availability
     * @param driver
     * @param locator
     * @param text
     * @return boolean
     * @throws ApplicationException
     * @throws ScriptException
     */
    public boolean verifyElementTextIs(RemoteWebDriver driver, By locator, String text) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> itr = options.iterator();
            for (; itr.hasNext(); ) {
                WebElement elem = itr.next();
                if (elem.getText().trim().compareTo(text.trim()) == 0) {
                    return true;
                }
            }
            return false;
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
     * Verify the particular item exact text availability with IgnoreCase
     * @param driver
     * @param locator
     * @param text
     * @return boolean
     * @throws ApplicationException
     * @throws ScriptException
     */
    public boolean verifyElementTextIsIgnoreCase(RemoteWebDriver driver, By locator, String text) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> itr = options.iterator();
            for (; itr.hasNext(); ) {
                WebElement elem = itr.next();
                if (elem.getText().trim().compareToIgnoreCase(text.trim()) == 0) {
                    return true;
                }
            }
            return false;
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
     * Verify the particular item exact text availability and store in working com.cambio.qa.utils.memory
     * @param driver
     * @param locator
     * @param memoryKey
     * @return boolean
     * @throws ApplicationException
     * @throws ScriptException
     */
    public boolean verifyElementMemorizedTextIs(RemoteWebDriver driver, By locator, String memoryKey) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
            if (memVal == null) {
                return false;
            }
            select = new Select(element);
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> itr = options.iterator();
            for (; itr.hasNext(); ) {
                WebElement elem = itr.next();
                if (elem.getText().trim().compareTo(memVal.trim()) == 0) {
                    return true;
                }
            }
            return false;
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
     * Verify the particular item exact text availability with IgnoreCase and store in working com.cambio.qa.utils.memory
     * @param driver
     * @param locator
     * @param memoryKey
     * @return boolean
     * @throws ApplicationException
     * @throws ScriptException
     */
    public boolean verifyElementMemorizedTextIsIgnoreCase(RemoteWebDriver driver, By locator, String memoryKey) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
            if (memVal == null) {
                return false;
            }
            select = new Select(element);
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> itr = options.iterator();
            for (; itr.hasNext(); ) {
                WebElement elem = itr.next();
                if (elem.getText().trim().compareToIgnoreCase(memVal.trim()) == 0) {
                    return true;
                }
            }
            return false;
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
     * Memorized in working com.cambio.qa.utils.memory that particular selected option
     * @param driver
     * @param locator
     * @param memoryKey
     * @throws ApplicationException
     * @throws ScriptException
     */
    public void memorizedSelectedOptionText(RemoteWebDriver driver, By locator, String memoryKey) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            WebElement option = select.getFirstSelectedOption();
            String value = option.getText();

            WorkingMemory wMem = WorkingMemory.getInstance();
            wMem.setMemory(memoryKey, value);
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
     * Compare selected option value against the memorized element text
     * @param driver
     * @param locator
     * @param memoryKey
     * @return boolean
     * @throws ApplicationException
     * @throws ScriptException
     */
    public boolean verifyElementIsSelectedMemorizedText(RemoteWebDriver driver, By locator, String memoryKey) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            String memVal = WorkingMemory.getInstance().getMemory(memoryKey);
            if (memVal == null) {
                return false;
            }
            select = new Select(element);
            WebElement option = select.getFirstSelectedOption();
            String value = option.getText();
            return value.equals(memVal);
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
     * Return selected option text value
     * @param driver
     * @param locator
     * @return selected option text
     * @throws ApplicationException
     * @throws ScriptException
     */
    public String getTextOfSelectedOption(RemoteWebDriver driver, By locator) throws ApplicationException, ScriptException {
        try {
            String text = "";
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            WebElement option = select.getFirstSelectedOption();
            text = option.getText();
            return text;
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
     * Select particular option and return selected option text value
     * @param driver
     * @param locator
     * @param index
     * @return selected option text
     * @throws ApplicationException
     * @throws ScriptException
     */
    public String getTextOfOption(RemoteWebDriver driver, By locator, Integer index) throws ApplicationException, ScriptException {
        try {
            WebElement element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            select = new Select(element);
            select.selectByIndex(index - 1);
            return getTextOfSelectedOption(driver, locator);
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

}
