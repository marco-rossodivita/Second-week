package com.corso.java.employee;


import com.corso.java.utils.LOG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties1 {

    private static LOG L;
    private Properties properties;
    private InputStream inputStream;
    private String resourceName;
    private final ClassLoader loader = Thread.currentThread().getContextClassLoader();


    public ReadProperties1() {
        this.init();
    }

    /**
     * Constructor
     *
     * @param properties
     * @param inputStream
     */
    public ReadProperties1(Properties properties, InputStream inputStream) {
        this.properties = properties;
        this.inputStream = inputStream;
    }

    /**
     * @return - L
     */
    public static LOG getL() {
        return L;
    }

    /**
     * initialize variables
     */
    public void init() {
        L = LOG.getInstance();
        this.properties = new Properties();
    }

    /**
     * read a resource name
     *
     * @throws IOException
     */
    public void read() throws IOException {
        this.resourceName = "application.properties";
        inputStream = new FileInputStream("src/main/resources/" + this.resourceName);
        this.properties.load(inputStream);
    }

    /**
     * @return - properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * @return - inputStream
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * @return - properties
     */
    public String getResourceName() {
        return resourceName;
    }

}
