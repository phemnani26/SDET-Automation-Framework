
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public ConfigReader() {

        try {

            prop = new Properties();

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/config/config.properties");

            prop.load(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) 
    {

        return prop.getProperty(key);
    }
}
