package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class Livepage {
		private WebDriver driver;
		//@FindBy(xpath=" (//span[text()='Live'])[1]")
			@FindBy(xpath="(//span[@class='b6ax4al1 lq84ybu9 hf30pyar om3e55n1 oshhggmv qm54mken'])[4]")
			private WebElement clicklive;
			
			 public Livepage(WebDriver driver) {
			    	PageFactory.initElements(driver, this);
			    	this.driver=driver;
			    }
			    	
			
	public void Clicklive()
	{
		clicklive.click();
    }	
		
	
}
	