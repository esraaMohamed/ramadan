package Ramadan.Series;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Script extends Driver {
	PageObject pageObj;
	public static String[] BaseURl = { "https://rmdan.net/157114/مسلسل-الزوجة-الـ18",
			"https://rmdan.net/157103/مسلسل-لمس-أكتاف", "https://rmdan.net/157104/مسلسل-هوجان",
			"https://rmdan.net/157110/مسلسل-ﻵخر-نفس", "https://rmdan.net/157138/مسلسل-طلقة-حظ",
			"https://rmdan.net/157135/مسلسل-أبو-جبل" };
	@BeforeTest
	public void init() {
		pageObj = new PageObject(driver);
	}
	
	@Test
	public void download() {
		for (String url : BaseURl) {
			navigate(url);	
		}
		
		pageObj.getDownloadLink();
	}

}
