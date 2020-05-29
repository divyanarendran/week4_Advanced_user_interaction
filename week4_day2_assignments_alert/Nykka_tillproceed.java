package week4_day2_assignments_alert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykka_tillproceed {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable notification");
		ChromeDriver driver= new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//System.out.println("seconds");
		//Mouseover on Brands and Mouseover on Popular
		WebElement brands=driver.findElementByXPath("//a[text()='brands']");
		WebElement popular=driver.findElementByXPath("//a[text()='Popular']");
		//System.out.println("1");
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		Thread.sleep(5000);
		builder.moveToElement(popular).perform();
	
		//Click Loreal Paris
		driver.findElementByXPath("//img[@ src=\"https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png\"]").click();
		// Go to the newly opened window, check the Page title contains L'Oreal Paris and close the first window
		Set<String> window= driver.getWindowHandles();
		List <String> loreal=new ArrayList(window);
		driver.switchTo().window(loreal.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(loreal.get(0));
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(loreal.get(1));
		Thread.sleep(2000);
		//driver.findElementByXPath("//button[text()='Maybe later']").click();
		// Click sort By and select customer top rated
		
        driver.findElementByXPath("//div[@class='sort-btn clearfix']").click();
		
		//click customer top rated radio button
		driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();
		Thread.sleep(2000);
	//	driver.findElementByXPath("//span[text()='Sort By : ']").click();
		//driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();
	//Click Category and click Shampoo
	
 	driver.findElementByXPath("//div[@class='filter-sidebar__filter-title pull-left']").click();
	driver.findElementByXPath("(//div[@class='control__indicator'])[31]").click();	
		
//Click the first listed item
	driver.findElementByXPath("(//img[@class='listing-img'])[1]").click();
	
//Go to new window and click on add bag
	Set<String> window1= driver.getWindowHandles();
	List <String> addtobag=new ArrayList(window1);
	driver.switchTo().window(addtobag.get(1));
	driver.findElementByXPath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();
	//Go to Shopping Bag and click Proceed
	driver.findElementByXPath("//div[@class='AddBagIcon']").click();
	driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
	
//Print the error
	String error= driver.findElementByXPath("//div[text()='We are not accepting orders of subtotal less than 500']").getText();
	System.out.println(error);
	
	driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
