package StepDef;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo6 {

	
	
	static WebDriver driver;
	String url="https://demo.guru99.com/test/guru99home/";
	
	
	@Given("user open the website")
	public void user_open_the_website() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.bandre\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
	}
	
	@Given("demo of scroll up and down")
	public void demo_of_scroll_up_and_down() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		//scroll up and down demo
				JavascriptExecutor scroll=( JavascriptExecutor ) driver;
				scroll.executeScript("window.scrollBy(0,400)");
				Thread.sleep(2000);
				scroll.executeScript("window.scrollBy(0,-400)");
	}

	@When("Mouse Hover actions")
	public void mouse_hover_actions() {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement action=driver.findElement(By.linkText("Testing"));
		Actions a=new Actions(driver);
		a.moveToElement(action).perform();
		driver.findElement(By.linkText("Selenium")).click();
	    
	}

	@Then("Close the broswer")
	public void close_the_broswer() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

}
