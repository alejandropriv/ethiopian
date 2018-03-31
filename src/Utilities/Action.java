package Utilities;

import org.openqa.selenium.WebElement;

public class Action {

	public enum ElementAction{
		click,
		sendKeys,
		getText
	}
	
	WebElement element;
	ElementAction action;
	String keys ="";
	
	
	public Action(ElementAction action, WebElement element, String keys) {
		this.action = action;
		this.element = element;			
		this.keys = keys;
	}

	public void execute() {
		switch (this.action){
			case  click:{
				this.element.click();
				System.out.println("Element: Action: click");
				break;
			}
			case sendKeys:{
				this.element.sendKeys(this.keys);
				System.out.println("Element: Action: sendKeys");
				break;
			}
			case getText:{
				String Text = this.element.getText();
				System.out.println("Element: "+Text+" Action: getText");
				break;
			}
				
		}
			
			
	}

}
