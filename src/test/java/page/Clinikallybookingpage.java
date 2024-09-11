

package page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class Clinikallybookingpage {
	WebDriver driver;
	By button=By.xpath("//*[@id=\"shopify-section-template--18087502971127__0764b2fc-73d3-4eea-953c-e6cc14bdd78e\"]/div[1]/div/div/a/img[1]");
	By age=By.xpath("//*[@id=\"age-properties\"]");
	By gender=By.xpath("//*[@id=\"AddToCartForm--6600106213539\"]/div/div[2]/select");
	By consult=By.xpath("//*[@id=\"AddToCartForm--6600106213539\"]/div/div[3]");
	By checkbox=By.xpath("//*[@id=\"AddToCartForm--6600106213539\"]/div/div[4]/div/h4[2]/input");
	By fileupload=By.xpath("//*[@id=\"AddToCartForm--6600106213539\"]/div/div[6]/div/input");
	By datepicker=By.xpath("//*[@id=\"datepicker\"]");
	By slot=By.xpath("//*[@id=\"AddToCartForm--6600106213539\"]/div/div[8]/div/div/div[1]/div[3]");
	By book=By.xpath("//*[@id=\"consultForm\"]");
	
	
	public  Clinikallybookingpage(WebDriver driver) throws InterruptedException, AWTException
	{
		this.driver=driver;
		
	}
	public void book() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(button).click();
		
	}
	public void age(String age1) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ageField = wait.until(ExpectedConditions.elementToBeClickable(age));
	    ageField.clear();
	    ageField.sendKeys(age1);
	    System.out.println("Age passed: " + age1);
	}
	public void gender()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement genderField = wait.until(ExpectedConditions.elementToBeClickable(gender));
		    Select genderSelect = new Select(genderField);
		    genderSelect.selectByIndex(2);
		    System.out.println("Gender index passed: " );
	}
	
	
	public void label() throws InterruptedException
	{
        Thread.sleep(2000);
        
       
		WebElement checkbox1 = driver.findElement(checkbox);
		checkbox1.click();
		
//		 if (!checkbox1.isSelected()) 
//		 {
//	            checkbox1.click();
//	        }
//		 if (checkbox1.isSelected()) {
//	            checkbox1.click();
//	        }
//		 Assert.assertFalse(checkbox1.isSelected(), "Checkbox should be deselected");
		
	}
	public void fileupload(String filepath) throws InterruptedException, AWTException
	{
		
		WebElement upload= driver.findElement(fileupload);
			Actions act=new Actions(driver);
			act.click(upload);
			act.perform();
			StringSelection stringselect=new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect,null);
			Thread.sleep(2000);
			Robot Rb=new Robot();
			Rb.keyPress(KeyEvent.VK_CONTROL);
			Rb.keyPress(KeyEvent.VK_V);
			
			Rb.keyRelease(KeyEvent.VK_CONTROL);
			Rb.keyRelease(KeyEvent.VK_V);
			
			Rb.keyPress(KeyEvent.VK_ENTER);
			Rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			}
	public void datepicker() throws InterruptedException 
	{
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(datepicker));
	        dateElement.click();
	        String targetMonth = "Sep 2024"; // Adjust this to match the format in your month and year
	        String targetDate = "20";

	        boolean dateSelected = false;
	        
	        while (!dateSelected) {
	            try {
	                // Get the selected month and year from the dropdowns
	                WebElement monthDropdown = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select/option[1]"));

	                // Use Select class to interact with dropdowns
	                Select monthSelect = new Select(monthDropdown);
	               String year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
	                String month1 = monthSelect.getFirstSelectedOption().getText();
	                String act = month1 + " " + year; // Add a space between month and year for comparison

	                // Debugging information
	                System.out.println("Current month and year: " + act);

	                // Compare the concatenated string with the target month and year
	                if (act.equals(targetMonth)) {
	                    System.out.println("Target month and year matched.");
	                    dateSelected = true;
	                } else {
	                    // Click the next button to navigate to the next month
	                    WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]"));

	                    // Wait for the element to be clickable
	                    WebDriverWait waitForClickable = new WebDriverWait(driver, Duration.ofSeconds(10));
	                    waitForClickable.until(ExpectedConditions.elementToBeClickable(nextButton));

	                    // Scroll into view and click
	                   

	                    Thread.sleep(2000); // Wait for the month to change
	                }
	            } catch (NoSuchElementException e) {
	                System.err.println("Element not found: " + e.getMessage());
	                break;
	            } catch (Exception e) {
	                System.err.println("An error occurred: " + e.getMessage());
	                break;
	            }
	        }
	        
	        // Select the date after the correct month and year are visible
	        WebElement dateToSelect = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]"));
	        WebDriverWait waitForDate = new WebDriverWait(driver, Duration.ofSeconds(10));
	        waitForDate.until(ExpectedConditions.elementToBeClickable(dateToSelect)).click();
	   
	    }
	public void slot() throws InterruptedException
	{
		Thread.sleep(2000);
	WebElement slot1=driver.findElement(slot);
	slot1.click();
	driver.findElement(By.xpath("//*[@id=\"AddToCartForm--6600106213539\"]/div/div[8]/div/div/div[2]/div/ul")).click();
	}
	public void submit() throws InterruptedException
	{
		driver.findElement(book).click();
		Thread.sleep(5000);
		driver.navigate().back();	
		
	}
}














