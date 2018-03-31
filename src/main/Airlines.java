package main;

import java.util.concurrent.TimeUnit;

import Utilities.Element;

public class Airlines {

	public static void main (String[] args) {
		Driver driver = new Driver(0);

		Ethiopian ethiopian = new Ethiopian(driver.driver); 

		try {
			ethiopian.bookingPageInit();
			ethiopian.createBooking();
			
			driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			
			ethiopian.validateBookingInit();
			ethiopian.validateBooking();	
			
			//driver.driver.close();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
