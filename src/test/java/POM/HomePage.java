package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver x) {
		super(x);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;
	
	public void clickmyaccount() {
	myaccount.click();
	}
	
	public void clickregister() {
		register.click();
	}
	
	public void clicklogin() {
		login.click();
	}
	
	
}
