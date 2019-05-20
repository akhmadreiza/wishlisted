package com.akhmadreiza.wishlisted.apis;

public class UserLoginResponse {
    private String accessToken;

    public UserLoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
