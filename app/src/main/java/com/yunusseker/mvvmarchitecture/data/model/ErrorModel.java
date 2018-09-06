package com.yunusseker.mvvmarchitecture.data.model;

/**
 * Created by yunus.seker on 16.04.2018
 */

public class ErrorModel {

    private String errorCode;

    private String errorMessage;

    public ErrorModel() {
    }

    public ErrorModel(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
