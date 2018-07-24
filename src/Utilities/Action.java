package Utilities;

import org.openqa.selenium.Keys;
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
	private Keys specialKeys = null;
	
	
	public Action(ElementAction action, WebElement element, String keys) {
		this.action = action;
		this.element = element;			
		this.keys = keys;
	}

	public Action(ElementAction action, WebElement element, Keys specialKeys) {
		this.action = action;
		this.element = element;			
		this.specialKeys = specialKeys;
	}

	public void execute() {
		switch (this.action){
			case  click:{
				this.element.click();
				System.out.println("Element: Action: click");
				break;
			}
			case sendKeys:{
				if(this.specialKeys != null) {
					this.element.sendKeys(this.specialKeys);
					System.out.println("Element: Action: sendKeys");
					
				}else {
					this.element.sendKeys(this.keys);
					System.out.println("Element: Action: sendKeys");
				}
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
