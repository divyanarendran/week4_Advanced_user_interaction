package week4_day2_classroom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IRCTC_screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	  
	
	//Click ok on alert(sweet alert)
	driver.findElementByXPath("//button[text()='Ok']").click();
	
	//Click on Flights link
	driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
	
	//Go to flights window
	Set <String> windowHandles = driver.getWindowHandles();
	List<String> listHandles= new ArrayList<String>(windowHandles);
	String secondWindow= listHandles.get(1);
	System.out.println(secondWindow);
	driver.switchTo().window(listHandles.get(1));
	
		//Select the "I have read the guidelines"
	WebElement checkbox= driver.findElementById("agree");
	Actions builder = new Actions(driver);
	builder.moveToElement(checkbox).click().perform();
	
	
	//Click on continue
	driver.findElementByXPath("//button[text()='Continue ']").click();
	
	//Take screenshot
	File source= driver.getScreenshotAs(OutputType.FILE);
	File target = new File("./screenshot/flights.png");
	FileUtils.copyFile(source,target);
	
	//Close the first window alone
	driver.switchTo().window(listHandles.get(0));
	driver.close();
	
	
	
		
		

	}

}
