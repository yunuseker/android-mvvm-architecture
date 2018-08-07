package com.yunusseker.mvvmarchitecture.base;

import android.arch.lifecycle.ViewModel;

import com.yunusseker.mvvmarchitecture.data.repository.post.PostDataSource;
import com.yunusseker.mvvmarchitecture.util.schedulers.BaseSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yunus.seker on 12.4.2018
 */

public abstract class BaseViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable ;
    private BaseSchedulerProvider schedulerProvider;

    public BaseViewModel(BaseSchedulerProvider schedulerProvider) {
        this.schedulerProvider=schedulerProvider;
        compositeDisposable=new CompositeDisposable();
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    protected BaseSchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    @Override
    protected void onCleared() {
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
        super.onCleared();
    }
}
