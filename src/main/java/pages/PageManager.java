package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {

    public static BasePage getPage(String pageName,
                                   WebDriver driver) {

        switch(pageName.toLowerCase()) {

        case "home":
            return new HomePage(driver);

        case "careers":
            return new CareersPage(driver);

        case "jobdetails":
            return new JobDetailsPage(driver);

        default:
            throw new RuntimeException(
                    "Invalid Page Name");
        }
    }
}