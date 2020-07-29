package com.mobilestar.rongo.android.activity.Home.live.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.live.activity.model.GoodInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseRecycler;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

public class GoodListAdapter extends BaseRecycler<GoodInfo> {
    IRecyclerClickListener listener;

    public GoodListAdapter(IRecyclerClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GoodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_live_good, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((GoodViewHolder)holder).setData((GoodInfo)list.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclerClick(position, null, "click_good");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
