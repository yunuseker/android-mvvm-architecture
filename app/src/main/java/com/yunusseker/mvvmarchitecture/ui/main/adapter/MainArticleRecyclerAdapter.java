package com.yunusseker.mvvmarchitecture.ui.main.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunusseker.mvvmarchitecture.R;
import com.yunusseker.mvvmarchitecture.base.BaseAdapter;
import com.yunusseker.mvvmarchitecture.data.model.PostModel;
import com.yunusseker.mvvmarchitecture.databinding.RowMainBinding;

import java.util.List;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class MainArticleRecyclerAdapter extends BaseAdapter<PostModel> {
    private OnClickItem onClickItem;

    public MainArticleRecyclerAdapter(List<PostModel> list, OnClickItem onClickItem) {
        this.list = list;
        this.onClickItem = onClickItem;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolderBase(ViewGroup parent, int viewType) {
        return new MainArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main, parent, false), onClickItem);
    }

    @Override
    public void onBindViewHolderBase(RecyclerView.ViewHolder holder, int position) {
        RowMainBinding binding = ((MainArticleViewHolder) holder).getBinding();
        binding.setPostModel(list.get(position));
    }


    class MainArticleViewHolder extends RecyclerView.ViewHolder {

        private final RowMainBinding binding;

        MainArticleViewHolder(View itemView, OnClickItem onClickItem) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.rowMainImgBg.setOnClickListener(v -> onClickItem.click(list.get(getAdapterPosition())));
        }

        RowMainBinding getBinding() {
            return binding;
        }
    }

    public interface OnClickItem {
        void click(PostModel postModel);
    }
}
