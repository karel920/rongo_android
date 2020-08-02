package com.mobilestar.rongo.android.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GoodDetailModel {
    @SerializedName("id")
    public int id;

    @SerializedName("label")
    public String label;

    @SerializedName("number")
    public String number;

    @SerializedName("description")
    public String description;

    @SerializedName("price")
    public int price;

    @SerializedName("nLikes")
    public int nLikes;

    @SerializedName("isLike")
    public int isLike;

    @SerializedName("shipper")
    public String shipper;

    @SerializedName("ship_days")
    public int ship_day;

    @SerializedName("store")
    public Store store;

    @SerializedName("portfolios")
    public ArrayList<String> portfolios;

    public static class Store {
        @SerializedName("id")
        public int id;

        @SerializedName("name")
        public String name;

        @SerializedName("nTotalFollows")
        public int followers;

        @SerializedName("icon")
        public String icon;

        @SerializedName("isFollow")
        public int isFollow;
    }
}
