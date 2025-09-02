package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver x){
		super(x);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement lpmailid;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement lppassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;
	

	
	public void entermail(String mail) {
		lpmailid.clear();
		lpmailid.sendKeys(mail);
	}
	
	public void enterpassword(String pwd) {
		lppassword.clear();
		lppassword.sendKeys(pwd);
	}
	
	public void clicklogin() {
		btnlogin.click();
	}
	
	
}
