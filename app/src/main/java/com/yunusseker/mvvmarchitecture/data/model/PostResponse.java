package com.yunusseker.mvvmarchitecture.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yunus.seker on 12.4.2018
 */

public class PostResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("posts")
    @Expose
    private List<PostModel> posts = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }
}
