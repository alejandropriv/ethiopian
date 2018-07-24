package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Action.ElementAction;
import errorhandling.ErrorDefinitions;
import errorhandling.ErrorObject;

public class Element {
	
	public enum LocatorType{
		id,
		xpath
	}
	

	private ErrorObject error;


	WebDriver driver = null;
	ElementAction action;
	LocatorType type;
	String locatorId;


	WebElement webElement;
	
	
	String keys = "";
	
	Action seleniumObject;


	private Keys specialKeys;
	
	
	public Element(WebDriver driver, 
			ElementAction action, 
			LocatorType type,
			String locatorId) {
		
		this.driver = driver;
		this.action = action;
		this.type = type;
		this.locatorId = locatorId;	

		
	}
	
	public Element(WebDriver driver,
			ElementAction action,
			LocatorType type,
			String locatorId,
			String keys) {
		
		this.driver = driver;
		this.action = action;
		this.type = type;
		this.locatorId = locatorId;	
		this.keys = keys;
		
		seleniumObject = new Action(this.action, this.webElement,this.keys);
	}
		
	
	public Element(WebDriver driver,
			ElementAction action,
			LocatorType type,
			String locatorId,
			Keys specialKeys) {
		
		this.driver = driver;
		this.action = action;
		this.type = type;
		this.locatorId = locatorId;	
		this.specialKeys = specialKeys;
		
		seleniumObject = new Action(this.action, this.webElement,this.specialKeys);
	}

	public ErrorObject getError() {
		return this.error;
	}

	public void execute() {

		seleniumObject.execute();
	}

	public void find(long timeout) {
		switch(this.type) {
			case id:{
				WebDriverWait wait = new WebDriverWait(this.driver, timeout); 
				webElement = wait.until(
						ExpectedConditions.elementToBeClickable(
								By.id(this.locatorId)
								)
						);
				System.out.println("Found: byId. Id:"+this.locatorId);
				break;
			}
			case xpath:{
				WebDriverWait wait = new WebDriverWait(this.driver, timeout); 
				webElement = wait.until(
						ExpectedConditions.elementToBeClickable(
								By.xpath(this.locatorId)
								)
						);	
				System.out.println("Found: byXpath. Text: "+this.locatorId);
				break;
			}						
		}

	}
}
 
