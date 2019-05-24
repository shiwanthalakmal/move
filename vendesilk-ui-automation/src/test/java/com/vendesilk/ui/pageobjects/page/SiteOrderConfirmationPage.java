package com.vendesilk.ui.pageobjects.page;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteOrderConfirmationPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SiteOrderConfirmationPage.class);

    private By lbl_confirmationTitle = By.cssSelector("h1");
    private By lbl_orderOnStore      = By.xpath("//*[@class='cheque-indent']/strong");

    private By btn_forthBreadcrumb   = By.xpath("//li[@class='step_done step_done_last four']");
    private By btn_fifthBreadcrumb   = By.xpath("//li[@id='step_end' and @class='step_current last']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteOrderConfirmationPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Verify current page url
     * @param url
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_Current_URLContains(String url){
        test_step_initiation();
        verifyTrue(driver.getCurrentUrl().contains(url), "Error ! URL does not matching ..");
        log.info("Verify current page url");
        return this;
    }

    /**
     * Step: Verify order confirmation title message
     * @param title
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_OrderConfirmation_Title(String title) throws ScriptException, ApplicationException {
        test_step_initiation();
        verifyEquals(label(lbl_confirmationTitle).getText(), title, "Error ! Confirmation title does not matching ..");
        log.info("Verify order confirmation title message");
        return this;
    }

    /**
     * Step: Verify order on store available message
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_OrderOnStore_Message() throws ScriptException, ApplicationException {
        test_step_initiation();
        verifyTrue(label(lbl_orderOnStore).getText().contains("Your order on My Store is complete."), "Error ! Order on store message does not matching ..");
        log.info("erify order on store available message");
        return this;
    }

    /**
     * Step: Verify previous breadcrumb availability
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_Breadcrumb_Availability(){
        test_step_initiation();
        verifyTrue(driver.findElement(btn_forthBreadcrumb).isDisplayed(),"Error ! Fourth breadcrumb is not available");
        verifyTrue(driver.findElement(btn_fifthBreadcrumb).isDisplayed(),"Error ! Fifth breadcrumb is not available");
        log.info("Verify previous breadcrumb availability");
        return this;
    }

}
