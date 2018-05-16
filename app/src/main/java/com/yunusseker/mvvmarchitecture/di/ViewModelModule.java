package com.yunusseker.mvvmarchitecture.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.yunusseker.mvvmarchitecture.util.ViewModelFactory;
import com.yunusseker.mvvmarchitecture.ui.login.LoginViewModel;
import com.yunusseker.mvvmarchitecture.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by yunus.seker on 12.4.2018
 */

@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindsMovieListViewModel(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract  ViewModel bindsMovieDetailViewModel(LoginViewModel loginViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);

}
