package com.softserve.edu08rest;

public class GreencityLoginEntity {

    private Integer userId;
    private String accessToken;
    private String refreshToken;
    private String name ;
    private Boolean ownRegistrations;

    public GreencityLoginEntity(Integer userId, String accessToken, String refreshToken, String name, Boolean ownRegistrations) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.name = name;
        this.ownRegistrations = ownRegistrations;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getName() {
        return name;
    }

    public Boolean getOwnRegistrations() {
        return ownRegistrations;
    }

    @Override
    public String toString() {
        return "GreencityLoginEntity{" +
                "userId=" + userId +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", name='" + name + '\'' +
                ", ownRegistrations=" + ownRegistrations +
                '}';
    }
}
