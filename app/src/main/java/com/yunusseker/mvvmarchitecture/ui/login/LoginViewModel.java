package com.yunusseker.mvvmarchitecture.ui.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.data.repository.post.PostDataSource;
import com.yunusseker.mvvmarchitecture.data.model.LoginResponse;
import com.yunusseker.mvvmarchitecture.util.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginViewModel extends BaseViewModel {
    private MutableLiveData<Throwable> networkConnectError = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<LoginResponse> loginMutableLiveData = new MutableLiveData<>();

    @Inject
    public LoginViewModel(BaseSchedulerProvider schedulerProvider) {
        super(chedulerProvider);
    }

    public LiveData<LoginResponse> login(String username, String password) {

        getCompositeDisposable().add(getDataRepository().login(username, password,"", "")
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(loginResponse -> {
                    if (loginResponse.isSuccess()) {
                        loginMutableLiveData.setValue(loginResponse);
                        getDataRepository().saveLoggedUser(loginResponse.getUserModel());
                    }else {
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
