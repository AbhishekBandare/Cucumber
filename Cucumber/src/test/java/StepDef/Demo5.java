package StepDef;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo5 {

	
	static WebDriver driver;
	String url="https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target";
	
	@Given("user open w3School website")
	public void user_open_w3school_website() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.bandre\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@When("user click on link and open new broswer instance")
	public void user_click_on_link_and_open_new_broswer_instance() {
	    // Write code here that turns the phrase above into concrete actions)
	    driver.findElement(By.id("getwebsitebtn")).click();
	    Set<String> set=driver.getWindowHandles();
	    Iterator<String> i=set.iterator();
	    String parentWindow=i.next();
	    String childWindow=i.next();
	    driver.switchTo().window(childWindow);
	    driver.findElement(By.linkText("Log in")).click();
	}

	@Then("verify the result & close the broswer")
	public void verify_the_result_close_the_broswer() {
	    // Write code here that turns the phrase above into concrete actions
		
		if (driver.getCurrentUrl().equals("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fwww.w3schools.com%2F")) {
			
			System.out.println("Window handling successsfuly");
			
		} else {
			System.out.println("Unsuccessfuly");

		}
	    driver.close();
	    driver.quit();
	}
}
