package com.yunusseker.mvvmarchitecture.data.model;

import com.yunusseker.mvvmarchitecture.data.defination.NetworkErrorType;

/**
 * Created by yunus.seker on 16.04.2018
 */

public class ErrorModel {

    @NetworkErrorType
    private int errorCode;

    private String errorMessage;

    public ErrorModel(@NetworkErrorType int errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorModel(@NetworkErrorType int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
