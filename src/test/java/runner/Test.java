package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue= {"stepDefinitions","com.setup"},
		plugin= {"pretty", "json:target/reports/cucumber-report.json",
				"junit:target/reports/cucumber-report.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true
		,tags="@Smoke or @Regression and not @Prod",
		publish=true,
		dryRun=false		
)
public class Test {

}
