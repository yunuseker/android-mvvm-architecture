package com.yunusseker.mvvmarchitecture.data.remote;

import android.arch.lifecycle.LiveData;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;

import io.reactivex.Single;

/**
 * Created by yunus.seker on 12.4.2018
 */

public interface RemoteDataSource {
    Single<PostResponse> getPostModel();

    Single<LoginResponse>login(String username, String password);

}
