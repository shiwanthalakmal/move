package com.vendesilk.ui.support;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverConnection {

    protected static RemoteWebDriver driver = null;

    private DriverConnection() {
    }

    public static RemoteWebDriver getDriverInstance(){
        if(driver == null){
            setDriverLocation();
            setBrowserInstant();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.close();
        driver.quit();
    }

    public static void setDriverLocation(){
        String exePath = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
    }

    public static void setBrowserInstant(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");
    }
}
