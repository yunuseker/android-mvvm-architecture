package com.yunusseker.mvvmarchitecture.data.repository.post;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import javax.inject.Inject;

import io.reactivex.Single;

public class PostRepository implements PostDataSource {

    private PostDataSource localDataSouce;
    private PostDataSource remoteDataSource;

    @Inject
    public PostRepository(PostDataSource localDataSouce, PostDataSource remoteDataSource) {
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
