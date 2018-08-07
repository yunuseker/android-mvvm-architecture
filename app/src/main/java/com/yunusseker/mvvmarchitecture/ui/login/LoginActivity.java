package com.yunusseker.mvvmarchitecture.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseActivity;
import com.yunusseker.mvvmarchitecture.databinding.ActLoginBinding;
import com.yunusseker.mvvmarchitecture.ui.main.MainActivity;
import com.yunusseker.mvvmarchitecture.util.ErrorUtil;

import javax.inject.Inject;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginActivity extends BaseActivity<LoginViewModel,ActLoginBinding> {

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

        viewModel.getErrorMessage().observe(this,s -> Toast.makeText(this,s,Toast.LENGTH_LONG).show());
    }

}
