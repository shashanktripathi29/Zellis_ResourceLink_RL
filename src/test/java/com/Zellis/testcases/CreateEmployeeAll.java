package com.Zellis.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.Zellis.PageObject.BasePage;
import com.Zellis.PageObject.CreateEmployeeAllPage;
import com.Zellis.Utilities.ReadConfig;
import com.Zellis.Utilities.Utility;

public class CreateEmployeeAll extends BaseClass {

	public CreateEmployeeAllPage createEmp;
	public Utility utility;

	public BasePage basePage = new BasePage(driver);

	@Test(priority = 2)

	public void verifyDCEmployeeCreation() throws InterruptedException, IOException, ParseException {

		createEmp = new CreateEmployeeAllPage(driver);
		wait.until(ExpectedConditions.visibilityOf(createEmp.txtFastPath));
		createEmp
				.enterFastPath((String) ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("CreateEmpFastPath"));
		basePage = new BasePage(driver);
	//	basePage.iFrameHandle();
		basePage.switchToFrame();
		utility = new Utility(driver);
		createEmp.enterEmployeeNo(utility.getEmployeeNumber());
		//basePage.iFrameHandle();
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		basePage.switchToFrame();
		createEmp.btnExit.click();
		//basePage.iFrameHandle();
		
		driver.switchTo().defaultContent();
		//Thread.sleep(4000);
		basePage.switchToFrame();
		Thread.sleep(5000);
		createEmp.enterPersonalDetails((String) ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("LastName"),
				(String) ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("Title"),
				(String) ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("FirstName"),
				(String) ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("Sex"),
				(String) ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("DOB"),
				(String) ReadConfig.getTestData(testdata, GNEMPALLData).get(0).get("NationalInsurance"));
		//basePage.iFrameHandle();
		driver.switchTo().defaultContent();
		//Thread.sleep(4000);
		basePage.switchToFrame();
		Thread.sleep(2000);
		createEmp.btnMultiExit.click();
		driver.switchTo().defaultContent();

		createEmp.btnHomeMenu.click();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		actions.sendKeys(" Test Add1").perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).sendKeys("Test Add2").perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).sendKeys("Test Add three").perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).sendKeys("city test").perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).sendKeys("county test").perform();
		Thread.sleep(1200);
		actions.sendKeys(Keys.TAB).sendKeys("HA3 0UX").perform();
		Thread.sleep(1200);
		actions.sendKeys(Keys.TAB);

		actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Basic Pay Details')]"))).click()
				.perform();
		Thread.sleep(2000);
		actions.sendKeys("PGUKL1300").perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.TAB);

		Thread.sleep(1000);
		actions.sendKeys("01/01/2025").perform();
		Thread.sleep(1500);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.sendKeys("CASH").perform();
		/*
		 * actions.moveToElement(driver.findElement(By.
		 * xpath("//span[contains(text(),'Basic Pay Details')]"))).click() .perform();
		 * Thread.sleep(2000); actions.moveToElement(driver.findElement(By.
		 * xpath("//span[contains(text(),'Fin Inst Det')]"))).click() .perform();
		 * Thread.sleep(2000); actions.sendKeys("00-00-01").perform();
		 * Thread.sleep(2000);
		 * actions.sendKeys(Keys.TAB).sendKeys("12344321").perform();
		 * Thread.sleep(2000); actions.sendKeys(Keys.TAB).perform(); Thread.sleep(2000);
		 * actions.sendKeys("0").perform(); Thread.sleep(2000);
		 * actions.sendKeys(Keys.TAB); Thread.sleep(2000);
		 */
//...........................
		//Current FuturePost -Landing Page
		actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Current/Future Post')]"))).click()
				.perform();
		Thread.sleep(2000);
//Move to frame
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'_iframe')]"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);

		actions.moveToElement(driver.findElement(By.xpath("//input[@id='proiv_MD47S1B-DATE_1Text']"))).click()
				.sendKeys("01/01/2025").sendKeys(Keys.TAB).perform();
		Thread.sleep(1500);

		actions.moveToElement(driver.findElement(By.xpath("//input[contains(@id,'POST_1Input')]"))).sendKeys("1015")
				.sendKeys(Keys.TAB).perform();

		Thread.sleep(3000);

		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2500);
		
		//Current Post-Conditions of Service
		driver.findElement(By.xpath("//a[@title='Conditions of Service']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[contains(@id,'CONDID-W2Button')]")).click();
		Thread.sleep(2500);
		WebElement startDate = driver.findElement(By.xpath("//input[contains(@id,'STDATE')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", startDate);
		startDate.click();
		startDate.sendKeys("01/01/2025", Keys.TAB);
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//input[contains(@id,'EmpPostService')]"))).click()
				.sendKeys("UKDH_NT").sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//span[contains(@id,'W3Text_Exit')]"))).click()
				.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		// ..................
		driver.findElement(By.xpath("//button[contains(@id,'POS_STAT')]")).click();
		Thread.sleep(3000);

		// driver.findElement(By.xpath("//button[contains(@id,'CONDID-W2Button')]")).click();
		Thread.sleep(1000);
		WebElement posStartDate = driver.findElement(By.xpath("//input[contains(@id,'STDATE')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", posStartDate);
		posStartDate.click();
		posStartDate.sendKeys("01/01/2025", Keys.TAB);
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//input[contains(@id,'EmpPostPositionStatus')]"))).click()
				.sendKeys("NT3750").sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//span[contains(@id,'W3Text_Exit')]"))).click()
				.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		//11driver.findElement(By.xpath("//*[contains(@class,'exitbutton')]")).click();
		Thread.sleep(2000);

		// ....grade
		
		driver.findElement(By.xpath("//a[@title='Grade Details']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(@id,'GRADEW-W2F')]")).click();
		Thread.sleep(2000);
	//	driver.switchTo().frame(frame);
		//Scroll into view and then click with JS scroll+focus+click
		WebElement pointInput = driver.findElement(By.id("W2_proiv_MD47G41-GRDPOINT_1Input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", pointInput);
		pointInput.click(); // bring focus to input

		WebElement button = driver.findElement(By.id("W2_proiv_MD47G41-GRDPOINT_1Button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

		//driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//span[text()='Select']")).click();
		Thread.sleep(3000);

		driver.switchTo().defaultContent();

		actions.moveToElement(driver.findElement(By.xpath("//span[contains(@title,'Employment Detail')]"))).click()
				.perform();
		// WebElement frame1 =
		// driver.findElement(By.xpath("//iframe[contains(@id,'_iframe')]"));
		driver.switchTo().frame(frame);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='proiv_MD47S1A-EmployeeTypeInput']")).click();
		WebElement empType = driver.findElement(By.id("proiv_MD47S1A-EmployeeTypeInput"));
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].value='EMP'; arguments[0].dispatchEvent(new Event('input'));", empType);
		Thread.sleep(2000);
		empType.sendKeys("EMP");
		Thread.sleep(4000);

		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		Thread.sleep(1600);
		actions.sendKeys(driver.findElement(By.xpath("//span[text()='Save']"))).click().perform();
		driver.switchTo().frame(frame);
		// actions.sendKeys(driver.findElement(By.xpath("//button[contains(@id,'W2Text_Yes')]"))).click().perform();
		WebElement btn = driver.findElement(By.id("W1_proiv_CTCONFRM-213-W2Text_Yes"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
		Thread.sleep(1000);
		btn.click();

	}
}
