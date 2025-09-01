package com.Zellis.testcases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Zellis.Utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public ReadConfig confg;
	public static WebDriverWait wait;

	public String testdata = "C:\\Users\\INE12380099\\Documents\\ResourseLinkAutomation\\ResourseLinkAutomation\\src\\test\\resources\\testdata\\testdata.json";
	String Test5LoginData = "Test5Login";
	String GNEMPALLData = "GNEMPALL";
	String HomeAddress = "HomeAddress";

	@BeforeSuite
	public void setUp() throws IOException, InterruptedException {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		confg = new ReadConfig();
		driver.get(confg.getBaseUrl());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://tescotest5.hcm.zellis.com/resourcelink/login/index.html");

	}
	/*
	 * @AfterSuite public void tearDown() { if (driver != null) { driver.quit(); } }
	 */
}
