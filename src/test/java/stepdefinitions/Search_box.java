package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
public class Search_box extends Base {
	
	public WebDriver driver;
	public Homepage homepage;
	public ContractorPage contractorpage;
	public ContrcatorListingPgae contractorlistingpage;
	@Before("@search")
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowser(prop.getProperty("browser"),driver);
		driver.get(prop.getProperty("url"));
		contractorlistingpage = new ContrcatorListingPgae(driver);
		homepage = new Homepage(driver);
		contractorpage = new ContractorPage(driver);
	}
	@After("@search")
	public void tearDownFailure(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName=scenario.getName().replaceAll(" ","_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(sourcePath,"image/png",screenshotName);   
		}
		driver.quit();
	}
	@Given("User navigate to contractor page")
	public void user_navigate_to_contractor_page() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cookie-popup-id']/div/button")));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		homepage.acceptCookies();

		homepage.clickFindaContractor();
	}
	@When("User enters valid zipcode {string}")
	public void user_enters_valid_zipcode(String validZipcode) throws InterruptedException {
		Thread.sleep(2000);		
		contractorpage.validzipcode(validZipcode); 
	}
	@Then("User click on search icon")
	public void user_click_on_search_icon() {
		
		contractorpage.clickOnSearch();	
	}
	@Then("User should able to see contractors list")
	public void user_should_able_to_see_contractors_list() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertEquals(contractorlistingpage.getContractorText(),"Asian Paints Trained Contractors");	
	}
	@When("User enters invalid zipcode {string}")
	public void user_enters_invalid_zipcode(String invalidZipcode) throws InterruptedException {
		Thread.sleep(2000);	
		contractorpage.invalidzipcode(invalidZipcode);  
	}
	@Then("User should get messasge {string}")
	public void user_should_get_messasge(String invalidzip) {
		Assert.assertTrue(contractorpage.getMesageTextInvalidZip().contains(invalidzip));
	}
	@When("User enters valid city name {string}")
	public void user_enters_valid_city_name(String validcity) throws InterruptedException {
		Thread.sleep(8000);
		
		contractorpage.validcity(validcity);
	}
	@Then("User can select city from dropdownlist")
	public void user_can_select_city_from_dropdownlist() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contractorpage.dropdownlist();
	}
	@Then("User should able to see the {string}")
	public void user_should_able_to_see_the(String contractorsList) {
		
		Assert.assertTrue(contractorlistingpage.getContractorText().contains(contractorsList));
	}
	@When("User enters invalid city name {string}")
	public void user_enters_invalid_city_name(String invalidCity ){
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		contractorpage.invalidcity(invalidCity);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}
	@Then("User should get the message {string}")
	public void user_should_the_get_message(String invalidcity) {
		Assert.assertTrue(contractorpage.getMesageTextInvalidCity().contains(invalidcity));
	}
	@Then("User click on the ssearch icon")
	public void user_click_on_the_search_icon() throws InterruptedException {
	
		contractorpage.clickOnSearch();	
		Thread.sleep(2000);
}
	@Then("User click on search button")
	public void user_click_on_search_button() {
		
		contractorpage.ClickOnLocationbutton();	
	}

}	
