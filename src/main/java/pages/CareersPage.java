package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WaitUtils;

public class CareersPage extends BasePage {

  

    // Constructor
    public CareersPage(WebDriver driver) {

        super(driver);
    }
    // By Type = id
   private By searchBox = By.id("typehead");

    // Exact job result from search popup
    // By Type = xpath
   private By searchedJob =
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
