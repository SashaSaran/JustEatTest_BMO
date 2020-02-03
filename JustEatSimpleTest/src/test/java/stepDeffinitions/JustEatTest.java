package stepDeffinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JustEatTest {
	static WebDriver driver;
	@Given("I want food in {string}")
	public void i_want_food_in(String string) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.just-eat.co.uk/");
		driver.findElement(By.xpath("/html/body/app/div/div/div[1]/div[2]/form/div[1]/div/label/input")).sendKeys(string);
		
		//
	}
	@Given("I want food from KFC in {string}")
	public void i_want_food_from_KFC_in(String string) throws InterruptedException {
		//WebDriverManager.firefoxdriver().setup();
		driver =  new FirefoxDriver();
		driver.get("https://www.just-eat.co.uk/");
		driver.findElement(By.xpath("/html/body/app/div/footer/div[1]/div[4]/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/div[2]/div/div/div/form/div/div/label/input")).sendKeys(string);
		
		
}
	@Given("I want indian food in {string}")
	public void i_want_indian_food_in(String string) throws InterruptedException {
		//WebDriverManager.firefoxdriver().setup();
		driver =  new FirefoxDriver();
		driver.get("https://www.just-eat.co.uk/");
		driver.findElement(By.xpath("/html/body/app/div/footer/div[1]/div[2]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/div[2]/div/div/div/form/div/div/label/input")).sendKeys(string);
		
}

	@When("I search for restaurants")
	public void i_search_for_restaurants() {
		driver.findElement(By.xpath("/html/body/app/div/div/div[1]/div[2]/form/div/button")).click();
	}
	@When("I search for KFC restaurants")
	public void i_search_for_KFC_restaurants() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("Form_c-search-btn_1EEhL")).click();
	}
	@When("I search for indian restaurants")
	public void i_search_for_indian_restaurants() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("Form_c-search-btn_1EEhL")).click();
	}

	@Then("I should see some restaurants in {string}")
public void i_should_see_some_restaurants_in(String string) {
	    if(driver.findElement(By.xpath("/html/body/main/main/div/div[2]")).isEnabled()) {
	    	System.out.println("Passed");
	    }
	    else {
	    	System.out.println("failed");
	    }
	    driver.close();

	}
}
