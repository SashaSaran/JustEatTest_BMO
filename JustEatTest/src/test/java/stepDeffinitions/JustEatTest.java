package stepDeffinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



// this is the glue class in TestRunner.java 
// this class provides actual functions to 
public class JustEatTest {
	static WebDriver driver;
	
	//this class opens firefox,
	//goes to just-eat.co.uk
	//takes string input (needs to be a uk valid postal code)
	// places the string textbox
	@Given("I want food in {string}")
	public void i_want_food_in(String string) {
		WebDriverManager.firefoxdriver().setup();
		//launches firefox
		driver = new FirefoxDriver();
		//goes to just-eat.co.uk
		driver.get("https://www.just-eat.co.uk/");
		//places the input string within the search textbox in just-eat.co.uk
		driver.findElement(By.xpath("/html/body/app/div/div/div[1]/div[2]/form/div[1]/div/label/input")).sendKeys(string);

	}
	
	//this class opens firefox, 
	//goes to just-eat.co.uk
	//clicks on KFC
	//takes string input (needs to be a uk valid postal code)
	// places the string textbox
	@Given("I want food from KFC in {string}")
	public void i_want_food_from_KFC_in(String string) throws InterruptedException {
		//launches firefox
		driver =  new FirefoxDriver();
		//goes to just-eat.co.uk
		driver.get("https://www.just-eat.co.uk/");
		//clicks on the KFC related link
		driver.findElement(By.xpath("/html/body/app/div/footer/div[1]/div[4]/ul/li[1]/a")).click();
		///waits 10 seconds for the page to load, this may fail depending on the connection of either website or user
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//places the input string within the search textbox in just-eat.co.uk
		driver.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/div[2]/div/div/div/form/div/div/label/input")).sendKeys(string);
		
		
}
	//this class opens firefox, 
	//goes to just-eat.co.uk
	//clicks on Indian Cuisine
	//takes string input (needs to be a uk valid postal code)
	// places the string textbox
	@Given("I want indian food in {string}")
	public void i_want_indian_food_in(String string) throws InterruptedException {
		//launches firefox
		driver =  new FirefoxDriver();
		//goes to just-eat.co.uk
		driver.get("https://www.just-eat.co.uk/");
		//clicks on the indian Cuisine related link
		driver.findElement(By.xpath("/html/body/app/div/footer/div[1]/div[2]/ul/li[2]/a")).click();
		//waits 10 seconds for the page to load, this may fail depending on the connection of either website or user
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//places the input string within the search textbox in just-eat.co.uk
		driver.findElement(By.className("Form_c-search-input_2hlRP")).sendKeys(string);
		
}
	//this clicks on search button after the given has happen for I_want_food_in
	@When("I search for restaurants")
	public void i_search_for_restaurants() {
		driver.findElement(By.xpath("/html/body/app/div/div/div[1]/div[2]/form/div/button")).click();
	}
	//this clicks on search button after the given has happen for I_want_food from KFC_in
	//It also waits 5 seconds to ensure it that enough times has passsed for the page to load
	@When("I search for KFC restaurants")
	public void i_search_for_KFC_restaurants() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("Form_c-search-btn_1EEhL")).click();
	}
	//this clicks on search button after the given has happen for I_want_food from KFC_in
	//It also waits 5 seconds to ensure it that enough times has passsed for the page to load
	@When("I search for indian restaurants")
	public void i_search_for_indian_restaurants() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("Form_c-search-btn_1EEhL")).click();
	}
	//this checks whether or not it was able to reach the final page in all the scenarios, 
	//it prints passed when it passes the scenarios
	//it prints fail when it fails the scenarios
	//it close the browser at the very end
	@Then("I should see some restaurants in {string}")
public void i_should_see_some_restaurants_in(String string) {
	    if(driver.findElement(By.xpath("/html/body/main/main/div/div[2]")).isEnabled()) {
	    	//PASSED
	    	System.out.println("Passed");
	    }
	    else {
	    	//FAILED
	    	System.err.println("failed");
	    }
	    //CLOSES FIREFOX
	    driver.close();

	}
}
