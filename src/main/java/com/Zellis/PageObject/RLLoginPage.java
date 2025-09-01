package com.Zellis.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RLLoginPage extends BasePage {

	public RLLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	/*
	 * public RLLoginPage(WebDriver driver) { this.driver = driver;
	 * PageFactory.initElements(driver, this); }
	 */

	@FindBy(xpath = "//input[@name='j_username']")
	public WebElement txtusername;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//button[@name='doLogin']")
	public WebElement btnLogin;
	
	@FindBy(xpath = "//span[contains(text(), 'Continue')]")
	public WebElement btnWarningContinue;
	
	@FindBy(xpath = "//span[contains(text(), 'Yes')]")
	public WebElement btnActiveYes;
	
	

	public void enterUserName(String name) {
		txtusername.sendKeys(name);

	}

	public void login() {
		btnLogin.click();
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

}
