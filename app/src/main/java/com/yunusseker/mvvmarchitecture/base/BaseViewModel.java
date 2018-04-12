package com.yunusseker.mvvmarchitecture.base;

import android.arch.lifecycle.ViewModel;

import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;

/**
 * Created by yunus.seker on 12.4.2018
 */

public abstract class BaseViewModel extends ViewModel {

    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    public BaseViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    protected RemoteDataSource getRemoteDataSource() {
        return remoteDataSource;
    }

    protected LocalDataSource getLocalDataSource() {
        return localDataSource;
    }


}
