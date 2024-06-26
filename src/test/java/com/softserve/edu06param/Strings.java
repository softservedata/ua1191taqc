package com.softserve.edu06param;

public class Strings {

    public static boolean isBlank(String string) {
        if (string == null) {
            return true;
        }
        string = string.trim();
        return string.isBlank();
    }
}
