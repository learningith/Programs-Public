package com.google.test;

import com.automation.GoogleHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHomePageTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
    //        driver.quit();
        }
    }

   // @Testorg.openqa.selenium.ElementNotInteractableException: element not interactable

    @Test
    public void GoogleHomePageLaunchTest() throws InterruptedException {
        final String URL = "https://www.google.com";
        final String buttonLocator = "gNO89b";
        final String searchFor = "org.openqa.selenium.ElementNotInteractableException: element not interactable";
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.launchBrowserAndNavigate(URL);
        googleHomePage.searchOnGoogle(searchFor);
        googleHomePage.launchBrowserAndNavigate(URL);
        googleHomePage.searchOnGoogle("w3 schools");
        googleHomePage.getSearchButtonsByClassName(buttonLocator);
    }

}
