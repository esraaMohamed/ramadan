package Ramadan.Series;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Driver {
	public static WebDriver driver;
	public static File dataFile;
	public static String BaseURl;

	@BeforeSuite
	@Parameters({ "URL" })
	public void startDriver(@Optional("http://akoam.com") String URL) {
		File pjs = new File(System.getProperty("user.dir") + File.separator + "resources"+ File.separator + "phantomjs");
		System.setProperty("phantomjs.binary.path", pjs.getAbsolutePath());
		driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "resources"
//						+ File.separator + "chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--test-type");
//		driver = new ChromeDriver(options);
		BaseURl = "https://ramdan.tv/157135/%D9%85%D8%B3%D9%84%D8%B3%D9%84-%D8%A3%D8%A8%D9%88-%D8%AC%D8%A8%D9%84";
	}

	public void navigate() {
		driver.get(BaseURl);
	}

	@AfterSuite(alwaysRun=true)
	public void stopDriver() {
		driver.quit();
	}

}
