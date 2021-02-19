package com.qa.automationPractice.tests;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.automationPractice.base.BasePage;
import com.qa.automationPractice.pages.LoginPage;
import com.qa.automationPractice.utils.AppConstants;

public class LoginPageTest {
	
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	
		
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
		
	}
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String title = loginpage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeaderTest(){
		Assert.assertTrue(loginpage.verifyLoginPageHeader());
	}
	
	@Test(priority=4)
	public void verifyLogin(){
		loginpage.doSignIn(prop.getProperty("emailID"), prop.getProperty("pwd"));
	}
	
	
	@DataProvider
	public Object[][] invalidTestData(){
		
		Object data[][] = {
		
		{"test@gmail.com","test"},
		{"test123@gmail.com"," "},
		{" ", "password"},
		{"test1234@gmail.com","jjiko"}
		
		};		
		return data;
		
	}	
	
	
	@Test(priority=3, dataProvider="invalidTestData")
	public void verifyInvalidLogin(String email, String pwd){
		//loginpage.clearElement(email);
		loginpage.doSignIn(email, pwd);
		String message = loginpage.getInvalidLoginErrorMessage();
		Assert.assertEquals(message, "There is 1 error");
	}
	
	
	@AfterTest
	public void testDown(){
		driver.quit();
	}
	

}
