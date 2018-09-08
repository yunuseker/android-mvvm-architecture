package com.yunusseker.mvvmarchitecture.base;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private ItemClickListener clickListener;
    private HashMap<Class<?>,Integer> layoutIds;

    public BaseRecyclerAdapter(List<Object> list, HashMap<Class<?>, Integer> layoutIds, ItemClickListener clickListener) {
        this.list = list;
        this.layoutIds = layoutIds;
        this.clickListener = clickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new BaseRecyclerViewHolder(DataBindingUtil.inflate(layoutInflater,viewType,parent,false),clickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseRecyclerViewHolder) holder).bind(getDataList().get(position));
    }

    @Override
    public int getItemViewType(int position) {
       return layoutIds.get(list.get(position).getClass());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Object> getDataList() {
        return list;
    }

    public void setData(List<Object> data){
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    public void appendData(List<Object> data){
        list.addAll(data);
        notifyDataSetChanged();
    }

}
