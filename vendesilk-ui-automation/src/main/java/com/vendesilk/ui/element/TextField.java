package com.vendesilk.ui.element;

import com.vendesilk.ui.element.core.BaseTextField;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.FrameworkException;
import com.vendesilk.ui.exception.ScriptException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TextField extends BaseTextField {

    public TextField(RemoteWebDriver driver, By locator) throws FrameworkException {
        super(driver, locator);

    }

    public void enterTextAndSubmit(String text) throws ScriptException, ApplicationException {
        super.enterText(text);
        baseTextFieldElement = driver.findElement(locator);
        baseTextFieldElement.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    public void enterTextAndSubmitForcefully(String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        keyBoard.clearTextField();
        keyBoard.typeText(text);
        keyBoard.type("\n");
    }
}
