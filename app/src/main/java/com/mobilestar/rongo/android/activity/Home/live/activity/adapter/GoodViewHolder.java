package com.mobilestar.rongo.android.activity.Home.live.activity.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.live.activity.model.GoodInfo;

import butterknife.ButterKnife;

public class GoodViewHolder extends RecyclerView.ViewHolder {

    public GoodViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(GoodInfo info, int position) {
    }
}
