package com.softserve.edu04inh;

public class A implements IA {
    private int i = 147;

//    public A() {
//        System.out.println("Constructor A() done");
//    }

    public A(int i) {
        //this.i = i;
        System.out.println("Constructor A(int i) done");
    }

    public int getI() {
        return i;
    }

    public void m1() {
        System.out.println("class A");
    }
}
