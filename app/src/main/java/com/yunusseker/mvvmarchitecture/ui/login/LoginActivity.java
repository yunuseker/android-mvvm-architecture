package com.yunusseker.mvvmarchitecture.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.yunusseker.mvvmarchitecture.BR;
import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseActivity;
import com.yunusseker.mvvmarchitecture.databinding.ActLoginBinding;
import com.yunusseker.mvvmarchitecture.ui.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LoginActivity extends BaseActivity<LoginViewModel, ActLoginBinding> {

    @Inject
    LoginViewModel loginViewModel;

    @Override
    public int getBindingVariable() {
        return BR.vmLogin;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.act_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding.setVariable(getBindingVariable(), loginViewModel);



        dataBinding.button.setOnClickListener(v ->
                loginViewModel.login(dataBinding.editText.getText().toString(),dataBinding.editText2.getText().toString())
                .observe(this,loginResponse -> {
                   if(loginResponse.getSuccess().equals("Success")){
                       Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();

                       startActivity(new Intent(LoginActivity.this,MainActivity.class));
                   }
                })
        );
    }


}
