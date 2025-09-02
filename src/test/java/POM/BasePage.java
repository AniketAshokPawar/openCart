package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver x;
	
	public BasePage(WebDriver x) {
		this.x=x;
		PageFactory.initElements(x, this);
	}
}
