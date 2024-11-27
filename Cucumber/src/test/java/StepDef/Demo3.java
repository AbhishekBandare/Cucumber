package StepDef;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo3 {
	
	static WebDriver driver;
	String url="http://10.82.180.36:81/Automation/PackAndGo_v2/";
	
	@Given("Login to the Site with credentials given above")
	public void login_to_the_site_with_credentials_given_above() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.bandre\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class=\"glyphicon glyphicon-log-in\"]")).click();
		driver.findElement(By.id("usernameLogin")).sendKeys("pgGru");
		driver.findElement(By.id("passwordLogin")).sendKeys("freezeray");
		driver.findElement(By.id("login")).click();
	}

	@When("User must perform a new booking")
	public void user_must_perform_a_new_booking() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement select=driver.findElement(By.id("fromDD"));
	    Select s= new Select(select);
	    s.selectByIndex(1);
	    Thread.sleep(1000);
	    WebElement select1=driver.findElement(By.id("toDD"));
	    Select s1= new Select(select1);
	    s1.selectByIndex(1);
	    driver.findElement(By.id("searchBus")).click();
	    WebElement Bus=driver.findElement(By.id("radio2"));
	    Boolean raidoButon= Bus.isSelected();
	    System.out.println(raidoButon);
	    driver.findElement(By.id("radio2")).click();
	    Thread.sleep(1000);
	    WebElement select2=driver.findElement(By.id("toDD1"));
	    Select s2=new Select(select2);
	    s2.selectByIndex(2);
	    driver.findElement(By.id("book")).click();
	}

	@Then("On successful booking, print the success message in the console")
	public void on_successful_booking_print_the_success_message_in_the_console() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("counter")).clear();
		driver.findElement(By.id("counter")).sendKeys("2");
		driver.findElement(By.xpath("//input[@value=\"Calculate Total Bill\"]")).click();
		WebElement fare=driver.findElement(By.id("tFare"));
		String text=fare.getText();
		System.out.println(text);
		driver.findElement(By.id("confirmBooking")).click();
		Alert alertText=driver.switchTo().alert();
		System.out.println(alertText.getText());
		alertText.accept();	
	  
	}

	@Then("close the driver")
	public void close_the_driver() {
	    // Write code here that turns the phrase above into concrete actions
	   
	    driver.close();
	    driver.quit();
	}
}
