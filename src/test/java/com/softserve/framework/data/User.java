package com.softserve.framework.data;

import java.util.ArrayList;
import java.util.List;

public class User { // user from UI
    private String email;
    private String password;
    private String username;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public static User getByList(List<String> row) {
        return new User(row.get(0), row.get(1), row.get(2));
    }

    public static List<User> getByLists(List<List<String>> rows) {
        //System.out.println("Start List<User> getByLists rows = " + rows);
        List<User> users = new ArrayList<>();
        if (!rows.get(0).get(0).contains("@")) {
            rows.remove(0);
        }
        for (List<String> row : rows) {
            users.add(getByList(row));
        }
        //System.out.println("Done List<User> getByLists users = " + users);
        return users;
    }
}
