package com.qa.automationPractice.tests;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.automationPractice.base.BasePage;
import com.qa.automationPractice.pages.HomePage;
import com.qa.automationPractice.pages.LoginPage;
import com.qa.automationPractice.utils.AppConstants;

public class HomePageTest {
	
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homePage;
	
	@BeforeTest
	public void setUp(){
		
		basepage = new BasePage();
		
		try {
			prop = basepage.init_prop();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		homePage = loginpage.doSignIn(prop.getProperty("emailID"), prop.getProperty("pwd"));
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String title = homePage.getPagetitle();
		System.out.println("Home page title is "+title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeader(){
		String header = homePage.isHomepageHeaderExist();
		System.out.println("Home page header is "+header);
		Assert.assertEquals(header, AppConstants.HOME_PAGE_HEADER);
		
	}
	
	@Test(priority=3)
	public void verifyUserLoggedin(){
		String loggedinUser = homePage.isLoggedinUsernameExist();
		System.out.println("LoggedIn username is "+loggedinUser);
		Assert.assertEquals(loggedinUser, AppConstants.LOGGEDIN_USER_NAME);
	}
	
	
	@AfterTest
	public void testDown(){
		driver.quit();
	}
	
	

}
