package com.yunusseker.mvvmarchitecture.base;

import android.content.Context;

import com.yunusseker.mvvmarchitecture.data.defination.NetworkErrorType;
import com.yunusseker.mvvmarchitecture.data.model.DataHolder;
import com.yunusseker.mvvmarchitecture.data.model.ErrorModel;
import com.yunusseker.mvvmarchitecture.data.remote.Api;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;


public class BaseRemoteRepository {

    private Api api;

    public BaseRemoteRepository(Api api) {
        this.api = api;
    }

    protected <T>Observable<DataHolder<T>> sendRequest(Observable<T> call){
        return call
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map(DataHolder::new);
    }

    protected Api getApi() {
        return api;
    }

    private ErrorModel handleError(Throwable error) {
        if (error instanceof HttpException) {
            return new ErrorModel(NetworkErrorType.HTTP_EXCEPTION);
        } else if (error instanceof UnknownHostException) {
            return new ErrorModel(NetworkErrorType.UNKNOW_HOST_EXCEPTION);
        }else if (error instanceof SocketTimeoutException) {
            return new ErrorModel(NetworkErrorType.SOCKET_TIMEOUT_EXCEPTION);
        } else {
            return new ErrorModel(NetworkErrorType.UNKNOWN_ERROR);
        }
    }

}
