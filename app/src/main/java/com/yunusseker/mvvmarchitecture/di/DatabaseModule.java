package com.yunusseker.mvvmarchitecture.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.yunusseker.mvvmarchitecture.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = AppModule.class)
public class DatabaseModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context) {
        return context.getSharedPreferences("com.yunusseker.mvvm", Context.MODE_PRIVATE);
    }
}
