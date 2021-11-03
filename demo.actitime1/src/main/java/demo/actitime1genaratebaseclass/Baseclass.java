package demo.actitime1genaratebaseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.internal.PropertyUtils;

import com.demoactitime1page.Homepage;
import com.demoactitime1page.LoginPage;

public class Baseclass {
	WebDriver driver=null;
	PropertyUtil putils=new PropertyUtil();
	
	@BeforeSuite
	public void configBS() {
		//database connection
	}
	@BeforeTest
	public void configBT() {
		//parallel testing codes
	}
	
	@BeforeClass
	public void configBC() {
		//open the browser
		String browsername=putils.getPropertyData("./src/test/resources/prop.properties", "Browser");
		String url= putils.getPropertyData("./src/test/resources/prop.properties", "url");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		
		}else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else {
			throw new SessionNotCreatedException("browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
	}
	@BeforeMethod
	public void configBM(){
		LoginPage loginpage=new LoginPage(driver);
		String username=putils.getPropertyData("./src/test/resources/prop.properties","username");
		String password=putils.getPropertyData("./src/test/resources/prop.properties", "password");
		System.out.println(username);
		System.out.println(password);
		loginpage.login(username,password);
		
	}
	@AfterMethod
	public void configAM() {
		Homepage homepage=new Homepage(driver);
		homepage.Logout();
	}
	@AfterClass
	public void configAC() {
		//close the browser
		driver.quit();
	}
	@AfterTest
	public void configAT() {
		//close all the parallel connections
	}
	@AfterSuite
	public void configAs() {
		//close all database connections
		
	}
}
