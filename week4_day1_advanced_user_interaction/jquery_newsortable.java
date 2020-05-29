package week4_day1_advanced_user_interaction;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class jquery_newsortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);

		Thread.sleep(1000);
		
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		
		Point item4Loc = driver.findElementByXPath("//li[text()='Item 4']").getLocation();
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(item1).moveToElement(item4, item4Loc.x, item4Loc.x).release(item1).perform();
		
		System.out.println("moved");
	}
		
		
		
		
	}

