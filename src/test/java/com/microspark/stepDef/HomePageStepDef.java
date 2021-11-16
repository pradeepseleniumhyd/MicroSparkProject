package com.microspark.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HomePageStepDef {
	
	WebDriver driver; 
	public CareersPageStepDef cpsf ;
	

	
	@Given("user opens the browser")
	public void user_opens_the_browser() {
		WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 this.driver = driver;
	 driver.manage().window().maximize();
	 cpsf = new CareersPageStepDef();
	}
	@When("user enters the url")
	public void user_enters_the_url() {
		driver.get("https://www.microspark.com/");
		}
	
	@Then("user able to see the Micro Spark Home Page")
	public void user_able_to_see_the_micro_spark_home_page() {
	String actualTitle=	driver.getTitle();
	Assert.assertEquals("Microspark Solutions Pvt Ltd | Top IT Consultancy in Hyderabad", actualTitle);
	String actualURL = driver.getCurrentUrl();
	Assert.assertEquals("https://www.microspark.com/", actualURL);
	}
	@Then("user verifies all the fields in the home page")
	public void user_verifies_all_the_fields_in_the_home_page() {
		String email= driver.findElement(By.xpath("(//span[contains(text(),'Email Address :')])[1]")).getText();
		if(email.equalsIgnoreCase("Email Address :"))
		{
			System.out.println(email + " is displayed");
		}else
		{
			System.out.println(email + " is not displayed");
			Assert.fail(email + " is not displayed");
		}
	}

	@When("user click on careers menu in homepage")
	public void user_click_on_careers_menu_in_homepage() {
			driver.findElement(By.xpath("(//a[text()='Careers'])[2]")).click();
	}
	@Then("user able to see Careers page")
	public void user_able_to_see_careers_page() {
			String actualURL = driver.getCurrentUrl();
		Assert.assertEquals("https://www.microspark.com/careers/", actualURL);

		}



}
