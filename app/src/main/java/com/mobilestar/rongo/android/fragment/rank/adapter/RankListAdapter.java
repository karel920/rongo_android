package com.mobilestar.rongo.android.fragment.rank.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseRecycler;
import com.mobilestar.rongo.android.fragment.rank.model.RankInfo;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

public class RankListAdapter extends BaseRecycler<RankInfo> {
    IRecyclerClickListener listener;

    public RankListAdapter(IRecyclerClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rank_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RankViewHolder)holder).setData((RankInfo)list.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecyclerClick(position, null, "click_news");
            }
        });

        ((RankViewHolder) holder).btnGoStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), v.getTag().toString(), Toast.LENGTH_SHORT).show();//store id
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
