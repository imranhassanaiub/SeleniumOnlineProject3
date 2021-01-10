package AdvanceSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Imran\\Desktop\\SeleniumFiles\\chromedriver_win32_2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/upload/");
		driver.findElement(By.name("uploadfile_0")).sendKeys("C:\\Users\\Imran\\Desktop\\Screenshot\\CV_of_ Md. Imran Hassan.pdf");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/ul/li/center/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/ul/li/div[1]/button")).click();
        
	}

}
