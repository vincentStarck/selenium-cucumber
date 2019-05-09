package pages.cucumber;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import static org.testng.AssertJUnit.assertTrue;

public class CucumberBDDTrainingPage extends LoadableComponent<CucumberBDDTrainingPage> {

    //*********Page Variables*********
    private String baseURL = "https://cucumber.io/training";
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    public CucumberBDDTrainingPage() {

        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        basePage = new BasePage(this.driver);
    }

    @Override
    protected void load() {
        this.driver.get(baseURL);

    }

    @Override
    protected void isLoaded() throws Error {

        assertTrue("HomePage is not loaded!", driver.getCurrentUrl().contains(baseURL));

    }


    //*********Page Methods*********
    public void ThenIVerifyIamInTheTrainingBDDPage() {

        Assert.assertTrue(driver.getCurrentUrl().contains(baseURL));

    }


}
