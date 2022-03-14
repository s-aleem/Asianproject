package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContrcatorListingPgae {
	
      WebDriver driver;
	
	  public ContrcatorListingPgae(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	  }
	  
	  @FindBy(xpath="//h2[@class='palleteTitle centerAlign']")//button[@class=\"ctaText i-understand-btn text-uppercase\"]
		private WebElement contractorCount;
	  
	  @FindBy(xpath="//div/div[@class='cl-form-mobile-input disabled']")
		private WebElement EnterMobileNo;
	  
	  @FindBy(xpath="//div/small[@class=\"cl-form-mobile-error\"]")
		private WebElement RequiredfieldMessage;
		
	  
	  @FindBy(xpath="//div[@class=\"js-items-collapsible-group\"][1]")
		private WebElement radioselect;
	  @FindBy(xpath="//span[text()=\"Interior Wall Textures (3)\"]") //span[text()="Exterior Wall Textures (2)"]
		private WebElement radioselectall;
	  @FindBy(xpath="//span[text()=\"Exterior Wall Textures (2)\"]") //span[text()="Exterior Wall Textures (2)"]
		private WebElement radioselectal2;
	  @FindBy(xpath="//span[text()=\"Exterior Wall Textures (2)\"]") //span[text()="Exterior Wall Textures (2)"]
		private WebElement radioselectal3;
	  @FindBy(xpath="//span[text()=\"Wood Finishes (2)\"]")
		private WebElement radioselect1;
	  
	  @FindBy(xpath="//div/button[@class='save-btn ctaText trackCTA']")
		private WebElement enterbutton;
	  
	  @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/label[1]")
		private WebElement editbutton;
	  
	  @FindBy(name="clMobileNo")
		private WebElement placeholder;
	
	  @FindBy(css="div[id='successMsgId'] div[class='mobile-success-message'] span")
		private WebElement successfulsubmission;
		public String getContractorText() {
			
			return contractorCount.getText(); 
			
		}
      public void Selectedradio() {
    	  
    	  radioselect.click();
      }
      
      public String getRequiredfiledMessage() {
			
			return RequiredfieldMessage.getText();	
      }
      
       public void ClickonButton() {
    	   Actions action = new Actions(driver);
    	   action.moveToElement(enterbutton).perform();
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	  enterbutton.click();
    	  enterbutton.click();
    	  
       }
       
       public String successfulsubmission() {
     	  
    	   return successfulsubmission.getText();
       }
       
       public void EnterMobileNumber(String number ) {
   		
   		placeholder.sendKeys(number);
       
       }
       public void ClickonEditButton() {
     	  
     	  editbutton.click();
     	  
        }
        
       public boolean CheckingButton() {
    	  
     	 return enterbutton.isEnabled();
     	  
        }
      
      public void Selectedradio1() {
    	  
    	  radioselect1.click();
    	  
      }
     public void selectradio2() {
    	 radioselectall.click();
     }
     public void selectradio3() {
    	 radioselectal2.click();
    	 
     }
     public void selectradio4() {
    	 radioselectal3.click();
    	 
     }
      public boolean EnterMobileNumber() {
     	  
      	 return EnterMobileNo.isEnabled();
 
      }
}

