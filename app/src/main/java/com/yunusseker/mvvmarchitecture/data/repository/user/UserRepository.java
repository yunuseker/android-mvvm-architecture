package com.yunusseker.mvvmarchitecture.data.repository.user;

import com.yunusseker.mvvmarchitecture.data.model.DataHolder;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UserRepository implements UserDataSource {

    private UserDataSource localDataSource;
    private UserDataSource remoteDataSource;

    @Inject
    public UserRepository(UserDataSource localDataSource, UserDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<DataHolder<LoginResponse>> login() {
        return remoteDataSource.login();
    }

    @Override
    public Observable<UserModel> getLoggedUser() {
        return localDataSource.getLoggedUser();
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {
        localDataSource.saveLoggedUser(userModel);
    }
}
