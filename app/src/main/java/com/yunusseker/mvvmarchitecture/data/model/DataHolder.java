package com.yunusseker.mvvmarchitecture.data.model;


public class DataHolder<T> {

    private ErrorModel errorModel;
    private T data;

    public DataHolder(ErrorModel errorModel, T data) {
        this.errorModel = errorModel;
        this.data = data;
    }

    public DataHolder(T data) {
        this.data = data;
    }

    public DataHolder(String errorMessage) {
        this.errorModel=new ErrorModel(errorMessage);
    }

    public DataHolder(ErrorModel errorModel) {
        this.errorModel = errorModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrorModel(ErrorModel errorModel) {
        this.errorModel = errorModel;
    }

    public boolean isSuccess(){return errorModel==null;}
}
