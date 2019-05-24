package com.vendesilk.ui.support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {
    //private static final Logger log  = Logger.getLogger(JavaScriptExecutor.class);
    private final WebDriver driver;

    public JavaScriptExecutor(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Mouse scroll on web page loaded
     *
     * @param driver current instance
     */
    public static void doMouseScroll(WebDriver driver) {
        JavascriptExecutor jsExecutorScroll = (JavascriptExecutor) driver;
        jsExecutorScroll.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    /**
     * Mouse scroll up action on the web page loaded
     *
     * @param driver current instance
     */
    public static void doMouseScrollUp(WebDriver driver) {
        JavascriptExecutor jsExecutorScrollUp = (JavascriptExecutor) driver;
        jsExecutorScrollUp.executeScript("window.scrollTo(0,document.documentElement.scrollTop);");
    }

    /**
     * Executes JavaScript in the context of the currently selected frame or window.
     *
     * @param script script to be executed (String)
     * @return One of Boolean, Long, String, List or WebElement. Or null.
     */
    public Object javascriptExecuteScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script);
    }

    /**
     * Executes JavaScript in the context of the currently selected frame or window.
     *
     * @param script script to be executed (String)
     * @param args   must be a number, a boolean, a String, WebElement, or a List of any combination of the above,
     *               may be even empty
     * @return One of Boolean, Long, String, List or WebElement. Or null.
     */
    public Object javascriptExecuteScript(String script, Object args) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript(script, args);
        } catch (Throwable e) {
            return e;
        }

    }

    /**
     * Execute an asynchronous piece of JavaScript in the context of the currently selected frame or window.
     * Unlike executing synchronous JavaScript,
     * scripts executed with this method must explicitly signal they are finished by invoking the provided callback.
     * This callback is always injected into the executed function as the last argument.
     * The first argument passed to the callback function will be used as the script's result
     *
     * @param script script to be executed (String)
     * @param args   must be a number, a boolean, a String, WebElement, or a List of any combination of the above,
     *               may be even empty
     * @return One of Boolean, Long, String, List or WebElement. Or null.
     */
    public Object javascriptExecuteAsyncScript(String script, Object args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeAsyncScript(script, args);

    }

    /**
     * Execute an asynchronous piece of JavaScript in the context of the currently selected frame or window.
     * Unlike executing synchronous JavaScript,
     * scripts executed with this method must explicitly signal they are finished by invoking the provided callback.
     * This callback is always injected into the executed function as the last argument.
     * The first argument passed to the callback function will be used as the script's result
     *
     * @param script script to be executed (String)
     * @return One of Boolean, Long, String, List or WebElement. Or null.
     */

    public Object javascriptExecuteAsyncScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeAsyncScript(script);

    }

    /**
     * Scroll into given element
     *
     * @param driver
     * @param element
     */
    public static void scrollToView(WebDriver driver, WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
