package com.mobilestar.rongo.android.fragment.notification.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("receiver")
    @Expose
    private String receiver;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("readStatus")
    @Expose
    private int readStatus;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("live_id")
    @Expose
    private String liveId;
    @SerializedName("store_id")
    @Expose
    private String storeId;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getIcon() {
        return icon;
    }

    public String getType() {
        return type;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public String getProductId() {
        return productId;
    }

    public String getLiveId() {
        return liveId;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
