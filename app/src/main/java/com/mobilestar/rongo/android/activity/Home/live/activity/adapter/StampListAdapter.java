package com.mobilestar.rongo.android.activity.Home.live.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.GoodInfo;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.StampInfo;
import com.mobilestar.rongo.android.base.BaseRecycler;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

public class StampListAdapter extends BaseRecycler<StampInfo> {
    IRecyclerClickListener listener;

    public StampListAdapter(IRecyclerClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StampViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_stamp_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((StampViewHolder)holder).setData((StampInfo)list.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclerClick(position, null, "click_stamp");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
