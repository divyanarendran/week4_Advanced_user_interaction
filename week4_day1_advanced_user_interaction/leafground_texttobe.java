package week4_day1_advanced_user_interaction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class leafground_texttobe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/TextChange.html");
		
		WebDriverWait wait= new WebDriverWait(driver,6);
		wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));
		driver.findElementById("btn").click();		
		
		System.out.println("clickme button is clicked");
		
		
		
		
	}

}
