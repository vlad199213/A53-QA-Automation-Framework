package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected FluentWait<WebDriver> fluentWait;

    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    protected WebElement fluentWaitForElementToBeClickable(WebElement webElement) {
        return fluentWait
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementClickInterceptedException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement findElementByLocator(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public List<WebElement> findElements(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

}
