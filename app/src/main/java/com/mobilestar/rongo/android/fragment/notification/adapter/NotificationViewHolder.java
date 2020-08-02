package com.mobilestar.rongo.android.fragment.notification.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.fragment.notification.model.NotificationInfo;
import com.mobilestar.rongo.android.helper.DateUtill;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_notification)
    ImageView ivImage;
    @BindView(R.id.tv_notification)
    TextView tvNotification;
    @BindView(R.id.tv_notification_date)
    TextView tvNotificationDate;

    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(NotificationInfo info) {

        Glide.with(itemView.getContext()).load(info.getIcon())
                .placeholder(itemView.getContext().getDrawable(R.drawable.img_store_placeholder))
                .error(itemView.getContext().getDrawable(R.drawable.img_store_placeholder))
                .into(ivImage);

        tvNotification.setText(info.getTitle());
        tvNotificationDate.setText(DateUtill.formatDateTime(info.getCreatedAt()));
    }
}
