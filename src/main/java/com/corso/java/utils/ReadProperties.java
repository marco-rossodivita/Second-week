package com.corso.java.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private static LOG L;
    private Properties properties;
    private InputStream inputStream;
    private String resourceName;
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    /**
     * Costruttore vuoto
     */
    public ReadProperties() {
    }

    /**
     * Constructor
     * @param properties
     * @param inputStream
     */
    public ReadProperties(Properties properties, InputStream inputStream) {
        this.properties = properties;
        this.inputStream = inputStream;
        this.init();
    }

    /**
     *
     */
    public void init(){
        L = LOG.getInstance();
        this.properties = new Properties();

    }

    /**
     *
     * @throws IOException
     */
    public void read(String name) throws IOException {
        //andiamo a leggerci il file
        this.resourceName = "application.properties";
        inputStream = new FileInputStream("src/main/resources/" + this.resourceName);

        this.properties.load(inputStream);
    }

    public static void main(String[] args) {
        ReadProperties readProperties = new ReadProperties();
        readProperties.init();

        try {
            readProperties.read("application.properties");

            String userName = readProperties.properties.getProperty("db.username");
            String password = readProperties.properties.getProperty("db.password");
            String mysqlUrl = readProperties.properties.getProperty("db.url");
            String dbUrl = readProperties.properties.getProperty("db.mysql.url");

            L.info(mysqlUrl);
            L.info(password);
            L.info(userName);
            L.info(dbUrl);

        } catch (IOException e) {
            e.printStackTrace();
            L.debug("ERROR");
        }
    }

}
