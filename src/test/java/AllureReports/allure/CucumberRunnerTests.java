package AllureReports.allure;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
@Suite
@IncludeEngines("cucumber")  // tells JUnit 5 to use the Cucumber engine
@SelectClasspathResource("features") // folder inside src/test/resources
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "AllureReports.allure.definitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm, json:target/cucumber.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME,
value = "@Addition")

public class CucumberRunnerTests {
    // empty class; JUnit 5 runs Cucumber tests
}
