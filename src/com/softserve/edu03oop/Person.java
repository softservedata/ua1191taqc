package com.softserve.edu03oop;

import java.util.Objects;

public class Person {

    private String name;
    private int age;

    private static int count = 0;

    public Person() {
        name = "ivan";
        age = 1;
        count++;
    }

    public Person(String name) {
        //this();
        this.name = name;
        age = 20;
        count++;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
