package com.mobilestar.rongo.android.activity.Home.fragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("live_state")
    @Expose
    private String liveState;
    @SerializedName("view_num")
    @Expose
    private String viewNum;
    @SerializedName("live_tag")
    @Expose
    private String liveTag;
    @SerializedName("live_name")
    @Expose
    private String liveName;
    @SerializedName("live_image")
    @Expose
    private String liveImage;

    public String getId() {
        return id;
    }

    public String getLiveState() {
        return liveState;
    }

    public String getViewNum() {
        return viewNum;
    }

    public String getLiveTag() {
        return liveTag;
    }

    public String getLiveName() {
        return liveName;
    }

    public String getLiveImage() {
        return liveImage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLiveState(String liveState) {
        this.liveState = liveState;
    }

    public void setViewNum(String viewNum) {
        this.viewNum = viewNum;
    }

    public void setLiveTag(String liveTag) {
        this.liveTag = liveTag;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public void setLiveImage(String liveImage) {
        this.liveImage = liveImage;
    }
}
