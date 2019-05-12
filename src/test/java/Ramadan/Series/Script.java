package Ramadan.Series;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ramadan.Series.Services.BashRunner;

public class Script extends Driver {
	PageObject pageObj;

	@DataProvider(name = "urls")
	public static Object[][] urls() {
		return new Object[][] { { "https://rmdan.net/157114/مسلسل-الزوجة-الـ18", "/mnt/public/" },
				{ "https://rmdan.net/157103/مسلسل-لمس-أكتاف", "/mnt/public/" },
				{ "https://rmdan.net/157104/مسلسل-هوجان", "/mnt/public/" },
				{ "https://rmdan.net/157110/مسلسل-ﻵخر-نفس", "/mnt/public/" },
				{ "https://rmdan.net/157138/مسلسل-طلقة-حظ", "/mnt/public/" },
				{ "https://rmdan.net/157135/مسلسل-أبو-جبل", "/mnt/public/" } };
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

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { Script.class });
		testng.addListener(tla);
		testng.run();
	}

}
