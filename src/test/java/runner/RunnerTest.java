package runner;

import com.sun.prism.shape.ShapeRep;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.DriverFactory;
import driver.SharedDriver;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

//@CucumberOptions(glue = "stepdef", plugin = {"json:target/json-cucumber-reports/cukejson.json",
//        "testng:target/testng-cucumber-reports/cuketestng.xml" }, features = "src/test/resources/features/")


@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepdef", plugin = {"json:target/json-cucumber-reports/cukejson.json",
        "testng:target/testng-cucumber-reports/cuketestng.xml" }, features = "src/test/resources/features", monochrome = true)
public class RunnerTest extends AbstractTestNGCucumberTests {


    @BeforeClass
    @Parameters(value={"browser"})
    public void setupTest (@Optional String browser) throws MalformedURLException {
        System.out.println("BeforeMethod is started. " + Thread.currentThread().getId());

        if (browser == null) {

            browser = "chrome";
        }


        SharedDriver.SetWebDriver(browser);
    }
    @AfterClass(description = "Class Level Teardown!")
    public void globalTearDown() {
        DriverFactory.getDriver().quit();
    }




}


