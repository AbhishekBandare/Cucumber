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
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo8 {
	
	static WebDriver driver;
	String url="https://demoqa.com/droppable/";
	String url2="http://10.82.180.36:81/Automation/PackAndGo_v2/";

	@Given("user open the demQA website")
	public void user_open_the_dem_qa_website() throws InterruptedException {
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

	@When("user perfrom action of drag and drop")
	public void user_perfrom_action_of_drag_and_drop() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    JavascriptExecutor scroll=(JavascriptExecutor) driver;
	    scroll.executeScript("window.scrollBy(0,400)");
	    
	    WebElement drog=driver.findElement(By.id("draggable"));
	    WebElement drop=driver.findElement(By.id("droppable"));
	    Thread.sleep(3000);
	    Actions a=new Actions(driver);
	    a.dragAndDrop(drog, drop).build().perform();
	}

	@Then("clsoe the browser")
	public void clsoe_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

	@Given("user open the pact and go website in chrome")
	public void user_open_the_pact_and_go_website_in_chrome() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.bandre\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		driver.get(url2);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("user logged in {string} and password {string}")
	public void user_logged_in_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[@class=\"glyphicon glyphicon-log-in\"]")).click();
		driver.findElement(By.id("usernameLogin")).sendKeys(string);
		driver.findElement(By.id("passwordLogin")).sendKeys(string2);
		driver.findElement(By.id("login")).click();
	}

	@Then("close chrome")
	public void close_chrome() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[@class=\"glyphicon glyphicon-log-out\"]")).click();
		driver.close();
	}
}
