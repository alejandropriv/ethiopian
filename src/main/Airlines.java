package main;

import java.util.concurrent.TimeUnit;

import Utilities.Element;
import airlines.CheapFlights;

public class Airlines {

	public static void main (String[] args) {

		CheapFlights cheapFlights = new CheapFlights();
		
	}
	
	public void ethiopian() {
		
		Driver driver = new Driver(0);
		Ethiopian ethiopian = new Ethiopian(driver.driver); 

		String webpageStr  = "https://www.ethiopianairlines.com/AA/DE/";
		driver.driver.get(webpageStr);
		driver.driver.manage().window().maximize();
		
		try {
			ethiopian.bookingPageInit();
			ethiopian.createBooking();
			
			driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			
			ethiopian.trainInit();
			ethiopian.train();	

			ethiopian.departureFlightInit();
			ethiopian.departureFlight();
		
			driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			ethiopian.returnFlightInit();
			ethiopian.returnFlight();
			
			//driver.driver.close();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
