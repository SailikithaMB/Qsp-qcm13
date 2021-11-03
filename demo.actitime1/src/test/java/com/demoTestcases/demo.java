package com.demoTestcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demo {
	@Test
	public void sample(){
		System.setProperty("WebDriver.chrome.driver","./src/main/resources/chromedriver.exe");
		new ChromeDriver();
		
	}

}
