package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Createaccpage {
	private WebDriver driver;
		@FindBy(xpath="//input[@aria-label='First name']")
		private WebElement firstname;
	
		@FindBy(xpath="//input[@aria-label='Surname']")
		private WebElement sirname;
	
		@FindBy(xpath="//input[@aria-label='Mobile number or email address']")
		private WebElement Mobileoremail;
	
		@FindBy(xpath="//input[@data-type='password']")
		private WebElement password;
	
		@FindBy(xpath="//select[@id='day']")
		private WebElement day;
	
		@FindBy(xpath="//select[@id='month']")
		private WebElement month;
	
		@FindBy(xpath="//select[@id='year']")
		private WebElement year;
		
		@FindBy(xpath="//label[text()='Female']")
		private WebElement female;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		private WebElement submit ;

		@FindBy(xpath="//h2[@aria-hidden='true']")
		private WebElement confirmation;
		
		@FindBy(xpath="//div[@id='userNavigationLabel']")
		private WebElement setting;

		@FindBy(xpath="(//a[@href='#'])[2]")
		private WebElement logout;
		
		@FindBy(xpath="//button[text()='Log Out']")
		private WebElement logoutclick;
		
		
		
	public Createaccpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendfirstname(String first)
	{
		firstname.sendKeys(first);
	}
	
	public void sendsirname(String last)
	{
		sirname.sendKeys(last);
	}
	
	public void Mobileoremail(String No)
	{
		Mobileoremail.sendKeys(No);
	}
	
	public void password(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void day()
	{
		Select s=new Select(day);
		s.selectByVisibleText("17");
	}
	
	public void month()
	{
		Select s=new Select(month);
		s.selectByValue("11");
	}
	
	public void year()
	{
		Select s=new Select(year);
		s.selectByValue("1995");
	}
	
	public void Female()
	{
		female.click();
	}
	
	public void Submit()
	{
		submit.click();
    }	
	
	public boolean showconfirmation()
	{
		return confirmation.isDisplayed();
    }	
	
	public void setting()
	{
		setting.click();
	}
	
	public void logout()
	{
		logout.click();
	}
	
	public void logoutclick()
	{
		logoutclick.click();
	}
	
}
