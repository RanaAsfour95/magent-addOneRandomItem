package magentoWebSiteTask1;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.checkerframework.common.value.qual.StringVal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addOneRandomItem {
	
	WebDriver driver = new ChromeDriver();
	String URL = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();

	
	@BeforeTest
	
	public void mySetup ()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		
		
			
	}
	
	@Test (invocationCount = 1, priority = 1, description = "This is my 1st test")
	public void addOneRandomItemToCart () throws InterruptedException
	{
		Random rand = new Random();
		int RandomIndex = rand.nextInt(4);
		driver.get(URL);



		WebElement container = driver.findElement(By.className("product-items"));
		
		List<WebElement> myList=  container.findElements(By.tagName("li"));
		
		
			myList.get(RandomIndex).click();
			
			if (driver.getCurrentUrl().contains("fusion")||driver.getCurrentUrl().contains("push"))
				
			{	WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
			addToCartButton.click();
			}
					
			else 
			{
				WebElement sizeContainer = driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
				
				List<WebElement> theListOfSize = sizeContainer.findElements(By.tagName("div"));
				
				int randomsize= rand.nextInt(theListOfSize.size());

				theListOfSize.get(randomsize).click();
				
				
				
		
				WebElement colorContainer = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
				
			List<WebElement> theListOfcolor	=colorContainer.findElements(By.tagName("div"));
			
			int randomColor = rand.nextInt(theListOfcolor.size());
			
			theListOfcolor.get(randomColor).click();
			
			
			WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
			addToCartButton.click();
			Thread.sleep(3000);
			
						}	
						
	}
	
	
	@Test (priority = 2, description = "Thia is the second test which is checkout" )
	
	public void CheckOutProccess ()
	{
		
		String CheckOutPage = "https://magento.softwaretestingboard.com/checkout/cart/";
		driver.get(CheckOutPage);
		
		WebElement checkOutButton  = driver.findElement(By.cssSelector("button[data-role='proceed-to-checkout']"));
		checkOutButton.click();
	}
	
	
	
	@Test (priority = 3)
	public void signUpProccess () throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("customer-email"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement StreetAddress = driver.findElement(By.name("street[0]"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("region_id"));
		WebElement postalCode = driver.findElement(By.name("postcode"));
		WebElement Country = driver.findElement(By.name("country_id"));
		WebElement phoneNumber = driver.findElement(By.name("telephone"));
		
		email.sendKeys("ranaasfour95@gmail.com");
		firstName.sendKeys("Rana");
		lastName.sendKeys("Asfour");
		StreetAddress.sendKeys("Amman TlaaAlali");
		city.sendKeys("TlaaAlali");
		state.sendKeys("Amman");
		postalCode.sendKeys("19933");
		Country.sendKeys("Jordan");
		phoneNumber.sendKeys("962793625419"); 
		
		WebElement nextButton= driver.findElement(By.cssSelector(".button.action.continue.primary"));
		nextButton.click();

		
		
		
		Thread.sleep(2000);
		Select select = new Select(Country);
		//select.selectByIndex(8);
		//select.selectByValue("AF");
select.selectByVisibleText("Chile");

		
		
		
		
		
	}
	
	
	
}
