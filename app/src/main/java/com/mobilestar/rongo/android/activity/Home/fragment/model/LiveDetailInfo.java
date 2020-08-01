package com.mobilestar.rongo.android.activity.Home.fragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveDetailInfo {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nViewer")
    @Expose
    private ViewCountInfo numJoined;
    @SerializedName("evaluation")
    @Expose
    private Integer evaluation;
    @SerializedName("isLike")
    @Expose
    private boolean isLike;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("hls_url")
    @Expose
    private String liveUrl;
    @SerializedName("date")
    @Expose
    private String dateString;
    @SerializedName("cid")
    @Expose
    private String channelId;
    @SerializedName("seller")
    @Expose
    private StoreInfo store;

    public Integer getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public Boolean getLike() {
        return isLike;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public StoreInfo getStore() {
        return store;
    }
}
