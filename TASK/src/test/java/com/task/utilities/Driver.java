package com.task.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<WebDriver>();
    /*
     * We use private and static modifiers so that no one can create a driver class object,
     * instead everyone should call the static getter method.
     */

    private Driver() {
    }

    /**
     * Synchronized makes method thread safe.
     * It ensures that only 1 thread can use it at the time.
     * Thread safety reduces performance but it makes everything safe.
     *
     * @return WebDriver
     */

    public synchronized static WebDriver getDriver() {
        /*
         * We first check if a webdriver object exists,
         * if not, this method will create it.
         *
         */
        if (driverPool.get() == null) {
            /*
             * We specified the type of browser in the configuration.properties file.
             * And then, we load these information into a Properties class object
             * by initiating a FileInputStream class  object.
             * This is where we will get type of browser by using ConfigurationReader.java class object.
             */
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36");
                    options.addArguments("start-maximized");
                    options.addArguments("disable-infobars");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--allow-insecure-localhost");
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name !");
            }
        }
        return driverPool.get();
    }
    public static void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
