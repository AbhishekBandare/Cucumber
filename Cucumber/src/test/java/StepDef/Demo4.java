package StepDef;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo4 {
	
	static WebDriver driver;
	String url="http://10.82.180.36:81/Automation/PackAndGo_v2/";

	@Given("Login to the Site")
	public void login_to_the_site() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.bandre\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("user enter the username {string} and password {string}")
	public void user_enter_the_username_and_password(String user, String pass) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[@class=\"glyphicon glyphicon-log-in\"]")).click();
		driver.findElement(By.id("usernameLogin")).sendKeys(user);
		driver.findElement(By.id("passwordLogin")).sendKeys(pass);
		driver.findElement(By.id("login")).click();
		if (driver.getCurrentUrl().equals("http://10.82.180.36:81/Automation/PackAndGo_v2/dashboard.html")) {
			
			System.out.println("Login successfuly :" +user +pass);
			driver.findElement(By.xpath("//span[@class=\"glyphicon glyphicon-log-out\"]")).click();
			
		} else {
			
			System.out.println("Login Unsuccessfuly : " +user +pass);
		}
	}

	@Then("Check the status of the login & close the broswer")
	public void check_the_status_of_the_login_close_the_broswer() {
	    // Write code here that turns the phrase above into concrete actions
		
	    driver.close();
	}
}
