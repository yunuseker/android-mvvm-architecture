package com.yunusseker.mvvmarchitecture.data.model;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginResponse {

    private String success;

    public LoginResponse(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
