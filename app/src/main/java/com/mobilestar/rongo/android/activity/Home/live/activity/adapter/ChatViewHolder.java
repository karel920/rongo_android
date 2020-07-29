package com.mobilestar.rongo.android.activity.Home.live.activity.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.live.activity.model.ChatInfo;

import butterknife.ButterKnife;

public class ChatViewHolder extends RecyclerView.ViewHolder {

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(ChatInfo info, int position) {
    }
}
