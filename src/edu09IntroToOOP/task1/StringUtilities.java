package edu09IntroToOOP.task1;

public class StringUtilities {

    // Task 1: Method to check if two strings are equal (case-sensitive and case-insensitive)
    public static boolean areStringsEqual(String str1, String str2, boolean caseSensitive) {
        if (caseSensitive) {
            return str1.equals(str2);
        } else {
            return str1.equalsIgnoreCase(str2);
        }
    }

    // Task 2: Method to get a substring between two indices
    public static String getSubstring(String str, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > str.length() || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid start or end index.");
        }
        return str.substring(startIndex, endIndex);
    }

    // Task 3: Method to check if a substring is contained in a string and return the first occurrence index
    public static int getSubstringIndex(String str, String substring) {
        return str.indexOf(substring);
    }

    // Task 4: Method to replace all occurrences of one substring with another in a given string
    public static String replaceSubstring(String str, String oldSubstring, String newSubstring) {
        return str.replace(oldSubstring, newSubstring);
    }

    // Task 5: Method to determine if a string contains digits
    public static boolean containsDigits(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // Task 6: Method to remove all leading and trailing spaces from a string
    public static String trimString(String str) {
        return str.trim();
    }

    // Task 7: Method to split a string into an array of substrings according to a given delimiter
    public static String[] splitString(String str, String delimiter) {
        return str.split(delimiter);
    }
}
