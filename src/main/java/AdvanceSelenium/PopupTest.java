package AdvanceSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Imran\\Desktop\\SeleniumFiles\\chromedriver_win32_2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		String MainWindow=driver.getWindowHandle();
		
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> itiration = windows.iterator();
		
		while(itiration.hasNext())
		{
			String secondwindow=itiration.next();
			
			
			if(!MainWindow.equalsIgnoreCase(secondwindow))
			{
				driver.switchTo().window(secondwindow);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("gaurav.3n@gmail.com");
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
				driver.findElement(By.xpath("/html/body/p/a")).click();
				driver.close();
				System.out.println("Pop up page has been handled");
			}
		
			driver.switchTo().window(MainWindow);
			System.out.println("Back To main window");
			driver.findElement(By.xpath("/html/body/p/a")).click();
		}
		
		
	

	}

}
