package com.yunusseker.mvvmarchitecture.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.yunusseker.mvvmarchitecture.BR;
import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseActivity;
import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.databinding.ActLoginBinding;
import com.yunusseker.mvvmarchitecture.ui.main.MainActivity;
import com.yunusseker.mvvmarchitecture.ui.main.adapter.MainArticleRecyclerAdapter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginActivity extends BaseActivity<LoginViewModel,ActLoginBinding> {

    @Inject
    LoginViewModel loginViewModel;

    @Override
    public int getBindingVariable() {
        return BR.vmLogin;
    }

    @Override
    public Class<LoginViewModel> getViewModel() {
        return LoginViewModel.class;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.act_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding.setVariable(getBindingVariable(), loginViewModel);



        dataBinding.button.setOnClickListener(v -> {
            startActivityWithoutBackstack(MainActivity.class);

        });
    }

}
