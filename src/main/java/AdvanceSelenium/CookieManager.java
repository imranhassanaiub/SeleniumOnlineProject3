package AdvanceSelenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieManager {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Imran\\Desktop\\SeleniumFiles\\chromedriver_win32_2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		// Capturing all cookies in an webapp
		Set<Cookie> cookies = driver.manage().getCookies();

		// Getting total size of the cookies
		System.out.println("Size of cokkies of this webapp : " + cookies.size());

		System.out.println("-----------------------------------------------------");
		// Getting information of each cookies

		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " :- " + cookie.getValue());
		}

		System.out.println("-----------------------------------------------------");

		// Getting a specifiq cookie info
		Cookie seesionid = driver.manage().getCookieNamed("session-id");
		System.out.println(seesionid);

		System.out.println("-----------------------------------------------------");

		// Adding new cookie
		Cookie newcookie = new Cookie("testcookie", "Test123");
		driver.manage().addCookie(newcookie);
		System.out.println(newcookie);
		cookies = driver.manage().getCookies();
		System.out.println("Size of cokkies of this webapp : " + cookies.size());

		System.out.println("-----------------------------------------------------");
		// Deleting a single cookies driver.manage().deleteCookie(newcookie);
		cookies = driver.manage().getCookies();
		System.out.println("Size of cokkies of this webapp : " + cookies.size());
		System.out.println("-----------------------------------------------------");

		// Deleting all cookies driver.manage().deleteAllCookies(); cookies =
		driver.manage().getCookies();
		System.out.println("Size of cokkies of this webapp : " + cookies.size());

	}

}
