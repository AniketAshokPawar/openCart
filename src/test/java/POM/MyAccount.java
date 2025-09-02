package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{
	
	public MyAccount(WebDriver x) {
		super(x);
	}
	
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement headingmsg;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutbtn;
	
	
	public boolean myaccountpageexists() {
		try {
	        return headingmsg.isDisplayed();
	    } 
		
		catch (Exception e) {
	        return false;
	    }
	}
	
	public void clicklogout() {
		
		logoutbtn.click();
	}
	
	
}
