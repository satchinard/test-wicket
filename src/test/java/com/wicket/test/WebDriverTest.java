package com.wicket.test;

import java.net.MalformedURLException;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author cagecfi
 */
public class WebDriverTest {

    WebDriver driver;

    @Test
    public void verifySearch() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cagecfi\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
//        driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        driver.get("http://only-testing-blog.blogspot.in/");
        driver.quit();
    }
}
