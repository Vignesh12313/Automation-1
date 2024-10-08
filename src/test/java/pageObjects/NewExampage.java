package pageObjects;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewExampage extends Basepage{
	
    WebDriver driver;
	
	public NewExampage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//button[@id='new-exam']")
	WebElement newexambtn;
	
	@FindBy(xpath = "//input[@id='exam-name']")
	WebElement examname;
	
	@FindBy(xpath = "//input[@id='start-date']")
	WebElement startdate;
	
	@FindBy(xpath = "//input[@id='start-time']")
	WebElement starttime;
	
	@FindBy(xpath = "//input[@id='end-date']")
	WebElement enddate;
	
	@FindBy(xpath = "//input[@id='end-time']")
	WebElement endtime;
	
	@FindBy(xpath = "//button[@id='next-to-step-2']")
	WebElement nxtbtn;
	
	
	public void createnewExam()
	{
		newexambtn.click();
	}
	public void setexamname()
	{
		examname.sendKeys("Automation Exam");
	}
	
	public void startdatetime()
	{
		
		Date currentDate = new Date();

        // Define the date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Format the current date according to the defined format
        String formattedDate = dateFormat.format(currentDate);

        // Print the formatted date
        System.out.println("Current date in  format: " + formattedDate);
		
        startdate.sendKeys(formattedDate);
        LocalTime currentTime = LocalTime.now();
       
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = currentTime.format(formatter);
        starttime.clear();
        starttime.sendKeys(formattedTime);
        
        enddate.sendKeys(formattedDate);
        LocalTime newTime = currentTime.plusHours(2);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedNewTime = newTime.format(formatter1);
        endtime.clear();
        endtime.sendKeys(formattedNewTime);
        
	 
	}
	public void clickNext()
	{
		nxtbtn.click();
	}
}
