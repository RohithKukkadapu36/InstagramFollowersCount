package com.Instagram.ObjectsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage 
{
	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//header//h2")
	public WebElement pageName;
	
	@FindBy(xpath = "//button[normalize-space(text())='followers']//span/span")
	public WebElement visibleFollowersCount;
	
	@FindBy(xpath = "//button[normalize-space(text())='followers']/span")
	public WebElement actualFollowersCount;
}
