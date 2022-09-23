package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class time {
	private WebDriver driver;
	@FindBy (xpath= "//a[text()=' Return to messenger.com ']")
	 private WebElement ReturnToMessenger ;
	
	@FindBy (xpath= "//a[text()='Visit our help center']")
	 private WebElement Helpcenter ;

	

	
   public time (WebDriver driver) {    //ha driver=test classcha driver=new chromedriver()
   	PageFactory.initElements(driver, this);
   	this.driver=driver;
   }
   	
   	//public methods(action on webele)
   	 
   	public void goBackToMessenger()
   	{
   		ReturnToMessenger.click();
   	}
   	
   	public void contactToHelpcenter()
   	{
   		Helpcenter.click();
   	}
}
