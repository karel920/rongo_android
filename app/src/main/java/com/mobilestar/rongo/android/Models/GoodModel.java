package com.mobilestar.rongo.android.Models;

import com.google.gson.annotations.SerializedName;

public class GoodModel {
    @SerializedName("id")
    public int id;

    @SerializedName("label")
    public String label;

    @SerializedName("number")
    public String number;

    @SerializedName("quantity")
    public int quantity;

    @SerializedName("price")
    public int price;

    @SerializedName("status")
    public int status;

    @SerializedName("numLikes")
    public int numLikes;

    @SerializedName("isLike")
    public int isLike;

    @SerializedName("thumbnail")
    public String thumbnail;

   @SerializedName("storeName")
    public String storeName;
}
