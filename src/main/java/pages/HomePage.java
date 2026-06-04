package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WaitUtils;

public class HomePage extends BasePage{

   
	public HomePage(WebDriver driver) {

	    super(driver);
	}

    // Locators

    // By Type = linkText
	private By careersLink = By.linkText("Careers");

    // Cookie accept button
	private By acceptCookiesButton =
            By.xpath("//button[contains(text(),'Accept')]");

    // Open website
    public void openLabCorpWebsite(String url) {

        driver.get(url);
    }

    // Handle cookies
    public void acceptCookies() {

        try {

            waitUtils.waitForElementClickable(
                    acceptCookiesButton);

            driver.findElement(
                    acceptCookiesButton).click();

        } catch (Exception e) {

            System.out.println(
                    "Cookie popup not displayed");
        }
    }

    // Click Careers
    public void clickCareersLink() {

        acceptCookies();

        driver.findElement(careersLink).click();
    }
}

