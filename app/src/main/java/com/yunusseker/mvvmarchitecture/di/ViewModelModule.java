package com.yunusseker.mvvmarchitecture.di;

import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;
import com.yunusseker.mvvmarchitecture.ui.login.LoginViewModel;
import com.yunusseker.mvvmarchitecture.ui.main.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yunus.seker on 12.4.2018
 */

@Module
public class ViewModelModule {

    @Provides
    MainViewModel provideMainViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource){
        return new MainViewModel(remoteDataSource,localDataSource);
    }

    @Provides
    LoginViewModel provideLoginViewModel(RemoteDataSource remoteDataSource, LocalDataSource localDataSource){
        return new LoginViewModel(remoteDataSource,localDataSource);
    }
}
