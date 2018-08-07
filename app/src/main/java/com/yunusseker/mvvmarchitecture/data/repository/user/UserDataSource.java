package com.yunusseker.mvvmarchitecture.data.repository.user;

import com.yunusseker.mvvmarchitecture.data.model.UserModel;

public interface UserDataSource {

    UserModel getLoggedUser();

    void saveLoggedUser(UserModel userModel);
}
