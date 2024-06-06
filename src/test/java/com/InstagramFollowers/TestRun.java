package com.InstagramFollowers;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Instagram.ObjectsRepo.ProfilePage;
import com.Instagram.TestData.GetTestDataFromExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRun 
{
	public WebDriver driver;
	public ProfilePage pobj;
	public WebDriverWait wait;

	@Test(priority = 0)
	public void launchBrowserAndUrl() throws Exception
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		pobj = new ProfilePage(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		String url = GetTestDataFromExcel.getData("url");
		driver.get(url);

	}
	@Test(priority = 1)
	public void GetFollowerCount() throws Exception
	{

		wait.until(ExpectedConditions.visibilityOf(pobj.visibleFollowersCount));
		//uncomment below sleep if want to see the page for sometime in browser
		//Thread.sleep(2000);
		String pageName = pobj.pageName.getText();
		String followersCount = pobj.visibleFollowersCount.getText();
		String actualFollowers = pobj.actualFollowersCount.getAttribute("title");

		System.out.println("Visible Followers Count of "+pageName+" page is: "+followersCount);
		System.out.println("Actual Followers Count of "+pageName+" page is: "+actualFollowers);
		

		driver.quit();

	}
}
