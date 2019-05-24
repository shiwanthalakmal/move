package com.vendesilk.ui.pageobjects.page;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteProfilePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SiteProfilePage.class);

    private By lbl_myAccount    = By.cssSelector("h1");
    private By lbl_welcomeMsg   = By.className("info-account");
    private By btn_profileName  = By.id("my-account");

    SiteHeaderPanel siteHeaderPanel;

    public SiteProfilePage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Verify current page url
     * @param contains
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_Current_URLContains(String contains){
        test_step_initiation();
        verifyTrue(driver.getCurrentUrl().contains(contains),"Error ! Url does not matching...");
        log.info("Verify current page url");
        return this;
    }

    /**
     * Step: Verify my-account page title
     * @param title
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_MyAccount_Title(String title) throws ScriptException, ApplicationException {
        test_step_initiation();
        verifyEquals(label(lbl_myAccount).getText(),title,"Error ! Title does not matching...");
        log.info("Verify my-account page title");
        return this;
    }

    /**
     * Step: Verify profile create success welcome message
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_Welcome_Message() throws ScriptException, ApplicationException {
        test_step_initiation();
        verifyTrue(label(lbl_welcomeMsg).getText().contains("Welcome to your account."),"Error ! Welcome mesage does not matching...");
        log.info("Verify profile create success welcome message");
        return this;
    }

    /**
     * Step: Verify user-profile section name value
     * @param profileName
     * @return SiteProfilePage
     */
    public SiteProfilePage check_Validate_UserProfile_Name(String profileName){
        test_step_initiation();
        siteHeaderPanel.action_Validate_UserProfile_Name(profileName);
        log.info("Verify user-profile section name value");
        return this;
    }

    /**
     * Step: Perform sign-out button if button available
     * @return SiteLoginPage
     */
    public SiteLoginPage step_Perform_SignOut_Button_If_Available() throws ScriptException, ApplicationException {
        test_step_initiation();
        siteHeaderPanel.action_Perform_SignOut_Button();
        log.info("Perform sign-out button if button available");
        return new SiteLoginPage(driver);
    }

    /**
     * Step: Navigate main menu for women section
     * @return SiteBrowsPage
     */
    public SiteBrowsPage step_Navigate_Woman_Collection_Using_MainMenu() throws ScriptException, ApplicationException {
        test_step_initiation();
        siteHeaderPanel.action_Navigate_Woman_Collection_Using_MainMenu();
        log.info("Navigate main menu for women section");
        return new SiteBrowsPage(driver);
    }

    /**
     * Step: Verify logged profile name
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_ProfileName(){
        test_step_initiation();

        log.info("Verify logged profile name");
        return this;
    }
}
