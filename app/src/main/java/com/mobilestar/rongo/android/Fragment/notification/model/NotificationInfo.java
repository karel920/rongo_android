package com.mobilestar.rongo.android.Fragment.notification.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("notification")
    @Expose
    private String notification;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getNotification() {
        return notification;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
