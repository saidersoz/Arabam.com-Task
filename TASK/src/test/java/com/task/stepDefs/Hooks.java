package com.task.stepDefs;

import com.task.utilities.ConfigurationReader;
import com.task.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.SQLException;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        logger.info(":::: Starting test automation ::::");
        logger.info("Browser type :: {}", ConfigurationReader.getProperty("browser"));
        logger.info("Environment :: {}", ConfigurationReader.getProperty("url"));
        logger.info("Test scenario :: {}", scenario.getName());
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
            logger.error("Test scenario :: {} :: Failed", scenario.getName());
        } else {
            logger.info("Test scenario :: {} :: Passed", scenario.getName());
        }
        Driver.closeDriver();
    }
}