package com.yunusseker.mvvmarchitecture.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.google.gson.Gson;
import com.yunusseker.mvvmarchitecture.BuildConfig;
import com.yunusseker.mvvmarchitecture.data.DataRepository;
import com.yunusseker.mvvmarchitecture.data.DataSource;
import com.yunusseker.mvvmarchitecture.data.local.LocalDataSource;
import com.yunusseker.mvvmarchitecture.data.remote.Api;
import com.yunusseker.mvvmarchitecture.data.remote.RemoteDataSource;
import com.yunusseker.mvvmarchitecture.utils.ErrorUtil;

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
    @LocalSouce
    DataSource localDataSource(SharedPreferences sharedPreferences,Gson gson) {
        return new LocalDataSource(sharedPreferences,gson);
    }

    @Provides
    @Singleton
    @RemoteSource
    DataSource remoteDataSource(Api api){
        return new RemoteDataSource(api);
    }


    @Provides
    @Singleton
    DataSource dataRepository(@LocalSouce DataSource localDataSource, @RemoteSource DataSource remoteDataSource){
        return new DataRepository(localDataSource,remoteDataSource);
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
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("YOUR_BASE_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();


    }

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    @Singleton
    Gson providesGson(){
        return new Gson();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context){
        return context.getSharedPreferences("com.yunusseker.mvvm",Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    ErrorUtil provideErrorUtil(Retrofit retrofit){
        return new ErrorUtil(retrofit);
    }

}
