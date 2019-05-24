package com.vendesilk.ui.pageobjects.page;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteBrowsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SiteBrowsPage.class);

    private By lnk_itemSelection = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
    private By btn_moreDetails   = By.xpath("//a[@title='View']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteBrowsPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Browse and select random item for buy
     * @return SiteDetailPage
     */
    public SiteDetailPage step_Select_Random_Item_And_MoveTo_Detail_View() throws ScriptException, ApplicationException {
        test_step_initiation();
        link(lnk_itemSelection).click();
        button(btn_moreDetails).click();
        log.info("Browse and select random item for buy");
        return new SiteDetailPage(driver);
    }

}
