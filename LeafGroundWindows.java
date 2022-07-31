package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {

	public static void main(String[] args) throws InterruptedException {
				//Chrome driver setup
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver= new ChromeDriver();
				//Load the URL
				driver.get("https://leafground.com/pages/Window.html");
				//maximize the window
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(By.id("home")).click();
				//window Handle
				String primary=driver.getWindowHandle();
				Set<String> windowHandles=driver.getWindowHandles();
				List<String> fstWindowHandles=new ArrayList<String>(windowHandles);
				String sndWindowHandles=fstWindowHandles.get(1);
				driver.switchTo().window(sndWindowHandles);
				System.out.println("HomePage Title :"+driver.getTitle());
				Thread.sleep(3000);
				driver.close();
				driver.switchTo().window(primary);
				//Clicking on Multiple windows opening link
				driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
				Thread.sleep(5000);
				driver.manage().window().maximize();
				Thread.sleep(5000);
				System.out.println("Total No of Windows open in this session :"+windowHandles.size());
				Thread.sleep(5000);
				//Closing the multiple windows
				Set<String> windowHandles1=driver.getWindowHandles();
				List<String> fstWindowHandles1=new ArrayList<String>(windowHandles1);
				String sndWindowHandles1=fstWindowHandles1.get(1);
				driver.switchTo().window(sndWindowHandles1);
				Thread.sleep(3000);
				driver.close();
				
				Set<String> windowHandles3=driver.getWindowHandles();
				List<String> fstWindowHandles3=new ArrayList<String>(windowHandles3);
				String sndWindowHandles3=fstWindowHandles3.get(1);
				driver.switchTo().window(sndWindowHandles3);
				Thread.sleep(3000);
				driver.close();
				driver.switchTo().window(primary);
				//clicking on the button to open 2 new windows
				driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
				Thread.sleep(5000);
				//Closing the opened windows
				System.out.println("Total No of Windows open in final session :"+windowHandles.size());				
				Set<String> windowHandles4=driver.getWindowHandles();
				List<String> fstWindowHandles4=new ArrayList<String>(windowHandles4);
				String sndWindowHandles4=fstWindowHandles4.get(1);
				driver.switchTo().window(sndWindowHandles4);
				Thread.sleep(3000);
				driver.close();
				Set<String> windowHandles5=driver.getWindowHandles();
				List<String> fstWindowHandles5=new ArrayList<String>(windowHandles5);
				String sndWindowHandles5=fstWindowHandles5.get(1);
				driver.switchTo().window(sndWindowHandles5);
				Thread.sleep(3000);
				driver.close();
				driver.switchTo().window(primary);
				System.out.println("switched back to primary window, "+driver.getTitle() );
				driver.quit();
				
	}

}
