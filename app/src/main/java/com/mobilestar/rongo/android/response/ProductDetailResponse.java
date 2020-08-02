package com.mobilestar.rongo.android.response;

import com.google.gson.annotations.SerializedName;
import com.mobilestar.rongo.android.Models.GoodDetailModel;

public class ProductDetailResponse {
    @SerializedName("product")
    public GoodDetailModel product;
}
