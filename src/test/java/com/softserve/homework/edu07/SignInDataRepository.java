package com.softserve.homework.edu07;

import java.util.Arrays;
import java.util.List;

public class SignInDataRepository {
    public static List<SignInData> validSignInData() {
        return List.of(
                new SignInData("tyv09754@zslsz.com", "Qwerty_1", "QwertyY", null)
        );
    }

    public static List<SignInData> invalidSignInData() {
        return Arrays.asList(
                new SignInData("invalidemailgreencity.com", "somepassword", null, "Please check if the email is written correctly"),
                new SignInData("@missingusername.com", "short", null, "Please check if the email is written correctly"),
                new SignInData("username@.missingdomain", "alllowercase", null, "Please check if the email is written correctly"),
                new SignInData("username@domain..com", "ALLUPPERCASE", null, "Please check if the email is written correctly"),
                new SignInData("username@domain,com", "12345678", null, "Please check if the email is written correctly"),
                new SignInData("username@domain com", "noSpecialChars1", null, "Please check if the email is written correctly"),
                new SignInData("username@domain.c", "!@#$%^&*", null, "Bad email or password"),
                new SignInData("username@domain.corporate", "password", null, "Bad email or password"),
                new SignInData("username@domain..com", "password1", null, "Please check if the email is written correctly"),
                new SignInData("username@domain.com.", "Password123!Password123!Password123!Password123!", null, "Please check if the email is written correctly"),
                new SignInData("plainaddressm", " ", null, "Please check if the email is written correctly")
        );
    }
}
