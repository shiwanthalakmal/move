package com.vendesilk.ui.pageobjects.page;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteShoppingCartPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SiteShoppingCartPage.class);

    private By btn_cartProceedToCheckout  = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteShoppingCartPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Perform shopping cart final checkout
     * @return SiteBillingAddressPage
     */
    public SiteBillingAddressPage step_Item_ProceedTo_ShoppingCart_Checkout() throws ScriptException, ApplicationException {
        test_step_initiation();
        button(btn_cartProceedToCheckout).click();
        log.info("Perform shopping cart final checkout");
        return new SiteBillingAddressPage(driver);
    }


}
