package com.yunusseker.mvvmarchitecture.data.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.yunusseker.mvvmarchitecture.data.DataSource;
import com.yunusseker.mvvmarchitecture.data.model.ErrorModel;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class RemoteDataSource implements DataSource {

    private Api api;

    @Inject
    public RemoteDataSource(Api api) {
        this.api = api;
    }


    @Override
    public Single<PostResponse> getPostModel() {
        return api.getPosts();
    }


    @Override
    public Single<LoginResponse> login(String username, String password,String apiKey, String pushToken) {
        return api.login(username,username,apiKey,pushToken);
    }

    @Override
    public UserModel getLoggedUser() {
        return null;
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {

    }
}
