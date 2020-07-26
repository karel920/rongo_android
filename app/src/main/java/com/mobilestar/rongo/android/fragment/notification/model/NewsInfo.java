package com.mobilestar.rongo.android.fragment.notification.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("news")
    @Expose
    private String news;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getId() {
        return id;
    }

    public String getNews() {
        return news;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
