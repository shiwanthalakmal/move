package com.vendesilk.ui.pageobjects.page;

import com.vendesilk.ui.base.BasePage;
import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.FrameworkException;
import com.vendesilk.ui.exception.ScriptException;
import com.vendesilk.ui.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteRegistrationPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SiteRegistrationPage.class);

    private By chkBx_Gender     = By.id("id_gender2");
    private By txtFld_Fname     = By.id("customer_firstname");
    private By txtFld_Lname     = By.id("customer_lastname");
    private By txtFld_Password  = By.id("passwd");

    private By ddl_Birth_Date   = By.id("days");
    private By ddl_Birth_Month  = By.id("months");
    private By ddl_Birth_Year   = By.id("years");

    private By txtFld_Company   = By.id("company");
    private By txtFld_Addre01   = By.id("address1");
    private By txtFld_Addre02   = By.id("address2");
    private By txtFld_City      = By.id("city");
    private By ddl_State        = By.id("id_state");
    private By txtFld_Postal    = By.id("postcode");
    private By txtArea_AddiInfo = By.id("other");
    private By txtFld_landPhone = By.id("phone");
    private By txtFld_mobilePhon= By.id("phone_mobile");
    private By txtFld_alias     = By.id("alias");

    private By btn_SubmitAccount= By.id("submitAccount");

    SiteHeaderPanel siteHeaderPanel;

    public SiteRegistrationPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Provide personal information for registration
     * @return SiteRegistrationPage
     */
    public SiteRegistrationPage step_Enter_Personal_Information() throws FrameworkException {
        test_step_initiation();
        checkBox(chkBx_Gender).check();
        textfield(txtFld_Fname).enterText(faker.name().firstName());
        textfield(txtFld_Lname).enterText(faker.name().lastName());
        textfield(txtFld_Password).enterText(faker.name().firstName()+""+String.valueOf(faker.number().numberBetween(100,999)));
        Select select = new Select(driver.findElement(ddl_Birth_Date));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1,30)));
        select = new Select(driver.findElement(ddl_Birth_Month));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1,12)));
        select = new Select(driver.findElement(ddl_Birth_Year));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1980,2000)));
        log.info("Provide personal information for registration");
        return this;
    }

    /**
     * Step: Provide address information for registration
     * @return SiteRegistrationPage
     */
    public SiteRegistrationPage step_Enter_Address_Information() throws FrameworkException {
        test_step_initiation();
        textfield(txtFld_Company).enterText(faker.company().name());
        textfield(txtFld_Addre01).enterText(faker.company().name()+" "+faker.number().numberBetween(1,100));
        textfield(txtFld_Addre02).enterText(faker.address().buildingNumber());
        textfield(txtFld_City).enterText(faker.address().cityName());
        Select select = new Select(driver.findElement(ddl_State));
        select.selectByVisibleText("Colorado");
        textfield(txtFld_Postal).enterText(String.valueOf(faker.number().numberBetween(10000,99999)));
        textfield(txtArea_AddiInfo).enterText("I m Fine Thank you !");
        textfield(txtFld_landPhone).enterText(faker.phoneNumber().phoneNumber());
        textfield(txtFld_mobilePhon).enterText(faker.phoneNumber().cellPhone());
        textfield(txtFld_alias).enterText(faker.idNumber().ssnValid());
        log.info("Provide address information for registration");
        return this;
    }

    /**
     * Step: Make submit account with valid detail
     * @return SiteProfilePage
     */
    public SiteProfilePage step_Submit_Account_Details() throws ScriptException, ApplicationException {
        test_step_initiation();
        button(btn_SubmitAccount).click();
        log.info("Make submit account with valid detail");
        return new SiteProfilePage(driver);
    }
}
