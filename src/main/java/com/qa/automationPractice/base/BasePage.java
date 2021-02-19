package com.qa.automationPractice.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop){
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}
		else{
			System.out.println("The given browser name "+browserName+" is not available. Please check the browser name");			
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	/**
	 * 
	 * @return This method returns properties object (prop) which contains the configuration 
	 * values from config.properties file
	 * @throws IOException
	 */
	 
	
	public Properties init_prop() throws IOException{
		
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(".\\src\\main\\java\\com\\qa\\automationPractice\\config\\config.properties");
			prop.load(fs);
			
			}catch (IOException e) {
				
				e.printStackTrace();
			
			}
		
		return prop;
		
	}
	

}
