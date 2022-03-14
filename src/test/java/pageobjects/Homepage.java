package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	
WebDriver driver;
	
	public Homepage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath="(//span[@class=\"iconTextLinks__text\"])[2]")
	private WebElement FindaContractor;
	
	@FindBy(xpath="//div[@id='cookie-popup-id']/div/button")
	private WebElement cookies;
	
	/*@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;*/
	
	public void clickFindaContractor() {
		
		FindaContractor.click();
		
	}
    public void acceptCookies() {
		
		cookies.click();
	
    }

}

