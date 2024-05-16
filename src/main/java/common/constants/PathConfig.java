package common.constants;

public class PathConfig {

    public static final String TEST_SCENARIOS = System.getProperty("user.dir") + "/src/test/resources/TestCases.csv";
    public static final String URL_CONFIG = System.getProperty("user.dir") + "/src/test/resources/URLConfig.properties";
    public static final String EXTENT_REPORT_CONFIG = System.getProperty("user.dir") + "/src/test/resources/ExtentReport.properties";
    public static final String EXTENT_REPORT_HTML = System.getProperty("user.dir") + "\\extent-reports\\";
    public static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "\\screenshots\\";

    public PathConfig() {
    }
}
