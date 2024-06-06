package com.softserve.edu04inh;

public class B extends A {

    public int j = 2;

    public B() {
        super(123);
        System.out.println("Constructor B() done");
    }

    @Override
    public void m1() {
        System.out.println("class B");
    }
}
