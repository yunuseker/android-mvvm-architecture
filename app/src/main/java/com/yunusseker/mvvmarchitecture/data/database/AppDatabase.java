package com.yunusseker.mvvmarchitecture.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.yunusseker.mvvmarchitecture.data.model.UserModel;

@Database(entities = {UserModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

}
