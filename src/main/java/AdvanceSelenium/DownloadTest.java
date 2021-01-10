package AdvanceSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Imran\\Desktop\\SeleniumFiles\\chromedriver_win32_2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/yahoo.html");
		
		WebElement downloadbtn= driver.findElement(By.xpath("//*[@id=\"messenger-download\"]"));
		String sourceurl=downloadbtn.getAttribute("href");
		
		String wgetcommand= "cmd /c C:\\\\Wget\\\\wget.exe -P D: --no-check-certificate "+sourceurl;
		
		try {
			Process execution = Runtime.getRuntime().exec(wgetcommand);
			System.out.println("File has successfully downloaded");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
