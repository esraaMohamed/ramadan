package Ramadan.Series;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ramadan.Series.Services.BashRunner;


public class Script extends Driver {
	PageObject pageObj;

	@DataProvider(name = "urls")
	public static Object[][] urls() { 
		return new Object[][] {
			{"https://rmdan.net/157114/مسلسل-الزوجة-الـ18" , "/Users/esraa/Desktop/test"}
//			,
//			{"https://rmdan.net/157103/مسلسل-لمس-أكتاف", ""},
//			{"https://rmdan.net/157104/مسلسل-هوجان", ""},
//			{"https://rmdan.net/157110/مسلسل-ﻵخر-نفس", ""},
//			{"https://rmdan.net/157138/مسلسل-طلقة-حظ", ""},
//			{"https://rmdan.net/157135/مسلسل-أبو-جبل", ""}
		};
	}

	@BeforeTest
	public void init() {
		pageObj = new PageObject(driver);
	}

	@Test(dataProvider = "urls")
	public void download(String url, String path) {
		navigate(url);	
		String link = pageObj.getDownloadLink();
		BashRunner bashRunner = new BashRunner();
		bashRunner.runCommand(link, path);
	}

}
