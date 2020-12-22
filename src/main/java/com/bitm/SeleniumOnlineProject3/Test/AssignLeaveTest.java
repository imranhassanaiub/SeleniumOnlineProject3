package com.bitm.SeleniumOnlineProject3.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.bitm.SeleniumOnlineProject3.Utils.DriverManager;
import com.bitm.SeleniumOnlineProject3.Utils.XpathUtils;

public class AssignLeaveTest {

	private WebDriver driver = null;

	@Test
	public void assignleavetest() {
		driver = DriverManager.driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.assignLeaveModule.assignleaveBtn)));

		driver.findElement(By.xpath(XpathUtils.assignLeaveModule.assignleaveBtn)).click();

	}
}
