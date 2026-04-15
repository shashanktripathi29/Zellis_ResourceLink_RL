package com.Zellis.testcases;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.Zellis.Base.BaseClass;
import com.Zellis.Config.ReadConfig;
import com.Zellis.PageObject.RLLoginPage;

public class LoginRL extends BaseClass {

	public RLLoginPage login;

	@Test(priority = 1)
	public void verifyValidLogin() throws IOException, ParseException, InterruptedException {

		login = new RLLoginPage(driver);
		login.enterUserName( ReadConfig.getTestData(testdata, Test5LoginData).get(0).get("username"));
		login.enterPassword((String) ReadConfig.getTestData(testdata, Test5LoginData).get(0).get("password"));
		login.btnLogin.click();

		wait.until(ExpectedConditions.visibilityOf(login.btnActiveYes));
		if (login.btnActiveYes.isDisplayed()) {
			login.btnActiveYes.click();
		}
		wait.until(ExpectedConditions.visibilityOf(login.btnWarningContinue));
		login.btnWarningContinue.click();

	}

}
