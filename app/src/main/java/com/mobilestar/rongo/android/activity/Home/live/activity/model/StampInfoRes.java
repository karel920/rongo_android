package com.mobilestar.rongo.android.activity.Home.live.activity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StampInfoRes {

    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("data")
    @Expose
    private List<GoodInfo> data = null;


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public List<GoodInfo> getData() {
        return data;
    }
}
