package com.Zellis.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	public String randomEmail() {

		long timestamp = System.currentTimeMillis();
		return "user" + timestamp + "@testmail.com";

	}

	public void iFrameHandle() throws InterruptedException {

		List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));

		for (int i = 0; i < allIframes.size(); i++) {
			WebElement iframe = allIframes.get(i);
			// System.out.println("size " + allIframes.size());
			String id = iframe.getAttribute("id");
			// System.out.println("id"+iframe.getAttribute("id"));
			if (iframe.getAttribute("id") != null && !iframe.getAttribute("id").isEmpty()) {
				String dynamicXpath = String.format("//iframe[@id='%s']", iframe.getAttribute("id"));
				WebElement frameByXpath = driver.findElement(By.xpath(dynamicXpath));
				driver.switchTo().frame(frameByXpath);
				// System.out.println("frameByXpath"+frameByXpath);

			}
		}
	}

	public void switchToFrame() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // max 10s wait
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
	            By.xpath("//iframe[contains(@id,'_iframe')]")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'_iframe')]")));

	}
}
