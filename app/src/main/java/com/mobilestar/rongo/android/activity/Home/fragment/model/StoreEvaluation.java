package com.mobilestar.rongo.android.activity.Home.fragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreEvaluation {
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
