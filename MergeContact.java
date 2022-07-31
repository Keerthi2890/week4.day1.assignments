package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		//Load the URL
		driver.get("http://leaftaps.com/opentaps");
		//maximize the window
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login with Username and Password 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//window Handle
		String primary=driver.getWindowHandle();
		//Navigate through the links and menus
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		//click on From contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		//To access the second window
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> fstWindowHandles=new ArrayList<String>(windowHandles);
		String sndWindowHandles=fstWindowHandles.get(1);
		driver.switchTo().window(sndWindowHandles);
		//Get the first value
		driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();
		Thread.sleep(3000);
		//Switch to primary window
		driver.switchTo().window(primary);
		//click on To contact
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		//Access the second window once again
		Set<String> windowHandles1=driver.getWindowHandles();
		List<String> fstWindowHandles1=new ArrayList<String>(windowHandles1);
		String sndWindowHandles1=fstWindowHandles1.get(1);
		driver.switchTo().window(sndWindowHandles1);
		//Get the second value
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]//a")).click();
		//switch back to primary window
		driver.switchTo().window(primary);
		//Click on Merge button
		driver.findElement(By.linkText("Merge")).click();
		//Handle the Alert and click on OK
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.accept();
		//Verify the page Title
		System.out.println(driver.getTitle());
	}

}
