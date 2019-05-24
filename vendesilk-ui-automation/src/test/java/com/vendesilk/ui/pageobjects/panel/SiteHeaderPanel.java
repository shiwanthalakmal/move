package com.vendesilk.ui.pageobjects.panel;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteHeaderPanel extends BasePage {

    private By btn_signIn       = By.linkText("Sign in");
    private By btn_signOut      = By.linkText("Sign out");
    private By btn_profile      = By.className("account");
    private By btn_contactUs    = By.linkText("Contact us");

    private By btn_menu_women   = By.linkText("Women");

    public SiteHeaderPanel(RemoteWebDriver driver) {
        super(driver);
    }

    /**
     * Action: Perform sign-in button
     */
    public void action_Perform_SingIn_Button() throws ScriptException, ApplicationException {
        button(btn_signIn).click();
    }

    /**
     * Action: Perform sign-out button
     */
    public void action_Perform_SingOut_Button() throws ScriptException, ApplicationException {
        button(btn_signOut).click();
    }

    /**
     * Action: Perform contact-us button
     */
    public void action_Perform_ContactUs_Button() throws ScriptException, ApplicationException {
        button(btn_contactUs).click();
    }

    /**
     * Action: Verify user-profile section name
     * @param profileName
     */
    public void action_Validate_UserProfile_Name(String profileName){
        verifyEquals(driver.findElement(btn_profile).getText(),profileName,"Error ! Profile does not matching ..");
    }

    /**
     * Action: Verify sign-out button availability and make sign-out
     */
    public void action_Perform_SignOut_Button() throws ScriptException, ApplicationException {
        if(driver.findElement(btn_signOut).isDisplayed()){
            button(btn_signOut).click();
        }
    }

    /**
     * Action: Menu navigation for women section
     */
    public void action_Navigate_Woman_Collection_Using_MainMenu() throws ScriptException, ApplicationException {
        button(btn_menu_women).click();
    }
}
