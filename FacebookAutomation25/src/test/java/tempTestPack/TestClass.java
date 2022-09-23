package tempTestPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.Messenger;
import pages.Room;

public class TestClass {

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");

			WebDriver driver=new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.get("https://www.facebook.com/");
			Login login=new Login (driver);    
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
			 Messenger messenger=new  Messenger(driver);
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
				
				
			 Room room=new Room(driver);
			 room.goBackToMessenger();
			 
			 String url=driver.getCurrentUrl();
			 String title=driver.getTitle();
				if(url.equals("https://www.messenger.com/")&& title.equals("Messenger"))
				{
					System.out.println("Test case pass");
				}
				else
				{
					System.out.println("Test case Fail");
				}
	}

}
