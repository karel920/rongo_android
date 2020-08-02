package com.mobilestar.rongo.android.fragment.rank.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.fragment.rank.model.RankInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RankViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_rank)
    TextView tvRank;
    @BindView(R.id.iv_crown)
    ImageView ivCrown;
    @BindView(R.id.iv_product)
    ImageView iv_product;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.btn_go_store)
    TextView btnGoStore;



    public RankViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(RankInfo info, int position) {
        if (position == 0) {
            tvRank.setVisibility(View.INVISIBLE);
            ivCrown.setVisibility(View.VISIBLE);
        } else if (position == 1) {
            tvRank.setVisibility(View.VISIBLE);
            ivCrown.setVisibility(View.GONE);
            tvRank.setBackgroundResource(R.drawable.round_back_silver);
            tvRank.setTextColor(itemView.getContext().getColor(R.color.white));
        } else if (position == 2) {
            tvRank.setVisibility(View.VISIBLE);
            ivCrown.setVisibility(View.GONE);
            tvRank.setBackgroundResource(R.drawable.round_back_brown);
            tvRank.setTextColor(itemView.getContext().getColor(R.color.white));
        } else {
            tvRank.setVisibility(View.VISIBLE);
            ivCrown.setVisibility(View.GONE);
            tvRank.setBackgroundResource(android.R.color.transparent);
            tvRank.setTextColor(itemView.getContext().getColor(R.color.mainTextColor));
        }
        tvRank.setText(String.valueOf(position + 1));
        tvProductName.setText(info.getLabel());
        tvPrice.setText(info.getPrice());
        btnGoStore.setTag(info.getStoreId());
    }
}
