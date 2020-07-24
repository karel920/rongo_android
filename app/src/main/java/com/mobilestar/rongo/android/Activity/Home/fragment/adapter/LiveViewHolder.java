package com.mobilestar.rongo.android.Activity.Home.fragment.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobilestar.rongo.android.Activity.Home.fragment.model.LiveInfo;
import com.mobilestar.rongo.android.R;

import butterknife.ButterKnife;

public class LiveViewHolder extends RecyclerView.ViewHolder {

    public LiveViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void setData(LiveInfo info) {
    }
}
