package com.Zellis.Base;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Zellis.Config.ReadConfig;
import com.Zellis.PageObject.RLLoginPage;

public class BaseClass {
	public static WebDriver driver;
	public ReadConfig confg;
	public static WebDriverWait wait;
	public RLLoginPage login;

	public String testdata = "C:\\Users\\INE12380099\\OneDrive - Tesco\\Documents\\ResourseLinkAutomation\\ResourseLinkAutomation\\src\\test\\resources\\testdata\\testdata.json";
	public String Test5LoginData = "Test5Login";
	public String GNEMPALLData = "GNEMPALL";
	public String HomeAddress = "HomeAddress";
	public String BasicPayDetails = "BasicPayDetails";
	public String currentPost = "CurrentPost";
	public String employementDetails = "EmployementDetails";

	@BeforeSuite
	public void setUp() throws IOException, InterruptedException, ParseException {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		confg = new ReadConfig();

		driver.get(confg.getBaseUrl());
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		login = new RLLoginPage(driver);
		// read username password using properties file
		String username = ReadConfig.getTestData(testdata, Test5LoginData).get(0).get("username");
		String password = ReadConfig.getTestData(testdata, Test5LoginData).get(0).get("password");

		login.enterUserName(username);
		login.enterPassword(password);
		login.btnLogin.click();

		Thread.sleep(15000);
		/*
		 * Alert alert = driver.switchTo().alert(); System.out.println(alert);
		 * System.out.println(alert.getText()); Thread.sleep(6000);
		 * driver.switchTo().alert().accept();
		 */
		wait.until(ExpectedConditions.visibilityOf(login.btnActiveYes));
		if (login.btnActiveYes.isDisplayed()) {
			login.btnActiveYes.click();
		}

		wait.until(ExpectedConditions.visibilityOf(login.btnWarningContinue));
		login.btnWarningContinue.click();
		Thread.sleep(2000);
		login.btnWarningContinue.click();
	}

//	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
