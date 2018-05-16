package com.yunusseker.mvvmarchitecture.data;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;

public class DataRepository implements DataSource {

    private DataSource localDataSouce;
    private DataSource remoteDataSource;

    @Inject
    public DataRepository(DataSource localDataSouce,DataSource remoteDataSource) {
        this.remoteDataSource=remoteDataSource;
        this.localDataSouce=localDataSouce;
    }

    @Override
    public Single<PostResponse> getPostModel() {
        return remoteDataSource.getPostModel();
    }

    @Override
    public Single<LoginResponse> login(String username, String password,String apiKey, String pushToken) {
        return remoteDataSource.login(username,password,apiKey,pushToken);
    }

    @Override
    public UserModel getLoggedUser() {
        return localDataSouce.getLoggedUser();
    }

    @Override
    public void saveLoggedUser(UserModel userModel)
    {
       localDataSouce.saveLoggedUser(userModel);
    }
}
