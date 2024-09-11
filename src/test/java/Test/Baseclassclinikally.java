package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclassclinikally {
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.clinikally.com/products/video-consult-with-a-skin-hair-specialist?utm_source=Google+CPC&utm_medium=Video+Consult&utm_campaign=Enhance+CPA&utm_campaign=Consult&utm_source=Google&utm_medium=Search+Ad&gad_source=1&gclid=CjwKCAjw8fu1BhBsEiwAwDrsjLPpWDJDzAViKf04eAOnQymo1SxVo27M6ExIhZzG6tUKyj1rYEadFRoCB3IQAvD_BwE");
		
	}
	
	

}
