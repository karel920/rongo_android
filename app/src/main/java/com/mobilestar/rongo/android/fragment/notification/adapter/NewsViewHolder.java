package com.mobilestar.rongo.android.fragment.notification.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.fragment.notification.model.NewsInfo;
import com.mobilestar.rongo.android.helper.DateUtill;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_news_title)
    TextView tvTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(NewsInfo info) {
        tvTitle.setText(info.getTitle());
        tvDate.setText(DateUtill.formatDateTime2(info.getDate()));
    }
}
