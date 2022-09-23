package tempTestPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Livepage;
import pages.Login;

public class OpenWatchlist {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	
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
}

