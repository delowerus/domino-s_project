package framework.webpages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.List;

public class BasePage {


    public WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown"
                );

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                return driver.findElement(locator);
            }
        });

        return element;
    }

    public List<WebElement> webActions(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
        return elements;
    }

    public boolean isWebElementDisplayed(By locator) {
        boolean isDisplayed = false;
        try {
            isDisplayed = SharedSD.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No such element found with locator: " + locator);
        }

        return isDisplayed;
    }

    public boolean isButtonEnabled(By locator) {
        return webAction(locator).isEnabled();
    }

    public String getTextFromElement(By locator) {
        return webAction(locator).getText();
    }

    public WebElement getWebElement(By locator){
        return webAction(locator);
    }

    public List<WebElement> getWebElements(By locator){
        return webActions(locator);
    }

    public String getPageUrl(){
        return SharedSD.getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return SharedSD.getDriver().getTitle();
    }

    public void clickOnWebElement(By locator){
        webAction(locator).click();
    }

    public void setValue(By locator, String value) {
        webAction(locator).sendKeys(value);
    }

}
