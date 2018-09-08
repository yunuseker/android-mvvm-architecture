package com.yunusseker.mvvmarchitecture.di;

import android.app.Application;
import android.content.Context;

import com.yunusseker.mvvmarchitecture.util.schedulers.BaseSchedulerProvider;
import com.yunusseker.mvvmarchitecture.util.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
