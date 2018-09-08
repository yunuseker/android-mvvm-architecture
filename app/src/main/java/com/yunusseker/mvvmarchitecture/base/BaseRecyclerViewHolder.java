package com.yunusseker.mvvmarchitecture.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import com.android.databinding.library.baseAdapters.BR;

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;
    private ItemClickListener clickListener;

    public BaseRecyclerViewHolder(ViewDataBinding binding, ItemClickListener clickListener) {
        super(binding.getRoot());
        this.binding=binding;
        this.clickListener=clickListener;
    }

    public void bind(Object data){
        binding.setVariable(BR.data,data);
        binding.setVariable(BR.clicklistener,clickListener);
        binding.executePendingBindings();
    }
}
