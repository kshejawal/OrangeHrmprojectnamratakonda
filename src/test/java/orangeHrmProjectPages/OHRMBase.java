package orangeHrmProjectPages;
    import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class OHRMBase {

		public static WebDriver driver;
		@BeforeTest
		public void setup() {
		System.setProperty("webdriver.chrome.driver","C:/Users/digu/Desktop/SeleniumJars/chromedriver_win32/chromedriver.exe");
		driver =new ChromeDriver();
		
	 }

         @Test
		public void initialization() {
			   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
               driver.manage().window().maximize();
				WebElement uid = driver.findElement(By.xpath("//input[@name='username']"));
				WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
				WebElement lgn = driver.findElement(By.xpath("//button[@type='submit']"));

				uid.sendKeys("Admin");
				pwd.sendKeys("admin123");
				lgn.click();
				}
        
         @AfterTest
         public void teardown()
         {
         	driver.close();
         }
 }


