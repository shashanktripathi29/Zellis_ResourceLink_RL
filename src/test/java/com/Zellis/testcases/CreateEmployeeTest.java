package com.Zellis.testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.Zellis.Base.BaseClass;
import com.Zellis.Config.ReadConfig;
import com.Zellis.PageObject.BasePage;
import com.Zellis.PageObject.CreateEmployeeAllPage;
import com.Zellis.Utilities.UiUtilities;

public class CreateEmployeeTest extends BaseClass {

	public CreateEmployeeAllPage createEmp;
	public UiUtilities utility;
	private static final Logger logger = LogManager.getLogger(CreateEmployeeTest.class);

	public BasePage basePage;

	@Test()

	public void verifyDCEmployeePersonalDetailsAddition() throws InterruptedException, IOException, ParseException {

		createEmp = new CreateEmployeeAllPage(driver);
		basePage = new BasePage(driver);
		utility = new UiUtilities(driver);

		String fastPath = ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("CreateEmpFastPath");

		logger.info("Wait and Enter Create Employee -All detail Fast Path");
		wait.until(ExpectedConditions.visibilityOf(createEmp.txtFastPath));
		createEmp.enterFastPath(fastPath);

		logger.info("Switch to Frame to Enter Employee Number");
		basePage.switchToFrame();
		basePage.doubleClick(driver, createEmp.txtEnterEmpNo);

		createEmp.enterEmployeeNo(utility.getEmployeeNumber());
		logger.info("Switch back to default Frame");
		driver.switchTo().defaultContent();

		logger.info("Switch to Frame to click exit and select default Country DC");
		basePage.switchToFrame();
		Thread.sleep(25000);
		basePage.doubleClick(driver, createEmp.btnExit);
		driver.switchTo().defaultContent();
		logger.info("Switch back to default Frame");

		logger.info("Switch to frame to enter Personal Details");
		basePage.switchToFrame();

		List<Map<String, String>> testDataList = ReadConfig.getTestData(testdata, GNEMPALLData);
		String lastname = testDataList.get(0).get("LastName");
		String title = testDataList.get(0).get("Title");
		String firstName = testDataList.get(0).get("FirstName");
		String sex = testDataList.get(0).get("Sex");
		String dateOfBirth = testDataList.get(0).get("DOB");
		String NationalInsuranceNo = testDataList.get(0).get("NationalInsurance");

		createEmp.enterPersonalDetails(lastname, title, firstName, sex, dateOfBirth, NationalInsuranceNo);

		driver.switchTo().defaultContent();
		logger.info("Switch back to default Frame");

		logger.info("Switch to frame to exit Warning-multi occurance of National Insurance");
		basePage.switchToFrame();

		wait.until(ExpectedConditions.elementToBeClickable(createEmp.btnMultiExit));
		Thread.sleep(300);
		createEmp.btnMultiExit.click();

		driver.switchTo().defaultContent();
		logger.info("Switch back to default Frame");

	}

	@Test(dependsOnMethods = "verifyDCEmployeePersonalDetailsAddition")
	public void verifyDCEmployeeHomeDetail() throws InterruptedException, IOException, ParseException {

		List<Map<String, String>> homeAddress = ReadConfig.getTestData(testdata, HomeAddress);
		String address1 = homeAddress.get(0).get("address1");
		String address2 = homeAddress.get(0).get("address2");
		String address3 = homeAddress.get(0).get("address3");
		String address4 = homeAddress.get(0).get("address4");
		String country = homeAddress.get(0).get("county");
		String postCode = homeAddress.get(0).get("postCode");

		createEmp.enterHomeAddress(address1, address2, address3, address4, country, postCode);

	}

	@Test(dependsOnMethods = "verifyDCEmployeeHomeDetail")
	public void verifyDCBasicPayDetails() throws InterruptedException, IOException, ParseException {

		List<Map<String, String>> basicpaydetails = ReadConfig.getTestData(testdata, BasicPayDetails);
		String group = basicpaydetails.get(0).get("group");
		String effectivedate = basicpaydetails.get(0).get("effectivedate");
		String mode = basicpaydetails.get(0).get("mode");

		createEmp.btnBasicPayDetails.click();
		createEmp.enterBasicPayDetails(group, effectivedate, mode);
	}

	@Test(dependsOnMethods = "verifyDCBasicPayDetails")
	public void verifyDCCurrentFuturePost() throws InterruptedException, IOException, ParseException {

		List<Map<String, String>> currentFuturePost = ReadConfig.getTestData(testdata, currentPost);

		String CurrentPostStartDate = currentFuturePost.get(0).get("postStartDate");
		String DCHourlyPost = currentFuturePost.get(0).get("DCpost");
		String DCHourlyPositionStatus = currentFuturePost.get(0).get("PositionStatus");

		createEmp.MoveToCurrentFutureDCPost(CurrentPostStartDate, DCHourlyPost);
		Thread.sleep(1000);
		createEmp.enterServiceConditions(DCHourlyPositionStatus);
		createEmp.enterDCHourlyGrade();
	}

	@Test(dependsOnMethods = "verifyDCCurrentFuturePost")
	public void verifyDCEmployeeDetails() throws InterruptedException, IOException, ParseException {
		List<Map<String, String>> empTypedetails = ReadConfig.getTestData(testdata, employementDetails);
		String EmployeeType = empTypedetails.get(0).get("EmployeeType");
		createEmp.EmployeeDetails(EmployeeType);
		createEmp.saveColleague();

	}
}
