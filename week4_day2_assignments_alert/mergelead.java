package week4_day2_assignments_alert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class mergelead {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Enter username and password using ID locator
		driver.findElementById("username").sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		//Click login button using class locator
		driver.findElementByClassName("decorativeSubmit").click();
		//Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();
		//Click on contacts Button
		driver.findElementByLinkText("Contacts").click();
		//Click on Merge Contacts
		driver.findElementByXPath("//a[@href='/crmsfa/control/mergeContactsForm']").click();
		//Click on widger of from contact
		driver.findElementByXPath("//img[@src=\"/images/fieldlookup.gif\"]").click();
		
		Set <String> window1=driver.getWindowHandles();
		List<String> listfrom= new ArrayList<String>(window1);
		driver.switchTo().window(listfrom.get(1));
		driver.findElementByXPath("(//a[@class=\"linktext\"])[1]").click();
		driver.switchTo().window(listfrom.get(0));
		
		//Click on Widget of To Contact
		driver.findElementByXPath("(//img[@src=\"/images/fieldlookup.gif\"])[2]").click();
		Set<String>window2= driver.getWindowHandles();
		List<String> listto= new ArrayList<String>(window2);
		driver.switchTo().window(listto.get(1));
		driver.findElementByXPath("(//a[@class='linktext'])[6]").click();
		driver.switchTo().window(listto.get(0));
		
		//Click on mergebutton using xpathlocator
		driver.findElementByXPath("//a[@class='buttonDangerous']").click();
		//Accept the alert
		Alert alert= driver.switchTo().alert();
		alert.accept();
		//Verify the title of the page
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
	}

}
