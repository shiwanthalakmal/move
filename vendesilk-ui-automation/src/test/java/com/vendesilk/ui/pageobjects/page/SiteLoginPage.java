package com.vendesilk.ui.pageobjects.page;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.FrameworkException;
import com.vendesilk.ui.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteLoginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SiteLoginPage.class);

    private By txtFld_userName = By.id("email");
    private By txtFld_passWord = By.id("passwd");
    private By btn_Login = By.id("SubmitLogin");

    private By txtFld_emailAddr= By.id("email_create");
    private By btn_createAcc   = By.id("SubmitCreate");


    SiteHeaderPanel siteHeaderPanel;

    public SiteLoginPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Provide successful user login credentials and login
     * @param username
     * @param password
     * @return SiteProfilePage
     */
    public SiteProfilePage step_Enter_Login_Credentials(String username, String password) throws FrameworkException{
        test_step_initiation();
        textfield(txtFld_userName).enterText(username);
        textfield(txtFld_passWord).enterText(password);
        button(btn_Login).click();
        log.info("Provide successful user login credentials and login");
        return new SiteProfilePage(driver);
    }

    /**
     * Step: Create new account with email address
     * @return SiteRegistrationPage
     */
    public SiteRegistrationPage step_Create_New_Account_Using_Email() throws FrameworkException {
        textfield(txtFld_emailAddr).enterText((faker.color().name()+faker.number().numberBetween(100,999)+"@mailinator.com").replaceAll("\\s+",""));
        button(btn_createAcc).click();
        log.info("Create new account with email address");
        return new SiteRegistrationPage(driver);
    }

}
