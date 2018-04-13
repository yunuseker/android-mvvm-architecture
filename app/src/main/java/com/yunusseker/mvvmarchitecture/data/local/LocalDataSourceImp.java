package com.yunusseker.mvvmarchitecture.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LocalDataSourceImp implements LocalDataSource {

    private static final String USER = "user";
    private static final String PROFILE = "profile";
    private SharedPreferences sharedPreferences;
    private Gson gson;


    @Inject
    public LocalDataSourceImp(SharedPreferences sharedPreferences,Gson gson) {
        this.sharedPreferences=sharedPreferences;
        this.gson =gson;
    }

    @Override
    public UserModel getLoggedUser() {
        if (sharedPreferences.getString(USER, null) == null) {
            return new UserModel("", "");
        } else {
            return gson.fromJson(sharedPreferences.getString(USER, null), UserModel.class);
        }
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {
            sharedPreferences.edit().putString(USER,gson.toJson(userModel)).apply();
    }
}
