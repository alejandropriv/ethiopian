package Utilities;

import org.openqa.selenium.By;
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
	}
		
	
	public ErrorObject getError() {
		return this.error;
	}

	public void execute() {
		Action action = new Action(this.action, this.webElement,this.keys);
		action.execute();
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



/**public boolean waitForElement(WebElement webElement,
int waitingInterval,
int timeout,
int additionalSleep) {

waiterLatch = new CountDownLatch(1);
Runnable waiterTask = () -> {			
try {
for(;;) {

if(webElement.isDisplayed() && webElement.isEnabled()) {
waiterLatch.countDown();
System.out.println("webElement displayed");
break;

}else {
Thread.sleep(waitingInterval);
System.out.println("waiting: "+ waitingInterval);
}

}
}catch(InterruptedException e) {
this.error = new ErrorObject(
ErrorDefinitions.interrupted_exception_id,
ErrorDefinitions.interrupted_exception_msg
);

waiterLatch.countDown();
}

};

waiterThread = new Thread(waiterTask);
waiterThread.start();
boolean result;

try {
result = this.waiterLatch.await(timeout, TimeUnit.MILLISECONDS);
System.out.println("LatchResult: "+result);
if(this.error != null) {
result = false;
}

}


catch(Exception e) {
this.error = new ErrorObject(
ErrorDefinitions.interrupted_exception_id,
ErrorDefinitions.interrupted_exception_msg
);
result = false;
}
return result;

}*/
