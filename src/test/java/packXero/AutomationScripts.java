package packXero;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationScripts extends Module{
	//Navigate to XERO
	public  void testID01_A() throws IOException, InterruptedException
	{
		startReport("testID01_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		Thread.sleep(4000);
		endReport();


	}

	//Incorrect Password
	public  void testID01_B() throws IOException, InterruptedException
	{
		startReport("testID01_B");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[2][1];
		String UserName2 = data[2][2];
		String Password2 = data[2][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName2, Password2);
		WebElement errmsg =findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "Error message");
		logger.log(LogStatus.PASS, errmsg.getText());
		String s3 = errmsg.getText();
		String s4 = "Your email or password is incorrect";
		compareStrings(s3, s4);
		endReport();
	}

	//Incorrect Email
	public  void testID01_C() throws IOException, InterruptedException
	{
		startReport("testID01_C");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\Desktop\\xero.xls", "Sheet1");
		String URL = data[3][1];
		String UserName3 = data[3][2];
		String Password3 = data[3][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName3, Password3);
		WebElement errmsg =findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"), "Error message");
		logger.log(LogStatus.PASS, errmsg.getText());
		String s3 = errmsg.getText();
		String s4 = "Your email or password is incorrect";
		compareStrings(s3, s4);
		endReport();
	}
	//Navigate to XERO forgotPasswordLink
	public  void testID01_D() throws IOException, InterruptedException
	{
		startReport("testID01_D");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		Launch(URL);
		Thread.sleep(4000);
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		WebElement ForgotPwd = findElement(By.xpath("//a[@class='forgot-password-advert']"), "ForgotPassword");
		clickObject(ForgotPwd, "ForgotPassword");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://login.xero.com/ForgottenPassword";
		compareStrings(s3, s4);

		WebElement userName = findElement(By.id("UserName"), "UserName");
		userName.clear();
		enterText(userName, "UserName", UserName1);
		WebElement sendLink = findElement(By.xpath("//span[contains(@class,'text')]"), "SendLink");
		clickObject(sendLink, "SendLink");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5 = driver.getCurrentUrl();
		String s6 = "https://login.xero.com/ForgottenPassword/SendLink";
		compareStrings(s5, s6);
		WebElement msg =findElement(By.xpath("//p[contains(text(),'A link to reset your password has been sent to:')]"), "Message");
		logger.log(LogStatus.PASS, msg.getText()+ " is displayed");
		Thread.sleep(4000);
		endReport();


	}
	
	//signup to XDC
	public  void testID02_A() throws IOException, InterruptedException
	{
		startReport("testID02_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet2");
		String URL = data[1][0];

		String FirstName = data[1][1];
		String LastName = data[1][2];
		String emailAdd = data[1][3];
		String PhoneNum = data[1][4];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);

		freeTrial();
		WebElement firstName = findElement(By.xpath("//input[@name='FirstName']"), "FirstName");
		firstName.clear();
		enterText(firstName, "FirstName", FirstName);
		WebElement lastName = findElement(By.xpath("//input[@name='LastName']"), "LastName");
		lastName.clear();
		enterText(lastName, "LastName", LastName);
		WebElement email = findElement(By.xpath("//input[@name='EmailAddress']"), "EmailAddress");
		email.clear();
		enterText(email, "EmailAddress", emailAdd);
		WebElement PhNo = findElement(By.xpath("//input[@name='PhoneNumber']"), "PhoneNumber");
		PhNo.clear();
		enterText(PhNo, "PhoneNumber", PhoneNum);
		Thread.sleep(2000);
		WebElement country = findElement(By.xpath("//select[@class='form-input']"), "Country");
		Thread.sleep(4000);
		SelectByValue(country, "Country", "US");
		WebElement TPcheckBox = findElement(By.xpath("//input[@value='true']"), "Terms&PolicyCheckBox");
		selectCheckBox(TPcheckBox, "Terms&PolicyCheckBox");

		WebElement getStarted = findElement(By.xpath("//span[@class='g-recaptcha-submit']"), "GetStarted");
		clickObject(getStarted, "GetStarted");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5 = driver.getCurrentUrl();
		String s6 = "https://www.xero.com/us/signup/success/";
		compareStrings(s5, s6);
		endReport();

	}
	public  void testID02_B() throws IOException, InterruptedException
	{
		startReport("testID02_B");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet2");
		String URL = data[2][0];

		String emailAdd = data[2][3];

		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);

		freeTrial();
		
		WebElement getStarted = findElement(By.xpath("//span[@class='g-recaptcha-submit']"), "GetStarted");
		clickObject(getStarted, "GetStarted");
		WebElement ErrMsg1 = findElement(By.id("signup-form-error-message-1"), "error Message1");
		logger.log(LogStatus.PASS, ErrMsg1.getText()+ " is displayed");

		WebElement ErrMsg2 = findElement(By.id("signup-form-error-message-2"), "error Message2");
		logger.log(LogStatus.PASS, ErrMsg2.getText()+ " is displayed");
		WebElement ErrMsg3 = findElement(By.id("signup-form-error-message-3"), "error Message3");
		logger.log(LogStatus.PASS, ErrMsg3.getText()+ " is displayed");
		WebElement ErrMsg4 = findElement(By.id("signup-form-error-message-4"), "error Message4");
		logger.log(LogStatus.PASS, ErrMsg4.getText()+ " is displayed");

		WebElement email = findElement(By.xpath("//input[@name='EmailAddress']"), "EmailAddress");
		email.clear();
		enterText(email, "EmailAddress", emailAdd);
		WebElement ErrMsg5 = findElement(By.id("signup-form-error-message-3"), "error Message5");
		logger.log(LogStatus.PASS, ErrMsg5.getText()+ " is displayed");
		WebElement getStarted1 = findElement(By.xpath("//span[@class='g-recaptcha-submit']"), "GetStarted");
		clickObject(getStarted1, "GetStarted");
		WebElement ErrMsg6 = findElement(By.xpath("//label[@class='form-label text']"), "Text Highlighted");
		logger.log(LogStatus.PASS, ErrMsg6.getText()+ " unchecked is displayed");
		endReport();



	}
	public  void testID02_C() throws IOException, InterruptedException
	{
		startReport("testID02_C");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet2");
		String URL = data[2][0];

		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);

		freeTrial();
		WebElement termsOfUse = findElement(By.xpath("//a[contains(text(),'Terms of Use')]"), "TermsOfUse");
		clickObject(termsOfUse, "TermsOfUse");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5 = driver.getTitle();
		String s6 = "Terms of Use | Xero US";
		compareStrings(s5, s6);
		WebElement privacy = findElement(By.xpath("//a[contains(text(),'Privacy')]"), "Privacy Notice");
		clickObject(privacy, "Privacy Notice");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s7 = driver.getTitle();
		String s8 = "Privacy Notice | Xero US";
		compareStrings(s7, s8);
		Thread.sleep(2000);
		
		endReport();
		
	}
	public  void testID02_D() throws IOException, InterruptedException
	{
		startReport("testID02_D");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet2");
		String URL = data[2][0];

		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);

		freeTrial();
		WebElement offerDetails = findElement(By.xpath("//a[contains(text(),'offer details')]"), "Offer Details");
		clickObject(offerDetails, "Offer Details");
		Thread.sleep(4000);
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getwindow =  getAllWindows.toArray(new String[getAllWindows.size()]);
		System.out.println(getAllWindows.size());
		driver.switchTo().window(getwindow[1]);
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5 = driver.getTitle();
		String s6 ="Offer details | Xero US";
		compareStrings(s5, s6);
		endReport();
	}
	public  void testID02_E() throws IOException, InterruptedException
	{
		startReport("testID02_E");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet2");
		String URL = data[2][0];

		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);

		freeTrial();
		WebElement A_B_Link = findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"), "accountant & bookkeeper Link");
		clickObject(A_B_Link, "accountant & bookkeeper Link");
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5 = driver.getTitle();
		String s6 ="Sign up for the Xero Partner Program | Xero US";
		compareStrings(s5, s6);
		endReport();
	}
	
	//test all tabs page
	public  void testID03_A() throws IOException, InterruptedException
	{
		startReport("testID03_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		WebElement msg1 = findElement(By.xpath("//span[@class='xrh-banner--text']"), "message");
		logger.log(LogStatus.PASS, msg1.getText()+" is displayed");
		String s15 = msg1.getText();
		String s16 = "You’re using a trial account.";
		compareStrings(s15, s16);
		
		WebElement dashBoard = findElement(By.partialLinkText("Dashboard"), "DashBoard");
		clickObject(dashBoard, "DashBoard");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5=driver.getCurrentUrl();
		String s6 ="https://go.xero.com/Dashboard/";
		compareStrings(s5, s6);
		WebElement accounts = findElement(By.xpath("//button[contains(text(),'Accounting')]"), "accounts");
		clickObject(accounts, "accounts");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, " you are now in accounts dropdown page");
		
		WebElement reports = findElement(By.linkText("Reports"), "reports");
		clickObject(reports, "reports");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s7 = driver.getTitle();
		String s8 = "Xero | Reports | self";
		compareStrings(s7, s8);
		WebElement contacts = findElement(By.xpath("//button[contains(text(),'Contacts')]"), "Contacts");
		clickObject(contacts, "Contacts");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, " you are now in contacts dropdown page");
		
		WebElement appButton = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton, "appButton");
		WebElement settings = findElement(By.linkText("Settings"), "Settings");
		clickObject(settings, "Settings");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s9 = driver.getCurrentUrl();
		String s10 = "https://go.xero.com/Settings/OrganisationSettings/";
		compareStrings(s9, s10);
		
		WebElement createnew = findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[1]/button[1]/div[1]"), "CreateNew");
		clickObject(createnew, "CreateNew");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, " you are now in new dropdown page");
		
		WebElement appButton1 = findElement(By.xpath("//div[@class='xrh-appbutton--body']"), "appButton");
		clickObject(appButton1, "appButton");
		WebElement files = findElement(By.linkText("Files"), "Files");
		clickObject(files, "Files");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s11 = driver.getTitle();
		String s12 = "Xero | Files | self";
		compareStrings(s11, s12);
		
		WebElement notification = findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[3]/button[1]/div[1]"), "Notification");
		clickObject(notification, "Notification");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "notification page is displayed");
		
		WebElement search = findElement(By.xpath("//button[@title='Search']//*[@class='xrh-icon xrh-icon-svg']"), "Search");
		clickObject(search, "Search");
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "search field area is displayed");
		
		WebElement help = findElement(By.xpath("//button[@title='Help']//*[@class='xrh-icon xrh-icon-svg']"), "Help");
		clickObject(help, "Help");
		Thread.sleep(3000);
		WebElement msg2 = findElement(By.xpath("//input[@id='menu_help']"), "message");
		logger.log(LogStatus.PASS, msg2.getAttribute("placeholder")+" is displayed");
		String s13 = msg2.getAttribute("placeholder");
		String s14 = "What do you need help with?";
		compareStrings(s13, s14);
		
		Thread.sleep(5000);
		
		
		endReport();
	}
	
	//test logout functionality
	public  void testID04_A() throws IOException, InterruptedException
	{
		startReport("testID04_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		
		WebElement usermenu = findElement(By.xpath("//img[@class='xrh-avatar']"), "userMenu");
		clickObject(usermenu, "userMenu");
		WebElement logOut = findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/ol[2]/li[5]/div[1]/div[2]/div[1]/ol[1]/li[5]/a[1]"), "LogOut");
		clickObject(logOut, "LogOut");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5 = driver.getTitle();
		String s6 = "Login | Xero Accounting Software";
		compareStrings(s5, s6);
		
		endReport();
	}
	
	//test upload profile image
	public  void testID06_A() throws IOException, InterruptedException
	{
		startReport("testID06_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet3");
		String URL = data[1][0];
		String UserName1 = data[1][1];
		String Password1 = data[1][2];
		String photoadd = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		
		WebElement usermenu = findElement(By.xpath("//img[@class='xrh-avatar']"), "userMenu");
		clickObject(usermenu, "userMenu");
		WebElement profile = findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//li[1]//a[1]"), "Profile button");
		clickObject(profile, "Profile button");
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s5 = driver.getTitle();
		String s6 ="My Xero | Profile Settings";
		compareStrings(s5, s6);
		WebElement uploadImg = findElement(By.xpath("//div[@id='button-1043']"), "Upload Image");
		clickObject(uploadImg, "Upload Image");
		
		Thread.sleep(5000);
		
		WebElement browsePhoto=findElement(By.xpath("//input[@class='x-form-file-input'"), "browsephoto");
		enterText(browsePhoto, "browsephoto", photoadd);
		
		//"//input[@name='file']"
		
		Thread.sleep(3000);
		WebElement upload = findElement(By.xpath("//div[@class='x-btn gray x-exclude x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"), "Upload");
		clickObject(upload, "Upload");
		Thread.sleep(3000);
		endReport();
	
	
	}
	
	//Add another organisation
	public  void testID08_A() throws IOException, InterruptedException
	{
		startReport("testID08_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		addOrganisation();
		WebElement nameOfOrg = findElement(By.name("OrganisationName"), "NameOfOrganisation");
		enterText(nameOfOrg, "NameOfOrganisation", "self");
		//WebElement orgTaxes = findElement(By.xpath("//div[@id='ext-gen1096']"), "payTaxes");
		//SelectByVisibleText(orgTaxes, "payTaxes", "United States");
		WebElement timeZone = findElement(By.id("cmbTimeZone-inputEl"), "TimeZone");
		enterText(timeZone, "TimeZone", "(UTC-05:00) Eastern Time (US & Canada)");
		WebElement business = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "business");
		enterText(business, "business", "Accounting");
		
		WebElement startTrial = findElement(By.linkText("Start Trial"), "StartTrial");
		clickObject(startTrial, "StartTrial");
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		endReport();
		
	}
		
	public  void testID08_B() throws IOException, InterruptedException
	{
		startReport("testID008_B");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		
		addOrganisation();
		WebElement nameOfOrg = findElement(By.name("OrganisationName"), "NameOfOrganisation");
		enterText(nameOfOrg, "NameOfOrganisation", "self");
		//WebElement orgTaxes = findElement(By.xpath("//div[@id='ext-gen1096']"), "payTaxes");
		//SelectByVisibleText(orgTaxes, "payTaxes", "United States");
		WebElement timeZone = findElement(By.id("cmbTimeZone-inputEl"), "TimeZone");
		enterText(timeZone, "TimeZone", "(UTC-05:00) Eastern Time (US & Canada)");
		WebElement business = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "business");
		enterText(business, "business", "Accounting");
		
		
		WebElement buy = findElement(By.linkText("Buy Now"), "BuyNow");
		clickObject(buy, "BuyNow");
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		endReport();
		
	}
	public  void testID08_F() throws IOException, InterruptedException
	{
		startReport("testID08_F");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		addOrganisation();
		WebElement nameOfOrg = findElement(By.name("OrganisationName"), "NameOfOrganisation");
		enterText(nameOfOrg, "NameOfOrganisation", "self");
		//WebElement orgTaxes = findElement(By.xpath("//div[@id='ext-gen1096']"), "payTaxes");
		//SelectByVisibleText(orgTaxes, "payTaxes", "United States");
		WebElement timeZone = findElement(By.id("cmbTimeZone-inputEl"), "TimeZone");
		enterText(timeZone, "TimeZone", "(UTC-05:00) Eastern Time (US & Canada)");
		WebElement business = findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"), "business");
		enterText(business, "business", "Accounting");
		
		WebElement convertDataLink = findElement(By.linkText("Move from QuickBooks for free."), "Move from QuickBooks for free");
		clickObject(convertDataLink, "Move from QuickBooks for free");
		WebElement checkBox = findElement(By.id("conversionCheckbox-inputEl"), "Want to convert your data");
		selectCheckBox(checkBox, "Want to convert your data");
		
		
		//WebElement buy = findElement(By.linkText("Buy Now"), "BuyNow");
		//clickObject(buy, "BuyNow");
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		
		endReport();
	
	}
	
	//check if users can look for their subscription and billing
	public  void testID010_A() throws IOException, InterruptedException
	{
		startReport("testID10_A");
		InitializeDriver();
		String[][] data = readExcelData("C:\\Users\\satishraju\\eclipse-workspace1\\Xero\\testData\\xero.xls", "Sheet1");
		String URL = data[1][1];
		String UserName1 = data[1][2];
		String Password1 = data[1][3];
		Launch(URL);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s1 =  driver.getTitle();
		String s2 = "Login | Xero Accounting Software";
		compareStrings(s1, s2);
		//login to xero app
		login(UserName1, Password1);
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, driver.getTitle()+" is displayed");
		String s3 = driver.getCurrentUrl();
		String s4 = "https://go.xero.com/Dashboard/";
		compareStrings(s3, s4);
		WebElement businessButton = findElement(By.xpath("//button[contains(text(),'Business')]"), "business");
		clickObject(businessButton, "business");
		WebElement billToPay = findElement(By.linkText("Bills to pay"), "Bills to pay");
		clickObject(billToPay, "Bills to pay");
		WebElement paid = findElement(By.linkText("Paid"), "paid");
		clickObject(paid, "paid");
		Thread.sleep(3000);
		String s5 =  driver.getCurrentUrl();
		String s6 = "https://go.xero.com/AccountsPayable/Search.aspx?invoiceStatus=INVOICESTATUS%2fPAID";
		compareStrings(s5, s6);
		
		WebElement repeating = findElement(By.xpath("//a[@href='/AccountsPayable/SearchRepeating.aspx']"), "Repeating");
		clickObject(repeating, "Repeating");
		Thread.sleep(3000);
		String s7 =  driver.getCurrentUrl();
		String s8 = "https://go.xero.com/AccountsPayable/SearchRepeating.aspx";
		compareStrings(s7, s8);
		WebElement all = findElement(By.xpath("//a[@href='/AccountsPayable/Search.aspx']"), "All");
		clickObject(all, "All");
		Thread.sleep(3000);
		String s9 =  driver.getCurrentUrl();
		String s10 = "https://go.xero.com/AccountsPayable/Search.aspx";
		compareStrings(s9, s10);
		endReport();
		
		
		
	


	}



}
