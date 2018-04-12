package com.yunusseker.mvvmarchitecture.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yunus.seker on 12.4.2018
 */

public abstract class BaseViewHolder<DB extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final DB binding;

    public BaseViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public DB getBinding() {
        return binding;
    }
}
