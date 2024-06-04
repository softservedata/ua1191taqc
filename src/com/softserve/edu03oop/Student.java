package com.softserve.edu03oop;

import java.util.List;

/**
 * <h1>Super <font color='red'>Class</font></h1>
 */
public class Student {
//public class Student extends Object { // By default

    private String name;

    public Student() {
        name = "ivan";
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() > 0) {
        //if (name.length() > 0 && name != null) { // Error
            this.name = name;
        }
    }

    public void check() {
        List<String> lst;
    }
}
