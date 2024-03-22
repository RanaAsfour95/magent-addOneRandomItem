package magentoWebSiteTask1;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addOneRandomItem {
	
	WebDriver driver = new ChromeDriver();
	String URL = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	int RandomIndex = rand.nextInt(6);

	
	@BeforeTest
	
	public void mySetup ()
	{
		driver.get(URL);
		driver.manage().window().maximize();
		
		
			
	}
	
	@Test
	public void addOneRandomItemToCart ()
	{
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
			
			
				
			}
			
		
		
		
	}
	
}
