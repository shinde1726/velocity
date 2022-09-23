package browsercompatibility;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Createaccpage;
import pages.Livepage;
import pages.Login;
import setup.Base;
import utils.Utility;


public class Varifyaccount extends Base {
	public class Varifycreateaccorwatchlist {
		 private WebDriver driver;     //global variable
		 private Createaccpage createaccpage;
		 private Login login;
		 private Livepage livepage;
	    int testID;
	    
	 
	     
	     @Parameters ("browser")
	 @BeforeTest
     public void launchBrowser(String browserName)
	 {
		 System.out.println(browserName); 
		if(browserName.equals("Chrome"))
		{
			driver= openChromeBrowser();
		}
		if(browserName.equals("FireFox"))
		{
			driver= openFireFoxBrowser();
		}	
		if(browserName.equals("Opera"))
		{
			driver= openOperaBrowser();
		}	
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
		
	@BeforeClass
    public void createPOMobjects() 
       {
		 System.out.println("Before classA");
	     login=new Login (driver);
	     createaccpage=new Createaccpage(driver);
	     livepage =new Livepage(driver);
       }
		
    @BeforeMethod
	public void openRoomsPage()
	  { 
	     System.out.println("Before MethodA");
		 driver.get("https://www.facebook.com/");
	  }
				
	@Test
	public void verifycreatenewacc() throws InterruptedException, EncryptedDocumentException, IOException
		{ 
		   System.out.println("Test 1A"); 
		    login.clickoncreateNewAcc();
			String createaccUrl=driver.getCurrentUrl();
		    Assert.assertEquals(createaccUrl,"https://www.facebook.com/","urlnotfound");
//						if(createaccUrl.equals("https://www.facebook.com/"))
//						{
//							System.out.println("createaccUrl is verified");
//						}
//						else
//						{
//							System.out.println("createaccUrl is wrong");
//						}
		    Thread.sleep(2000);
			createaccpage.sendfirstname(Utility.getdata(0, 1));
			createaccpage.sendsirname(Utility.getdata(1, 1));
			createaccpage.Mobileoremail(Utility.getdata(2, 1));
			createaccpage.password(Utility.getdata(3, 1));
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
				
//	@Test
//	public void verifywishlist() throws InterruptedException
//		{ testID=1012;
//			System.out.println("Test 2A"); 
//			login.openWatch();
//			String watchlistUrl=driver.getCurrentUrl();
//			if(watchlistUrl.equals("https://www.facebook.com/watch/"))
//			  {
//				  System.out.println("watchlistUrl is verified");
//			  }
//			else
//			  {
//				  System.out.println("watchlistUrl is wrong");
//			  }
//					
//			 Thread.sleep(4000);
//			 livepage.Clicklive();
//		     String liveUrl=driver.getCurrentUrl();
//			if(liveUrl.equals("https://www.facebook.com/watch/live/?ref=watch"))
//				{
//				   System.out.println("liveUrl is verified");
//				}
//			else
//				{
//				   System.out.println("liveUrl is wrong");
//				}
//			
//		}
				
	@AfterMethod
	public void logOutFromAppln()
		{
		
			 System.out.println("After MethodA");
			 System.out.println("logout");
			 
		}
				
	@AfterClass
	public void cleanPOMObject() 
		{
			System.out.println("After ClassA");
			 login=null;
			 createaccpage=null;
			 livepage =null;
		}
				
	@AfterTest
	public void closeBrowser()
		{
			 System.out.println("After TestA");
			 driver.close();
			System.gc();  
		}
}

}
