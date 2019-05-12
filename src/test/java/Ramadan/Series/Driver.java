package Ramadan.Series;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import bsh.Capabilities;

public class Driver {
	public static WebDriver driver;
	public static File dataFile;
	public static String BaseURl;

	@BeforeSuite
	@Parameters({ "URL" })
	public void startDriver(@Optional("http://akoam.com") String URL) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "resources"
						+ File.separator + "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		BaseURl = "https://rmdan.net/157114/مسلسل-الزوجة-الـ18";
//		BaseURl = "https://rmdan.net/157103/مسلسل-لمس-أكتاف";
//		BaseURl = "https://rmdan.net/157104/مسلسل-هوجان";
//		BaseURl = "https://rmdan.net/157110/مسلسل-ﻵخر-نفس";
		BaseURl = "https://rmdan.net/157138/مسلسل-طلقة-حظ";
	}

	public void navigate() {
		driver.get(BaseURl);
	}

	@AfterSuite(alwaysRun=true)
	public void stopDriver() {
		driver.quit();
	}

}
