package com.yunusseker.mvvmarchitecture.data.remote;

import android.arch.lifecycle.LiveData;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;

/**
 * Created by yunus.seker on 12.4.2018
 */

public interface RemoteDataSource {
    LiveData<PostResponse> getPostModel();

    LiveData<LoginResponse> login(String username, String password);
}
