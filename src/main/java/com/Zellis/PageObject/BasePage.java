package com.Zellis.PageObject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//iframe[contains(@id,'_iframe')]")
	public WebElement iFrame;


	public void switchToFrame() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // max 10s wait
		Thread.sleep(1800);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
		
	}

	
	public void clickLongAndSendkey(WebDriver driver, WebElement element, String elementvalue) {
		actions = new Actions(driver);
		actions.clickAndHold(element).pause(Duration.ofSeconds(5)).release().sendKeys(elementvalue).perform();

	}

	public void clickAndSendkey(WebDriver driver, WebElement element, String elementvalue) {
		actions = new Actions(driver);
		actions.clickAndHold(element).pause(Duration.ofMillis(1100)).release().sendKeys(elementvalue).perform();

	}
	public void doubleClick(WebDriver driver, WebElement element) throws InterruptedException {
		actions = new Actions(driver);
		Thread.sleep(9500);
		//actions.doubleClick(element).build().perform();
		actions.clickAndHold(element).pause(Duration.ofMillis(900)).release().perform();
	}

	public void jsScrollToElement(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

	}
}
