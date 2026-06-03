
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WaitUtils;

public class JobDetailsPage {

    WebDriver driver;
    WaitUtils waitUtils;

    private String parentWindow;

    public JobDetailsPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // ==========================
    // Locators
    // ==========================

    // Job Title
    By jobTitle = By.xpath("//h1");

    // Job Location
    By jobLocation =
            By.xpath("//span[contains(text(),'This job is available in')]");

    // Apply Now Button
    By applyNowButton =
            By.xpath("(//*[contains(text(),'Apply Now')])[last()]");

    // ==========================
    // Methods
    // ==========================

    // Get Job Title
    public String getJobTitle() {

        waitUtils.waitForElementVisible(jobTitle);

        return driver.findElement(jobTitle).getText();
    }

    // Get Job Location
    public String getJobLocation() {

        waitUtils.waitForElementVisible(jobLocation);

        return driver.findElement(jobLocation).getText();
    }

    // Get Job ID from URL
    public String getJobId() {

        String url = driver.getCurrentUrl();

        return url.split("/job/")[1].split("/")[0];
    }

    // Click Apply Now and switch to new tab
    public void clickApplyNow() {

        parentWindow = driver.getWindowHandle();

        waitUtils.waitForElementClickable(applyNowButton);

        driver.findElement(applyNowButton).click();

        for (String handle : driver.getWindowHandles()) {

            if (!handle.equals(parentWindow)) {

                driver.switchTo().window(handle);
                break;
            }
        }
    }

    // Close Apply tab and return to Job Details page
    public void clickReturnToJobSearch() {

        driver.close();

        driver.switchTo().window(parentWindow);
    }
}
