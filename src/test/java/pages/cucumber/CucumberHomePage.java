package pages.cucumber;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import static org.testng.AssertJUnit.assertTrue;

public class CucumberHomePage extends LoadableComponent<CucumberHomePage> {

    //*********Page Variables*********
    private String baseURL = "https://cucumber.io/";
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

   public CucumberHomePage(){

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

    // Web Elements
    By learnBDDButton = By.xpath("//*[@id=\"block-yui_3_17_2_1_1533375529341_8854\"]/div/div/a");


    //*********Page Methods*********
    //Go to learn BDD page
    public void  goToBDDLearningPage (){

       // wait.until(ExpectedConditions.visibilityOfElementLocated(learnBDDButton));
        basePage.click(learnBDDButton);

    }



}
