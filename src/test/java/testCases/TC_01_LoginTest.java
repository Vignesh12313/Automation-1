package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ExamConfigurationpage;
import pageObjects.Homepage;
import pageObjects.NewExampage;
import testBase.BaseClass;


public class TC_01_LoginTest extends BaseClass {
	
	@Test
	public void verify_Login() throws InterruptedException
	{
		try {
		logger.info(" ***Starting the TC_01_LoginTest*** ");
		
		
		Homepage hp =new Homepage(driver);
		hp.setusername();
		Thread.sleep(3000);
		logger.info("Providing Username");
		hp.setpassword();
		Thread.sleep(3000);
		logger.info("Providing password");
		hp.clickLogin();
		Thread.sleep(3000);
		logger.info("Clicking the Login button");
		hp.getpagetitle();
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "List Exams";
		logger.info("Comparing the pagetitle");
		 
		 Assert.assertEquals(actualTitle, expectedTitle);
		 
		 if (actualTitle.equals(expectedTitle)) {
	            System.out.println("Page title verification passed!");
	        } else {
	            System.out.println("Page title verification failed! Actual title: " + actualTitle);
	        }

			Thread.sleep(3000);

		 
		 NewExampage np=new NewExampage(driver);
		 logger.info("clicking the Create New button");
		 np.createnewExam();
		 Thread.sleep(3000);
		 np.setexamname();
		 logger.info("Giving the Exam Name");
		 np.startdatetime();
		 logger.info("providing the start date and Enddate");
		 np.clickNext();
		 Thread.sleep(3000);
		 
		 
		 ExamConfigurationpage EC= new ExamConfigurationpage(driver);
		 EC.AddMCQques();
		
		 
		}catch(Exception e)
		{
			logger.error("Testcase failed");
			logger.debug("Debugging the logs");
			Assert.fail();
		}

	}
}
