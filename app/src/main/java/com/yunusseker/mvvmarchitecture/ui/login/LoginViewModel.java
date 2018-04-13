package com.yunusseker.mvvmarchitecture.ui.login;

import android.arch.lifecycle.LiveData;

import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginViewModel extends BaseViewModel {


    public LoginViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }

    public LiveData<LoginResponse> login(String username,String password){
        return getRemoteDataSource().login(username,password);
    }
}
