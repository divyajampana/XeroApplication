package packXero;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class Module extends ReusableMethods{
	
	public static void login(String UserName, String Password) throws IOException, InterruptedException
	{
	
		WebElement userName = findElement(By.id("email"), "UserName");
		userName.clear();
		enterText(userName, "UserName", UserName);
		WebElement password = findElement(By.id("password"), "Password");
		password.clear();
		enterText(password, "Password", Password);
		WebElement login = findElement(By.id("submitButton"), "Login");
		clickObject(login, "Login");
		Thread.sleep(3000);
		
		
	}
	public static void freeTrial() throws InterruptedException
	{
		WebElement TryForFreeLink = findElement(By.partialLinkText("Try Xero for fr"), "Try Xero for free");
		clickObject(TryForFreeLink, "Try Xero for free");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 =  driver.getTitle();
		String s4 = "Signup for Xero - Free Trial | Xero US";
		compareStrings(s3, s4);
	}
	public static void addOrganisation() throws InterruptedException
	{
		WebElement appButton = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton, "appButton");
		WebElement myXero = findElement(By.linkText("My Xero"), "MyXero");
		clickObject(myXero, "MyXero");
		Thread.sleep(5000);
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getwindow =  getAllWindows.toArray(new String[getAllWindows.size()]);
		System.out.println(getAllWindows.size());
		driver.switchTo().window(getwindow[1]);
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		WebElement addOrg = findElement(By.partialLinkText("Add an organizati"), "AddOrganisation");
		
		clickObject(addOrg, "AddOrganisation");
		Thread.sleep(4000);
	}

}
