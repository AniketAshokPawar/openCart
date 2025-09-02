package TestCases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import POM.MyAccount;
import TestBase.BaseClass;

public class TC_002_AccountLogin extends BaseClass {

@Test(dataProvider = "dp",groups= {"ddt","regression","master"})
	public void verifylogin(String mail, String pwd, String expresult) {
	
	
	try{logger.info("-------------------Started TC_002_AccountLogin------------------------");
	
	HomePage hp = new HomePage(x);
	
	hp.clickmyaccount();
	test.pass("Clicked My Account");
	logger.info("-------------------clicked my account-------------------------");
	
	hp.clicklogin();
	test.pass("Clicked login");
	logger.info("-------------------clicked login-------------------------");
	
	LoginPage lp = new LoginPage(x);
	
	lp.entermail(mail);
	lp.enterpassword(pwd);
	lp.clicklogin();
	test.pass("Entered credentials");
	
	MyAccount ma = new MyAccount(x);
	boolean targetpage = ma.myaccountpageexists();
	
	if (expresult.equalsIgnoreCase("Valid")) {
	    // Expect login to succeed
	    Assert.assertTrue(targetpage, "Valid credentials should login successfully");
	    if (targetpage) {
	    	test.pass("Login successful with valid credentials");
	    	logger.info("-------------------login successfully-------------------------");
	        // logout button exists only if login succeeded
	        ma.clicklogout();
	        logger.info("-------------------logout successfully-------------------------");
	    }
	} else if (expresult.equalsIgnoreCase("Invalid")) {
	    // Expect login to fail
	    Assert.assertFalse(targetpage, "Invalid credentials should NOT login");
	    test.pass("Invalid credentials - login failed");
	    logger.info("-------------------Invalid data-------------------------");
	    // No logout click needed here because page did NOT change
	}
	
	logger.info("-------------------Finished TC_002_AccountLogin-------------------------");
	}
	catch(Exception e) {
	
		test.fail("Test case failed due to exception: " + e.getMessage());
		logger.error("Exception occurred in TC_002_AccountLogin", e);
		Assert.fail("Exception in test execution: " + e.getMessage());
		}
}

@DataProvider(name="dp")
Object[][] logindata(){
	Object data[][] = {
			{"aniketp10091999@gmail.com", "aniket10091999", "Valid"},
            {"wrongemail@gmail.com", "wrongpass", "Invalid"},
            {"aniketp10091999@gmail.com", "wrongpass", "Invalid"},
            {"anotherwrong@gmail.com", "test123", "Invalid"}
	};
	
	return data;
}
}
