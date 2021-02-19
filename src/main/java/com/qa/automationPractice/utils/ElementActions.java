package com.qa.automationPractice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	/*
	 * This is the constructor
	 */
	
	public ElementActions(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(this.driver, AppConstants.EXPLICIT_WAIT_DEFAULT_TIMEOUT);
	}
	
	/*
	 * This is the method to get any element byt its locator
	 */
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
		element = driver.findElement(locator);
		}
		catch(Exception e){
			System.out.println("Some execption occured while locating this webelement: "+locator);
		}
		return element;
	}
	
	/*
	 * This is the method for click action
	 */
	
	public void doClick(By locator){
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String inputData) {
		getElement(locator).sendKeys(inputData);
	}
	
	public Boolean doIsDisplayed(By locator){
		Boolean bool = getElement(locator).isDisplayed();
		return bool;
	}
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	public void waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
	}
	
	public void waitForelementVisible(By locator){
		WebElement element = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String doGetPageTitle(String title){
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
		
	}
	
	public void doClearText(By locator){
		getElement(locator).clear();
	}
	
	
	
	
	
	
	

}
