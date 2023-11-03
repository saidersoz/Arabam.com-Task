package com.task.utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;


    /**
     * Loads the properties from the specified file path.
     *
     * @param filePath The path to the properties file.
     * @throws IOException If there was an error reading the properties file.
     */
    static {
        try {
            // Location of properties
            String path = System.getProperty("user.dir") + "/Configuration.properties";
            // Getting this file as a stream
            FileInputStream input = new FileInputStream(path);
            // Creating an object of Properties class
            configFile = new Properties();
            //  Loading information from the FileInputStream object into the Properties object with the load method.
            configFile.load(input);
            // close the input FileInputStream
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * This method returns property value from configuration.properties file
     *
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

}
