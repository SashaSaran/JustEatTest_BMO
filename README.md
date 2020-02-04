# QA Engineering Challenge

Just EAT has a website available at https://just-eat.co.uk that you can use to find takeaway restaurants in a postcode area.

`1. Write the step definitions for the below scenario`
```
Feature: Use the website to find restaurants
	So that  I can order food
	As a hungry customer
	I want to be able to find restaurants in my area
Scenario: Search for restaurants in an area
    Given I want food in "AR51 1AA"
    When I search for restaurants
    Then I should see some restaurants in "AR51 1AA"
```
`2. Add two more scenarios, which coressponding step definitions, which you feel would enhance the test coverage of the site.`

#### First Added Scenario
```
Scenario: Search for restaurants in an area and picking a specific brand
    Given I want food from KFC in "AR51 2AA"
    When I search for KFC restaurants
    Then I should see some restaurants in "AR51 2AA"
  
```
#### Second Added Scenario
```
Scenario: Search for restaurants in an area and picking a specific cuisine
    Given I want indian food in "AR51 3AA"
    When I search for indian restaurants
    Then I should see some restaurants in "AR51 3AA"
  
```
# JustEatTest

This project uses Selenium, and Cucumber to test a three scenarios on the website https://www.just-eat.co.uk/



## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Eclipse Download or the IDE of your choice
```
https://www.eclipse.org/downloads/
```
Latest Java Version, you may need to look up a tutorial on how to install java on your machine depending on your OS
```
https://www.java.com/en/download
```
Maven, A tutorial may be needed depending on your OS
```
https://maven.apache.org/download.cgi
```
It is also recomended that you have the cucumber plugin for your IDE of choice

## Running the Program

This will go through step by step on how to run the program in eclipse

Download the Repository, and extract the zip file.

![Extract](https://user-images.githubusercontent.com/58343393/73685242-d079c700-4693-11ea-9d35-ec7e957e957b.png)

Open up Eclipse(or your IDE of choice) and click on

` file - > import `

![File](https://user-images.githubusercontent.com/58343393/73685599-6b72a100-4694-11ea-957c-f977fbdda14b.png)

click on existing maven project and hit next

![MavenProject](https://user-images.githubusercontent.com/58343393/73685857-e20f9e80-4694-11ea-9526-1cf0c80b1bd5.png)

click browse, and browse to the location where you chose to extract said project

![Browse](https://user-images.githubusercontent.com/58343393/73689767-f6579980-469c-11ea-93ec-06e48b16f082.png)

Click on JustEatTest folder and press Ok,(Note: this is the start location of the project, thus do not go any further than this.)

![SelectProject](https://user-images.githubusercontent.com/58343393/73689925-5c442100-469d-11ea-8bbe-0b2acc397ccf.png)

Ensure that the project is selected with the checkmark beside the name, and click finish. The projet should appear on the package explorer

![SelectAllFinish](https://user-images.githubusercontent.com/58343393/73690109-a6c59d80-469d-11ea-80d8-9a546e86d868.png)

Find and DoubleClick the file TestRunner.java within the project

![PickTestRunner](https://user-images.githubusercontent.com/58343393/73690355-25bad600-469e-11ea-8ed2-cc2eeaed0a7b.png)

Run the TestRunner.java either through:

`Pressing the green button`
`Right-Clicking on TestRunner.java -> Run As -> JUnit`

![RunTestRunner](https://user-images.githubusercontent.com/58343393/73690562-a37ee180-469e-11ea-9afe-3f32bf8a02f0.png)

Below are the expect results

![SuccessfulJUnitTest](https://user-images.githubusercontent.com/58343393/73691338-294f5c80-46a0-11ea-84da-87e42c661031.png)


## Feature with 3 Scenarios

Note: @Then are using the same Java Code as all three scenarios should end at the same result

### First Scenario

First Scenario was given within the assignement, it was implemented within cumcumber and can be found within the `features.features`

```
  @First
  Scenario: Search for restaurants in an area
    Given I want food in "AR51 1AA"
    When I search for restaurants
    Then I should see some restaurants in "AR51 1AA"
```

The following java code was coded to meet the requirments given by the cucumber code, this code can be found in `JustEatTest.java`:

#### Given

```
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

```

#### When

```
//this clicks on search button after the given has happen for I_want_food_in
	@When("I search for restaurants")
	public void i_search_for_restaurants() {
		driver.findElement(By.xpath("/html/body/app/div/div/div[1]/div[2]/form/div/button")).click();
	}

```

#### Then

```
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

```

### Second Scenario

The Second Scenario was made by me, I decided that I would be a good idea to check weather or not a similar address can be chosen after a user picks their brand of choice (for this test KFC was chosen). This was implemented using cucumber, it can be found within the `features.features`

```
  @Second
  Scenario: Search for restaurants in an area and picking a specific brand
    Given I want food from KFC in "AR51 2AA"
    When I search for KFC restaurants
    Then I should see some restaurants in "AR51 2AA"
  
```
The following java code was coded to meet the requirments given by the cucumber code, this code can be found in `JustEatTest.java`:

#### Given
```
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
```
#### When

```
//this clicks on search button after the given has happen for I_want_food from KFC_in
	//It also waits 5 seconds to ensure it that enough times has passsed for the page to load
	@When("I search for KFC restaurants")
	public void i_search_for_KFC_restaurants() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("Form_c-search-btn_1EEhL")).click();
	}
```

#### Then

```
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

```


### Third Scenario

The Third and last Scenario was also made by me, I decided that I would be a good idea to check weather or not a similar address can be chosen after a user picks their cuisine of choice (for this test indian cuisine was chosen). This was implemented using cucumber. it can be found within the `features.features`

```
  @Third
  Scenario: Search for restaurants in an area and picking a specific cuisine
    Given I want indian food in "AR51 3AA"
    When I search for indian restaurants
    Then I should see some restaurants in "AR51 3AA"
  
```
The following java code was coded to meet the requirments given by the cucumber code, this code can be found in `JustEatTest.java`:

#### Given
```
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
		
		
}
```
#### When

```
//this clicks on search button after the given has happen for I_want_food from KFC_in
	//It also waits 5 seconds to ensure it that enough times has passsed for the page to load
	@When("I search for indian restaurants")
	public void i_search_for_indian_restaurants() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("Form_c-search-btn_1EEhL")).click();
	}
```

#### Then

```
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

```

## Built With

* [Selenium](https://selenium.dev/) - Automating Web Applications for Testing Purposes
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/junit5/) - Testing Framework for Java
* [Cucumber](https://cucumber.io/) - Software Tool for Behavior-Driven Development.


## Authors

* **Alexander Sarancha** - *Sole Contributor* - [Sasha Sarancha](https://github.com/SashaSaran)

## Acknowledgments

* Countless Youtube Videos
* StackOverflow
* Internet Searches
