package com.mobilestar.rongo.android.Fragment.notification.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.Fragment.notification.model.NewsInfo;
import com.mobilestar.rongo.android.Fragment.notification.model.NotificationInfo;

import butterknife.ButterKnife;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(NewsInfo info) {
    }
}
