package com.yunusseker.mvvmarchitecture.data.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class RemoteDataSourceImp implements RemoteDataSource {

    private Api api;

    @Inject
    public RemoteDataSourceImp(Api api) {
        this.api = api;
    }


    @Override
    public Single<PostResponse> getPostModel() {
        return api.getPosts();
    }


    @Override
    public Single<LoginResponse> login(String username, String password) {
        //TODO get result from api
        LoginResponse loginResponse=new LoginResponse(true,"Success");
        return Single.just(loginResponse);
    }
}
