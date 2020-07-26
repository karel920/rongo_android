package com.mobilestar.rongo.android.fragment.notification.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.fragment.notification.model.NotificationInfo;

import butterknife.ButterKnife;

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void setData(NotificationInfo info) {
    }
}
