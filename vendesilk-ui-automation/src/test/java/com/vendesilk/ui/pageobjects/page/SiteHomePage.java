package com.vendesilk.ui.pageobjects.page;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteHomePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SiteHomePage.class);

    SiteHeaderPanel siteHeaderPanel;

    public SiteHomePage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Perform sign-in button to access
     * @return SiteLoginPage
     */
    public SiteLoginPage step_Perform_SingIn_Button() throws ScriptException, ApplicationException {
        test_step_initiation();
        siteHeaderPanel.action_Perform_SingIn_Button();
        log.info("Perform sign-in button to access");
        return new SiteLoginPage(driver);
    }

}
