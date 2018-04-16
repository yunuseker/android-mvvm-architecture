package com.yunusseker.mvvmarchitecture.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class MainViewModel extends BaseViewModel {

    private final MutableLiveData<Throwable> error = new MutableLiveData<>();

    public MainViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }


    LiveData<PostResponse> getLiveData() {
        final MutableLiveData<PostResponse> livedata = new MutableLiveData<>();

        getCompositeDisposable().add(getRemoteDataSource().getPostModel()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(livedata::setValue, error::setValue)
        );

        return livedata;
    }

    LiveData<Throwable> getError() {
        return error;
    }

}
