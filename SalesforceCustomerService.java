package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerService {

	public static void main(String[] args) throws InterruptedException {
				//Chrome driver setup
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver= new ChromeDriver();
				//Load the URL
				driver.get("https://login.salesforce.com/");
				//maximize the window
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//Login to the application with Username and Password
				driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
				driver.findElement(By.id("password")).sendKeys("Password$123");
				driver.findElement(By.id("Login")).click();
				Thread.sleep(3000);
				//Click on the learn more option in the Mobile publisher
				driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
				//window Handle- Moving to the second window
				String primary=driver.getWindowHandle();
				Set<String> windowHandles=driver.getWindowHandles();
				List<String> fstWindowHandles=new ArrayList<String>(windowHandles);
				String sndWindowHandles=fstWindowHandles.get(1);
				driver.switchTo().window(sndWindowHandles);
				//Clicking on the confirm button
				driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
				Thread.sleep(3000);
				//Getting the page title
				System.out.println("Confirm Page Title :"+driver.getTitle());
				//switching back to primary window
				driver.switchTo().window(primary);
				Thread.sleep(3000);
				//Checking if the control is in primary window and then closing the browser
				System.out.println("Confirm control is in Parent :"+driver.getTitle());
				driver.quit();						
		}

}
