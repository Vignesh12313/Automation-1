package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExamConfigurationpage extends Basepage {

	 public WebDriver driver;
		
		public ExamConfigurationpage (WebDriver driver)
		{
			super(driver);
		}
		
		@FindBy(xpath = "//h1[normalize-space()='Exam - Configuration']")
		WebElement header;
		
		@FindBy(xpath = "//button[@id='add-question-btn']")
		WebElement MCQques;
		
		@FindBy(xpath = "//span[@class=\"toggle-icon\"]")
		List<WebElement> quesopenbtn;
		
		@FindBy(xpath = "//body/div[@class='container main-content']/div[@id='step-2']/div[@class='question-section']/div[@id='questions-container']/div[@id='question-1']/div[@class='question-content']/div[@role='application']/div[@role='presentation']/div[@aria-label='Editor editing area: main']/p[1]")
		WebElement questext;
		
		@FindBy(xpath = "//div[@id='choice-A-1']//p")
		WebElement option1;
		@FindBy(xpath = "//div[@id='choice-B-1']//p")
		WebElement option2;
		@FindBy(xpath = "//div[@id='choice-C-1']//p")
		WebElement option3;
		@FindBy(xpath = "//div[@id='choice-D-1']//p")
		WebElement option4;
		
		@FindBy(xpath = "//input[@value='D']")
		WebElement radiobtn4;
	
		@FindBy(xpath = "//input[@id='file-upload-1']")
		WebElement choosefile;
		
		@FindBy(xpath = "//button[@id='preview-and-next']")
		WebElement previewbtn;
		@FindBy(xpath = "//button[@type='button'][normalize-space()='Next']")
		WebElement nxtbtn1;
		@FindBy(xpath = "//input[@id='email']")
		WebElement stuEmailid;
		@FindBy(xpath = "//input[@id='national_id']")
		WebElement stuNatID;
		@FindBy(xpath = "//input[@id='sla_id']")
		WebElement AdmID;
		@FindBy(xpath = "//button[@id='add-emails-btn']")
		WebElement Addemailbtn;
		@FindBy(xpath = "//button[@id='finalize-btn']")
		WebElement finalizebtn;
		
		@FindBy(xpath = "//tbody/tr[80]/td[8]/button[2]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]" )
		WebElement examstartbtn;
		
		@FindBy(xpath = "//input[@id='email-check']")
		WebElement stuIDcheck;
		@FindBy(xpath = "//button[@id='email-button']")
		WebElement emailclickbtn;
		
		@FindBy(xpath = "//button[@id='add-saq-btn']")
		WebElement SAQques;
		@FindBy(xpath = "//div[@id='question-2']//h3[@class='qtntoggle'][contains(text(),'Question')]")
		WebElement sqaopbtn;
		@FindBy(xpath = "//div[@id='question-2']//p")
		WebElement Sqatext;
		
		
		public void Headertext()
		{
			String actualHeaderText = header.getText();
			
			String expectedHeaderText = "Exam - Configuration";
			
			 if (actualHeaderText.equals(expectedHeaderText)) {
		            System.out.println("Header text is correct: " + actualHeaderText);
		        } else {
		            System.out.println("Header text is incorrect. Expected: " + expectedHeaderText + ", but found: " + actualHeaderText);
		        }
		}
		public void AddMCQques() throws InterruptedException
		{
			
			 // Arrays of dynamic questions and their options
	        String[] questions = {
	            "What is the capital of France?",
	            "Which language is used for Android development?",
	            "What is the square root of 64?",
	            "Who is 'Albert Einsteing'?",
	            "Where is Digival Located?"
	        };

	        String[][] options = {
	            {"Paris", "Berlin", "Madrid", "Rome"},
	            {"Java", "Python", "JavaScript", "Ruby"},
	            {"6", "8", "10", "12"},
	            {"Shakespeare", "Hemingway", "Tolkien", "Rowling"},
	            {"USA", "Saudi", "Dubai", "chennai"}
	        };
			
			
			
			
			/* for (int i = 1; i <= 2; i++)
			 {
				 MCQques.click();
				 Thread.sleep(2000);
				 System.out.println("number "+ i);
				 WebElement Qopenbtn= quesopenbtn.get(quesopenbtn.size() - 1);

				// Click the last element
				 Qopenbtn.click();
				 
				 Thread.sleep(2000);
				 
				 String text = "//div[@id='question-" + i + "']//p[1]";
				 System.out.println(text);
				 WebElement text1 = driver.findElement(By.xpath(text));
				 
//				 WebElement questtext= questext.get(questext.size() - 1);
				 
				// Click the last element
				 
				 
				 
				 text1.click();
				 text1.sendKeys(questions[i]);
				
				 Thread.sleep(3000);
				 option1.click();
		         option1.sendKeys(options[i][0]);
				 Thread.sleep(2000);
				 
				option2.click();
				option2.sendKeys(options[i][1]);
				option3.click();
				option3.sendKeys(options[i][2]);
				option4.click();
				option4.sendKeys(options[i][3]);
				
				 Qopenbtn.click();
				 Thread.sleep(2000);
				
			 }*/
	         MCQques.click();
			 Thread.sleep(2000);
			 WebElement Qopenbtn= quesopenbtn.get(quesopenbtn.size() - 1);

			// Click the last element
			 Qopenbtn.click();
			 
			 Thread.sleep(2000);
			 questext.sendKeys("What is the capital of France?");
			 option1.sendKeys("Paris");
			 Thread.sleep(1000);
			 option2.sendKeys("Rome");
			 Thread.sleep(1000);
			 option3.sendKeys("Berlin");
			 Thread.sleep(1000);
			 option4.sendKeys("chennai");
			 Thread.sleep(1000);
			 radiobtn4.click();
			 
			 SAQques.click();
			 Thread.sleep(2000);
			 sqaopbtn.click();
			 
			 Sqatext.click();
			 Sqatext.sendKeys("Which language is used for Android development?");
			 Thread.sleep(2000);
			 
			 previewbtn.click();
			 Thread.sleep(1000);
			 nxtbtn1.click();
			 Thread.sleep(1000);
			 stuEmailid.sendKeys("vicky@mail.com");
			 stuNatID.sendKeys("123456");
			 AdmID.sendKeys("101");
			 Addemailbtn.click();
			 Thread.sleep(3000);
			 finalizebtn.click();
			 System.out.println("created successfully");
			 Thread.sleep(2000);
			
			
			 
			 
//			 driver.get("https://entrance.digi-val.com/fullscreenexam/email-landing/");
//			 Thread.sleep(3000);
//			 
//			 stuIDcheck.sendKeys("123456");
//			 Thread.sleep(1000);
//			 emailclickbtn.click();
			 }
		
		
		}

		

