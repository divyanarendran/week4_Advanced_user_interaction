package week4_day1_advanced_user_interaction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		
		WebElement mensfashion = driver.findElementByLinkText("Men's Fashion");
		Actions builder = new Actions(driver);
		builder.moveToElement(mensfashion).perform();
		
		driver.findElementByLinkText("Shirts").click();
		
		WebElement firstelement =driver.findElementByXPath("(//img[@class='product-image '])[1]");
		builder.moveToElement(firstelement).perform();
		//quickqThread.sleep(1000);
		
		WebElement quickview =driver.findElementByXPath("//div[contains(text(),'Quick View')]");
		   
		builder.moveToElement(quickview).perform();
		System.out.println("done");
		driver.close();
		
		
		
		
		
		
		
		
		
	}

}
