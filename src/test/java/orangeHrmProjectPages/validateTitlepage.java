package orangeHrmProjectPages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validateTitlepage {
			public WebDriver driver;
			
			@BeforeTest
			public void setup()
			{

				System.setProperty("webdriver.chrome.driver","C:/Users/digu/Desktop/SeleniumJars/chromedriver_win32/chromedriver.exe");
			      driver = new ChromeDriver();
					driver.manage().window().maximize();
					
				}
						
			@BeforeMethod
			public void launch() {
						
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				}
			@Test
			public void validateTitle() {
							
				String expTitle="OrangeHRM";
				String actTitle=driver.getTitle();
				Assert.assertEquals(actTitle,expTitle);
				System.out.println(actTitle);
				WebElement uid = driver.findElement(By.xpath("//input[@name='username']"));
				WebElement lgn = driver.findElement(By.xpath("//button[@type='submit']"));

				uid.sendKeys("Admin");
					lgn.click();
				
					driver.findElement(By.name("username")).sendKeys("Admin");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
			
				}
			@AfterTest
			public void aftermethod()
			{
				driver.close();

			}

}
