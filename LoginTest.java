package com.vwo.tta0xselenium.test.web.loginTests.tests;

import com.vwo.tta0xselenium.main.base.BasePage;
import com.vwo.tta0xselenium.main.driver.DriverManagerTL;
import com.vwo.tta0xselenium.main.pages.DashboardPage;
import com.vwo.tta0xselenium.main.pages.LoginPage;

import com.vwo.tta0xselenium.main.utils.PropertyReaderOptimized;
import com.vwo.tta0xselenium.test.web.loginTests.testbase.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class LoginTest extends BasePage {

    @Test
    public void testLogin() throws Exception {
        DriverManagerTL.getDriver().get(PropertyReaderOptimized.readKeyO("url"));
        DashboardPage dashboardPage = new LoginPage().loginToVWO().afterLogin();
        String expectResult  = dashboardPage.loggedInUserName();
        Assertions.assertThat(expectResult)
                .isNotBlank()
                .isNotNull()
                .contains(PropertyReaderOptimized.readKeyO("expected_username"));

    }
}
