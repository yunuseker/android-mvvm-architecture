package com.yunusseker.mvvmarchitecture.data.repository.user;

import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

public class UserRepository implements UserDataSource {

    private UserDataSource localDataSource;
    private UserDataSource remoteDataSource;

    @Inject
    public UserRepository(UserDataSource localDataSource, UserDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public UserModel getLoggedUser() {
        return null;
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {

    }
}
