package com.bitm.SeleniumOnlineProject3.DataProvider;

import org.testng.annotations.DataProvider;

import com.bitm.SeleniumOnlineProject3.Utils.ExcelUtils;

public class LoginDataProvider {

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		try {
			return new Object[][] { { ExcelUtils.getLoginData() }, };
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}