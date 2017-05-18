package com.wicket.test;

import java.net.MalformedURLException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author cagecfi
 */
public class GoogleTest {

    WebDriver driver;

    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cagecfi\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

    @BeforeTest
    public void StartBrowser_NavURL() throws MalformedURLException {

        driver = new ChromeDriver();
        driver.get("http://jw.org");
//        driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        driver.manage().window().maximize();
    }

    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }

    @Test
    public void testToCompareDoubles() {
        driver.get("http://www.google.com");
    }

    @Test
    public void testCaseVerifyConnectHomePage() {
        driver = new FirefoxDriver();
        driver.navigate().to("http://google.com");
        Assert.assertEquals("Gooogle", driver.getTitle(), "Strings are not matching");
//        //Write a code to login and write a method called isUserLoggedInSuccessfully and isUserLoggedOut which returns boolean.
//        Assert.assertTrue(isUserLoggedInSuccessfully(), "User failed to login");
//        Assert.assertFalse(isUserLoggedOut());
    }

    @Test
    public void testCaseVerifyHomePage() {
        driver = new FirefoxDriver();
        driver.navigate().to("http://google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void testCaseVerifyCorrectHomePage() {
        driver = new FirefoxDriver();
        driver.navigate().to("http://google.com");
        Assert.assertEquals("Gooooogle", driver.getTitle());
    }
}
