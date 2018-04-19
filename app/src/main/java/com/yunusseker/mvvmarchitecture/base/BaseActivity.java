package com.yunusseker.mvvmarchitecture.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.yunusseker.mvvmarchitecture.utils.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yunus.seker on 12.4.2018
 */

public abstract class BaseActivity<VM extends ViewModel,DB extends ViewDataBinding> extends AppCompatActivity implements HasSupportFragmentInjector, LifecycleOwner {

   private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentAndroidInjector;

    @Inject
    ViewModelFactory viewModelFactory;

    public DB dataBinding;

    public VM viewModel;

    @LayoutRes
    public abstract int getLayoutRes();

    public abstract Class<VM> getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        viewModel=ViewModelProviders.of(this,viewModelFactory).get(getViewModel());
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentAndroidInjector;
    }

    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    public void startActivityWithoutBackstack(Class activityClass){
        Intent i = new Intent(this, activityClass);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void startActivityWithBackstack(Class activityClass){
        Intent i = new Intent(this, activityClass);
        startActivity(i);
    }


}
