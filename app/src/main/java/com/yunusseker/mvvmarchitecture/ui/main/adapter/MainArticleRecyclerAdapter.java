package com.yunusseker.mvvmarchitecture.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseAdapter;
import com.yunusseker.mvvmarchitecture.data.model.PostModel;
import com.yunusseker.mvvmarchitecture.databinding.RowMainBinding;
import com.yunusseker.mvvmarchitecture.ui.main.viewholder.MainArticleViewHolder;

import java.util.List;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class MainArticleRecyclerAdapter extends BaseAdapter<PostModel> {

    public MainArticleRecyclerAdapter(List<PostModel> list) {
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolderBase(ViewGroup parent, int viewType) {
        return new MainArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main,parent,false));
    }

    @Override
    public void onBindViewHolderBase(RecyclerView.ViewHolder holder, int position) {
        RowMainBinding binding =((MainArticleViewHolder) holder).getBinding();
        binding.setPostModel(list.get(position));
    }
}
