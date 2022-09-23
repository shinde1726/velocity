package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Messenger {
	private WebDriver driver;
	
	@FindBy (xpath= "//a[text()='Rooms']")
	 private WebElement Room ;
	
	@FindBy (xpath= "//a[text()='Features']")
	 private WebElement Features ;

    public Messenger(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    	this.driver=driver;
    }
    		//public methods(action on webele)
    	 
    	public void openRooms()
    	{
    		Room.click();
    	}
    	
    	public void openFeatures()
    	{
    		Features.click();
    	}
    	


}  

