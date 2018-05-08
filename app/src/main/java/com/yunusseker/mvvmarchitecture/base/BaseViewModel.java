package com.yunusseker.mvvmarchitecture.base;

import android.arch.lifecycle.ViewModel;

import com.yunusseker.mvvmarchitecture.data.DataSource;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yunus.seker on 12.4.2018
 */

public abstract class BaseViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable ;
    private DataSource dataRepository;

    public BaseViewModel(DataSource dataRepository) {
        this.dataRepository=dataRepository;
        compositeDisposable=new CompositeDisposable();
    }

    protected DataSource getDataRepository() {
        return dataRepository;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
        super.onCleared();
    }
}
