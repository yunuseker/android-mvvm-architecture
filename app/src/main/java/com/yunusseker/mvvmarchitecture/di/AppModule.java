package com.yunusseker.mvvmarchitecture.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.BuildConfig;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostRepository;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostDataSource;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostLocalDataSource;
import com.yunusseker.mvvmarchitecture.data.remote.Api;
import com.yunusseker.mvvmarchitecture.util.Constants;
import com.yunusseker.mvvmarchitecture.util.ErrorUtil;
import com.yunusseker.mvvmarchitecture.util.schedulers.BaseSchedulerProvider;
import com.yunusseker.mvvmarchitecture.util.schedulers.SchedulerProvider;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yunus.seker on 12.4.2018
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    BaseSchedulerProvider provideScheduler() {
        return new SchedulerProvider();
    }

}
