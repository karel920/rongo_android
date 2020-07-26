package com.mobilestar.rongo.android.fragment.notification.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.fragment.notification.model.NewsInfo;

import butterknife.ButterKnife;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(NewsInfo info) {
    }
}
