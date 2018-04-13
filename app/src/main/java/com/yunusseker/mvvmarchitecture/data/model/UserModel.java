package com.yunusseker.mvvmarchitecture.data.model;

/**
 * Created by yunus.seker on 13.4.2018
 */

public class UserModel {
    private String username;
    private String token;

    public UserModel() {
    }

    public UserModel(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
