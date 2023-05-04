package orangeHrmProjectPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestCases {

	WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver","C:/Users/digu/Desktop/SeleniumJars/chromedriver_win32/chromedriver.exe");
      driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	@Test(priority = 1)
	public void validatelogin() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement uid = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement lgn = driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

		uid.sendKeys("Admin");
		pwd.sendKeys("admin123");
		lgn.click();

		WebElement dshbrd = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));

		Assert.assertTrue(dshbrd.isDisplayed(), "Test failed, User is not able to login with valid credentials");

	}

	@Test(priority = 2)
	public void loginButton() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement uid = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement lgn = driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

		uid.sendKeys("Admin1");
		pwd.sendKeys("admin123");
		lgn.click();
		
		WebElement errmsg = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
		Assert.assertTrue(errmsg.isDisplayed(),"Test Failed,invalid user ID and valid password");
		
	}
	
	@Test(priority = 3)
	public void loginButton1() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement uid = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement lgn = driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

		uid.sendKeys("Admin");
		pwd.sendKeys("admin1234");
		lgn.click();
		
		WebElement errmsg = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
		Assert.assertTrue(errmsg.isDisplayed(),"Test Failed,when valid user ID and invalid password");
		
	}
	
	@Test(priority = 4)
	public void loginButton2() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement uid = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement lgn = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

		uid.sendKeys("Admin11");
		pwd.sendKeys("admin1234");
		lgn.click();
		
		WebElement errmsg = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
		Assert.assertTrue(errmsg.isDisplayed(),"Test Failed,invalid user ID and invalid password");
		
	}
		
	@AfterMethod
	public void close() {

		driver.close();
	}



	}


