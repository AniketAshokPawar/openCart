package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver x) {
		super(x);
	}
	
	//xpath
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement mail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmpassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkpolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confmmsg;
	
	
	public void setfirstname(String fn){
		firstname.sendKeys(fn);
	}
	
	public void setlastname(String ln) {
		lastname.sendKeys(ln);
	}
	
	public void setmail(String ml) {
		mail.sendKeys(ml);
	}
	
	public void settelephone(String tp) {
		telephone.sendKeys(tp);
	}
	
	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setconfirmpassword(String cpwd) {
		confirmpassword.sendKeys(cpwd);
	}
	
	public void checkpolicy() {
		checkpolicy.click();
	}
	
	public void clickcontinue() {
		btncontinue.click();
	}
	
	public String getconfirmmsg() {
		
		try {
			return confmmsg.getText();
		
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
