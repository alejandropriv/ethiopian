package airlines;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingQueue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Element;
import Utilities.Action.ElementAction;
import errorhandling.ErrorObject;
import main.Driver;

public class CheapFlights {

	private Driver driver;
	private WebDriver webDriver;
	
	ErrorObject error;
	Deque<Element> executionOrder = new ArrayDeque<Element>();
	//LinkedBlockingQueue<Element> executionQueue = new LinkedBlockingQueue<>();
	
	String webpageStr  = "https://www.cheapflights.com/";


	
	/*WebElement departCityTxt = null;
	WebElement returnCityTxt = null;
	WebElement departureDate = null;
	WebElement returnDate = null;
	WebElement submitButton = null;
	WebElement railwayNoButton = null;
	WebElement economyButton = null;		*/

	public CheapFlights() {
		
		driver = new Driver(0);
		webDriver = driver.driver;
		webDriver.get(webpageStr);
		webDriver.manage().window().maximize();
		
		pageInit();
		try {
			runPageInit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void pageInit() {

		/*this.executionOrder.offer(
				new Element(
						webDriver,
						ElementAction.sendKeys,
						Element.LocatorType.id,
						"departCity",
						"Frankfurt (FRA), Germany"
						)
				);*/
		
		this.executionOrder.offer(
				new Element(
						webDriver,
						ElementAction.sendKeys,
						Element.LocatorType.xpath,
						"//*[contains(@id,'destination')]",
						 "MBA")
				);
		this.executionOrder.offer(
				new Element(
						webDriver,
						ElementAction.sendKeys,
						Element.LocatorType.xpath,
						"//*[contains(@id,'destination')]",
						 Keys.TAB)
				);
			
		this.executionOrder.offer(
				new Element(
						webDriver,
						ElementAction.sendKeys,
						Element.LocatorType.xpath,
						"//*[contains(@id,'depart-input')]",
						"  Thu 7/19")
				);
		
		this.executionOrder.offer(
				new Element(
						webDriver,
						ElementAction.sendKeys,
						Element.LocatorType.xpath,
						"//*[contains(@id,'return-input')]",
						 "  Thu 7/20")
				);
		
		this.executionOrder.offer(
				new Element(
						webDriver,
						ElementAction.click,
						Element.LocatorType.xpath,
						"//*[contains(@id,'submit')]")

				);
		
		
		/*this.executionOrder.offer(
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
				);*/
	}
	
	public void runPageInit() throws InterruptedException {
		
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

}
