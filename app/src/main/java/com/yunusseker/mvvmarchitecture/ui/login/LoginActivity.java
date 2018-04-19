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
import com.yunusseker.mvvmarchitecture.utils.ErrorUtil;
import com.yunusseker.mvvmarchitecture.utils.ViewModelFactory;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginActivity extends BaseActivity<LoginViewModel,ActLoginBinding> {

    @Inject
    ErrorUtil errorUtil;

    @Override
    public int getLayoutRes() {
        return R.layout.act_login;
    }

    @Override
    public Class<LoginViewModel> getViewModel() {return LoginViewModel.class;}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding.button.setOnClickListener(v -> {
            viewModel.login("","").observe(this,loginResponse -> startActivityWithoutBackstack(MainActivity.class));
        });

        viewModel.getNetworkConnectError().observe(this,throwable -> errorUtil.openErrorToast(throwable,LoginActivity.this,true));

        viewModel.getErrorMessage().observe(this,s -> Toast.makeText(this,s,Toast.LENGTH_LONG).show());
    }

}
