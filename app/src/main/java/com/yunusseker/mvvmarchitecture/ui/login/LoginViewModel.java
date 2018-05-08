package com.yunusseker.mvvmarchitecture.ui.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.data.DataSource;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginViewModel extends BaseViewModel {
    private final MutableLiveData<Throwable> networkConnectError = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();

    @Inject
    public LoginViewModel(DataSource dataRepository) {
        super(dataRepository);
    }

    public LiveData<LoginResponse> login(String username, String password) {
        final MutableLiveData<LoginResponse> loginMutableLiveData = new MutableLiveData<>();

        getCompositeDisposable().add(getDataRepository().login(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(loginResponse -> {
                    if (loginResponse.isStatus()) {
                        loginMutableLiveData.setValue(loginResponse);
                    }else {
                        //this message comes from api.
                        errorMessage.setValue(loginResponse.getErrorModel().getErrorMessage());
                    }
                }, networkConnectError::setValue));

        return loginMutableLiveData;
    }

    LiveData<Throwable> getNetworkConnectError() {
        return networkConnectError;
    }

    LiveData<String> getErrorMessage(){
        return errorMessage;
    }


}
