package com.yunusseker.mvvmarchitecture.di;

import com.yunusseker.mvvmarchitecture.ui.login.LoginActivity;
import com.yunusseker.mvvmarchitecture.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by yunus.seker on 12.4.2018
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {ViewModelModule.class, FragmentModule.class})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = {ViewModelModule.class, FragmentModule.class})
    abstract LoginActivity loginActivity();
}
