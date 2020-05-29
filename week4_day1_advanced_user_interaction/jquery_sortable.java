package week4_day1_advanced_user_interaction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class jquery_sortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Thread.sleep(1000);
	//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	WebElement list1=driver.findElementByXPath("//li[text()='Item 1']");
	WebElement list4 =driver.findElementByXPath("//li[text()='Item 4']");
	Point item4Loc = driver.findElementByXPath("//li[text()='Item 4']").getLocation();
	
	Actions builder= new Actions(driver);
	//Thread.sleep(1000);
	builder.clickAndHold(list1).moveToElement(list4, item4Loc.x, item4Loc.y).release(list1).perform();
	//sortable.dragAndDrop(list1, list4).perform();
	System.out.println("ITem 1 is dragged and droppped to item 4");
		
		
		
		
		
		
	}

}
