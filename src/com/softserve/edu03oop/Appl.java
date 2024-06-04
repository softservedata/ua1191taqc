package com.softserve.edu03oop;

public class Appl {
    private int i = 0;

    public Appl() { // overload
        i = 0;
    }

    public Appl(int i) { // overload
        this.i = i;
    }

    public void hello() {
        System.out.println("Hello, i = " + i);
    }

    public static void m1() {
        System.out.println("static method");
    }
    public static void main(String[] args) {
        Appl a1 = new Appl();
        a1.i = 123;
        a1.hello();
        //
        Appl a2 = new Appl();
        a2.i = 345;
        a2.hello();
        //
        // a1.main(null);
        // a1.m1();
        // Appl.m1();
        m1();
        a1.hello();
        a2.hello();
        //
        // Helper h = new Helper(); // Compile Error
    }
}
