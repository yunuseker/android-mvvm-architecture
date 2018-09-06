package com.yunusseker.mvvmarchitecture.util;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import com.yunusseker.mvvmarchitecture.data.model.ErrorModel;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by yunus.seker on 16.04.2018
 */

public class ErrorUtil {
    private final Retrofit retrofit;

    public ErrorUtil(Retrofit retrofit) {
        this.retrofit = retrofit;
    }


    //TODO add localization with context end improve first case
    private Throwable handleError(Throwable error, Context context) {
        if (error instanceof HttpException) {
            // TODO Http error with retrofit
            return new Throwable("HttpException");
        } else if (error instanceof UnknownHostException) {
            return new Throwable("UnknownHostException");
        }else if (error instanceof SocketTimeoutException) {
            return new Throwable("SocketTimeoutException");
        } else {
            return new Throwable("UnknownError");
        }
    }


    public ErrorModel parseError(Response<?> response) {
        ResponseBody responseBody = response.errorBody();
        Converter<ResponseBody, ErrorModel> converter =
                retrofit.responseBodyConverter(ErrorModel.class, new Annotation[0]);
        ErrorModel error;
        try {
            error = converter.convert(responseBody);
        } catch (IOException e) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorMessage("");
            errorModel.setErrorCode("");
            return errorModel;
        }
        return error;
    }
}
