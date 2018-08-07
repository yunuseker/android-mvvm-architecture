package com.yunusseker.mvvmarchitecture.data.repository.post;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface PostDataSource {

    Observable<PostResponse> getPostModel();

}
