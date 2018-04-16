package com.yunusseker.mvvmarchitecture.ui.login;

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

public class LoginViewModel extends BaseViewModel {
    private final MutableLiveData<Throwable> error = new MutableLiveData<>();


    public LoginViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }

    public LiveData<LoginResponse> login(String username,String password){
        final MutableLiveData<LoginResponse> loginMutableLiveData = new MutableLiveData<>();

        getCompositeDisposable().add(getRemoteDataSource().login(username,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(loginResponse -> {
                    if(loginResponse.isStatus()){

                    }

                }, error::setValue));

        return loginMutableLiveData;
    }

}
