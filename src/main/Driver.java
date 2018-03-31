package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public WebDriver driver = null; 
	public Driver(int browser) {
		
		if(browser==0) {//chrome
			String exePath = "C:\\chromedriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		
		}
	}
}
