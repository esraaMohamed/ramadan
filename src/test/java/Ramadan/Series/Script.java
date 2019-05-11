package Ramadan.Series;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Script extends Driver {
	PageObject pageObj;
	
	@BeforeTest
	public void init() {
		pageObj = new PageObject(driver);
	}
	
	@Test
	public void download() {
		navigate();
		pageObj.getDownloadLink();
	}

}
