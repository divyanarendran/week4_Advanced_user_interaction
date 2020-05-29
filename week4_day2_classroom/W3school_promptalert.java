package week4_day2_classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3school_promptalert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Load https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
			//2. Get into frame
		driver.switchTo().frame("iframeResult");
			//3. Click Try it button
		driver.findElementByXPath("//button[text()='Try it']").click();
		
			//4. enter your name in the alert
		Alert alert= driver.switchTo().alert();
		alert.sendKeys("Divya");
		
			//5. accept the alert
		alert.accept();
			//6. Read the text which has your name
		String text=driver.findElementByXPath("//p[contains(text(),'Divya')]").getText();
		System.out.println(text);
		String text2= "Divya";
		
			//7. Verify that the text contains your name or not
       if(text.contains(text2))
    	   
       {
    	   System.out.println("matched");
    	   
       }
	}

}
