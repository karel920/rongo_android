package com.mobilestar.rongo.android.activity.Home.fragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewCountInfo {
    @SerializedName("nWatchers")
    @Expose
    private Integer numWatchers;
    @SerializedName("nViewers")
    @Expose
    private Integer numViewers;

    public Integer getNumWatchers() {
        return numWatchers;
    }

    public Integer getNumViewers() {
        return numViewers;
    }
}
