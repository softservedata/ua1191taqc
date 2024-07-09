package com.softserve.homework.edu08;

public class SignInData {
    private final String email;
    private final String password;
    private final String expectedUsername;
    private final String expectedErrorMessage;

    public SignInData(String email, String password, String expectedUsername, String expectedErrorMessage) {
        this.email = email;
        this.password = password;
        this.expectedUsername = expectedUsername;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedUsername() {
        return expectedUsername;
    }

    public String getExpectedErrorMessage() {
        return expectedErrorMessage;
    }
}
