package com.yunusseker.mvvmarchitecture.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseActivity;
import com.yunusseker.mvvmarchitecture.base.BaseRecyclerAdapter;
import com.yunusseker.mvvmarchitecture.base.ItemClickListener;
import com.yunusseker.mvvmarchitecture.data.model.PostModel;
import com.yunusseker.mvvmarchitecture.data.model.UserModel;
import com.yunusseker.mvvmarchitecture.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel,ActivityMainBinding> implements ItemClickListener {
    List<Object> list =new ArrayList<>();
    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public Class<MainViewModel> getViewModel() {return MainViewModel.class;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserModel user =new UserModel("yunus");
        PostModel postModel =new PostModel("example post");


        list.add(user);
        list.add(postModel);

        HashMap<Class<?>,Integer> layoutIds =new HashMap<>();
        layoutIds.put(UserModel.class,R.layout.row_user);
        layoutIds.put(PostModel.class,R.layout.row_main);


        BaseRecyclerAdapter baseAdapter =new BaseRecyclerAdapter(list,null,this);
        dataBinding.recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//TODO inject from mainActivityModule
        baseAdapter.setLayoutMap(UserModel.class,R.layout.row_user);
        baseAdapter.setLayoutMap(PostModel.class,R.layout.row_main);

        dataBinding.recView.setAdapter(baseAdapter);


    }


    @Override
    public void onItemClick(int itemType, int compenentIndex, Object itemData) {
        if (itemType==1){

            Toast.makeText(this, ((UserModel)itemData).getName(), Toast.LENGTH_LONG).show();
        }else if (itemType==0){
            Toast.makeText(this, ((PostModel)itemData).getTitle(), Toast.LENGTH_LONG).show();

        }

    }
}
