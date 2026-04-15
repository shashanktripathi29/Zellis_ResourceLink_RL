package com.Zellis.PageObject;

import java.time.Duration;
import java.util.concurrent.locks.Condition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

	@FindBy(xpath = "//input[contains(@id, 'FIRSTFLDInput')]")
	public WebElement txtPayGroup;

	@FindBy(xpath = "//input[contains(@id, 'EffectiveDate-W2Text')]")
	public WebElement txtEffectiveDate;

	@FindBy(xpath = "//input[contains(@id, 'PayMethodInput')]")
	public WebElement txtPayMethod;

	@FindBy(xpath = "//input[contains(@id,'W2_proiv_MD47G40-GradeBasicAmount_1Text')]")
	public WebElement txtGradeBasicSalary;

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

	@FindBy(xpath = "//input[contains(@id,'ADDRESS1')]")
	public WebElement txtAddress1;

	@FindBy(xpath = "//span[contains(text(),'Basic Pay Details')]")
	public WebElement btnBasicPayDetails;

	@FindBy(xpath = "//span[contains(text(),'Current/Future Post')]")
	public WebElement btnCurrentFuturePost;

	@FindBy(xpath = "//input[@id='proiv_MD47S1B-DATE_1Text']")
	public WebElement txtPostStartDate;

	@FindBy(xpath = "//input[contains(@id,'POST_1Input')]")
	public WebElement txtPost;

	@FindBy(xpath = "//button[contains(@id,'W1_proiv_CTDILOGR-153-W2TextPanel')]")
	public WebElement btnCTIDILOGBOXExit1;
	@FindBy(xpath = "//button[contains(@id,'W1_proiv_CTDILOGX-163-W2Text_Exit')]")
	public WebElement btnCTIDILOGBOXExit2;

	@FindBy(xpath = "//button[contains(@id,'W1_proiv_CTDILOGX-158-W2Text_Exit')]")
	public WebElement btnDCCTIDILOGBOXExit1;

	@FindBy(xpath = "//a[@title='Conditions of Service']")
	public WebElement lnkConditionOfService;

	@FindBy(xpath = "//button[contains(@id,'CONDID-W2Button')]")
	public WebElement btnServiceCondId;

	@FindBy(xpath = "//input[contains(@id,'STDATE')]")
	public WebElement txtServiceCondPositionStartDate;

	@FindBy(xpath = "//input[contains(@id,'EmpPostService')]")
	public WebElement txtServiceCondition;

	@FindBy(xpath = "//button[contains(@id,'POS_STAT')]")
	public WebElement btnPositionStatus;

	@FindBy(xpath = "//span[contains(@id,'W3Text_Exit')]")
	public WebElement btnServiceConditionPositionExit;

	@FindBy(xpath = "//input[contains(@id,'EmpPostPositionStatus')]")
	public WebElement txtPositionStatus;

	@FindBy(xpath = "//a[@title='Grade Details']")
	public WebElement lnkGradeDetails;

	@FindBy(xpath = "//span[contains(@id,'GRADEW-W2F')]")
	public WebElement btnGradePoint;

	@FindBy(xpath = "//*[@id='W2_proiv_MD47G41-GRDPOINT_1Input']")
	public WebElement btnGradePointInput;

	@FindBy(xpath = "//button[contains(@id,'W2_proiv_MD47G40-CyclePagingPagingArea-W3Node_grid0_gridRecordHideShow_0_998')]")
	public WebElement btnCollapse;

	@FindBy(id = "W2_proiv_MD47G41-GRDPOINT_1Button")
	public WebElement btnGradePointbutton;

	@FindBy(xpath = "//span[contains(@title,'Employment Detail')]")
	public WebElement btnEmployementDetails;

	@FindBy(xpath = "//span[text()='Select']")
	public WebElement btnSelectGrade;

	@FindBy(xpath = "//button[@id='W2_proiv_MD47G40-491-W3TextPanel']")
	public WebElement btnGradeExit;

	@FindBy(xpath = "//input[@id='proiv_MD47S1A-EmployeeTypeInput']")
	public WebElement txtEmpType;

	@FindBy(xpath = "//span[text()='Save']")
	public WebElement btnSaveColleague;

	@FindBy(id = "W1_proiv_CTCONFRM-213-W2Text_Yes")
	public WebElement btnConfirmYes;

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
	@FindBy(xpath = "//input[@id='W2_proiv_MD47G40-EmpGradeReason_1Input']")
	public WebElement txtChangeReason;

	public void enterFastPath(String path) {
		txtFastPath.sendKeys(path, Keys.ENTER);
	}

	private static final Logger logger = LogManager.getLogger(CreateEmployeeAllPage.class);

	public void enterEmployeeNo(String emp) throws InterruptedException {
		txtEnterEmpNo.sendKeys(emp, Keys.ENTER);
		Thread.sleep(1000);
		btnAdd.click();
	}

	public void enterPersonalDetails(String Surname, String title, String FirstName, String Sex, String DOB,
			String insurance) throws InterruptedException {
		clickLongAndSendkey(driver, txtSurname, Surname);
		clickAndSendkey(driver, txtTitle, title);
		clickAndSendkey(driver, txtFirstForename, FirstName);
		clickAndSendkey(driver, txtLegalSex, Sex);
		clickAndSendkey(driver, txtDOB, DOB);
		Thread.sleep(800);
		clickAndSendkey(driver, txtNationalInsurance, insurance);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.TAB).build().perform();
	}

	public void enterHomeAddress(String address1, String address2, String address3, String address4, String county,
			String postCode) throws InterruptedException {

		btnHomeMenu.click();
		switchToFrame();
		logger.info("Switch to frame -Home Details");
		wait.until(ExpectedConditions.elementToBeClickable(txtAddress1));

		logger.info("Enter Address1");

		txtAddress1.clear();
		txtAddress1.click();
		txtAddress1.sendKeys(address1);

		logger.info("Enter Address2");
		wait.until(ExpectedConditions.visibilityOf(txtAddress2));
		wait.until(ExpectedConditions.elementToBeClickable(txtAddress2));
		txtAddress2.clear();
		Thread.sleep(500);
		txtAddress2.click();
		txtAddress2.sendKeys(address2);

		logger.info("Enter Address3");
		wait.until(ExpectedConditions.visibilityOf(txtAddress3));
		wait.until(ExpectedConditions.elementToBeClickable(txtAddress3));
		txtAddress3.clear();
		Thread.sleep(1500);
		txtAddress3.click();
		txtAddress3.sendKeys(address3);

		logger.info("Enter Address4");
		wait.until(ExpectedConditions.visibilityOf(txtAddress4));
		wait.until(ExpectedConditions.elementToBeClickable(txtAddress4));
		txtAddress4.click();
		Thread.sleep(900);
		txtAddress4.click();
		txtAddress4.sendKeys(address4);

		logger.info("Enter County");
		wait.until(ExpectedConditions.visibilityOf(txtAddressCounty));
		wait.until(ExpectedConditions.elementToBeClickable(txtAddressCounty));
		txtAddressCounty.click();
		Thread.sleep(500);
		txtAddressCounty.click();
		txtAddressCounty.sendKeys(county);

		logger.info("Enter Post Code");
		wait.until(ExpectedConditions.visibilityOf(txtAddressPostCode));
		wait.until(ExpectedConditions.elementToBeClickable(txtAddressPostCode));
		Thread.sleep(500);
		txtAddressPostCode.click();
		txtAddressPostCode.clear();
		txtAddressPostCode.click();
		Thread.sleep(300);
		txtAddressPostCode.sendKeys(postCode);
		Thread.sleep(500);
		actions.sendKeys(Keys.TAB).build().perform();

		logger.info("Switch back to default frame");
		driver.switchTo().defaultContent();
	}

	public void enterBasicPayDetails(String group, String effectivedate, String mode) throws InterruptedException {

		switchToFrame();
		logger.info("Switch to Basic Detail Frame");

		txtPayGroup.click();
		txtPayGroup.sendKeys(group);
		actions.sendKeys(Keys.TAB).build().perform();

		txtEffectiveDate.click();
		txtEffectiveDate.sendKeys(effectivedate);
		actions.sendKeys(Keys.TAB).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		switchToFrame();
		wait.until(ExpectedConditions.visibilityOf(txtPayMethod));
		wait.until(ExpectedConditions.elementToBeClickable(txtPayMethod));
		Thread.sleep(500);

		txtPayMethod.click();
		txtPayMethod.clear();
		txtPayMethod.sendKeys(mode);
		Thread.sleep(100);
		driver.switchTo().defaultContent();

	}

	public void MoveToCurrentFutureDCPost(String date, String post) throws InterruptedException {

		actions.moveToElement(btnCurrentFuturePost).click().perform();
		switchToFrame();
		logger.info("Start Date entered");
		txtPostStartDate.click();
		// switchToFrame();
		// switchToFrameAndClickElement(txtPostStartDate);
		Thread.sleep(1500);
		txtPostStartDate.click();
		Thread.sleep(1500);
		logger.info("Send Start Date and TAB");
		actions.moveToElement(txtPostStartDate).click().sendKeys(date).sendKeys(Keys.TAB).perform();
		Thread.sleep(1800);
		logger.info("Send POST and TAB");
		actions.moveToElement(txtPost).sendKeys(post).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		logger.info("TAB");
		Thread.sleep(2500);
		logger.info("---");
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		logger.info("Dialogue box-WARNING *** Budget FTE already exceeded");

		Thread.sleep(3000);
		switchToFrame();
		Thread.sleep(4000);

		btnDCCTIDILOGBOXExit1.isDisplayed();
		btnDCCTIDILOGBOXExit1.click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		/*
		 * logger.info("Message-affected Entitlement will be recalculated on save");
		 * switchToFrame(); Thread.sleep(2000); btnCTIDILOGBOXExit2.click();
		 */
		// }
		/*
		 * else { btnDCCTIDILOGBOXExit1.click(); Thread.sleep(1000);
		 * driver.switchTo().defaultContent(); Thread.sleep(3000); }
		 */
		/*
		 * //btnCTIDILOGBOXExit1.click(); btnDCCTIDILOGBOXExit1.click();
		 * driver.switchTo().defaultContent(); Thread.sleep(2000);
		 * 
		 * logger.info("Message-affected Entitlement will be recalculated on save");
		 * switchToFrame(); Thread.sleep(2000); btnCTIDILOGBOXExit2.click();
		 * 
		 * Thread.sleep(1000); driver.switchTo().defaultContent();
		 */
	}

	public void MoveToCurrentFuturePost(String date, String post) throws InterruptedException {

		actions.moveToElement(btnCurrentFuturePost).click().perform();
		switchToFrame();
		logger.info("Start Date entered");
		txtPostStartDate.click();
		// switchToFrame();
		// switchToFrameAndClickElement(txtPostStartDate);
		Thread.sleep(1000);
		txtPostStartDate.click();
		Thread.sleep(1500);
		logger.info("Send Start Date and TAB");
		actions.moveToElement(txtPostStartDate).click().sendKeys(date).sendKeys(Keys.TAB).perform();
		Thread.sleep(1800);
		logger.info("Send POST and TAB");
		actions.moveToElement(txtPost).sendKeys(post).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		logger.info("TAB");
		Thread.sleep(2500);
		logger.info("---");
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		logger.info("Dialogue box-WARNING *** Budget FTE already exceeded");

		Thread.sleep(3000);
		switchToFrame();
		Thread.sleep(4000);
		// System.out.println(btnDCCTIDILOGBOXExit1.isDisplayed()==true);

		if (btnDCCTIDILOGBOXExit1.isDisplayed()) {
			btnCTIDILOGBOXExit1.click();
			driver.switchTo().defaultContent();
			Thread.sleep(2000);

			/*
			 * logger.info("Message-affected Entitlement will be recalculated on save");
			 * switchToFrame(); Thread.sleep(2000); btnCTIDILOGBOXExit2.click();
			 */
		}
		/*
		 * else { btnDCCTIDILOGBOXExit1.click(); Thread.sleep(1000);
		 * driver.switchTo().defaultContent(); Thread.sleep(3000); }
		 */
		/*
		 * //btnCTIDILOGBOXExit1.click(); btnDCCTIDILOGBOXExit1.click();
		 * driver.switchTo().defaultContent(); Thread.sleep(2000);
		 * 
		 * logger.info("Message-affected Entitlement will be recalculated on save");
		 * switchToFrame(); Thread.sleep(2000); btnCTIDILOGBOXExit2.click();
		 * 
		 * Thread.sleep(1000); driver.switchTo().defaultContent();
		 */
	}

	public void enterServiceConditions(String position) throws InterruptedException {
		switchToFrame();
		wait.until(ExpectedConditions.elementToBeClickable(lnkConditionOfService));
		actions.moveToElement(lnkConditionOfService).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(btnServiceCondId));
		actions.moveToElement(btnServiceCondId).click().perform();
		jsScrollToElement(txtServiceCondPositionStartDate);
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.TAB).perform();
		wait.until(ExpectedConditions.elementToBeClickable(btnServiceConditionPositionExit));

		Thread.sleep(1300);
		actions.moveToElement(btnServiceConditionPositionExit).click().perform();
		logger.info("Service Condition ID Entered");
		Thread.sleep(1300);

		logger.info("Move to Position status");
		wait.until(ExpectedConditions.elementToBeClickable(btnPositionStatus));
		actions.moveToElement(btnPositionStatus).click().build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(txtServiceCondPositionStartDate));
		Thread.sleep(1000);
		jsScrollToElement(txtServiceCondPositionStartDate);
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).perform();

		/*
		 * driver.switchTo().defaultContent(); switchToFrame();
		 */
		Thread.sleep(5000);
		txtPositionStatus.click();
		txtPositionStatus.sendKeys(position);
		actions.moveToElement(txtPositionStatus).click().sendKeys(position).build().perform();
		Thread.sleep(5000);
		actions.moveToElement(btnServiceConditionPositionExit).click().build().perform();
		Thread.sleep(5000);

	}

	public void enterDCHourlyGrade() throws InterruptedException {

		logger.info("Move to Grade TAB");
		actions.moveToElement(lnkGradeDetails).click().build().perform();
		Thread.sleep(500);
		logger.info("Click on pay grade");
		actions.moveToElement(btnGradePoint).click().build().perform();
		Thread.sleep(2000);
		// Scroll into view and then click with JS scroll+focus+click

		logger.info("Scroll to grade source-POSTGD");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
				btnGradePointInput);
		//switchToFrame();
		logger.info("Click on source-POSTGD");
		Thread.sleep(4000);
		doubleClick(driver, btnGradePointInput);
		// btnGradePointInput.click();
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		switchToFrame();
		/*
		 * Thread.sleep(2000); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
		 * txtChangeReason);
		 * 
		 * btnCollapse.click(); Thread.sleep(2000); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
		 * txtGradeBasicSalary); Thread.sleep(4000); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].value='20000';", txtGradeBasicSalary);
		 * 
		 */ /*
			 * txtGradeBasicSalary.click(); Thread.sleep(2000); txtGradeBasicSalary.click();
			 * txtGradeBasicSalary.click(); txtGradeBasicSalary.sendKeys("20000");
			 */
		Thread.sleep(4000);
		btnGradeExit.click();
		// actions.moveToElement(btnSelectGrade).click().build().perform();
		driver.switchTo().defaultContent();

	}

	public void enterGrade() throws InterruptedException {

		logger.info("Move to Grade TAB");
		actions.moveToElement(lnkGradeDetails).click().build().perform();
		Thread.sleep(500);
		logger.info("Click on pay grade");
		actions.moveToElement(btnGradePoint).click().build().perform();
//Thread.sleep(2000);
		// Scroll into view and then click with JS scroll+focus+click

		/*
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
		 * btnGradePointInput);
		 */
		// Thread.sleep(4000);
		// btnGradePointInput.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		switchToFrame();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", txtChangeReason);

		btnCollapse.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
				txtGradeBasicSalary);
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='20000';", txtGradeBasicSalary);

		/*
		 * txtGradeBasicSalary.click(); Thread.sleep(2000); txtGradeBasicSalary.click();
		 * txtGradeBasicSalary.click(); txtGradeBasicSalary.sendKeys("20000");
		 */
		Thread.sleep(2000);
		btnGradeExit.click();
		// actions.moveToElement(btnSelectGrade).click().build().perform();
		driver.switchTo().defaultContent();

	}

	public void EmployeeDetails(String empType) throws InterruptedException {
		actions.moveToElement(btnEmployementDetails).click().build().perform();
		switchToFrame();
		actions.moveToElement(txtEmpType).click().build().perform();
		Thread.sleep(1000);
		txtEmpType.sendKeys(empType);
		Thread.sleep(1000);

	}

	public void saveColleague() throws InterruptedException {
		driver.switchTo().defaultContent();
		actions.sendKeys(btnSaveColleague).click().build().perform();
		switchToFrame();
		Thread.sleep(500);
		btnConfirmYes.click();
	};
}
