package com.yunusseker.mvvmarchitecture.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.data.DataSource;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LocalDataSource implements DataSource {

    private static final String USER = "user";
    private static final String PROFILE = "profile";
    private SharedPreferences sharedPreferences;
    private Gson gson;


    @Inject
    public LocalDataSource(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences=sharedPreferences;
        this.gson =gson;
    }

    @Override
    public Single<PostResponse> getPostModel() {
        return null;
    }

    @Override
    public Single<LoginResponse> login(String username, String password,String apiKey, String pushToken) {
        return null;
    }

    @Override
    public UserModel getLoggedUser() {
            return gson.fromJson(sharedPreferences.getString(USER, null), UserModel.class);
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {
            sharedPreferences.edit().putString(USER,gson.toJson(userModel)).apply();
    }
}
