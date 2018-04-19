package com.yunusseker.mvvmarchitecture.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.yunusseker.mvvmarchitecture.BR;
import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseActivity;
import com.yunusseker.mvvmarchitecture.base.BaseViewModel;
import com.yunusseker.mvvmarchitecture.data.model.PostModel;
import com.yunusseker.mvvmarchitecture.databinding.ActivityMainBinding;
import com.yunusseker.mvvmarchitecture.ui.main.adapter.MainArticleRecyclerAdapter;
import com.yunusseker.mvvmarchitecture.utils.ErrorUtil;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity<MainViewModel,ActivityMainBinding> implements MainArticleRecyclerAdapter.OnClickItem {

    @Inject
    MainViewModel mainViewModel;

    @Inject
    ErrorUtil errorUtil;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public Class<MainViewModel> getViewModel() {return MainViewModel.class;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        viewModel.getLiveData().observe(this, postResponse -> {
            dataBinding.recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            dataBinding.recView.setAdapter(new MainArticleRecyclerAdapter(postResponse.getPosts(), this));
        });

        viewModel.getError().observe(this,throwable -> errorUtil.openErrorToast(throwable,MainActivity.this,true));

    }

    @Override
    public void click(PostModel postModel) {
        Toast.makeText(this, postModel.getCategory(), Toast.LENGTH_LONG).show();
    }

}
