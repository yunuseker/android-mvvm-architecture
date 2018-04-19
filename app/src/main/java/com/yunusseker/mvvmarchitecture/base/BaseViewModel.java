package com.yunusseker.mvvmarchitecture.base;

import android.arch.lifecycle.ViewModel;

import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yunus.seker on 12.4.2018
 */

public abstract class BaseViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable ;
    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    public BaseViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        compositeDisposable=new CompositeDisposable();
    }

    protected RemoteDataSource getRemoteDataSource() {
        return remoteDataSource;
    }

    protected LocalDataSource getLocalDataSource() {
        return localDataSource;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
        super.onCleared();
    }
}
