package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = { "pretty", "junit:target/cucumberReports/Cucumber.xml" },
        tags = "@search5"
)

public class testRunner {
}