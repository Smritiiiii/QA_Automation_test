import Application.Test;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

import static Application.Test.closeBrowser;
//import static Application.Test.driver;

@CucumberOptions(plugin = {"pretty:target/cucumber-pretty.txt",
        "html:target/cucumber-html-report",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:output/cucumber.json"},
        tags = "@InvalidCredentials",
        features = "classpath:features")

public class RunnerTest extends AbstractTestNGCucumberTests {

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("Test Failed");
        }
        closeBrowser();
    }
}