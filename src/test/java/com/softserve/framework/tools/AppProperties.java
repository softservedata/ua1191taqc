package com.softserve.framework.tools;

public class AppProperties {

    public static void main(String[] args) {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        String baseUrl = propertiesUtil.readBaseUrl();
        System.out.println("baseUrl = " + baseUrl);
    }
}
