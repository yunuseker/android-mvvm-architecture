package com.yunusseker.mvvmarchitecture.data.repository.post;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class PostLocalDataSource implements PostDataSource {

    private static final String POST = "post";
    private SharedPreferences sharedPreferences;
    private Gson gson;


    @Inject
    public PostLocalDataSource(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences=sharedPreferences;
        this.gson =gson;
    }

    @Override
    public Observable<PostResponse> getPostModel() {
        return null;
    }
}
