package com.wicket.test;

/**
 *
 * @author cagecfi
 */
public class MouseHoverExample {

//    public static WebDriver driver;
//
//    @Test
//    public void testouseOver() throws InterruptedException {
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("http://www.amazon.com/");
//
//        WebElement element = driver.findElement(By.id("nav-wishlist"));
//        mouseHoverJScript(element);
//    }
//
//    public void mouseHoverJScript(WebElement HoverElement) {
//        try {
//            if (isElementPresent(HoverElement)) {
//
//                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);            } else if (document.createEventObject) {                arguments[0].fireEvent('onmouseover');}";
//                ((JavascriptExecutor) driver).executeScript(mouseOverScript,
//                        HoverElement);
//
//            } else {
//                System.out.println("Element was not visible to hover " + "\n");
//
//            }
//        }
//        catch (StaleElementReferenceException e) {
//            System.out.println("Element with " + HoverElement
//                    + "is not attached to the page document"
//                    + e.getStackTrace());
//        }
//        catch (NoSuchElementException e) {
//            System.out.println("Element " + HoverElement + " was not found in DOM"
//                    + e.getStackTrace());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error occurred while hovering"
//                    + e.getStackTrace());
//        }
//    }
//
//    public static boolean isElementPresent(WebElement element) {
//        boolean flag = false;
//        try {
//            if (element.isDisplayed()
//                    || element.isEnabled()) {
//                flag = true;
//            }
//        }
//        catch (NoSuchElementException e) {
//            flag = false;
//        }
//        catch (StaleElementReferenceException e) {
//            flag = false;
//        }
//        return flag;
//    }
//
//    public void loginTestCase() {
//        driver.navigate().to(new URL("http://jw.org"));
//        driver.findElement(By.name("signIn")).click();
//        driver.findElement(By.id("username")).sendKeys("testuser");
//        driver.findElement(By.id("password")).sendKeys("testpassword");
//        driver.findElement(By.name("loginbtn")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile")));
//        String Expected = driver.findElement(By.id("message")).getText();
//        Assert.assertEquals(Expected, "Welcome");
//    }
}
