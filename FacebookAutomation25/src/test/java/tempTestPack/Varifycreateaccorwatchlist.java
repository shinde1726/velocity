package tempTestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Createaccpage;
import pages.Livepage;
import pages.Login;

public class Varifycreateaccorwatchlist {
	private WebDriver driver;     //global variable
	 private Createaccpage createaccpage;
	 private Login login;
	
	 @BeforeClass
	public void launchBrowser()
	{
		 System.out.println("Before Class");
		 System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	 @BeforeMethod
		public void openRoomsPage()
			{ 
				 System.out.println("Before Method");
				  driver.get("https://www.facebook.com/");
			}
			
		@Test
		public void verifycreatenewacc() throws InterruptedException
			{
				 System.out.println("Test 1"); 
					login=new Login (driver);
					login.clickoncreateNewAcc();
					String createaccUrl=driver.getCurrentUrl();
					Assert.assertEquals(createaccUrl,"https://www.facebook.com/","urlnotfound");
//					if(createaccUrl.equals("https://www.facebook.com/"))
//					{
//						System.out.println("createaccUrl is verified");
//					}
//					else
//					{
//						System.out.println("createaccUrl is wrong");
//					}
					
					createaccpage=new Createaccpage(driver);
//					createaccpage.sendfirstname();
//					createaccpage.sendsirname();
//					createaccpage.Mobileoremail();
//					createaccpage.password();
					createaccpage.day();
				    createaccpage.month();
					createaccpage.year();
					createaccpage.Female();
					createaccpage.Submit();
				
					
					boolean result=createaccpage.showconfirmation();
					System.out.println(result );
					System.out.println("hi" );
					 Assert.assertEquals(result,true ,"hihello");
					
					createaccpage.setting();
					createaccpage.logout();
					createaccpage.logoutclick();
					
					
			}
			
			@Test
			public void verifywishlist() throws InterruptedException
			{
				Login login=new Login(driver);
				login.openWatch();
				String watchlistUrl=driver.getCurrentUrl();
				if(watchlistUrl.equals("https://www.facebook.com/watch/"))
				{
					System.out.println("watchlistUrl is verified");
				}
				else
				{
					System.out.println("watchlistUrl is wrong");
				}
				
				Thread.sleep(4000);
				Livepage livepage =new Livepage(driver);
				livepage.Clicklive();
				String liveUrl=driver.getCurrentUrl();
				if(liveUrl.equals("https://www.facebook.com/watch/live/?ref=watch"))
				{
					System.out.println("liveUrl is verified");
				}
				else
				{
					System.out.println("liveUrl is wrong");
				}
				
			}
			
			
			@AfterMethod
			public void logOutFromAppln()
			{
				 System.out.println("After Method");
				 System.out.println("logout");
			}
			
			@AfterClass
			public void closeBrowser()
			{
				 System.out.println("After Class");
				 driver.close();
			}
	}
