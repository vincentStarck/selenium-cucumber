package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SouceLabService {



    public static WebDriver getWebDriver(String browerName){

         WebDriver driver=null;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //set your user name and access key to run tests in Sauce
        capabilities.setCapability("username", "vicente_11_13");

        //set your sauce labs access key
        capabilities.setCapability("accessKey", "d0635479-508a-4df9-ae10-f51f3545cb2b");

        //set browser to Safari
        capabilities.setCapability("browserName", "Safari");

        //set operating system to macOS version 10.13
        capabilities.setCapability("platform", "macOS 10.13");

        //set the browser version to 11.1
        capabilities.setCapability("version", "11.1");

        //set the build name of the application
        capabilities.setCapability("build", "Onboarding Sample App - Java");

        //set your test case name so that it shows up in Sauce Labs
        capabilities.setCapability("name", "1-first-test");

        /**
         * In this section, we will set the WebDriver to a Remote driver to run on sauce, and pass the capabilities
         * we just set. Then we perform som actions on the page before quitting the driver.
         */

        //create a new Remote driver that will allow your test to send
        // commands to the Sauce Labs grid so that Sauce can execute your tests
        /** If you're accessing the EU data center, use the following endpoint:.
         * https://ondemand.eu-central-1.saucelabs.com/wd/hub
         * */
        try {
            driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;


    }
}
