package com.wicket.test;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//http://www.seleniumeasy.com/selenium-tutorials/how-to-double-click-on-element-using-webdriver
/**
 *
 * @author cagecfi
 */
public class BingTest {

    WebDriver driver;

    @BeforeTest
    public void StartBrowser_NavURL() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cagecfi\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
//        driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        driver.manage().window().maximize();
    }

    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }

    @Test
    public void testToCompareDoubles() {
        driver.get("http://www.bing.com");
    }
}
