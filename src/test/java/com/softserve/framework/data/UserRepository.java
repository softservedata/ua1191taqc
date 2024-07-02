package com.softserve.framework.data;

import com.softserve.framework.tools.CSVReader;

import java.util.ArrayList;
import java.util.List;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getDefault() {
        return getValidUserQwertyY();
    }

    public static User getValidUserQwertyY() {
        return new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY");
        //return new User("tyv09754@zslsz.com", System.getenv().get("USER_QWERTY"), "QwertyY");
    }

    public static User getValidUserMyName() {
        return new User("jahovi6261@hupoi.com", "Super_qwerty_1", "MyName");
    }

    public static List<User> fromList() {
        List<User> lst = new ArrayList<>();
        lst.add(getValidUserQwertyY());
        lst.add(getValidUserMyName());
        return lst;
    }

    public static List<User> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public static List<User> fromCsv() {
        return fromCsv("users.csv");
    }

    /*
    public List<User> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }

    public List<User> fromExcel() {
        return fromExcel("users.xlsx");
    }
    */
}
