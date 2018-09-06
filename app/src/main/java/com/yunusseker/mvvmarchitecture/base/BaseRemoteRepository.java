package com.yunusseker.mvvmarchitecture.base;

import com.yunusseker.mvvmarchitecture.data.model.DataHolder;
import com.yunusseker.mvvmarchitecture.data.remote.Api;

import io.reactivex.Observable;


public class BaseRemoteRepository {

    private Api api;

    public BaseRemoteRepository(Api api) {
        this.api = api;
    }

    protected <T>Observable<DataHolder<T>> sendRequest(Observable<T> call){
        return call
                .map(DataHolder::new);
    }

    protected Api getApi() {
        return api;
    }
}
