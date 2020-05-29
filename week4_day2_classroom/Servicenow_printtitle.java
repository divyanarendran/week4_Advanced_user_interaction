package week4_day2_classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Servicenow_printtitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://dev60453.service-now.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//1. Login to service now application
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		
		
		//2. print the title
		System.out.println(driver.getTitle());
		//3. close the application
		driver.close();
		

	}

}
