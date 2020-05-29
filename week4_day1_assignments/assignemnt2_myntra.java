package week4_day1_assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class assignemnt2_myntra {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable notification");
	ChromeDriver driver= new ChromeDriver(options);
	driver.get("https://www.myntra.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	Actions builder= new Actions(driver);
	//Mouse over on WOMEN 
	WebElement women = driver.findElementByXPath("//a[@data-group='women']");
//   WebElement women=driver.findElementByLinkText("Women");
   builder.moveToElement(women).perform();
   System.out.println("mouse over on women");
   Thread.sleep(2000);
  
   //Click jackets and coats
  WebElement jacket=driver.findElementByXPath("//a[@href='/women-jackets-coats']");
  jacket.click();
   //Find the total count of item 
  String count= driver.findElementByXPath("//div[@class='title-container']//span[1]").getText();
  System.out.println("Total count"+count);
  String total1=count.replaceAll("\\D", "");
 int total2= Integer.parseInt(total1);
  // Validate the sum of categories count matches
  String jacketcount=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
  System.out.println(jacketcount);
  Thread.sleep(2000);
  String coatcount = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
  //String coatcount=driver.findElementByXPath("//span[text()='700']").getText();
  System.out.println(coatcount);
  String jacketc= jacketcount.replaceAll("\\D", "");
  System.out.println(jacketc);
  String coatc=coatcount.replaceAll("\\D", "");
  System.out.println(coatc);
  int jc=Integer.parseInt(jacketc);
  int cc=Integer.parseInt(coatc);
  int total=jc+cc;
  System.out.println(total);
  if(total == total2)
  {
	  System.out.println("total count matched");
  }
  
  // Check Coats in CATEGORIES 
  driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
  //Click + More option under BRAND	
  driver.findElementByXPath("(//div[@class='brand-more'])").click();
  Thread.sleep(2000);
  //Type MANGO and click checkbox
  driver.findElementByXPath("(//input[@class='FilterDirectory-searchInput'])").sendKeys("MANGO");
  Thread.sleep(1000);
  driver.findElementByXPath("//label[@class=' common-customCheckbox']//div[1]").click();
  //Close the pop-up x
  
  driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']//span[1]").click();
  //Confirm all the Coats are of brand MANGO  
  int mangocount=0;
  List<WebElement> text=driver.findElementsByXPath("//h3[@class='product-brand']");
  
  String name="MANGO";
 for (WebElement mango : text) {
	 String eachbrandname=mango.getText();
	 if(eachbrandname.equals(name))
	 {
	  mangocount++;
	 }
	
	
}
 if(mangocount!=0)
 {
	 System.out.println("mango name matched");
 }
 // Sort by Better Discount
 
 driver.findElementByXPath("//div[@class='sort-sortBy']").click();

 driver.findElementByXPath("//label[text()='Better Discount']").click();
//Find the price of first displayed item    
 String firstprice=driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
 System.out.println(firstprice);
 //Mouse over on size of the first item
 WebElement firstitem=driver.findElementByXPath("//div[@class='product-sliderContainer']");
 builder.moveToElement(firstitem).perform();;
 Thread.sleep(2000);
 //Click on WishList Now
 driver.findElementByXPath("(//span[text()='wishlist'])[1]").click();
 //close the browser
 driver.close();
 
  // driver.close();
	
	
	 	
	
	
	
















}
	
	
	
	
	
	
	
	
	
	
}
