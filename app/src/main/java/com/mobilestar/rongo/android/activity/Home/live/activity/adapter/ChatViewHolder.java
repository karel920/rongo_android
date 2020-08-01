package com.mobilestar.rongo.android.activity.Home.live.activity.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.live.activity.model.ChatInfo;

import butterknife.ButterKnife;
import io.getstream.chat.android.client.models.Message;

public class ChatViewHolder extends RecyclerView.ViewHolder {



    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(Message info, int position) {

    }
}
