package com.mobilestar.rongo.android.activity.Home.live.activity.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.live.activity.model.GoodInfo;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.StampInfo;

import butterknife.ButterKnife;

public class StampViewHolder extends RecyclerView.ViewHolder {

    public StampViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(StampInfo info, int position) {
    }
}
