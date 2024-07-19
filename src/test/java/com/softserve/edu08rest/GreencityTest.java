package com.softserve.edu08rest;

import com.google.gson.Gson;
import okhttp3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class GreencityTest {

    private Gson gson = new Gson();
    private OkHttpClient client = new OkHttpClient();
    private Request request;
    private Response response;
    private RequestBody requestBody;
    private String resultTextJson;
    private static String accessToken;
    private static GreencityLoginEntity greencityLoginEntity;

    //private static GreencityHabitsEntity greencityHabitsEntity;

    @Test
    //@Order(1)
    public void checkLogin() throws Exception {
        // Login
        String jsonBody =  new StringBuilder()
                .append("{")
                .append("\"email\":\"tyv09754@zslsz.com\",")
                .append("\"password\":\"Qwerty_1\"")
                .append("}").toString();
        //
        requestBody = RequestBody.create(jsonBody,
                MediaType.parse("application/json; charset=utf-8"));
        request = new Request.Builder()
                .url("https://greencity-user.greencity.cx.ua/ownSecurity/signIn")
                //.addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();
        response = client.newCall(request).execute();
        resultTextJson = response.body().string();
        greencityLoginEntity = gson.fromJson(resultTextJson, GreencityLoginEntity.class);
        accessToken = greencityLoginEntity.getAccessToken();
        //
        System.out.println("checkLogin() resultJson = " + resultTextJson);
        System.out.println("checkLogin() accessToken = " + accessToken);
        //
        Assertions.assertTrue(response.isSuccessful());
    }

    /*
    @Test
    @Order(2)
    public void checkHabits() throws Exception {
        //accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0eXYwOTc1NEB6c2xzei5jb20iLCJyb2xlIjpbIlJPTEVfVVNFUiJdLCJleHAiOjE3MTE2NTU0ODMsImlhdCI6MTcxMTY0ODI4M30.jUWlC1AHoFaqjaOH_sNRHZlG180BMpkaEhC5qjx4yOo";
        //accessToken = greencityLoginEntity.getAccessToken();
        //System.out.println("checkHabits() accessToken = " + accessToken);
        // Get All Habits
        request = new Request.Builder()
                .url("https://greencity.greencity.social/habit?page=0&size=5")
                .addHeader("Accept", "* / *") // TODO
                .addHeader("Authorization", "Bearer " + accessToken)
                .get()
                .build();
        response = client.newCall(request).execute();
        resultTextJson = response.body().string();
        greencityHabitsEntity = gson.fromJson(resultTextJson, GreencityHabitsEntity.class);
        //
        System.out.println("checkHabits() resultJson = " + resultTextJson);
        System.out.println("checkHabits() greencityHabitsEntity = " + greencityHabitsEntity);
        //
        Assertions.assertTrue(response.isSuccessful());
    }
    */

}
