package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{
	
	WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='login-button']")
	WebElement lgnbtn;
	
	@FindBy(xpath = "//h3[normalize-space()='Exams List']")
	WebElement pagetitle;
	
	public void setusername()
	{
		username.sendKeys("digiproductsadmin@digivalsolutions.com");
	}
	
	public void setpassword()
	{
		password.sendKeys("digiassess@#801");
	}
	public void clickLogin() 
	{
		lgnbtn.click();
	}
	public void getpagetitle()
	{
		pagetitle.getText();
	}



}

