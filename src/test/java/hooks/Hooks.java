
package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ScreenshotUtil;

public class Hooks {

    DriverFactory driverFactory;

    @Before
    public void setUp() {

        driverFactory = new DriverFactory();
        driverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            DriverFactory.getDriver(),
                            scenario.getName());

            System.out.println(
                    "Screenshot captured at: "
                            + screenshotPath);
        }

        driverFactory.quitDriver();
    }
}
