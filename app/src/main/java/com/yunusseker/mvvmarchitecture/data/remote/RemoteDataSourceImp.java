package com.yunusseker.mvvmarchitecture.data.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;

import javax.inject.Inject;

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
    public LiveData<PostResponse> getPostModel() {
        final MutableLiveData<PostResponse> postResponseMutableLiveData = new MutableLiveData<>();

        api.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(postResponseMutableLiveData::setValue, throwable -> {
                });


        return postResponseMutableLiveData;
    }

    @Override
    public LiveData<LoginResponse> login(String username, String password) {
        final MutableLiveData<LoginResponse> loginMutableLiveData = new MutableLiveData<>();
        loginMutableLiveData.setValue(new LoginResponse("Success"));
        return loginMutableLiveData;
    }
}
