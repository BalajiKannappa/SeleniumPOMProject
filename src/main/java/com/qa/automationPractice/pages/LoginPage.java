package com.qa.automationPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationPractice.base.BasePage;
import com.qa.automationPractice.utils.AppConstants;
import com.qa.automationPractice.utils.ElementActions;

public class LoginPage extends BasePage{
	
	
	WebDriver driver;
	ElementActions elementActions;
	
	//1.Page objects/elements
	By username = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='passwd']");
	By signinButton = By.xpath("//button[@name='SubmitLogin']");
	By loginPageHeader = By.xpath("//h1[text()='Authentication']");
	By LoginErrormessage = By.xpath("//div/p[text()='There is 1 error']");
	
	
	//2.Page constructor
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
		
	}
	
	//3.Page actions/methods
	public String getPageTitle(){
		return elementActions.doGetPageTitle(AppConstants.LOGIN_PAGE_TITLE);
	}
	
	public Boolean verifyLoginPageHeader(){
		
		return elementActions.doIsDisplayed(loginPageHeader);
		//return driver.findElement(loginPageHeader).isDisplayed();
	}
	
	public HomePage doSignIn(String emailID, String pwd){
		elementActions.doClearText(username);
		elementActions.doSendKeys(username, emailID);
		elementActions.doClearText(password);
		elementActions.doSendKeys(password, pwd);
		elementActions.doClick(signinButton);
		
		/*driver.findElement(username).clear();
		driver.findElement(username).sendKeys(emailID);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signinButton).click();*/
		
		return new HomePage(driver);
	}
	
	public String getInvalidLoginErrorMessage(){
		return driver.findElement(LoginErrormessage).getText();
	}
	
	public void clearElement(By locator){
		driver.findElement(locator).clear();
	}
	
	

}
