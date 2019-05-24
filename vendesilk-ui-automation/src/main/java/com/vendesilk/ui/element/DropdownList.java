package com.vendesilk.ui.element;

import com.vendesilk.ui.element.core.BaseDropdownList;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DropdownList extends BaseDropdownList {

    public DropdownList(RemoteWebDriver driver, By locator) {
        super(driver, locator);

    }

}
