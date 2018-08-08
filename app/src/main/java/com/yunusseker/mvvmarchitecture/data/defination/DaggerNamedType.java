package com.yunusseker.mvvmarchitecture.data.defination;

import android.support.annotation.StringDef;

@StringDef({
        DaggerNamedType.USER,
        DaggerNamedType.POST_LOCAL,
        DaggerNamedType.POST_REMOTE
})
public @interface DaggerNamedType {
    String USER="user";
    String POST_REMOTE="postremote";
    String POST_LOCAL="postlocal";
    String POST_REPOSITORY="postrepository";
}
