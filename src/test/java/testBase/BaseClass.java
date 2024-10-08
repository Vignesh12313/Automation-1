package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;

	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br)
	{
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default : System.out.println("Invalid browser name");return;
	
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://entrance.digi-val.com/fullscreenexam/exam-list/");
		driver.manage().window().maximize();
	    System.out.println("Opened first URL: Exam List");
	    
		
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(2);
		return generatedNumber;
		
	}
	public String captureScreen(String tname) 
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
		File sourcefile = takesscreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath = System.getProperty("user.dir")+ "\\screenshots\\"+ tname + " " + timestamp + ".png";
		File targetfile = new File(targetfilepath);
		
		sourcefile.renameTo(targetfile);
		
		return targetfilepath;
		
	}
	
}
