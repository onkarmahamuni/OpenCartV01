package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);		
	}
     
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement txtContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has been Created!']")
	WebElement msgconfirmation;
	
	public void SetFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void SetLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}	
	public void SetEmail(String mail)
	{
		txtEmail.sendKeys(mail);
	}	
	public void SetTelephone(String Telno)
	{
		txtTelephone.sendKeys(Telno);
	}	
	public void SetPassword(String password)
	{
		txtPassword.sendKeys(password);
	}	
	public void SetConfirmPassword(String CPassword)
	{
		txtConfirmPassword.sendKeys(CPassword);
	}	
	public void CheckPolicy()
	{
		chkPolicy.click();
	}
	public void SetContinue()
	{
		txtContinue.click();
	}
	
	public String getConfirmationmsg()
	{
		try {
			return(msgconfirmation.getText());
		} catch(Exception e) {
			return (e.getMessage());
		}
	}
}

