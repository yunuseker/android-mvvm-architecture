package com.yunusseker.mvvmarchitecture.data.repository.post;

import com.yunusseker.mvvmarchitecture.data.model.PostResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PostRepository implements PostDataSource {

    private PostDataSource localDataSouce;
    private PostDataSource remoteDataSource;

    @Inject
    public PostRepository(PostDataSource localDataSouce, PostDataSource remoteDataSource) {
        this.remoteDataSource=remoteDataSource;
        this.localDataSouce=localDataSouce;
    }

    @Override
    public Observable<PostResponse> getPostModel() {
        return Observable.concat(
                localDataSouce.getPostModel(),
                remoteDataSource.getPostModel());
    }
}
