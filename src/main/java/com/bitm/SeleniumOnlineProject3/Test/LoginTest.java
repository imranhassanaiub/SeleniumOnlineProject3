package com.bitm.SeleniumOnlineProject3.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bitm.SeleniumOnlineProject3.DTO.LoginDTO;
import com.bitm.SeleniumOnlineProject3.DataProvider.LoginDataProvider;
import com.bitm.SeleniumOnlineProject3.Utils.DriverManager;
import com.bitm.SeleniumOnlineProject3.Utils.TestNGReporting;
import com.bitm.SeleniumOnlineProject3.Utils.UrlTextUtils;
import com.bitm.SeleniumOnlineProject3.Utils.XpathUtils;

@Listeners(TestNGReporting.class)
public class LoginTest {

	private WebDriver driver = null;

	@Test
	public void homepagetitleverify() {
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.URL.baseUrl);
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.Text.homepageTitle);
		System.out.println("HomePage title verified!");
	}

	@Test(dependsOnMethods = "homepagetitleverify", dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void logintest(List<LoginDTO> logdata) {
		for (LoginDTO login : logdata) {

			driver.findElement(By.xpath(XpathUtils.LoginModule.username)).sendKeys(login.getUsername());
			driver.findElement(By.xpath(XpathUtils.LoginModule.password)).sendKeys(login.getPassword());
			driver.findElement(By.id(XpathUtils.LoginModule.loginBtn)).click();
			System.out.println("Logged In Successfully!");
		}

	}
}
