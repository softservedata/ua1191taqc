package com.softserve.framework.data;

import com.softserve.framework.tools.PropertiesUtil;

public final class PropertiesRepository {

    private static PropertiesUtil propertiesUtil;

    static {
        propertiesUtil = new PropertiesUtil();
    }

    private PropertiesRepository() {
    }

    public static String getBaseUrl() {
        return propertiesUtil.readBaseUrl();
    }

}
