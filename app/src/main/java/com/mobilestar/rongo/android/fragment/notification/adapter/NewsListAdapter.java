package com.mobilestar.rongo.android.fragment.notification.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.fragment.notification.model.NewsInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseRecycler;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

public class NewsListAdapter extends BaseRecycler<NewsInfo> {
    IRecyclerClickListener listener;

    public NewsListAdapter(IRecyclerClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((NewsViewHolder)holder).setData((NewsInfo)list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclerClick(position, null, "click_news");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
