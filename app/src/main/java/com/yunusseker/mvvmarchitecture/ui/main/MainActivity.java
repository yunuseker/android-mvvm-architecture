package com.yunusseker.mvvmarchitecture.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.yunusseker.mvvmarchitecture.BR;
import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseActivity;
import com.yunusseker.mvvmarchitecture.databinding.ActivityMainBinding;
import com.yunusseker.mvvmarchitecture.ui.main.adapter.MainArticleRecyclerAdapter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainViewModel,ActivityMainBinding>  {


    @Inject
    MainViewModel mainViewModel;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding.setVariable(getBindingVariable(),mainViewModel);

        mainViewModel.getLiveData().observe(this,postResponse -> {
            dataBinding.recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            dataBinding.recView.setAdapter(new MainArticleRecyclerAdapter(postResponse.getPosts()));
        });


    }




}
