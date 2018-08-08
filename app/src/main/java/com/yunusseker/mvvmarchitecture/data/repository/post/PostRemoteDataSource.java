package com.yunusseker.mvvmarchitecture.data.repository.post;

import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.remote.Api;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PostRemoteDataSource implements  PostDataSource {

    private Api api;

    @Inject
    public PostRemoteDataSource(Api api) {
        this.api = api;
    }

    @Override
    public Observable<PostResponse> getPostModel() {
        return null;
    }
}
