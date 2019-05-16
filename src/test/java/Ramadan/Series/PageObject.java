package Ramadan.Series;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public String getDownloadLink() {
		driver.get(downloadBtns.get(0).getAttribute("href"));
		for (int i = 0; i < links.size(); i++) {
			if(links.get(i).getAttribute("href") != null && (links.get(i).getAttribute("href").contains("https://rmdan.net/download/") || links.get(i).getAttribute("href").contains("http://akoam.com/download/"))) {
				driver.get(links.get(i).getAttribute("href"));
				break;
			}
		}
		WebElement timer = driver.findElement(By.id("timerHolder"));
		waitForBrowserToLoadCompletely();
		return timer.findElement(By.tagName("a")).getAttribute("href");
	}
}
