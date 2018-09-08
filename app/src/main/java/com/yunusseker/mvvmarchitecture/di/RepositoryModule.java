package com.yunusseker.mvvmarchitecture.di;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.data.database.AppDatabase;
import com.yunusseker.mvvmarchitecture.data.defination.DaggerNamedType;
import com.yunusseker.mvvmarchitecture.data.remote.Api;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostDataSource;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostLocalDataSource;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostRemoteDataSource;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostRepository;
import com.yunusseker.mvvmarchitecture.data.repository.user.UserDataSource;
import com.yunusseker.mvvmarchitecture.data.repository.user.UserLocalDataSource;
import com.yunusseker.mvvmarchitecture.data.repository.user.UserRemoteDataSource;
import com.yunusseker.mvvmarchitecture.data.repository.user.UserRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DatabaseModule.class,NetworkModule.class})
public class RepositoryModule {

    @Provides
    @Singleton
    @Named(DaggerNamedType.POST_LOCAL)
    public PostDataSource provPostLocalData(SharedPreferences sharedPreferences, Gson gson, AppDatabase appDatabase) {
        return new PostLocalDataSource(sharedPreferences, gson,appDatabase);
    }

    @Provides
    @Singleton
    @Named(DaggerNamedType.POST_REMOTE)
    public PostDataSource provPostRemoteData(Api api) {
        return new PostRemoteDataSource(api);
    }


    @Provides
    @Singleton
    @Named(DaggerNamedType.POST_REPOSITORY)
    public PostDataSource provPostRepository(@Named(DaggerNamedType.POST_LOCAL) PostDataSource localDataSource,
                                      @Named(DaggerNamedType.POST_REMOTE) PostDataSource remoteDataSource) {
        return new PostRepository(localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    @Named(DaggerNamedType.USER_LOCAL)
    public UserDataSource provUserLocalData(SharedPreferences sharedPreferences, Gson gson, AppDatabase appDatabase) {
        return new UserLocalDataSource(sharedPreferences, gson,appDatabase);
    }

    @Provides
    @Singleton
    @Named(DaggerNamedType.USER_REMOTE)
    public UserDataSource provUserRemoteData(Api api) {
        return new UserRemoteDataSource(api);
    }


    @Provides
    @Singleton
    @Named(DaggerNamedType.USER_REPOSITORY)
    public UserDataSource provUserRepository(@Named(DaggerNamedType.USER_LOCAL) UserDataSource localDataSource,
                                      @Named(DaggerNamedType.USER_REMOTE) UserDataSource remoteDataSource) {
        return new UserRepository(localDataSource, remoteDataSource);
    }

}
