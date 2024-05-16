package common.utils;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyFileReader {

    static Properties properties;
    public static Properties readFile(String filePath) {
        try {
            properties = new Properties();
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }

        try {
            FileReader reader = new FileReader(filePath);
            properties.load(reader);
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return properties;
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}
