package tempTestPack;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.Createaccpage;
import pages.Login;


public class Opencreateacc {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		Login login=new Login (driver);
		login.clickoncreateNewAcc();
		String createaccUrl=driver.getCurrentUrl();
		if(createaccUrl.equals("https://www.facebook.com/"))
		{
			System.out.println("createaccUrl is verified");
		}
		else
		{
			System.out.println("createaccUrl is wrong");
		}
		
		Createaccpage createaccpage=new Createaccpage(driver);
//		createaccpage.sendfirstname();
//		createaccpage.sendsirname();
//		createaccpage.Mobileoremail();
//		createaccpage.password();
		createaccpage.day();
	    createaccpage.month();
		Thread.sleep(2000);
		createaccpage.year();
		Thread.sleep(2000);
		createaccpage.Female();
		createaccpage.Submit();
	
		
		boolean result=createaccpage.showconfirmation();
		System.out.println(result );
		System.out.println("hi" );
		 Assert.assertEquals(result,true);
		
		createaccpage.setting();
		createaccpage.logout();
		createaccpage.logoutclick();
		
   
	}

}
