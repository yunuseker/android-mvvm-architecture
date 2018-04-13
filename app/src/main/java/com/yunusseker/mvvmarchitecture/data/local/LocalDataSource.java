package com.yunusseker.mvvmarchitecture.data.local;

import com.yunusseker.mvvmarchitecture.data.model.UserModel;

/**
 * Created by yunus.seker on 12.4.2018
 */

public interface LocalDataSource {

    UserModel getLoggedUser();

    void saveLoggedUser(UserModel userModel);
}
