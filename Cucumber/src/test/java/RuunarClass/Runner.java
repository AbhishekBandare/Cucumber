package RuunarClass;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\java\\Cucumber\\Demo03.feature"}
		
		
		)
	
public class Runner {

}
