package com.yunusseker.mvvmarchitecture.base;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.data.database.AppDatabase;

public class BaseLocalRepository {

    private SharedPreferences sharedPreferences;
    private Gson gson;
    private AppDatabase appDatabase;

    public BaseLocalRepository(SharedPreferences sharedPreferences, Gson gson, AppDatabase appDatabase) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
        this.appDatabase = appDatabase;
    }


    protected AppDatabase getAppDatabase() {
        return appDatabase;
    }

    protected Gson getGson() {
        return gson;
    }

    protected SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
