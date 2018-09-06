package com.yunusseker.mvvmarchitecture.data.repository.user;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.base.BaseLocalRepository;
import com.yunusseker.mvvmarchitecture.data.database.AppDatabase;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

public class UserLocalDataSource extends BaseLocalRepository implements UserDataSource {

    private static final String USER = "user";

    @Inject
    public UserLocalDataSource(SharedPreferences sharedPreferences, Gson gson, AppDatabase appDatabase) {
        super(sharedPreferences,gson,appDatabase);
    }

    @Override
    public UserModel getLoggedUser() {
        return getGson().fromJson(getSharedPreferences().getString(USER, null), UserModel.class);
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {
        getSharedPreferences().edit().putString(USER,getGson().toJson(userModel)).apply();
    }
}
