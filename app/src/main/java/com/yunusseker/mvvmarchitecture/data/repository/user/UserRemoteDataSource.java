package com.yunusseker.mvvmarchitecture.data.repository.user;

import com.yunusseker.mvvmarchitecture.data.model.UserModel;

public class UserRemoteDataSource implements UserDataSource {
    @Override
    public UserModel getLoggedUser() {
        return null;
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {

    }
}
