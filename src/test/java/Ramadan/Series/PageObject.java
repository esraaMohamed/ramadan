package Ramadan.Series;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Ramadan.Series.Services.RamadanLogger;

public class PageObject extends BasePage {

	@FindBy(className = "download_btn")
	private List<WebElement> downloadBtns;

	@FindBy(tagName = "a")
	private List<WebElement> links;

	public PageObject(WebDriver driver) {
		super(driver);
	}

	public String getDownloadLink() {
		RamadanLogger.info(downloadBtns.get(0).getAttribute("href"));
		driver.get(downloadBtns.get(0).getAttribute("href"));
		String serviceDownloadLink = getDownloadServiceLink(10);
		if (serviceDownloadLink != null) {
			driver.get(serviceDownloadLink);
			return getFinalLink(10);
		}
		RamadanLogger.error("No link has been fetched", 
				new TimeoutException(downloadBtns.get(0).getAttribute("href")));
		return null;
	}

	private String getDownloadServiceLink(int maxRetries) {
		while (--maxRetries >= 0) {
			waitForBrowserToLoadCompletely();
			for (int i = 0; i < links.size(); i++) {
				if (links.get(i).getAttribute("href") != null && links.get(i).getAttribute("href").contains("akoam")
						&& links.get(i).getAttribute("href").contains("/download/")) {
					RamadanLogger.info(links.get(i).getAttribute("href"));
					return links.get(i).getAttribute("href");
				}
			}
			RamadanLogger.info("Trying to get the SERVICE link: " + maxRetries);
		}
		return null;
	}

	private String getFinalLink(int maxRetries) {
		while (--maxRetries >= 0) {
			waitForBrowserToLoadCompletely();
			if (driver.findElement(By.id("timerHolder")).findElements(By.tagName("a")).size() > 0) {
				return driver.findElement(By.id("timerHolder")).findElement(By.tagName("a")).getAttribute("href");
			}
			RamadanLogger.info("Trying to get the DOWNLOAD link: " + maxRetries);
		}
		return null;
	}
}
