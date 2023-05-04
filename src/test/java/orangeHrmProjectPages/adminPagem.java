package orangeHrmProjectPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class adminPagem {
	WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:/Users/digu/Desktop/SeleniumJars/chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement uid = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement lgn = driver.findElement(
		By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

		uid.sendKeys("Admin");
		pwd.sendKeys("admin123");
		lgn.click();
		driver.findElement(By.xpath("//*[@href='/web/index.php/admin/viewAdminModule']")).click();
	}

	@BeforeMethod
	public void topaygrades() {
		driver.findElement(By.xpath("//*[text()='Job ']")).click();
		driver.findElement(By.xpath("//*[text()='Pay Grades']")).click();

	}

	@Test(priority = 1)
	public void paygradePage()  {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewPayGrades";
		Assert.assertEquals(actualurl, expectedurl,"Test failed, driver is not redirected to pay grades page");
	
	
	}

	@Test(priority = 2)
	public void check() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement lst = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div"));
		Assert.assertTrue(lst.isDisplayed(), "Test failed");
	}
	
	@Test(priority = 3)
	public void addForm() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()=' Add ']")).click();
		WebElement addform = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--h6 orangehrm-main-title']"));
		Assert.assertTrue(addform.isDisplayed(), "Test failed");
		
	}
	
	@Test(priority = 4)
	public void submitbutton() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()=' Add ']")).click();
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input"));
		WebElement cancel = driver.findElement(By.xpath("//button[text()=' Cancel ']"));
		WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
		
		Assert.assertTrue(name.isDisplayed(),"Test failed, name input box is not displayed");
		Assert.assertTrue(cancel.isDisplayed(), "Test failed, cancel button is not displayed");
		Assert.assertTrue(save.isDisplayed(),"Test failed, save button is not displayed");
		
		Assert.assertTrue(name.isEnabled(),"Test failed, name input box is not enabled");
		Assert.assertTrue(cancel.isEnabled(), "Test failed, cancel button is not enabled");
		Assert.assertTrue(save.isEnabled(),"Test failed, save button is not enabled");
	}
	
	
	@Test(priority = 5)
	public void jobgradebuttn() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()=' Add ']")).click();
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input"));
		WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
		name.sendKeys("Grade B");
		save.click();
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		driver.findElement(By.xpath("//*[text()='-- Select --']")).click();
		driver.findElement(By.xpath("//*[text()='INR - Indian Rupee']")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("600000");
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("900000");
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[2]/form/div[3]/button[2]")).click();
		
		driver.findElement(By.xpath("//*[text()='Job ']")).click();
		driver.findElement(By.xpath("//*[text()='Pay Grades']")).click();
		
		WebElement cnfrmadd = driver.findElement(By.xpath("//*[text()='Grade A']"));
		Assert.assertTrue(cnfrmadd.isDisplayed(),"Test failed, grade is not added to list");
	}
	
	@Test(priority = 6)
	public void massage() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()=' Add ']")).click();
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input"));
		WebElement save1 = driver.findElement(By.xpath("//button[@type='submit']"));
		name.sendKeys("Grade B");
		WebElement errmsg = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		Assert.assertTrue(errmsg.isDisplayed(),"Test failed, the site is not showing Already exist message");
	}
	
	
	@Test(priority = 7)
	public void gradedis() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div/div[4]/div/button[2]/i")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")).sendKeys("Grade 8");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}
	
	@Test(priority = 8)
	public void delete() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[1]/div/div[1]/div/label/span/i")).click();
		driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
		
		WebElement cnfrm = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[2]/div/span"));
		String exp = "No Records Found";
		Assert.assertEquals(cnfrm.getText(), exp, "test failed");
	}
		@AfterClass
	public void close() {
		

		driver.quit();
	}

}


