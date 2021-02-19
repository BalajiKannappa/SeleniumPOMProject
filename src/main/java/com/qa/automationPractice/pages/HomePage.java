package com.qa.automationPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	//1. page objects
	
	By loggedInusername = By.xpath("//span[contains(text(),'Balaji Kannappa')]");
	By HomepageHeader = By.xpath("//h1[contains(text(),'My account')]");
	
	
	//2. Contructor
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	//3. page actions/methods
	public String getPagetitle(){
		return driver.getTitle();
	}
	
	public String isLoggedinUsernameExist(){
		if(driver.findElement(loggedInusername).isDisplayed()){
			return driver.findElement(loggedInusername).getText();
		}
		return null;
	}
	
	public String isHomepageHeaderExist(){
		if(driver.findElement(HomepageHeader).isDisplayed()){
			return driver.findElement(HomepageHeader).getText();
		}
		return null;
		
	}
}
