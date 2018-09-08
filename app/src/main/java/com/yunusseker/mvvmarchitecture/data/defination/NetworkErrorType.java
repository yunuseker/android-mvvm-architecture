package com.yunusseker.mvvmarchitecture.data.defination;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

@IntDef({
        NetworkErrorType.UNKNOWN_ERROR,
        NetworkErrorType.HTTP_EXCEPTION,
        NetworkErrorType.UNKNOW_HOST_EXCEPTION,
        NetworkErrorType.SOCKET_TIMEOUT_EXCEPTION

})
public @interface NetworkErrorType {
    int UNKNOWN_ERROR=0;
    int HTTP_EXCEPTION=1;
    int UNKNOW_HOST_EXCEPTION=2;
    int SOCKET_TIMEOUT_EXCEPTION=3;
}
