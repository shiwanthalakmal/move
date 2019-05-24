package com.vendesilk.ui.element;

import com.vendesilk.ui.element.core.BaseButton;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Button extends BaseButton {

    public Button(RemoteWebDriver driver, By locator) {
        super(driver, locator);

    }
}
