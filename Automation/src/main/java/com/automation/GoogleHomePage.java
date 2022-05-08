package com.automation;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class GoogleHomePage {
    protected final WebDriver driver;
    private final By searchInputText = By.xpath("//input[@title='Search']");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void launchBrowserAndNavigate(final String url) throws InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(1000*05);
    }

    public void searchOnGoogle(String searchText) throws InterruptedException {
        WebElement searchInputElement = driver.findElement(searchInputText);

        searchInputElement.sendKeys(searchText);
        searchInputElement.sendKeys(Keys.RETURN);
        Thread.sleep(1000*05);
    }

    //WebElement
    public void getSearchButtonsByClassName(String className) {
        By buttonsLocator = By.className(className);
        //ArrayList<WebElement> buttonElements = (ArrayList)driver.findElements(buttonsLocator);
        List<WebElement> buttonElements = driver.findElements(buttonsLocator);

        //for(int i = 0; i < buttonElements.size(); i++)
        for(WebElement buttonElement :   buttonElements) {
            String textColor = buttonElement.getCssValue("color");
            String text = buttonElement.getAttribute("value");
            String type = buttonElement.getAttribute("type");

            if (text.equalsIgnoreCase("google search")) {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].click()", buttonElement);
                //buttonElement.click();
                break;
                //i
            }

            System.out.println(
                    String.format("HTML element type %s name %s text color %s ", type, text, textColor)
            );
        }



    }


}
