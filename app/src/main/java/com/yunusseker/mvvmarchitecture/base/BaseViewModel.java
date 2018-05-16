package com.yunusseker.mvvmarchitecture.base;

import android.arch.lifecycle.ViewModel;

import com.yunusseker.mvvmarchitecture.data.DataSource;
import com.yunusseker.mvvmarchitecture.util.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yunus.seker on 12.4.2018
 */

public abstract class BaseViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable ;
    private DataSource dataRepository;
    private BaseSchedulerProvider schedulerProvider;


    public BaseViewModel(DataSource dataRepository,BaseSchedulerProvider schedulerProvider) {
        this.dataRepository=dataRepository;
        this.schedulerProvider=schedulerProvider;
        compositeDisposable=new CompositeDisposable();
    }

    protected DataSource getDataRepository() {
        return dataRepository;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public BaseSchedulerProvider getSchedulerProvider() {
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
