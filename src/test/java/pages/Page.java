package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.cucumber.CucumberBDDTrainingPage;
import pages.cucumber.CucumberHomePage;
import pages.n11.HomePage;
import pages.n11.LoginPage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public class Page {

    private ConcurrentHashMap<WebDriver, ConcurrentHashMap<String, Object>> pageHashMap = new ConcurrentHashMap<>();

    private synchronized void setPageHashMap(WebDriver driver, String pageName, Object obj) {
        if (!pageHashMap.containsKey(driver)) {
            ConcurrentHashMap<String, Object> pageHashMapPageNamePageObj = new ConcurrentHashMap<>();
            pageHashMapPageNamePageObj.put(pageName, obj);
            pageHashMap.put(driver, pageHashMapPageNamePageObj);
        } else {
            if (!pageHashMap.get(driver).containsKey(pageName)) {
                pageHashMap.get(driver).put(pageName, obj);
            }
        }
    }

    private synchronized Object getPageHashMap(WebDriver driver, String pageName) {
        if (pageHashMap.containsKey(driver)) {
            return pageHashMap.get(driver).get(pageName);
        } else {
            return null;
        }
    }

    //This method creates a new screen with given Screen Name and Screen Class parameters
    private synchronized <T extends LoadableComponent<T>> T createPage(String pageName, Class<T> t) {
        T page = (T) getPageHashMap(DriverFactory.getDriver(), pageName);
        if (page != null) {
            return page;
        } else {
            page = instantiateNewPage(DriverFactory.getDriver(), t);
            setPageHashMap(DriverFactory.getDriver(), pageName, page.get());
            return (T) getPageHashMap(DriverFactory.getDriver(), pageName);
        }
    }

    //This Method Instantiates a new screen. I got this method from PageFactory Class and modify it.
    private static <T extends LoadableComponent<T>> T instantiateNewPage(WebDriver driver, Class<T> t) {
        try {
            try {
                Constructor<T> constructor = t.getConstructor(WebDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException var3) {
                return t.newInstance();
            }
        } catch (InstantiationException var4) {
            throw new RuntimeException(var4);
        } catch (IllegalAccessException var5) {
            throw new RuntimeException(var5);
        } catch (InvocationTargetException var6) {
            throw new RuntimeException(var6);
        }
    }

    public synchronized HomePage homePage() {

        return createPage("homePage", HomePage.class);
    }

    public synchronized LoginPage loginPage() {

        return createPage("loginPage", LoginPage.class);
    }

    public synchronized CucumberHomePage cucumberHomePage() {

        return createPage("cucumberHomePage", CucumberHomePage.class);
    }

    public synchronized CucumberBDDTrainingPage cucumberBDDTrainingPage() {
        return createPage("cucumberBDDTrainingPage", CucumberBDDTrainingPage.class);
    }


}