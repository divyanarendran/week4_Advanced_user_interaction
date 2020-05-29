package week4_day1_advanced_user_interaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class leafground_waittoappear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/appear.html");
		
		WebDriverWait wait= new WebDriverWait(driver,6);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn")));
		String text= driver.findElementByXPath("//button[@id='btn']//b[1]").getText();
		System.out.println(text);
		
		
		
		
		
		

	}

}
