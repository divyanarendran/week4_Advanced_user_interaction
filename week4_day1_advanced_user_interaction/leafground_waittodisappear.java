package week4_day1_advanced_user_interaction;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class leafground_waittodisappear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/disapper.html");
		
		WebDriverWait wait= new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElementById("btn")));
		String text= driver.findElementByXPath("//strong[contains(text(),'Button is disappeared')]").getText();
		System.out.println(text);
		
		
		
		
		
		
	}

}
