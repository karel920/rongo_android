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
    @SerializedName("nTotalUsers")
    @Expose
    private Integer numJoined;
    @SerializedName("evaluation")
    @Expose
    private Integer evaluation;
    @SerializedName("isLike")
    @Expose
    private Boolean isLike;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("hls_url")
    @Expose
    private Integer liveUrl;
    @SerializedName("date")
    @Expose
    private String dateString ;

}
