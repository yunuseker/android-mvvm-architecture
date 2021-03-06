package com.yunusseker.mvvmarchitecture.data.remote;

import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yunus.seker on 12.4.2018
 */

public interface Api {

    @POST("feed.php")
    Observable<PostResponse> getPosts(

    );


    @POST("5afc3e7a31000091007c5d8f")
    Observable<LoginResponse> login(
            @Query("username") String username,
            @Query("password") String password,
            @Query("api_key") String apiKey
    );
}
