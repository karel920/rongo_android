package com.mobilestar.rongo.android.Fragment.notification.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.Activity.Home.fragment.model.LiveInfo;
import com.mobilestar.rongo.android.Fragment.notification.model.NotificationInfo;

import butterknife.ButterKnife;

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(NotificationInfo info) {
    }
}
