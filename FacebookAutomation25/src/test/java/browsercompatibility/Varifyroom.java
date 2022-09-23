package browsercompatibility;
import java.util.concurrent.TimeUnit;

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
import org.testng.asserts.SoftAssert;
import pages.Login;
import pages.Messenger;
import pages.Room;
import setup.Base;

public class Varifyroom extends Base {
	public class VarifyRoomPageTestNg {
		 private WebDriver driver;     //global variable
		 private Room room;
		 private Login login;
		 private Messenger messenger;
		 
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
	public void createPOMobjects() {
		 System.out.println("Before classB");
		login=new Login (driver);
		 messenger=new  Messenger(driver);
		 room=new Room(driver);
		}
		
	@BeforeMethod
	public void openRoomsPage()
	{
			 System.out.println("Before MethodB");
			 driver.get("https://www.facebook.com/");
			   	login.openMessenger();
					
		String messengerUrl=driver.getCurrentUrl();
		if(messengerUrl.equals("https://www.messenger.com/"))
			{
				System.out.println("messengerUrl is verified");
			}
			else
			{
				System.out.println("messengerUrl is wrong");
			}
			  
			messenger.openRooms();
			String messengerroomUrl=driver.getCurrentUrl();
					 
		 if(messengerroomUrl.equals("https://www.messenger.com/rooms"))
			{
				System.out.println("messengerroomUrl is verified");
			}
	    	else
			{
		    	System.out.println("messengerroomUrl is wrong");
		    }
	}
			
    @Test
	public void verifyMessengerButton()
		{
		   System.out.println("Test 1B"); 
	         room.goBackToMessenger();
			 String url=driver.getCurrentUrl();
			 String title=driver.getTitle();
				 
		 Assert.assertEquals(url, "https://www.messenger.com/");
		 Assert.assertEquals(title, "Messenger" );
//					if(url.equals("https://www.messenger.com/")&& title.equals("Messenger"))
//					{
//						System.out.println("Test case pass");
//					}
//					else
//					{
//						System.out.println("Test case Fail");
//					}
		}
			
		@Test
	public void verifyHelpCenterButton()
		{
		   System.out.println("Test 2B"); 
	           room.contactToHelpcenter();
			   String url=driver.getCurrentUrl();
			   String title=driver.getTitle();
				 
			 SoftAssert soft =new SoftAssert();
				 
			 soft.assertEquals(url,"https://www.messenger.com/help");
			 System.out.println("hellooooo");
			 soft.assertEquals(title,"Messenger Help Centre"); //end la e missing kela ki pass hot nahi pn k tri run hot 
			 soft.assertAll();
			 System.out.println("by");
//					if(url.equals("https://www.messenger.com/help")&& title.equals("Messenger Help Centre"))
//					{
//						System.out.println("Test case pass");
//					}
//					else
//					{
//						System.out.println("Test case Fail");
//					}
		}
			
	@AfterMethod
	public void logOutFromAppln()
		{
			System.out.println("After MethodB");
			System.out.println("logout");
		}
			
	@AfterClass
	public void cleanPOMObject()
	{
		System.out.println("After ClassB");
		login=null;
	    messenger=null;
	    room=null;
    }
			
	@AfterTest
	public void closeBrowser()
	{
		 System.out.println("After TestB");
		 driver.close();
		 System.gc();     //gc mean garbage collector-delete the unused obj
	}
}
}
