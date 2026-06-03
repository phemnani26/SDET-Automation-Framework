package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public WaitUtils(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("explicitWait"))));
    }

    // Wait for visible element
    public void waitForElementVisible(By locator) {

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }

    // Wait for clickable element
    public void waitForElementClickable(By locator) {

        wait.until(
                ExpectedConditions
                        .elementToBeClickable(locator));
    }

}
