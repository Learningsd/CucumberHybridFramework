package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                  glue = {"stepdefinitions","myHooks"},
                  publish = true,
                  plugin ={"pretty","html:target/CucumberReports/Cucumbera.html"}
                 )
public class TestRunner 
{
	
	

}
