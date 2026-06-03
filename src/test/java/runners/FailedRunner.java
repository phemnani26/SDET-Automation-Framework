package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failedrerun.txt",
        glue = {"stepdefinitions", "hooks"},
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/failed-cucumber-report.html"
        }
)

public class FailedRunner extends AbstractTestNGCucumberTests {

}