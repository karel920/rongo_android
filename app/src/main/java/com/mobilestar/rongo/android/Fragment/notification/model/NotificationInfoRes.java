package com.mobilestar.rongo.android.Fragment.notification.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationInfoRes {

    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("data")
    @Expose
    private List<NotificationInfo> data = null;


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public List<NotificationInfo> getData() {
        return data;
    }
}
