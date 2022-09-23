package pages;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
//private variables (WebElement)
	private WebDriver driver;
	@FindBy (xpath= "//input[@id='email']")
	 private WebElement username ;
	
	@FindBy (xpath= "//input[@id='pass']")
	 private WebElement password ;
	
	@FindBy (xpath= "//button[@name='login']")
	 private WebElement loginbutton ;
	
    @FindBy (xpath= "//a[text()='Create New Account']")
    private WebElement createNewAcc ;
    
    @FindBy (xpath= "//a[text()='Messenger']")
	 private WebElement messengerlink ;
	
   // @FindBy(xpath="//a[@href='/watch/?ref=tab']")
    @FindBy(xpath="//a[text()='Watch']")
	private WebElement watch;
    
    public Login(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    	this.driver=driver;
    }
    	
    	//public methods(action on webele)
    	 
    	public void sendusername()
    	{
    	username.sendKeys("7058234317");
    	}
    	
    	public void sendpassword()
    	{
    		password.sendKeys("ai");
    	}
    	
    	public void clickonloginbutton()
    	{
    		loginbutton.click();
    	}
    	
    	public void clickoncreateNewAcc()
    	{
    		createNewAcc.click();
    	}
    
    	public void openMessenger()
    	{
    		messengerlink.click();
    	}
    	
    	public void openWatch()
    	{
    		watch.click();
        }	
    	
//or //complete functionality
          public void logintoappln()
		{
			username.sendKeys("7058234317");
			username.sendKeys("pari");
			loginbutton.click();
			createNewAcc.click();
		}


}  