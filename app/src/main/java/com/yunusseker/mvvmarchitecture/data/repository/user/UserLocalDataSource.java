package com.yunusseker.mvvmarchitecture.data.repository.user;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

public class UserLocalDataSource implements UserDataSource {

    private static final String USER = "user";
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Inject
    public UserLocalDataSource(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences=sharedPreferences;
        this.gson =gson;
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
