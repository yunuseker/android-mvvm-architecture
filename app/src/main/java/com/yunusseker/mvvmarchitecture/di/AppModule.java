package com.yunusseker.mvvmarchitecture.di;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.yunusseker.mvvmarchitecture.BuildConfig;
import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.local.LocalDataSourceImp;
import com.yunusseker.mvvmarchitecture.data.remote.Api;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSourceImp;

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

@Module
public class AppModule {



    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    LocalDataSource localDataSource(Context context) {
        return new LocalDataSourceImp(context);
    }

    @Provides
    @Singleton
    RemoteDataSource remoteDataSource(Api api){
        return new RemoteDataSourceImp(api);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .header("Device-Type", "Android")
                            .header("Device-Model", Build.MODEL)
                            .header("Device-Version", String.valueOf(Build.VERSION.SDK_INT))
                            .header("Lang", Locale.getDefault().getLanguage())
                            .header("App-Version", BuildConfig.VERSION_NAME)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                })
                .build();
    }

    @Provides
    @Singleton
    Api provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("your_base_url")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(Api.class);
    }
}
