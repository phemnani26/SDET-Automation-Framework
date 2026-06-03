package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ConfigReader;

public class DriverFactory {

		public static WebDriver driver;
		
		public WebDriver initDriver()
		{
			ConfigReader configReader = new ConfigReader();
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt( ConfigReader.getProperty("implicitWait"))));
			return driver;
			
		}
		
		public static WebDriver getDriver()
		{
			return driver;
		}
		
		public void quitDriver()
		{
			if(driver!=null)
			{
				driver.quit();
			}
		}
		
}
