package com.yunusseker.mvvmarchitecture.data.model;

import com.yunusseker.mvvmarchitecture.utils.ErrorUtil;

import io.reactivex.internal.util.ErrorMode;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginResponse {

    private boolean status;
    private String token;

    private ErrorModel errorModel;

    public LoginResponse(boolean status, String token) {
        this.status = status;
        this.token = token;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

    public void setErrorModel(ErrorModel errorModel) {
        this.errorModel = errorModel;
    }
}
