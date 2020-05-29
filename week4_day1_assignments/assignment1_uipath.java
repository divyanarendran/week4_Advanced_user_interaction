package week4_day1_assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assignment1_uipath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		//Launch URL: https://acme-test.uipath.com/account/login
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder= new Actions(driver);
		//Enter UserName (kumar.testleaf@gmail.com) and TAB
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		//Enter Password (leaf@12)
		driver.findElementById("password").sendKeys("leaf@12");
		//Click login
		driver.findElementById("buttonLogin").click();
		
	
		//Mouse Over on Vendors
		WebElement vendors= driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		builder.moveToElement(vendors).perform();
		//click on Search on vendors
		driver.findElementByLinkText("Search for Vendor").click();
		
		//Enter Vendor Name (Blue Lagoon)
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		//Click on Search button
		driver.findElementById("buttonSearch").click();
		
		//find the country based on vendor.
		String countryname=driver.findElementByXPath("//tr/td[5]").getText();
		System.out.println("Country name is :"+countryname);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
