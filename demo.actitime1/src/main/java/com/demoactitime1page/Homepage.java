package com.demoactitime1page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public Homepage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="logoutLink")
	private  WebElement Logout;
	
	
	public void Logout() {
		Logout.click();
		
	}

}
