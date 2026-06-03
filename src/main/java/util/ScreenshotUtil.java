package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver,
                                           String scenarioName) {

        String timeStamp =
                LocalDateTime.now()
                        .format(DateTimeFormatter
                                .ofPattern("yyyyMMdd_HHmmss"));

        String filePath =
                "test-output/screenshots/"
                        + scenarioName + "_"
                        + timeStamp + ".png";

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File destination = new File(filePath);

        destination.getParentFile().mkdirs();

        try {

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return filePath;
    }
}