package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty(
                                        "explicitWait"))));
    }

    public void waitForElementVisible(
            By locator) {

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                locator));
    }

    public void waitForElementClickable(
            By locator) {

        wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                locator));
    }

    public void waitForElementPresent(
            By locator) {

        wait.until(
                ExpectedConditions
                        .presenceOfElementLocated(
                                locator));
    }

    public void waitForTitleContains(
            String title) {

        wait.until(
                ExpectedConditions
                        .titleContains(
                                title));
    }
}