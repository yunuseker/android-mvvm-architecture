package com.yunusseker.mvvmarchitecture.data.repository.user;

import com.yunusseker.mvvmarchitecture.base.BaseRemoteRepository;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;
import com.yunusseker.mvvmarchitecture.data.remote.Api;

import javax.inject.Inject;

public class UserRemoteDataSource extends BaseRemoteRepository implements UserDataSource {

    @Inject
    public UserRemoteDataSource(Api api) {
        super(api);
    }

    @Override
    public UserModel getLoggedUser() {
        return null;
    }

    @Override
    public void saveLoggedUser(UserModel userModel) {

    }
}
