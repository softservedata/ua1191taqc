package com.softserve.framework.tools;

import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
    private final String PATH_SEPARATOR = "/";
    private final String BASE_URL = "base.url";
    private Properties appProps;
    private String filename;

    public PropertiesUtil() {
        appProps = new Properties();
        filename = "application-test.properties";
    }

    public PropertiesUtil(String filename) {
        this();
        this.filename = filename;
    }

    private String getFullPath() {
        String path = this.getClass().getResource(PATH_SEPARATOR + filename).getPath();
        System.out.println("\tpath = " + path);
        return path;
    }

    private void readProperties() {
        try (FileInputStream fileInputStream = new FileInputStream(getFullPath())) {
            appProps.load(fileInputStream);
        } catch (Exception e){
            System.out.println("ERROR Reading " + filename + "  Message = " + e.getMessage());
        }
    }

    public String readBaseUrl() {
        readProperties();
        String baseUrl = appProps.getProperty(BASE_URL, null);
        return baseUrl;
    }
}
