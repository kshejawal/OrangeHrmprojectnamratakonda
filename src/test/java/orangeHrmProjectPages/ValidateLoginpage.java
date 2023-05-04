package orangeHrmProjectPages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ValidateLoginpage 
{
	public static WebDriver driver;

	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.chrome.driver","C:/Users/digu/Desktop/SeleniumJars/chromedriver_win32/chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize();
 }

	@Test
	public void OrangeLogin() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']"));
	}
	@AfterTest
public void teardown()
{
	driver.close();
}
}
