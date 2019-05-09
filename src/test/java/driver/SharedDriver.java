package driver;

public class SharedDriver {


	public static void SetWebDriver(String browser) {
		System.out.println(Thread.currentThread().getId() + " CONST");
		if (DriverFactory.getDriver() == null) {

			DriverFactory.addDriver(DriverService.getWebDriver(browser));
		}



	}

}
