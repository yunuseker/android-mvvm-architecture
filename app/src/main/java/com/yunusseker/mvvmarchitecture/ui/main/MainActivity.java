package com.yunusseker.mvvmarchitecture.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseActivity;
import com.yunusseker.mvvmarchitecture.data.model.PostModel;
import com.yunusseker.mvvmarchitecture.databinding.ActivityMainBinding;
import com.yunusseker.mvvmarchitecture.ui.main.adapter.MainArticleRecyclerAdapter;
import com.yunusseker.mvvmarchitecture.util.ErrorUtil;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainViewModel,ActivityMainBinding> implements MainArticleRecyclerAdapter.OnClickItem {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public Class<MainViewModel> getViewModel() {return MainViewModel.class;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainArticleRecyclerAdapter adapter=new MainArticleRecyclerAdapter(this);//TODO inject from mainActivityModule
        dataBinding.recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//TODO inject from mainActivityModule
        dataBinding.recView.setAdapter(adapter);

        viewModel.getLiveData().observe(this, postResponse -> adapter.setData(postResponse.getPosts()));


    }

    @Override
    public void click(PostModel postModel) {
        Toast.makeText(this, postModel.getCategory(), Toast.LENGTH_LONG).show();
    }

}
