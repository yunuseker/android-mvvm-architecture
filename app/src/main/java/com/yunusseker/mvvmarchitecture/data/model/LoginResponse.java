package com.yunusseker.mvvmarchitecture.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginResponse {

    @SerializedName("is_success")
    private boolean isSuccess;
    @SerializedName("user_model")
    private UserModel userModel;
    @SerializedName("error_model")
    private ErrorModel errorModel;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

    public void setErrorModel(ErrorModel errorModel) {
        this.errorModel = errorModel;
    }
}
