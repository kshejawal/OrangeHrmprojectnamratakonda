package orangeHrmProjectPages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class UsermanagementPage {
	public static WebDriver driver;
		@BeforeTest
		public void launch() {

			String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        System.setProperty("webdriver.chrome.driver","C:/Users/digu/Desktop/SeleniumJars/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
			}

		@BeforeMethod
		public void Usermngment() {
			driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement umpage = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6[2]"));
			Assert.assertTrue(umpage.isDisplayed(), "Test Failed, driver is not navigated to User manangement page");
		}

		@Test(priority = 1)
		public void UMPage() {

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			WebElement username = driver.findElement(By.xpath(
					"/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
			username.sendKeys("Admin");
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))
					.click();
			WebElement l1 = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div"));
			Assert.assertTrue(l1.isDisplayed(), "Test Failed, Unable to search with user name");
		
		}

		@Test(priority = 2)
		public void userRole() {

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();

			WebElement l = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]"));
			Assert.assertTrue(l.isDisplayed(), "Test Failed, Unable to search with Role name");
		}

		@Test(priority = 3)
		public void searchPage() {

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")).sendKeys("Paul Collings");
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
			WebElement l = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]"));
			Assert.assertTrue(l.isDisplayed(), "Test Failed, Unable to search with Employee name");
		}
		@Test(priority = 4)
		public void searchbutton() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
			WebElement l = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]"));
			Assert.assertTrue(l.isDisplayed(), "Test Failed, Unable to search with Employement Status");
		}

		@Test(priority = 5)
		public void systemuserrole() {

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[3]/div/div[6]/div/button[2]")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).clear();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("Namrata Konda");
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).clear();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("snamrata30sd@gmail.com");
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();

		}

		@Test(priority =6)
		public void result() {

			List<String> userList = new ArrayList<String>();
			List<WebElement> userElements = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a"));

			for (WebElement userElement : userElements) {
				userList.add(userElement.getText());
			}
			List<String> sortedUserList = new ArrayList<String>(userList);
			Collections.sort(sortedUserList);

			Assert.assertEquals(userList, sortedUserList, "The user list is not sorted alphabetically.");
		}

		@Test(priority = 7)
		public void adduserb() {
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
			WebElement adusr = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/h6"));
			Assert.assertTrue(adusr.isDisplayed(), "Test Failed, user is not able to see add user form");
		}

		@Test(priority = 8)
		public void systemUsers() {
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
			WebElement userrole = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div"));
			WebElement employeename = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
			WebElement status = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div"));
			WebElement username = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
			WebElement paswrd = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
			WebElement cnfrmpaswrd = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
			WebElement submit = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
			WebElement cancel = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[1]"));

			Assert.assertTrue(employeename.isDisplayed(), "Employee Name input box is not visible");
			Assert.assertTrue(username.isDisplayed(), "Username input box is not visible");
			Assert.assertTrue(paswrd.isDisplayed(), "Password input box is not visible");
			Assert.assertTrue(cnfrmpaswrd.isDisplayed(), "Confirm Password input box is not visible");
			Assert.assertTrue(submit.isDisplayed(), "Save button is not visible");
			Assert.assertTrue(cancel.isDisplayed(), "Cancel button is not visible");
			Assert.assertTrue(userrole.isDisplayed(), "User Role dropdown is not visible");
			Assert.assertTrue(status.isDisplayed(), "Status dropdown is not visible");

			Assert.assertTrue(employeename.isEnabled(), "Employee Name input box is disabled");
			Assert.assertTrue(username.isEnabled(), "Username input box is disabled");
			Assert.assertTrue(paswrd.isEnabled(), "Password input box is disabled");
			Assert.assertTrue(cnfrmpaswrd.isEnabled(), "Confirm Password input box is disabled");
			Assert.assertTrue(submit.isEnabled(), "Save button is disabled");
			Assert.assertTrue(cancel.isEnabled(), "Cancel button is disabled");
			Assert.assertTrue(userrole.isEnabled(), "User Role dropdown is disabled");
			Assert.assertTrue(status.isEnabled(), "Status dropdown is disabled");

		}
		@AfterMethod
		public void addbutton() {

			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
			WebElement errormsg = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/span"));

			Assert.assertTrue(errormsg.isDisplayed(),"Test failed, user is able to add user");

		}

		@AfterTest
		public void Close() {
			driver.close();

		}


	}



