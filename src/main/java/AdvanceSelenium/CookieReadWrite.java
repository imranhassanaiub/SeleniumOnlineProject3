package AdvanceSelenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.eclipse.jetty.util.thread.TryExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieReadWrite {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Imran\\Desktop\\SeleniumFiles\\chromedriver_win32_2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		File filecreate = new File("C:\\Users\\Imran\\Desktop\\Cookie\\cookie.text");

		// Cookie Write

		try {
			filecreate.delete();
			filecreate.createNewFile();

			FileWriter filewrite = new FileWriter(filecreate);
			BufferedWriter bufferwite = new BufferedWriter(filewrite);

			// Get current cookies

			for (Cookie cookies : driver.manage().getCookies()) {
				bufferwite.write(cookies.getName() + ";" + cookies.getValue() + ";" + cookies.getDomain() + ";"
						+ cookies.getPath() + ";" + cookies.getExpiry() + ";" + cookies.isSecure());
				bufferwite.newLine();
			}

			bufferwite.close();
			filewrite.close();

			System.out.println("Cookie write operation done");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Read Saved Cookies
		try {

			File fileread = new File("C:\\Users\\Imran\\Desktop\\Cookie\\cookie.text");

			FileReader filereader = new FileReader(fileread);
			BufferedReader bufferreader = new BufferedReader(filereader);

			// read

			String strline;
			while ((strline = bufferreader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(strline, ";");

				while (token.hasMoreTokens()) {
					String name = token.nextToken();
					String value = token.nextToken();
					String domain = token.nextToken();
					String path = token.nextToken();
					Date expiry = null;

					String val;
					if (!(val = token.nextToken()).equals("null")) {
						String desiredDate = "Sun Jan 17 23:59:59 IST 2021";
						DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
						expiry = df.parse(desiredDate);
					}
					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
					Cookie newcookie = new Cookie(name, value, domain, path, expiry, isSecure);
					System.out.println(newcookie);
					driver.manage().addCookie(newcookie);
					driver.manage().getCookies();
					System.out.println("Cookies Read Operation done");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

}
