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

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DatabaseModule.class,NetworkModule.class})
public class RepositoryModule {

    @Provides
    @Singleton
    @Named(DaggerNamedType.POST_LOCAL)
    PostDataSource provPostLocalData(SharedPreferences sharedPreferences, Gson gson, AppDatabase appDatabase) {
        return new PostLocalDataSource(sharedPreferences, gson,appDatabase);
    }

    @Provides
    @Singleton
    @Named(DaggerNamedType.POST_REMOTE)
    PostDataSource provPostRemoteData(Api api) {
        return new PostRemoteDataSource(api);
    }


    @Provides
    @Singleton
    @Named(DaggerNamedType.POST_REPOSITORY)
    PostDataSource provPostRepository(@Named(DaggerNamedType.POST_LOCAL) PostDataSource localDataSource,
                                      @Named(DaggerNamedType.POST_REMOTE) PostDataSource remoteDataSource) {
        return new PostRepository(localDataSource, remoteDataSource);
    }

}
