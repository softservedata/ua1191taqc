package com.softserve.edu08set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class ProgTreeSet {

    public static void main(String[] args) {
        //Set<String> set = new TreeSet<>();
        //Set<String> set = new HashSet<>();
        //Set<String> set = new LinkedHashSet<>();
        //
//        Set<String> set = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return -o1.compareTo(o2);
//            }
//        });
        //
        Set<String> set = new TreeSet<>((o1, o2) -> -o1.compareTo(o2));
        //
        set.add("10");
        set.add("05");
        set.add("08");
        set.add("03");
        set.add("12");
        for (String s : set) {
            System.out.println(s);
        }
    }

}