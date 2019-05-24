package com.vendesilk.ui.testcases;


import com.vendesilk.ui.base.BaseTest;
import com.vendesilk.ui.exception.FrameworkException;
import com.vendesilk.ui.pageobjects.page.SiteHomePage;
import org.testng.annotations.Test;

public class HelloFreshTest extends BaseTest
{

    @Test(groups = {"BAT"})
    public void site_user_registration_functionality_test() throws FrameworkException  {
        new SiteHomePage(getDriver()).step_Perform_SingIn_Button().
                step_Create_New_Account_Using_Email().
                step_Enter_Personal_Information().
                step_Enter_Address_Information().
                step_Submit_Account_Details().
                check_And_Validate_MyAccount_Title("MY ACCOUNT").
                check_And_Validate_ProfileName().
                check_And_Validate_Welcome_Message().
                check_And_Validate_Current_URLContains("controller=my-account").
                step_Perform_SignOut_Button_If_Available();
    }

    /**
     * Deliberatly failing test case for demonstrate reporting, screen-short and exception categorization
     * @throws FrameworkException
     */
    @Test(groups = {"BAT"})
    public void site_deliberately_fail_test() throws FrameworkException  {
        new SiteHomePage(getDriver()).step_Perform_SingIn_Button().
                step_Create_New_Account_Using_Email().
                step_Enter_Personal_Information().
                step_Enter_Address_Information().
                step_Submit_Account_Details().
                check_And_Validate_MyAccount_Title("MY ACCOUNT SHIWANTHA !").
                check_And_Validate_ProfileName().
                check_And_Validate_Welcome_Message().
                check_And_Validate_Current_URLContains("controller=my-account").
                step_Perform_SignOut_Button_If_Available();
    }
}
