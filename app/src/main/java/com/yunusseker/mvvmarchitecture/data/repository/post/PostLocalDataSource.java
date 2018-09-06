package com.yunusseker.mvvmarchitecture.data.repository.post;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.base.BaseLocalRepository;
import com.yunusseker.mvvmarchitecture.data.database.AppDatabase;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class PostLocalDataSource extends BaseLocalRepository implements PostDataSource {

    private static final String POST = "post";

    @Inject
    public PostLocalDataSource(SharedPreferences sharedPreferences, Gson gson, AppDatabase appDatabase){
        super(sharedPreferences,gson,appDatabase);
    }

    @Override
    public Observable<PostResponse> getPostModel() {
        return null;
    }
}
