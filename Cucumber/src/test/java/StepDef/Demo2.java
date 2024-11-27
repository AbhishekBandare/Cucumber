package StepDef;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo2 {

	WebDriver driver;
	@Given("user login to the EDU Bank page")
	public void user_login_to_the_edu_bank_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.bandre\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		driver.get("http://10.82.180.36:8080/EDUBank/tellerLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("user enters the signup details")
	public void user_enters_the_signup_details() {
	    // Write code here that turns the phrase above into concrete actions
		String titlePage=driver.getTitle();
		System.out.println("Title of the page :" +titlePage);
		driver.findElement(By.id("tellerId")).sendKeys("T7302");
		driver.findElement(By.id("password")).sendKeys("T7302*abc");
		driver.findElement(By.xpath("//i[@class=\"fa fa-sign-in\"]")).click();
		if (driver.getCurrentUrl().equals("http://10.82.180.36:8080/EDUBank/authenticateTeller")) {
			
			System.out.println("Login successfuly");
			
		} else {
			System.out.println("Login Unsuccessfuly");

		}
	    
	}

	@Then("User Logged In to EDU")
	public void user_logged_in_to_edu() {
	    // Write code here that turns the phrase above into concrete actions
		//validation method 
	    WebElement logo = driver.findElement(By.linkText("Logout"));
	    boolean display=logo.isDisplayed();
	    System.out.println(display);
	    logo.click();
	    driver.close();

	}


}
