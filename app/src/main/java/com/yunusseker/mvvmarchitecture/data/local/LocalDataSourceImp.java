package com.yunusseker.mvvmarchitecture.data.local;

import android.content.Context;

import com.yunusseker.mvvmarchitecture.R;

import javax.inject.Inject;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class LocalDataSourceImp implements LocalDataSource {
    private Context context;

    @Inject
    public LocalDataSourceImp(Context context) {
        this.context=context;
    }

    @Override
    public String getLoggedUser() {
        return context.getString(R.string.name);
    }
}
