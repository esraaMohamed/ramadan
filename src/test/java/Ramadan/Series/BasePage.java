package Ramadan.Series;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected static final int FIND_ELEMENT_TIMEOUT = 60; 	// in seconds
	protected static final int POLL = 1000; 		// poll in milliseconds (don't ask me why Selenium wants different units)

	private int driverDefaultFluentWait = 120;
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		this.driver = driver;
	}

	public void waitForElementToBeVisible(WebElement element ,  WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,driverDefaultFluentWait);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForElementClickable(WebElement element) { 
		WebDriverWait wait = new WebDriverWait(driver, FIND_ELEMENT_TIMEOUT, POLL); 
		wait.until(ExpectedConditions.elementToBeClickable(element)); 
	}
	
	public void waitForBrowserToLoadCompletely() {
	    String state = null;
	    String oldstate = null;
	    try {
	        System.out.print("Waiting for browser loading to complete");

	        int i = 0;
	        while (i < 5) {
	            Thread.sleep(1000);
	            state = ((JavascriptExecutor) driver).executeScript("return document.readyState;").toString();
	            System.out.print("." + Character.toUpperCase(state.charAt(0)) + ".");
	            if (state.equals("interactive") || state.equals("loading"))
	                break;
	            /*
	             * If browser in 'complete' state since last X seconds. Return.
	             */

	            if (i == 1 && state.equals("complete")) {
	                System.out.println();
	                return;
	            }
	            i++;
	        }
	        i = 0;
	        oldstate = null;
	        Thread.sleep(2000);

	        /*
	         * Now wait for state to become complete
	         */
	        while (true) {
	            state = ((JavascriptExecutor) driver).executeScript("return document.readyState;").toString();
	            System.out.print("." + state.charAt(0) + ".");
	            if (state.equals("complete"))
	                break;

	            if (state.equals(oldstate))
	                i++;
	            else
	                i = 0;
	            /*
	             * If browser state is same (loading/interactive) since last 60
	             * secs. Refresh the page.
	             */
	            if (i == 15 && state.equals("loading")) {
	                System.out.println("\nBrowser in " + state + " state since last 60 secs. So refreshing browser.");
	                driver.navigate().refresh();
	                System.out.print("Waiting for browser loading to complete");
	                i = 0;
	            } else if (i == 6 && state.equals("interactive")) {
	                System.out.println(
	                        "\nBrowser in " + state + " state since last 30 secs. So starting with execution.");
	                return;
	            }

	            Thread.sleep(4000);
	            oldstate = state;

	        }
	        System.out.println();

	    } catch (InterruptedException ie) {
	        ie.printStackTrace();
	    }
	}
	
	 public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
	        return new ExpectedCondition<Boolean>() {
	            @Override
	            public Boolean apply(WebDriver driver) {
	                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
	            }
	        };
	    }
	 
	 public void setTimer() {
		 ((JavascriptExecutor) driver).executeScript("timer=1;");
	 }
	 
	 public void callClock() {
		 ((JavascriptExecutor) driver).executeScript("clock();");
	 }
}
