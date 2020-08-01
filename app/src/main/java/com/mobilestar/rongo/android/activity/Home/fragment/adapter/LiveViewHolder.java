package com.mobilestar.rongo.android.activity.Home.fragment.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_live_thumb)
    ImageView imgThumbView;
    @BindView(R.id.tv_view_num)
    TextView txtNumView;
    @BindView(R.id.tv_live_name)
    TextView txtLiveNameView;
    @BindView(R.id.tv_live_tag)
    TextView txtLiveTag;

    private LiveListInfo info;

    public LiveViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(LiveListInfo info) {
        this.info = info;

        this.txtLiveNameView.setText(info.getTitle());
        this.txtLiveTag.setText(info.getTag());
        this.txtNumView.setText(info.getNumJoined().getNumViewers().toString());

//        Glide.with(this.itemView).load(info.getThumbnail()).centerCrop().placeholder(R.drawable.img_store_placeholder).into(imgThumbView);
    }

    public LiveListInfo getInfo() {
        return info;
    }
}
