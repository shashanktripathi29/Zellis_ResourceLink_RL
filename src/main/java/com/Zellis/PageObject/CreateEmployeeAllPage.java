package com.Zellis.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEmployeeAllPage extends BasePage {
	public CreateEmployeeAllPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@placeholder='Enter fast path']")
	public WebElement txtFastPath;

	@FindBy(xpath = "//input[@id='proiv_MD55S22-EmployeeNumberText']")
	public WebElement txtEnterEmpNo;

	@FindBy(xpath = "//button[contains(text(), 'Add')]")
	public WebElement btnAdd;

	@FindBy(xpath = "//button[@id='W1_proiv_MD55G12-126-W2TextPanel']")
	public WebElement btnExit;

	@FindBy(xpath = "//input[contains(@id, 'SurnameInput')]")
	public WebElement txtSurname;

	@FindBy(xpath = "//input[contains(@id,'TitleInput')]")
	public WebElement txtTitle;

	@FindBy(xpath = "//input[contains(@id,'FirstForenameText')]")
	public WebElement txtFirstForename;

	@FindBy(xpath = "//input[contains(@id,'GenderText')]")
	public WebElement txtLegalSex;

	@FindBy(xpath = "//input[contains(@id,'DateOfBirthInput')]")
	public WebElement txtDOB;

	@FindBy(xpath = "//input[contains(@id,'NINOText')]")
	public WebElement txtNationalInsurance;

	@FindBy(xpath = "//button[contains(@id, 'save')]")
	public WebElement btnSave;

	@FindBy(xpath = "//span[text()='E']")
	public WebElement btnMultiExit;

	@FindBy(xpath = "//span[normalize-space()='Home Address']")
	public WebElement btnHomeMenu;

	@FindBy(xpath = "//input[contains(@title, 'first line of the address')]")
	public WebElement txtAddress1;

	@FindBy(xpath = "//input[contains(@id,'ADDRESS2')]")
	public WebElement txtAddress2;

	@FindBy(xpath = "//input[contains(@id,'ADDRESS3')]")
	public WebElement txtAddress3;

	@FindBy(xpath = "//input[contains(@id,'ADDRESS4')]")
	public WebElement txtAddress4;

	@FindBy(xpath = "//input[contains(@id,'ADDRESSR')]")
	public WebElement txtAddressCounty;

	@FindBy(xpath = "//input[contains(@id,'ADDRESSPC')]")
	public WebElement txtAddressPostCode;

	public void enterFastPath(String path) {
		txtFastPath.sendKeys(path, Keys.ENTER);
	}

	public void enterEmployeeNo(String emp) throws InterruptedException {
		txtEnterEmpNo.sendKeys(emp, Keys.ENTER);
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(btnAdd)).click();

		btnAdd.click();
	} 

	public void enterPersonalDetails(String Surname, String title, String FirstName, String Sex, String DOB,
			String insurance) throws InterruptedException {
		

		wait.until(ExpectedConditions.elementToBeClickable(txtSurname)).sendKeys(Surname, Keys.TAB);

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(txtTitle)).sendKeys(title, Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(txtFirstForename)).sendKeys(FirstName, Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(txtLegalSex)).sendKeys(Sex, Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(txtDOB)).sendKeys(DOB, Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(txtNationalInsurance)).sendKeys(insurance, Keys.TAB);

	}

	public void enterHomeAddress(String Address1, String Address2, String Address3, String Address4, String County,
			String PostCode) throws InterruptedException {

		Thread.sleep(2000);
		txtAddress1.click();
		txtAddress1.sendKeys(Address1, Keys.TAB);
		Thread.sleep(2000);
		txtAddress2.click();
		txtAddress2.sendKeys(Address2, Keys.TAB);
		Thread.sleep(2000);
		txtAddress3.click();
		txtAddress3.sendKeys(Address3, Keys.TAB);
		txtAddress4.click();
		txtAddress4.sendKeys(Address4, Keys.TAB);
		txtAddressCounty.click();
		txtAddressCounty.sendKeys(County, Keys.ENTER);
		txtAddressPostCode.click();
		txtAddressPostCode.sendKeys(PostCode, Keys.ENTER);

	}
}
