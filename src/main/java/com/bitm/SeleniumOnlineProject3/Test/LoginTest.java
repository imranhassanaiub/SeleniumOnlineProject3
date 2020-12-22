package com.bitm.SeleniumOnlineProject3.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.SeleniumOnlineProject3.Utils.DriverManager;
import com.bitm.SeleniumOnlineProject3.Utils.UrlTextUtils;
import com.bitm.SeleniumOnlineProject3.Utils.XpathUtils;


public class LoginTest {

	private WebDriver driver = null;

	@Test
	public void homepagetitleverify() {
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.URL.baseUrl);
        Assert.assertEquals(driver.getTitle(),UrlTextUtils.Text.homepageTitle);
        System.out.println("HomePage title verified!");
	}

	@Test(dependsOnMethods = "homepagetitleverify")
	public void logintest() {
		driver.findElement(By.xpath(XpathUtils.LoginModule.username)).sendKeys("Admin");
		driver.findElement(By.xpath(XpathUtils.LoginModule.password)).sendKeys("admin123");
		driver.findElement(By.id(XpathUtils.LoginModule.loginBtn)).click();		
		System.out.println("Logged In Successfully!");
	}
}
