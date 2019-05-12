package Ramadan.Series;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Driver {
	public static WebDriver driver;
	public static File dataFile;

	@BeforeSuite
	@Parameters({ "URL" })
	public void startDriver(@Optional("http://akoam.com") String URL) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "resources" + File.separator + "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void navigate(String url) {
		driver.get(url);
	}

	@AfterSuite(alwaysRun = true)
	public void stopDriver() {
		driver.quit();
	}

}
