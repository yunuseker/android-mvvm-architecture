package com.yunusseker.mvvmarchitecture.di;

import com.yunusseker.mvvmarchitecture.ui.detail.MainDetailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by yunus.seker on 12.4.2018
 */

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract MainDetailFragment contMainFragment();
}
