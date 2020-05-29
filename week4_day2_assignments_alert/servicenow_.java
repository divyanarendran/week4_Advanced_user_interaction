package week4_day2_assignments_alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class servicenow_ {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://dev60453.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login with username as admin and password as India@123
		driver.switchTo().frame("gsft_main");
    driver.findElementById("user_name").sendKeys("admin");
    driver.findElementById("user_password").sendKeys("India@123");
    driver.findElementById("sysverb_login").click();
    //Type id in filter
    driver.findElementById("filter").sendKeys("change");
    //Click on open
   
    driver.findElementByXPath("(//div[text()='Open'])[3]").click();
    Thread.sleep(5000);
		//Click on create
    driver.switchTo().frame("gsft_main");
    driver.findElementByXPath("//button[text()='New']").click();
    Thread.sleep(1000);
    //Click on to first link
    driver.findElementByLinkText("Normal: Changes without predefined plans that require approval and CAB authorization.").click();
		
		// Capture the change request Number from the Number Filed
   // driver.switchTo().frame("gsft_main");
    String number= driver.findElementByXPath("//input[@id='change_request.number']").getAttribute("value").toString();
    System.out.println(number);
   //Create new normal Change by filling mandatory fields
    driver.findElementById("change_request.short_description").sendKeys("divya");
    //Click submit button
    driver.findElementByXPath("//div[@class='form_action_button_container']/button").click();
    //Go to the search field and search the captured number
    driver.findElementById("change_request_table_header_search_control").sendKeys(number,Keys.ENTER);
    //Verify the successful creation of page.
    //driver.switchTo().frame("gsft_main");
    String numberappeared=driver.findElementByXPath("//a[@class='linked formlink']").getText();
    if(numberappeared.equals(number))
    {
    	System.out.println("Number matched");
    	
    }
    else
    {
    	System.out.println("number doesnot match");
    }
    
		
		
		
		
		
		
		
		
		
		
		
	}

}
