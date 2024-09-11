package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;
	public Logger logger;   //Log4j2
	public Properties p;
	   @BeforeClass
	   @Parameters({"os","browser"})
	   public void setup(String os, String br) throws IOException
	   {
		   //loading config.properties
		   FileReader file=new FileReader("./src//test//resources//config.properties");
		   p=new Properties();
	       p.load(file);
		  
		   logger=LogManager.getLogger(this.getClass());  //log4j2
		   
		   switch(br.toLowerCase())
		   {
		   case "chrome" :driver=new ChromeDriver(); break;
		   case "edge" :driver=new EdgeDriver(); break;
		   case "firefox" :driver=new FirefoxDriver(); break;
		   default : System.out.println("invalid browser"); return;
		   }
		      
		   driver=new ChromeDriver();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.get(p.getProperty("appURl"));  //reading url from config.properties
		   driver.manage().window().maximize();
	   }
	   @AfterClass
	   public void teardown()
	   {
		   driver.close();
	   }
	   
	   public String randomString()
	   {
		  String generatedString=RandomStringUtils.randomAlphabetic(5);
	      return generatedString;  
	   }
	   public String randomNumber()
	   {
		   String generatedno=RandomStringUtils.randomNumeric(10);
		   return generatedno;
	   }
	   
	  public String randomAlphnumeric()
	  {
		  String generatString=RandomStringUtils.randomAlphabetic(3);
		  String generatedno=RandomStringUtils.randomNumeric(4);
		  return (generatString+"@"+generatedno);
	  }
}
