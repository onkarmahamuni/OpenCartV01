 package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccntRegTest extends BaseClass
{
   
   
   @Test
   public void Acctreg()
   {
	   logger.info("*** Starting the automation***");
	   try
	   {
	   HomePage hp=new HomePage(driver);
	   hp.clickMyaccount();
	   logger.info("Clicked on Myaccount");
	   hp.clickRegister();
	   logger.info("Clicked on registerlink");
	   
	   AccountRegistrationPage regacc=new AccountRegistrationPage(driver);
	   logger.info("Providing customer details");
	   regacc.SetFirstName(randomString().toUpperCase());
	   regacc.SetLastName(randomString().toUpperCase());
	   regacc.SetEmail(randomString()+"@gmail.com");
	   regacc.SetTelephone(randomNumber());
	   
	   String password=randomAlphnumeric();
	   regacc.SetPassword(password);
	   regacc.SetConfirmPassword(password);
	   
	   regacc.CheckPolicy();
	   regacc.SetContinue();
	   
	   logger.info("Validating expected msg");
	   String confmmsg=regacc.getConfirmationmsg();
	   Assert.assertEquals(confmmsg,"Your Account Has been Created!");
	   }
	   catch(Exception e)
	   {
		   logger.error("Test case failed");
		   logger.error("debug logs");
		   Assert.fail();
	   }
   }
   
   
}
