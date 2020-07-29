package com.mobilestar.rongo.android.activity.Home.live.activity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StampInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("store_name")
    @Expose
    private String storeName;

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getStoreName() {
        return storeName;
    }
}
