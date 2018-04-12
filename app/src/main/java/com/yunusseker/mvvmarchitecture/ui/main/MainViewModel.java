package com.yunusseker.mvvmarchitecture.ui.main;

import android.arch.lifecycle.LiveData;

import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class MainViewModel extends BaseViewModel {

    public MainViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource,localDataSource);
    }

    public LiveData<PostResponse> getLiveData() {
        return getRemoteDataSource().getPostModel();
    }
}
