package main;

import java.awt.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Action.ElementAction;
import Utilities.Element;
import errorhandling.ErrorDefinitions;
import errorhandling.ErrorObject;

public class Ethiopian {

	WebDriver driver = null;
	WebElement departCityTxt = null;
	WebElement returnCityTxt = null;
	WebElement departureDate = null;
	WebElement returnDate = null;
	WebElement submitButton = null;
	WebElement railwayNoButton = null;
	WebElement economyButton = null;
	

	ErrorObject error;

	Deque<Element> executionOrder = new ArrayDeque<Element>();

	String webpageStr  = "https://www.ethiopianairlines.com/AA/DE/";
	
	
	public Ethiopian(WebDriver driver) {
		this.driver = driver;
	}
	
	public void bookingPageInit() {
		this.driver.get(webpageStr);

		this.executionOrder.offer(
				new Element(
						driver,
						ElementAction.sendKeys,
						Element.LocatorType.id,
						"departCity",
						"Frankfurt (FRA), Germany"
						)
				);
		
		this.executionOrder.offer(
				new Element(
						driver,
						ElementAction.sendKeys,
						Element.LocatorType.id,
						"returnCity",
						 "Mombassa (MBA), Kenya")
				);
		
		this.executionOrder.offer(
				new Element(
						driver,
						ElementAction.sendKeys,
						Element.LocatorType.id,
						"depYear",
						 "27 Apr 2018")
				);
		
		this.executionOrder.offer(
				new Element(
						driver,
						ElementAction.sendKeys,
						Element.LocatorType.id,
						"retYear",
						 "1 May 2018")
				);
		
		this.executionOrder.offer(
				new Element(
						driver,
						ElementAction.click,
						Element.LocatorType.id,
						"submit-btn-booking-dx")
				);
		
		this.executionOrder.offer(
				new Element(
						driver,
						ElementAction.click,
						Element.LocatorType.id,
						"no-railway")
				);
		/*
	String xpath = "/html[@id='world-wide-air']/body/div[@id='app']/div[@class='chrome windows has-scrollbar']/div[@id='main-content']/div/div[@class='dxp-view dxp-summary-bar-enhanced-view']/div[@class='dxp-background']/div[@class='background-content']/div[@class='dxp-breadcrumbs-enhanced-view centered-content b2c']/div/div[@class='flight-selection-view']/div[@class='dxp-view dxp-shared-flight-selection']/div[@class='centered-content']/div[@class='dxp-flight-selection']/div[@class='flights']/table[@class='flights-table']/tbody[@class='dxp-flight multi-row'][1]/tr[@id='flight-201804272205201804281120-0-0']/td[@class='column flight-prices dxp-cabin-offers'][1]/div[@id='offer-container-0-0']/button[@class='dxp-button small secondary offer non-disabled-flights']/div[@class='price-container']/div[@class='dxp-price']/span[@class='alternative']/span[@class='price']";
				
		executionOrder.add(
				new Element(
						driver,
						ElementAction.getText,
						Element.LocatorType.xpath,
						xpath)
				);
		
		executionOrder.add(
				new Element(
						driver,
						ElementAction.click,
						Element.LocatorType.xpath,
						xpath)
				);	
	*/
	}
	
	public void createBooking() throws InterruptedException {
		
		Runnable task = () -> {
			Element element;
			while(executionOrder.size()>0) {
				element = executionOrder.poll();
				element.find(20l);
				element.execute();
			}

		};
		
		Thread bookingThread = new Thread(task);
		bookingThread.start();	
		
	}
	
	public void validateBookingInit() {
		
		/*Element wait =  new Element();
		wait.waitForElement(this.economyButton, 500, 30000,1000);
		
		this.economyButton = driver.findElement(By.xpath(economyButtonXpath)); 
			*/
	}
	
	public void validateBooking() throws InterruptedException {
		/*
		System.out.println(this.economyButton.getText());		
	
		this.economyButton.click();
		Thread.sleep(15000);
	*/}
	

}
