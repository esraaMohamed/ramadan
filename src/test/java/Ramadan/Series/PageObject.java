package Ramadan.Series;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject extends BasePage{
	
	@FindBy(className = "download_btn")
	private List<WebElement> downloadBtns;
	
	@FindBy(xpath = "//*[contains(text(), 'https://akoam.net/download/')]")
	private WebElement downloadLink;
	
	@FindBy(tagName = "a")
	private List<WebElement> links;
	
	@FindBy(id = "timerHolder")
	private WebElement timerDiv;
	
	public PageObject(WebDriver driver) {
		super(driver);
	}
	
	public void getDownloadLink() {
		driver.get(downloadBtns.get(0).getAttribute("href"));
		System.out.println(driver.getCurrentUrl());
		for (int i = 0; i < links.size(); i++) {
			if(links.get(i).getAttribute("href") != null && links.get(i).getAttribute("href").contains("https://akoam.net/download/")) {
				System.out.println(links.get(i).getAttribute("href"));
				driver.get(links.get(i).getAttribute("href"));
				break;
			}
		}
		WebElement timer = driver.findElement(By.id("timerHolder"));
		waitForBrowserToLoadCompletely();

		System.out.println(timer.findElement(By.tagName("a")).getAttribute("href"));
		driver.get(timer.findElement(By.tagName("a")).getText());
	}
}
