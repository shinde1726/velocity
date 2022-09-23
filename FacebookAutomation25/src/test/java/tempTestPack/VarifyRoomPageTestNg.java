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
import org.testng.asserts.SoftAssert;

import pages.Login;
import pages.Messenger;
import pages.Room;

public class VarifyRoomPageTestNg {
	private WebDriver driver;     //global variable
	 private Room room;
	 private Login login;
	 private Messenger messenger;
	
	@BeforeClass
	public void launchBrowser()
		{
			 System.out.println("Before Class");
			 System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
              //WebDriver driver=new ChromeDriver();   //local variable
			 driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
			
		
	 @BeforeMethod
	public void openRoomsPage()
		{
			 System.out.println("Before Method");
			 driver.get("https://www.facebook.com/");
		     login=new Login (driver);    
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
		   messenger=new  Messenger(driver);
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
					
					
				  room=new Room(driver);
		}
		
	@Test
	public void verifyMessengerButton()
		{
			 System.out.println("Test 1"); 
             room.goBackToMessenger();
			 
			 String url=driver.getCurrentUrl();
			 String title=driver.getTitle();
			 
			 Assert.assertEquals(url, "https://www.messenger.com/");
			 Assert.assertEquals(title, "Messenger" );
//				if(url.equals("https://www.messenger.com/")&& title.equals("Messenger"))
//				{
//					System.out.println("Test case pass");
//				}
//				else
//				{
//					System.out.println("Test case Fail");
//				}
		}
		
		@Test
		public void verifyHelpCenterButton()
		{
			 System.out.println("Test 2"); 
              room.contactToHelpcenter();
			 
			 String url=driver.getCurrentUrl();
			 String title=driver.getTitle();
			 
			 SoftAssert soft =new SoftAssert();
			 
			 soft.assertEquals(url,"https://www.messenger.com/help");
			 System.out.println("hellooooo");
			 soft.assertEquals(title,"Messenger Help Centre"); //end la e missing kela ki pass hot nahi pn k tri run hot 
			 soft.assertAll();
			 System.out.println("by");
//				if(url.equals("https://www.messenger.com/help")&& title.equals("Messenger Help Centre"))
//				{
//					System.out.println("Test case pass");
//				}
//				else
//				{
//					System.out.println("Test case Fail");
//				}
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
		
