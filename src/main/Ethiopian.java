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

	public Ethiopian(WebDriver driver) {
		this.driver = driver;
	}
	
	public void bookingPageInit() {

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
		
		new Thread(task).start();	
		
	}
	
	public void trainInit() {
		this.executionOrder.offer(
				new Element(
						driver,
						ElementAction.click,
						Element.LocatorType.id,
						"no-railway")
				);
	}
	
	public void train() {
		
		Runnable task = () -> {
			Element element;
			while(executionOrder.size()>0) {
				element = executionOrder.poll();
				element.find(20l);
				element.execute();
			}

		};
		
		new Thread(task).start();	

	}
	
	public void departureFlightInit() {
	
		String xpath = "/html[@id='world-wide-air']/body/div[@id='app']/div[@class='chrome windows has-scrollbar']/div[@id='main-content']/div/div[@class='dxp-view dxp-summary-bar-enhanced-view']/div[@class='dxp-background']/div[@class='background-content']/div[@class='dxp-breadcrumbs-enhanced-view centered-content b2c']/div/div[@class='flight-selection-view']/div[@class='dxp-view dxp-shared-flight-selection']/div[@class='centered-content']/div[@class='dxp-flight-selection']/div[@class='flights']/table[@class='flights-table']/tbody[@class='dxp-flight multi-row'][1]/tr[@id='flight-201804272205201804281120-0-0']/td[@class='column flight-prices dxp-cabin-offers'][1]/div[@id='offer-container-0-0']";
					
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
			
			xpath = "";
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
		
	}
	
	public void departureFlight() throws InterruptedException {

		Runnable task = () -> {
			Element element;
			while(executionOrder.size()>0) {
				element = executionOrder.poll();
				element.find(30l);
				element.execute();
			}

		};
		
		new Thread(task).start();	

	}
	
	public void returnFlightInit() {
		
		String xpath = "/html[@id='world-wide-air']/body/div[@id='app']/div[@class='chrome windows has-scrollbar']/div[@id='main-content']/div/div[@class='dxp-view dxp-summary-bar-enhanced-view']/div[@class='dxp-background']/div[@class='background-content']/div[@class='dxp-breadcrumbs-enhanced-view centered-content b2c']/div/div[@class='flight-selection-view']/div[@class='dxp-view dxp-shared-flight-selection']/div[@class='centered-content']/div[@class='dxp-flight-selection']/div[@class='flights']/table[@class='flights-table']/tbody[@class='dxp-flight multi-row'][1]/tr[@class='dxp-flight-row']/td[@class='column flight-prices dxp-cabin-offers'][1]/div[@id='offer-container-0-0']/button[@class='dxp-button small secondary offer non-disabled-flights']/div[@class='name']";
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
		
		 xpath = "/html[@id='world-wide-air']/body/div[@id='app']/div[@class='chrome windows has-scrollbar']/div[@id='main-content']/div/div[@class='dxp-view dxp-summary-bar-enhanced-view']/div[@class='dxp-background']/div[@class='background-content']/div[@class='dxp-breadcrumbs-enhanced-view centered-content b2c']/div/div[@class='flight-selection-view']/div[@class='dxp-view dxp-shared-flight-selection']/div[@class='centered-content']/div[@class='dxp-flight-selection']/div[@class='flights']/table[@class='flights-table']/tbody[@class='dxp-flight multi-row'][1]/tr[@class='dxp-flight-row']/td[@class='column flight-prices dxp-cabin-offers'][1]/div[@id='offer-container-0-0']/button[@class='dxp-button small secondary offer non-disabled-flights']/div[@class='name']";
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

		
	}
	
	public void returnFlight() throws InterruptedException {

		Runnable task = () -> {
			Element element;
			while(executionOrder.size()>0) {
				element = executionOrder.poll();
				element.find(30l);
				element.execute();
			}

		};
		
		new Thread(task).start();	

	}
}
