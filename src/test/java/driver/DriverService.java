package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverService {



    public  static WebDriver getWebDriver(String browser) {
        WebDriver webDriver;
         String webDriverLocation = "local";


        System.out.println("Browser selected to run test::"+browser);

        if(webDriverLocation.equals("local")){

          if(browser.equals("chrome")){
              System.setProperty("webdriver.chrome.driver", "/Users/vincent/Documents/selenium-drivers/chrome-v74/chromedriver");

              webDriver = new ChromeDriver();
          }
          else  if(browser.equals("firefox")){

              System.setProperty("webdriver.gecko.driver", "/Users/vincent/Documents/selenium-drivers/firefox/geckodriver");

              webDriver = new FirefoxDriver();
          }
          else{
              System.setProperty("webdriver.chrome.driver", "/Users/vincent/Documents/selenium-drivers/chrome-v74/chromedriver");

              webDriver = new ChromeDriver();
          }


        }
        else{

            webDriver = SouceLabService.getWebDriver(browser);
        }

        return webDriver;
    }
}
