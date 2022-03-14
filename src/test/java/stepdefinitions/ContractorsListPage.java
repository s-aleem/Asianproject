package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageobjects.ContractorPage;
import pageobjects.ContrcatorListingPgae;
import pageobjects.Homepage;
import utilities.Base;

/* Summary		:
 * Author		: Shaik Saleem Ahammad
 * Email		: Shaik.saleem-Ahammad@capgemini.com
 * Creation Date: 11/03/2022	
 * Comments 	:
 * 
 */
public class ContractorsListPage extends Base{
	           
	
	WebDriver driver=null;      
	Homepage homepage;
	ContractorPage contractorpage;
	ContrcatorListingPgae contractorlistingpage;
	
	@Before("@contractor")
	public void setup() {
		
		loadPropertiesFile();
		driver = initializeBrowser(prop.getProperty("browser"),driver);
		driver.get(prop.getProperty("url"));
		contractorlistingpage = new ContrcatorListingPgae(driver);
		homepage = new Homepage(driver);
		contractorpage = new ContractorPage(driver);
		
	}
	@After("@contractor")
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName=scenario.getName().replaceAll(" ","_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(sourcePath,"image/png",screenshotName);
		    
		}
		driver.quit();	
	}
	/*@After(order=0)
	public void tearDown() {
		driver.quit();	
	}*/
	@Given("User navigates to contractors list page")
	public void user_navigates_to_contractors_list_page() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cookie-popup-id']/div/button")));
		homepage.acceptCookies();

		homepage.clickFindaContractor(); 
	}
	@When("User search with ZipCode {string}")
	public void user_search_with_zip_code(String zipcode) throws InterruptedException {
		
		Thread.sleep(5000);
		contractorpage.validzipcode(zipcode);
	}
	@Then("User should click on search button")
	public void user_should_click_on_search_button() {
		contractorpage.clickOnSearch();  
	}
	@Then("User can able to select one of radio buttons in CATEGORY")
	public void user_can_able_to_select_one_of_radio_buttons_in_category() throws InterruptedException {
		Thread.sleep(5000);
		contractorlistingpage.Selectedradio();contractorlistingpage.selectradio2();
		contractorlistingpage.selectradio3();contractorlistingpage.selectradio4();
	}
	@Then("User wants to see appropriate contractors list")
	public void user_wants_to_see_appropriate_contractors_list() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(contractorlistingpage.getContractorText().contains("Asian Paints Trained Contractors"));  
	}
	@Then("User can able to select contractor by Rating and Review")
	public void user_can_able_to_select_contractor_by_rating_and_review() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"js-items-collapsible-group js-cpReviewRatingFilter\"][1]")));
		contractorlistingpage.Selectedradio1();  
	}
	@Then("User shoule able to see Call back button option")
	public void user_shoule_able_to_see_call_back_button_option() throws InterruptedException {
		
		Thread.sleep(5000);
		Assert.assertTrue(contractorlistingpage.CheckingButton()); 
	}
	@Then("User should click on CALL ME BACK BUTTON without entering phone number")
	public void user_should_click_on_call_me_back_button_without_entering_phone_number() {
		
		contractorlistingpage.ClickonButton();  
	}
	@Then("User should get message required field")
	public void user_should_get_message_required_field() {
		
		contractorlistingpage.getRequiredfiledMessage();   
	}
	@Then("User should click on edit button")
	public void user_should_click_on_edit_button() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		contractorlistingpage.ClickonEditButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void user_should_able_to_enter_mobile_number(String validMobileNumber) throws InterruptedException {
		
		Thread.sleep(1000);
		contractorlistingpage.EnterMobileNumber(validMobileNumber);
	}
	@Then("User can click on CALL ME BACK button")
	public void user_can_click_on_call_me_back_button() throws InterruptedException  {
		
		contractorlistingpage.ClickonButton();
		Thread.sleep(10000);
	}
	@Then("User can see successfull submision")
	public void user_can_see_successfull_submision(){
		
		//contractorlistingpage.CheckingButton();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div[id='successMsgId'] div[class='mobile-success-message'] span")));
		Assert.assertTrue(contractorlistingpage.successfulsubmission().contains("Successfully submitted!!!"));	
	}
	@Then("User should able to enter invalid mobile number {string}")//Successfully submitted!!!
	public void user_should_able_to_enter_invalid_mobile_number(String invalidMobileNumber)  {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		contractorlistingpage.EnterMobileNumber(invalidMobileNumber); 
	}
	@Then("User should see invalid mobile number")
	public void user_should_see_invalid_mobile_number()  {
		
		Assert.assertTrue(contractorlistingpage.getRequiredfiledMessage().contains("Invalid Mobile Number")); 
	}
	@Then("User should able to enter valid mobile number {string}")
	public void user_should_able_to_enter_valid_mobile_number(String validMobileNumber) throws InterruptedException {
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[@class='cl-form-mobile-input disabled']")));
				contractorlistingpage.EnterMobileNumber(validMobileNumber); 
	}
	@Then("User should click on CALL ME BACK button")
	public void user_should_click_on_call_me_back_button() throws InterruptedException {
		
		contractorlistingpage.ClickonButton();
		Thread.sleep(1000);
	}


}
