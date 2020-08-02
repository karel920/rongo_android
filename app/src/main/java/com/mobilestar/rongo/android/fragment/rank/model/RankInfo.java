package com.mobilestar.rongo.android.fragment.rank.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RankInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("status_id")
    @Expose
    private String statusId;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("ship_days")
    @Expose
    private String shipDays;
    @SerializedName("shipper")
    @Expose
    private String shipper;
    @SerializedName("storeId")
    @Expose
    private String storeId;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("storeThumbnail")
    @Expose
    private String storeThumbnail;

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getPrice() {
        return price;
    }

    public String getStatusId() {
        return statusId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getNumber() {
        return number;
    }

    public String getQty() {
        return qty;
    }

    public String getShipDays() {
        return shipDays;
    }

    public String getShipper() {
        return shipper;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreThumbnail() {
        return storeThumbnail;
    }
}
