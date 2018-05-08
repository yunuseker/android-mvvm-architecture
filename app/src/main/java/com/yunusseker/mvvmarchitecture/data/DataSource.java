package com.yunusseker.mvvmarchitecture.data;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import io.reactivex.Single;

public interface DataSource {

    Single<PostResponse> getPostModel();

    Single<LoginResponse>login(String username, String password);

    UserModel getLoggedUser();

    void saveLoggedUser(UserModel userModel);
}
