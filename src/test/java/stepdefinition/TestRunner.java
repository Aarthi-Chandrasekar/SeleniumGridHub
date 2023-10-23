package stepdefinition;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, strict = true, plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}, features = "src/test/java/features/uiautomation", glue = "stepdefinition"
        )

public class TestRunner {

}