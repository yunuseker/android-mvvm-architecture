package com.yunusseker.mvvmarchitecture.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.yunusseker.mvvmarchitecture.App;
import com.yunusseker.mvvmarchitecture.data.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = AppModule.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(Context context) {
        return context.getSharedPreferences("com.yunusseker.mvvm", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public AppDatabase providesAppDatabase(Context context){
        return Room.databaseBuilder(context,AppDatabase.class,"com.yunusseker.mvvm").build();
    }
}
