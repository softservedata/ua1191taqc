package com.softserve.homework.edu09;

import com.google.gson.Gson;
import okhttp3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GreencityLoginEntity {
    private Integer userId;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String toString() {
        return "GreencityLoginEntity{" +
                "userId=" + userId +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}

public class GreencityTest {

    private static final String BASE_URL = "https://greencity.greencity.cx.ua";
    private static final String USER_URL = "https://greencity-user.greencity.cx.ua";
    private static final Gson gson = new Gson();
    private static final OkHttpClient client = new OkHttpClient();
    private static String accessToken;

    @BeforeAll
    public static void setUp() throws Exception {
        String jsonBody = "{ \"email\":\"tyv09754@zslsz.com\", \"password\":\"Qwerty_1\" }";
        RequestBody requestBody = RequestBody.create(jsonBody, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(USER_URL + "/ownSecurity/signIn")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        String resultTextJson = response.body().string();
        GreencityLoginEntity loginEntity = gson.fromJson(resultTextJson, GreencityLoginEntity.class);
        accessToken = loginEntity.getAccessToken();
        System.out.println("Access Token: " + accessToken);
    }

    @Test
    public void getAllActiveComments() throws Exception {
        // Prepare the request
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/econews?title=Test&page=0&size=5")
                .toString();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + accessToken)
                .get()
                .build();

        // Execute the request
        Response response = client.newCall(request).execute();
        String resultTextJson = response.body().string();

        // Output the results
        System.out.println("getAllActiveComments() resultJson = " + resultTextJson);

        // Assertions
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertNotNull(resultTextJson);
    }
}
