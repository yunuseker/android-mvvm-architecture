package com.yunusseker.mvvmarchitecture.data.defination;

import android.support.annotation.StringDef;

@StringDef({
        DaggerNamedType.USER_REMOTE,
        DaggerNamedType.USER_LOCAL,
        DaggerNamedType.USER_REPOSITORY,
        DaggerNamedType.POST_LOCAL,
        DaggerNamedType.POST_REMOTE
})
public @interface DaggerNamedType {
    String USER_REMOTE="userremote";
    String USER_LOCAL="userlocal";
    String USER_REPOSITORY="userrepository";
    String POST_REMOTE="postremote";
    String POST_LOCAL="postlocal";
    String POST_REPOSITORY="postrepository";
}
