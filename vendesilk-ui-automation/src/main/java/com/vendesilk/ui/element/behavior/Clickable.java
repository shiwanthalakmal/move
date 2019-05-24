package com.vendesilk.ui.element.behavior;

import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clickable {

    public void click(RemoteWebDriver driver, By locator) throws ApplicationException, ScriptException {
        try {
            WebElement element;
            element = (new WebDriverWait(driver, 5000 / 1000)).until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (ElementNotVisibleException e) {
            throw new ScriptException("Element Not Clickable");
        } catch (InvalidElementStateException e) {
            throw new ApplicationException("Element Not editable");
        } catch (StaleElementReferenceException e) {
            throw new ScriptException("Element No longer attached to page DOM");
        } catch (WebDriverException e){
            throw new ScriptException("Element is not clickable at current point");
        }
    }
}
