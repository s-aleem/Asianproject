package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractorPage {
	
	
    WebDriver driver;
	
	public ContractorPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	// hello
	@FindBy(xpath="//div/input[@name='PINCODE_LOCATOR']")
	private WebElement searchbox;
	
	@FindBy(xpath="//div/button[@class='ctaText baseBtn']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//div[text()=\"Enter a valid 6 digit Zip Code\"]")
	private WebElement warningMessage;
	
	
	@FindBy(css=".citySearch--errorMsg")
	private WebElement warningMessageForCity;  
	
	@FindBy(id="js-locationIcon")
	private WebElement locationbutton;   
	@FindBy(xpath="//div[@id='js-autoCompleteListArea']//div[1]//p[1]")
	private WebElement dropdownlist;     
	
	
    public void validzipcode(String validZipcode ) {
		
		searchbox.sendKeys(validZipcode);
		
	}
    public void invalidzipcode(String invalidZipcode ) {
		searchbox.clear();
		searchbox.sendKeys(invalidZipcode);
    }
    public void validcity(String validCity ) {
		
		searchbox.sendKeys(validCity);
    }
    public void invalidcity(String invalidCity ) {
		
		searchbox.sendKeys(invalidCity);
    }
    public void clickOnSearch() {
		
		searchbutton.click();
    }
    
    public void dropdownlist() {
		
    	dropdownlist.click();
    }
    
   public void ClickOnLocationbutton() {
		
	   locationbutton.click();
    }
    
    public String getMesageTextInvalidZip() {
		
		return warningMessage.getText();
		
	}
    
    public String getMesageTextInvalidCity() {
		
		return warningMessageForCity.getAttribute("innerHTML");
		
	}

}
