package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WaitUtils;

public class CareersPage {

    WebDriver driver;
    WaitUtils waitUtils;

    // Constructor
    public CareersPage(WebDriver driver) {

        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    // By Type = id
    By searchBox = By.id("typehead");

    // Exact job result from search popup
    // By Type = xpath
    By searchedJob =
            By.xpath("//li[contains(.,'QA Test Automation Developer')]");

    // Search Job
    public void searchJob(String jobName) {

        waitUtils.waitForElementVisible(searchBox);

        driver.findElement(searchBox)
                .clear();

        driver.findElement(searchBox)
                .sendKeys(jobName);
    }

    // Select searched job
    public void selectJob() {

        waitUtils.waitForElementClickable(searchedJob);

        driver.findElement(searchedJob)
                .click();
    }
}
