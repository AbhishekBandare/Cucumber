package StepDef;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo7 {

	
	
	static WebDriver driver;
	String url="https://www.flipkart.com/";
		
	@Given("user open the flipkart website")
	public void user_open_the_flipkart_website() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.bandre\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//span[@role=\"button\"]")).click();
	    
	}

	@When("user perform the slider action")
	public void user_perform_the_slider_action() {
	    // Write code here that turns the phrase above into concrete actions
		//keybroad actiond demo
		driver.findElement(By.name("q")).sendKeys("Vivo" +Keys.ENTER);
		WebElement slider=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]/div"));
		Actions a=new Actions(driver);
		a.dragAndDropBy(slider, 50, 0).perform();
	}

	@Then("close the broswer")
	public void close_the_broswer() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

}
