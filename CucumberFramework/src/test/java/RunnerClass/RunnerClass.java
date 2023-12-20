package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\navve\\eclipse-workspace\\CucumberFramework\\Feature file\\Verify_CEO_Name.feature", glue = "StepDefinitions", monochrome = true, dryRun = false,
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty"})

public class RunnerClass {
	
	

}
