package com.yunusseker.mvvmarchitecture.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.provider.ContactsContract;

import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.data.DataSource;
import com.yunusseker.mvvmarchitecture.data.model.PostResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class MainViewModel extends BaseViewModel {

    private final MutableLiveData<Throwable> error = new MutableLiveData<>();

    @Inject
    public MainViewModel(DataSource dataRepository) {
        super(dataRepository);
    }


    LiveData<PostResponse> getLiveData() {
        final MutableLiveData<PostResponse> livedata = new MutableLiveData<>();

        getCompositeDisposable().add(getDataRepository().getPostModel()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(livedata::setValue, error::setValue)
        );

        return livedata;
    }

    LiveData<Throwable> getError() {
        return error;
    }

}
