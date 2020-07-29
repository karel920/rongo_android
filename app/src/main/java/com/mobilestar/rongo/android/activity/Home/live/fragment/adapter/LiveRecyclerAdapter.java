package com.mobilestar.rongo.android.activity.Home.live.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.fragment.adapter.LiveViewHolder;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;
import com.mobilestar.rongo.android.base.BaseRecycler;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

public class LiveRecyclerAdapter extends BaseRecycler {
    IRecyclerClickListener listener;

    public LiveRecyclerAdapter(IRecyclerClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.mobilestar.rongo.android.activity.Home.fragment.adapter.LiveViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_live_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((LiveViewHolder)holder).setData((LiveListInfo) list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclerClick(position, null, "click_live");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
