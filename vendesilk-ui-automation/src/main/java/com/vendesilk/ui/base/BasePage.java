package com.vendesilk.ui.base;

import com.github.javafaker.Faker;
import com.vendesilk.ui.element.*;
import com.vendesilk.ui.exception.FrameworkException;
import com.vendesilk.ui.element.Label;
import com.vendesilk.ui.support.ScreeCapture;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

import java.util.Collection;
import java.util.Locale;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    public RemoteWebDriver driver;
    public Faker faker;

    public BasePage(RemoteWebDriver driver)
    {
        this.driver = driver;
        this.faker = new Faker(new Locale("en-IND"));;
    }

    /**
     * Locate button element.
     *
     * @param findBy mechanism to locate the button.
     * @return Located button
     */
    public Button button(By findBy)
    {
        return new Button(driver,findBy);
    }

    public TextField textfield(By findBy) throws FrameworkException{
        return new TextField(driver,findBy);
    }

    public Link link(By findBy)
    {
        return new Link(driver,findBy);
    }

    public CheckBox checkBox(By findBy)
    {
        return new CheckBox(driver,findBy);
    }

    public Label label(By findBy)
    {
        return new Label(driver,findBy);
    }

    public DropdownList dropdownList(By findBy)
    {
        return new DropdownList(driver,findBy);
    }

    public void verifyTrue(boolean condition, String message) {
            Assert.assertTrue(condition);
    }

    public void verifyFalse(boolean condition, String message) {
            Assert.assertFalse(condition);
    }

    public void verifyEquals(Object actual, Object expected, String message) {
            Assert.assertEquals(actual, expected);
    }

    public void verifyEquals(String actual, String expected, String message) {
        try {
            Assert.assertEquals(actual, expected);
        } catch(AssertionError e){
            handleAssertionFailure(e.getMessage());
        }
    }

    public void verifyEquals(boolean actual, boolean expected, String message) {
        try{
            Assert.assertEquals(actual, expected);
        } catch(AssertionError e){
            handleAssertionFailure(e.getMessage());
        }
    }

    public void verifyEquals(Collection<?> actual, Collection<?> expected, String message) {
        try{
            Assert.assertEquals(actual, expected);
        } catch(AssertionError e){
            handleAssertionFailure(e.getMessage());
        }
    }

    public void verifyNotEquals(Object actual, Object expected, String message) {
        try{
            Assert.assertNotEquals(actual, expected);
        } catch(AssertionError e){
            handleAssertionFailure(e.getMessage());
        }
    }

    public void verifyNotEquals(String actual, String expected, String message) {
        try{
            Assert.assertNotEquals(actual, expected, message);
        } catch(AssertionError e){
            handleAssertionFailure(e.getMessage());
        }
    }

    public void verifyNotEquals(boolean actual, boolean expected, String message) {
        try{
            Assert.assertNotEquals(actual, expected);
        } catch(AssertionError e){
            handleAssertionFailure(e.getMessage());
        }
    }

    protected void test_step_initiation() {
        Reporter.log(Thread.currentThread().getStackTrace()[2].getMethodName());
        log.info("[Passed] :"+Thread.currentThread().getStackTrace()[2].getMethodName()+" ----");;
    }

    private void handleAssertionFailure(String message){
        try {
            ScreeCapture.captureDesktopScreenshot(ScreeCapture.getFileName());
            Assert.fail(message);
        } catch (FrameworkException e) {
            e.printStackTrace();
        }
    }
}
