package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.RegisterPage;
import TestBase.BaseClass;
import Utilities.randomString_generator;

public class TC_001_AccountRegistration extends BaseClass {
	
	
	@Test(groups = {"sanity","master"})
	public void verifyaccountregistration() {
		
		try{logger.info("-------------TC_001_AccountRegistration Started--------------");
		test.info("Test started");
		
		HomePage hp = new HomePage(x);
		hp.clickmyaccount();
		test.pass("Clicked on My account");
		logger.info("-------------Clicked on My account--------------");
		
		hp.clickregister();
		test.pass("Clicked on Register");
		logger.info("-------------Clicked on Register--------------");
		
		RegisterPage rp = new RegisterPage(x);
		String password = randomString_generator.randomalphanumeric();
		
		rp.setfirstname(randomString_generator.randomstring());
		test.pass("Entered first name");
		logger.info("-------------Entered name--------------");
		
		rp.setlastname(randomString_generator.randomstring());
		test.pass("Entered last name");
		logger.info("-------------Enteredd last name--------------");
		
		rp.setmail(randomString_generator.randomstring()+"@gmail.com");
		test.pass("Entered mail id");
		logger.info("-------------Entered mail id--------------");
		
		rp.settelephone(randomString_generator.randomnumber());
		test.pass("Entered mobile number");
		logger.info("-------------Entered mobile number--------------");
		
		rp.setpassword(password);
		test.pass("Entered password");
		logger.info("-------------Entered password--------------");
		
		rp.setconfirmpassword(password);
		test.pass("Entered confirm password");
		logger.info("-------------Entered confirm password--------------");
		
		
		rp.checkpolicy();
		test.pass("Checked policy");
		logger.info("-------------checked policy--------------");
		
		rp.clickcontinue();
		test.pass("Clicked continue");
		logger.info("-------------clicked to continue--------------");
		
		String confmsg = rp.getconfirmmsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		test.pass("Account created successfully");
		logger.info("-------------test cast completed--------------");
		
	}
	catch(Exception e){
		test.fail("Test case failed due to exception: " + e.getMessage());
		logger.error("Exception occurred in TC_001_AccountRegistration", e);
		Assert.fail("Exception in test execution: " + e.getMessage());
		}
	}
		
}
