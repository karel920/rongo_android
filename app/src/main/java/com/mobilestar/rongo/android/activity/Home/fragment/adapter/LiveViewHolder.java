package com.mobilestar.rongo.android.activity.Home.fragment.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveInfo;

import butterknife.ButterKnife;

public class LiveViewHolder extends RecyclerView.ViewHolder {

    public LiveViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void setData(LiveInfo info) {
    }
}
