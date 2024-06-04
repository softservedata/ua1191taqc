package com.softserve.edu03oop;

import com.softserve.edu03oop.Student;

public class AppStud {
    public static void main(String[] args) {
        Student st = new Student("Petro");
        //st.name = "Ira";
        st.setName(null);
        //st.equals()
        //
        Person p1 = new Person();
        Person p2 = new Person("Petro");
        Person p3 = new Person("Ira", 18);
        Person p4 = new Person();
        System.out.println("p1 = " + p1.toString()); // p1.toString()
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        System.out.println("count = " + Person.getCount());
        //
        int i1 = 4;
        int i2 = 4;
        System.out.println("(i1 == i2) = " + (i1 == i2)); // true
        System.out.println("(p1 == p4) = " + (p1 == p4)); // false
        System.out.println("p1.equals(p4) = " + p1.equals(p4));
        //
        System.out.printf("p1.hashCode() = %h \n", p1.hashCode());
        System.out.printf("p2.hashCode() = %h \n", p2.hashCode());
        System.out.printf("p3.hashCode() = %h \n", p3.hashCode());
        System.out.printf("p4.hashCode() = %h \n", p4.hashCode());
    }
}
