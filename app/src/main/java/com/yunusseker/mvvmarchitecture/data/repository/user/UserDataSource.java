package com.yunusseker.mvvmarchitecture.data.repository.user;

import com.yunusseker.mvvmarchitecture.data.model.DataHolder;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import io.reactivex.Observable;

public interface UserDataSource {

    Observable<DataHolder<LoginResponse>> login();

    Observable<UserModel> getLoggedUser();

    void saveLoggedUser(UserModel userModel);
}
