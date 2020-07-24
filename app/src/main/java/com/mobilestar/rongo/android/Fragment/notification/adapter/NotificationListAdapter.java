package com.mobilestar.rongo.android.Fragment.notification.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.Activity.Home.fragment.model.LiveInfo;
import com.mobilestar.rongo.android.Fragment.notification.model.NotificationInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseRecycler;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

public class NotificationListAdapter extends BaseRecycler<NotificationInfo> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notification_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((NotificationViewHolder)holder).setData((NotificationInfo)list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
