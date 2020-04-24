package Ramadan.Series;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ramadan.Series.Services.BashRunner;
import Ramadan.Series.Services.RamadanLogger;

public class Script extends Driver {
	PageObject pageObj;

	@DataProvider(name = "urls")
	public static Object[][] urls() {
		return new Object[][] { { "https://rmdan.org/157114/مسلسل-الزوجة-الـ18", "/mnt/public/Shows/Alzoga_18/" },
				{ "https://rmdan.net/157103/مسلسل-لمس-أكتاف", "/mnt/public/Shows/Lams_Aktaf/" },
				{ "https://rmdan.net/157104/مسلسل-هوجان", "/mnt/public/Shows/Hogan/" },
				{ "https://rmdan.net/157110/مسلسل-ﻵخر-نفس", "/mnt/public/Shows/La_Akher_Nafas/" },
				{ "https://rmdan.net/157138/مسلسل-طلقة-حظ", "/mnt/public/Shows/Lucky_Bullet/" },
				{ "https://rmdan.net/157135/مسلسل-أبو-جبل", "/mnt/public/Shows/Abo_Gabal/" },
				{ "https://myakoam.com/157111/%D9%85%D8%B3%D9%84%D8%B3%D9%84-%D8%AD%D9%83%D8%A7%D9%8A%D8%AA%D9%8A", "/mnt/public/Shows/Hekayty/" },
				{ "https://myakoam.com/157113/%D9%85%D8%B3%D9%84%D8%B3%D9%84-%D8%B2%D9%8A-%D8%A7%D9%84%D8%B4%D9%85%D8%B3", "/mnt/public/Shows/Zy_El_Shams/" },
				{ "https://myakoam.com/157108/%D9%85%D8%B3%D9%84%D8%B3%D9%84-%D9%88%D9%84%D8%AF-%D8%A7%D9%84%D8%BA%D9%84%D8%A7%D8%A8%D8%A9", "/mnt/public/Shows/Weld_El_Ghalaba/" },
				{ "https://myakoam.com/157109/%D9%85%D8%B3%D9%84%D8%B3%D9%84-%D9%82%D8%A7%D8%A8%D9%8A%D9%84", "/mnt/public/Shows/Kabel/" }};
	}

	@BeforeTest
	public void init() {
		pageObj = new PageObject(driver);
	}

	@Test(dataProvider = "urls")
	public void download(String url, String path) {
		navigate(url);
		String link = pageObj.getDownloadLink();
		RamadanLogger.info(link);
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
